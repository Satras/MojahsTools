package de.mojah.mojahstools.item;

import net.minecraft.item.ItemStack;

/**
 * Created on 13.08.2015.
 */
public class ItemEmeryPaper extends ItemMT{
    public ItemEmeryPaper() {
        super();
        setUnlocalizedName("emeryPaper");
        isDamageable();
        setMaxDamage(10);
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack)
    {
        //setDamage(stack, getDamage(stack)+1);
        //showDurabilityBar(stack);
        return false;
    }
}
