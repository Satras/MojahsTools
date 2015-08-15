package de.mojah.mojahstools.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import de.mojah.mojahstools.init.ModItems;
import de.mojah.mojahstools.utility.LogHelper;
import net.minecraft.item.ItemStack;

/**
 * Created on 14.08.2015.
 */
public class CraftingEventHandler {
    @SubscribeEvent
    public void onCrafting(PlayerEvent.ItemCraftedEvent event) {
        for(int i=0;i < event.craftMatrix.getSizeInventory(); i++) {
            try {
                ItemStack itemstack = event.craftMatrix.getStackInSlot(i);
                if(itemstack.getItem() == ModItems.emeryPaper) {
                    LogHelper.info("ItemDamage : "+itemstack.getItemDamage());
                    ItemStack newStack = new ItemStack(ModItems.emeryPaper, 1, (itemstack.getItemDamage() +1 ));
                    LogHelper.info("ItemDamage : "+newStack.getItemDamage());
                    event.craftMatrix.setInventorySlotContents(i, newStack);
                }
            } catch(Exception e) {}
        }
    }
}
