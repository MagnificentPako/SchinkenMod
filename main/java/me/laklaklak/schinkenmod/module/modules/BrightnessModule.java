package me.laklaklak.schinkenmod.module.modules;

import me.laklaklak.schinkenmod.module.SchinkenModule;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import org.lwjgl.input.Keyboard;

/**
 * Created by Paul on 31.08.2014.
 */
public class BrightnessModule extends SchinkenModule {
    public BrightnessModule() {
        super("Brightness", Keyboard.KEY_B);
    }

    public void onEnable(){
        Minecraft.getMinecraft().thePlayer.addPotionEffect(new PotionEffect(Potion.nightVision.getId(),999999,1));
    }

    public void onDisable(){
        Minecraft.getMinecraft().thePlayer.removePotionEffectClient(Potion.nightVision.getId());
    }
}
