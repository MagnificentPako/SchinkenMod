package me.laklaklak.schinkenmod.module.modules;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import me.laklaklak.schinkenmod.module.SchinkenModule;
import me.laklaklak.schinkenmod.module.keybinds.ModuleKeybind;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.packet.Packet11PlayerPosition;
import org.lwjgl.input.Keyboard;
import scala.collection.parallel.ParIterableLike;

/**
 * Created by Paul on 31.08.2014.
 */
public class NoFallModule extends SchinkenModule {
    public NoFallModule() {
        super("NoFall", Keyboard.KEY_N);
    }

    public void onUpdate(){
        if(Minecraft.getMinecraft().thePlayer.fallDistance >= 2.0F){
            EntityClientPlayerMP thePlayer = Minecraft.getMinecraft().thePlayer;
            Minecraft.getMinecraft().getNetHandler().addToSendQueue(new Packet11PlayerPosition(thePlayer.motionX,-999D,-999D,thePlayer.motionZ, true));
        }
    }


}
