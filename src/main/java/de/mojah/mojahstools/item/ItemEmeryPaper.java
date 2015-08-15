package de.mojah.mojahstools.item;

import net.minecraft.item.ItemStack;

/**
 * Created on 13.08.2015.
 */
public class ItemEmeryPaper extends ItemMT{
    public ItemEmeryPaper() {
        super();
        setUnlocalizedName("emeryPaper");
        setMaxDamage(6 - 1); // 6 Recipes
        maxStackSize = 1;
        setNoRepair();
    }



    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack)
    {
        return false;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {

        // Damaging Item on craft
        // http://www.minecraftforge.net/forum/index.php?topic=3203.0

        itemStack.setItemDamage(itemStack.getItemDamage() + 1);
        return itemStack;
    }
}
