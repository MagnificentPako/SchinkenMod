package me.laklaklak.schinkenmod.module;

import me.laklaklak.schinkenmod.SchinkenMod;
import me.laklaklak.schinkenmod.module.SchinkenModule;
import me.laklaklak.schinkenmod.module.modules.*;

import java.util.ArrayList;

/**
 * Created by Paul on 31.08.2014.
 */
public class SchinkenModuleManager {

    public static ArrayList<SchinkenModule> activeModules = new ArrayList<SchinkenModule>();

    public SchinkenModuleManager(){
        registerModule(new FlyModule());
        registerModule(new NoFallModule());
        registerModule(new BrightnessModule());
        registerModule(new SprintModule());
        registerModule(new ForceFieldModule());
        registerModule(new SneakModule());
        registerModule(new StepModule());
    }

    private void registerModule(SchinkenModule module){
        module.registerKeybind();
        activeModules.add(module);
    }

    public static SchinkenModule getModuleByName(String name){
        SchinkenModule foundModule = null;
        for(SchinkenModule module : activeModules){
            if(module.getName() == name){
                foundModule = module;
                break;
            }
        }
        return foundModule;
    }

}
