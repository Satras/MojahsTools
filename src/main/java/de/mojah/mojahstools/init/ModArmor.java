package de.mojah.mojahstools.init;

import cpw.mods.fml.common.registry.GameRegistry;
import de.mojah.mojahstools.armor.ArmorMT;
import de.mojah.mojahstools.armor.ArmorStone;
import de.mojah.mojahstools.item.ItemEmeryPaper;
import de.mojah.mojahstools.item.ItemMT;
import de.mojah.mojahstools.item.ItemPolishedStone;
import de.mojah.mojahstools.reference.Reference;
import net.minecraft.item.Item;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModArmor {

    public static final ArmorMT stonearmorHelmet = new ArmorStone("stonearmorHelmet", 0);
    public static final ArmorMT stonearmorChestplate = new ArmorStone("stonearmorChestplate", 1);
    public static final ArmorMT stonearmorLeggings = new ArmorStone("stonearmorLeggings", 2);
    public static final ArmorMT stonearmorBoots = new ArmorStone("stonearmorBoots", 3);

    public static void init() {

        GameRegistry.registerItem(stonearmorHelmet, "stonearmorHelmet");
        GameRegistry.registerItem(stonearmorChestplate, "stonearmorChestplate");
        GameRegistry.registerItem(stonearmorLeggings, "stonearmorLeggings");
        GameRegistry.registerItem(stonearmorBoots, "stonearmorBoots");

    }

}
