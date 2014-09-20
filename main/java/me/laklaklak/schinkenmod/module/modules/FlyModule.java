package me.laklaklak.schinkenmod.module.modules;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import me.laklaklak.schinkenmod.module.SchinkenModule;
import me.laklaklak.schinkenmod.module.keybinds.ModuleKeybind;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * Created by Paul on 31.08.2014.
 */
public class FlyModule extends SchinkenModule {
    public FlyModule() {
        super("Fly", Keyboard.KEY_F);
    }

    public void onUpdate(){
        Minecraft.getMinecraft().thePlayer.capabilities.isFlying = true;
    }

    public void onDisable(){
        Minecraft.getMinecraft().thePlayer.capabilities.isFlying = false;
    }
}
