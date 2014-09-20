package me.laklaklak.schinkenmod;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import me.laklaklak.schinkenmod.events.TickHandler;
import me.laklaklak.schinkenmod.module.SchinkenModule;
import me.laklaklak.schinkenmod.module.SchinkenModuleManager;
import net.minecraft.block.Block;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

@Mod(modid = SchinkenMod.MODID, version = SchinkenMod.VERSION)
public class SchinkenMod
{
    public static final String MODID = "schinken";
    public static final String VERSION = "0.2";

    public static SchinkenMod instance;
    public static SchinkenModuleManager moduleManager;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        instance = this;
        moduleManager = new SchinkenModuleManager();

        MinecraftForge.EVENT_BUS.register(new TickHandler());

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}
