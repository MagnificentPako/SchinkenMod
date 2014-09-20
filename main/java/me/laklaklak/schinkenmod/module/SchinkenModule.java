package me.laklaklak.schinkenmod.module;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import me.laklaklak.schinkenmod.SchinkenMod;
import me.laklaklak.schinkenmod.module.keybinds.ModuleKeybind;
import net.minecraft.client.settings.KeyBinding;

/**
 * Created by Paul on 31.08.2014.
 */
public class SchinkenModule {

    private String moduleName;
    private int moduleKeybind;
    private boolean isToggled;

    public SchinkenModule(String moduleName, int moduleKeybind){
        this.moduleKeybind = moduleKeybind;
        this.moduleName = moduleName;
        this.isToggled = false;
    }

    public String getName(){
        return this.moduleName;
    }

    public int getModuleKeybind() {
        return this.moduleKeybind;
    }

    public void setToggled(boolean toggle) {
        if (toggle != this.isToggled) {
            this.isToggled = toggle;
            this.onToggle();
            if(toggle == false){
                this.onDisable();
            }else{
                this.onEnable();
            }
        }
    }

    public void toggleModule(){
        this.setToggled(!this.isToggled);
    }

    public boolean getToggled() {return this.isToggled;}

    public void registerKeybind(){
        KeyBinding[] key = {new KeyBinding(this.getName(), this.getModuleKeybind())};
        boolean[] repeat = {false};
        KeyBindingRegistry.registerKeyBinding(new ModuleKeybind(key, repeat));
    }

    public void onUpdate() {}
    public void onEnable() {}
    public void onDisable() {}
    public void onToggle() {}

}
