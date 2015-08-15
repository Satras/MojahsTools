package de.mojah.mojahstools;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.mojah.mojahstools.handler.ConfigurationHandler;
import de.mojah.mojahstools.handler.CraftingEventHandler;
import de.mojah.mojahstools.init.ModArmor;
import de.mojah.mojahstools.init.ModBlocks;
import de.mojah.mojahstools.init.ModItems;
import de.mojah.mojahstools.init.Recipes;
import de.mojah.mojahstools.proxy.IProxy;
import de.mojah.mojahstools.reference.Reference;
import de.mojah.mojahstools.utility.LogHelper;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid= Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class MojahsTools
{

    @Mod.Instance(Reference.MOD_ID)
    public static MojahsTools instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Configs
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        // so the ConfigHandler listens to the Event-bus
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        // CraftingEventHandler
        //FMLCommonHandler.instance().bus().register(new CraftingEventHandler());

        // Blocks
        ModItems.init();
        ModBlocks.init();
        ModArmor.init();

        //LogHelper.info("Pre Initialization Complete");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // Recepiece
        Recipes.init();

        //GameRegistry.registerWorldGenerator(new WorldgenerationLMRB(),0);

        //LogHelper.info("Initialization Complete");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        /*
        for(String oreName : OreDictionary.getOreNames()) {
            LogHelper.info(oreName);

            LogHelper.info("      "+OreDictionary.getOres(oreName).toString());
        }

        LogHelper.info("Post Initialization Complete");
        */
    }
}
