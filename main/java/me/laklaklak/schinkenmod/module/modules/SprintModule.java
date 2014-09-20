package me.laklaklak.schinkenmod.module.modules;

import me.laklaklak.schinkenmod.module.SchinkenModule;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

/**
 * Created by Paul on 31.08.2014.
 */
public class SprintModule extends SchinkenModule {
    public SprintModule() {
        super("Sprint", Keyboard.KEY_M);
    }

    public void onUpdate(){
        Minecraft.getMinecraft().thePlayer.setSprinting(true);
    }
}
