package de.mojah.mojahstools.creativetab;

import de.mojah.mojahstools.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class CreativeTabMT {

    public static final CreativeTabs MT_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(Blocks.fire);
        }
    };
}
