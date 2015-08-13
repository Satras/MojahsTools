package de.mojah.mojahstools.block;

import de.mojah.mojahstools.utility.LogHelper;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Random;

public class BlockPolishedCobblestone extends BlockMT {

    public BlockPolishedCobblestone() {
        super();
        setHardness(1.5F);
        setResistance(10.0F);
        setStepSound(soundTypeStone);


        this.setBlockName("polishedCobblestone");
        this.setBlockTextureName("polishedcobblestone");
        setHarvestLevel("pickaxe",0);
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        return Item.getItemFromBlock(Blocks.cobblestone);
    }

}
