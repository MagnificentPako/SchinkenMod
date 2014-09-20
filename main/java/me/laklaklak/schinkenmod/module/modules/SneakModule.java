package me.laklaklak.schinkenmod.module.modules;

import me.laklaklak.schinkenmod.module.SchinkenModule;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

/**
 * Created by Paul on 31.08.2014.
 */
public class SneakModule extends SchinkenModule {
    public SneakModule() {
        super("Sneak", Keyboard.KEY_Z);
    }

    public void onUpdate(){
        Minecraft.getMinecraft().thePlayer.setSneaking(true);
    }
}
