package de.mojah.mojahstools.block;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockPolishedStone extends BlockMT {

    public BlockPolishedStone() {
        super();
        setHardness(1.5F);
        setResistance(10.0F);
        setStepSound(soundTypeStone);

        this.setBlockName("polishedStone");
        this.setBlockTextureName("polishedstone");
        setHarvestLevel("pickaxe",0);
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        return Item.getItemFromBlock(Blocks.cobblestone);
    }

}
