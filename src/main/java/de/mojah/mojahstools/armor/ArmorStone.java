package de.mojah.mojahstools.armor;

import de.mojah.mojahstools.init.ModArmor;
import de.mojah.mojahstools.init.ModItems;
import de.mojah.mojahstools.reference.Reference;
import de.mojah.mojahstools.utility.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created on 13.08.2015.
 * Sources:
 *      http://bedrockminer.jimdo.com/modding-tutorials/basic-modding-1-7/custom-armor/
 *      http://www.minecraftforum.net/forums/mapping-and-modding/mapping-and-modding-tutorials/1571540-1-7-x-1-8-forge-making-custom-armor-that-adds
 */
public class ArmorStone extends ArmorMT {
                                            //EnumHelper.addArmorMaterial("NAME", durability, damageReduction[], enchantability)
    public static final ArmorMaterial ARMOR = EnumHelper.addArmorMaterial("STONE_ARMOR", 16, new int[]{2, 5, 4, 1}, 15);

    public ArmorStone(String unlocalizedName, int type) {
        super(ARMOR, "StoneArmor", type);

        setUnlocalizedName(unlocalizedName);
    }

    @Override
    public boolean isRepairable() {
        return true;
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        int slowness = 0;

        for(int i=0;i<4;i++) {
            if(player.getCurrentArmor(i) != null && player.getCurrentArmor(i).getItem() instanceof ArmorStone) {
                slowness++;
            }
        }

        if(slowness > 0) {

            /*
             *  1 Armor piece    => Slowness 1
             *  2 Armor pieces   => Slowness 1
             *  3 Armor pieces   => Slowness 2, Mining Fragile 1
             *  4 Armor pieces   => Slowness 3, Mining Fragile 1, 100% Firedamage absorbtion due to durability
             */

            int amplifier = 0;

            if(slowness>1) {
                // nothing bad, nothing good :D
            }
            if(slowness>2) {
                amplifier = 1;
                player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 5));
                //player.addPotionEffect(new PotionEffect(Potion.resistance.id, 5));

            }
            if(slowness>3) {
                amplifier = 2;
                // Fire Resistance via ArmorProperties
                //player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 5));
            }

            //LogHelper.info("Amplifier : " + amplifier);
            player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 5, amplifier));
        }

    }

    @Override
    public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
        //LogHelper.info("Source : " + source.getDamageType() + " >> " + damage);

        int pieces = 0;
        if(player instanceof EntityPlayer) {
            for(int i=0;i<4;i++) {
                if (((EntityPlayer) player).getCurrentArmor(i) != null && ((EntityPlayer) player).getCurrentArmor(i).getItem() instanceof ArmorStone) {
                    pieces++;
                }
            }
        }

        if(source.isFireDamage()) {
            if(pieces == 4) {
                return new ArmorProperties(1, 1, MathHelper.floor_double(damage * 20D));
            }
        }

        if(source.isExplosion()) {
            if(pieces == 4) {
                return new ArmorProperties(1, 1, MathHelper.floor_double(damage * 8D));
            }
        }


        return new ArmorProperties(1, 1, 1);
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
        switch(slot) {
            case 0:
                // boots
                return(2);
            case 1:
                // leggings
                return(3);
            case 2:
                // chestplate
                return(5);
            case 3:
                // helmet
                return(2);
            default:
                return(0);
        }
    }

    @Override
    public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
        //LogHelper.info("Source dA : " + source.getDamageType() + " >> " + damage);

        if(source.isFireDamage() || source.isExplosion()) {
            damage *= 5;
        } else {
            damage *= 2;
        }

        int totalReduce = 0;

        if(entity instanceof EntityPlayer) {
            int damageTotal = damage + stack.getItemDamage();
            EntityPlayer player = (EntityPlayer) entity;
            InventoryPlayer inventory = player.inventory;

            int cobble2repair = 5;

            for(int i=0;i<inventory.getSizeInventory();i++) {
                try {
                    // Cobblestone in Slot?
                    if(inventory.getStackInSlot(i).getItem().equals(new ItemStack(Blocks.cobblestone,1).getItem())) {
                        int stackSize = inventory.getStackInSlot(i).stackSize;
                        int newStacksize = stackSize - (MathHelper.floor_double((damageTotal-1)/cobble2repair*1D) +1);

                        if(newStacksize > 0) {
                            totalReduce += damageTotal;
                            damageTotal = 0;

                            inventory.setInventorySlotContents(i, new ItemStack(Blocks.cobblestone, newStacksize));
                            break;

                        } else {
                            totalReduce += stackSize*cobble2repair;
                            damageTotal -= stackSize*cobble2repair;

                            inventory.setInventorySlotContents(i, null);
                        }

                    }
                } catch(Exception e) {}
            }

        }
        //LogHelper.info("DamageReduce : "+totalReduce+"("+cobTot+"); Damage : "+stack.getItemDamage() +" <> "+damage);
        stack.setItemDamage(MathHelper.abs_int(totalReduce - stack.getItemDamage() - damage));
        stack.damageItem(0, entity);

    }
}
