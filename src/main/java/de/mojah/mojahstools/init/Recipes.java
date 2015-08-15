package de.mojah.mojahstools.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipes {

    public static void init() {
        //GameRegistry.addRecipe(new ItemStack(ModItems.mapleLeaf), " s ", "sss", " s ", 's', new ItemStack(Items.stick));
        //GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.flag), new ItemStack(ModItems.mapleLeaf), new ItemStack(ModItems.mapleLeaf));

       //GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.emeryPaper), " s ", "sss", " s ", 's', "stickWood"));
       //GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.flag), new ItemStack(ModItems.mapleLeaf), new ItemStack(ModItems.mapleLeaf)));

        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.emeryPaper), "sand", new ItemStack(Items.paper)));

        // ItemStack(Item, count, OreDictionary.WILDCARD_VALUE)
        // OreDictionary.WILDCARD_VALUE any Damage-Value!
        // http://www.minecraftforge.net/forum/index.php?topic=6944.0
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.polishedStone, 2), "cobblestone", new ItemStack(ModItems.emeryPaper.setContainerItem(ModItems.emeryPaper), 1, OreDictionary.WILDCARD_VALUE)));

        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.cobblestone), new ItemStack(ModItems.polishedStone), new ItemStack(ModItems.polishedStone),new ItemStack(ModItems.polishedStone) ,new ItemStack(ModItems.polishedStone)));

        // ArmorRecipes
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModArmor.stonearmorBoots), "s s", "s s", 's', ModItems.polishedStone));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModArmor.stonearmorHelmet), "sss", "s s", 's', ModItems.polishedStone));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModArmor.stonearmorLeggings), "sss", "s s", "s s", 's', ModItems.polishedStone));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModArmor.stonearmorChestplate), "s s", "sss", "sss", 's', ModItems.polishedStone));

        //GameRegistry.addSmelting(ModBlocks.polishedCobblestone, new ItemStack(Blocks.stone), 0.1f);

    }

}
