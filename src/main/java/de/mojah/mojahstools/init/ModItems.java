package de.mojah.mojahstools.init;

import cpw.mods.fml.common.registry.GameRegistry;
import de.mojah.mojahstools.item.ItemEmeryPaper;
import de.mojah.mojahstools.item.ItemMT;
import de.mojah.mojahstools.item.ItemPolishedStone;
import de.mojah.mojahstools.armor.ArmorStone;
import de.mojah.mojahstools.reference.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {

    public static final ItemMT emeryPaper = new ItemEmeryPaper();
    public static final ItemMT polishedStone = new ItemPolishedStone();

    public static void init() {
        GameRegistry.registerItem(emeryPaper, "emeryPaper");
        GameRegistry.registerItem(polishedStone, "polishedStone");
    }

}
