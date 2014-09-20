package me.laklaklak.schinkenmod.events;

import me.laklaklak.schinkenmod.module.SchinkenModule;
import me.laklaklak.schinkenmod.module.SchinkenModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;
import org.lwjgl.opengl.GL11;

/**
 * Created by Paul on 31.08.2014.
 */
public class TickHandler {

    @ForgeSubscribe
    public void onRenderPlayerEvent(LivingEvent.LivingUpdateEvent e){
        for(SchinkenModule module : SchinkenModuleManager.activeModules){
            if(module.getToggled()){
                module.onUpdate();
            }
        }
    }

    @ForgeSubscribe
    public void onOverlayRender(RenderGameOverlayEvent e){
        if(e.type.equals(RenderGameOverlayEvent.ElementType.TEXT)) {
            int xPos = 5;
            for (SchinkenModule module : SchinkenModuleManager.activeModules) {
                if (module.getToggled()) {
                    Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(module.getName(),2,xPos,0x90FFFFFF);
                    xPos += 10;
                }
            }
        }
    }



}
