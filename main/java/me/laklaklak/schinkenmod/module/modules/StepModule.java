package me.laklaklak.schinkenmod.module.modules;

import me.laklaklak.schinkenmod.module.SchinkenModule;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

/**
 * Created by Paul on 31.08.2014.
 */
public class StepModule extends SchinkenModule {

    public StepModule() {
        super("Step", Keyboard.KEY_P);
    }

    public void onEnable(){
        Minecraft.getMinecraft().thePlayer.stepHeight = 1.0F;
    }

    public void onDisable(){
        Minecraft.getMinecraft().thePlayer.stepHeight = 0.5F;
    }
}
