package me.laklaklak.schinkenmod.module.keybinds;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.TickType;
import me.laklaklak.schinkenmod.module.SchinkenModule;
import me.laklaklak.schinkenmod.module.SchinkenModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.GuiIngameForge;

import java.util.EnumSet;

/**
 * Created by Paul on 31.08.2014.
 */
public class ModuleKeybind extends KeyBindingRegistry.KeyHandler {

    private EnumSet tickTypes = EnumSet.of(TickType.CLIENT);

    private int key;

    public ModuleKeybind(KeyBinding[] keyBindings, boolean[] repeatings) {
        super(keyBindings, repeatings);
        this.key = keyBindings[0].keyCode;
    }

    private boolean released = false;
    private boolean isKeyPressed = false;
    private boolean firstTimePressed = true;

    @Override
    public void keyDown(EnumSet<TickType> tickTypes, KeyBinding keyBinding, boolean b, boolean b2) {
        if(Minecraft.getMinecraft().currentScreen == null) {
            released = false;
            if (released == false && isKeyPressed == false && firstTimePressed == true)
                isKeyPressed = true;
            if (isKeyPressed == true && firstTimePressed == true) {
                for (SchinkenModule module : SchinkenModuleManager.activeModules) {
                    if (module.getModuleKeybind() == key) {
                        module.toggleModule();
                        Minecraft.getMinecraft().thePlayer.playSound("random.click", 1, 1);
                        firstTimePressed = false;
                    }
                }
            }
        }
    }

    @Override
    public void keyUp(EnumSet<TickType> tickTypes, KeyBinding keyBinding, boolean b) {
        if(released == false) released = true;
        firstTimePressed = true;
    }

    @Override
    public EnumSet<TickType> ticks() {
        return tickTypes;
    }

    @Override
    public String getLabel() {
        return "Fly";
    }

}
