package de.mojah.mojahstools.item;

import net.minecraft.item.ItemStack;

/**
 * Created on 13.08.2015.
 */
public class ItemPolishedStone extends ItemMT{
    public ItemPolishedStone() {
        super();
        setUnlocalizedName("polishedStone");
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack)
    {
        //setDamage(stack, getDamage(stack)+1);
        //showDurabilityBar(stack);
        return false;
    }
}
