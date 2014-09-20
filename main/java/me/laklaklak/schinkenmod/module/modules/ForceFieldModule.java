package me.laklaklak.schinkenmod.module.modules;

import me.laklaklak.schinkenmod.module.SchinkenModule;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.input.Keyboard;

/**
 * Created by Paul on 31.08.2014.
 */
public class ForceFieldModule extends SchinkenModule {
    public ForceFieldModule() {
        super("ForceField", Keyboard.KEY_R);
    }

    public void onUpdate(){
        for(int i = 0; i < Minecraft.getMinecraft().theWorld.loadedEntityList.size(); i++){
           Entity entity = (Entity)Minecraft.getMinecraft().theWorld.loadedEntityList.get(i);
           if(entity instanceof EntityLivingBase && !(entity instanceof EntityClientPlayerMP)){
               if(entity.getDistanceToEntity(Minecraft.getMinecraft().thePlayer) < 5D){
                   Minecraft.getMinecraft().playerController.attackEntity(Minecraft.getMinecraft().thePlayer,entity);
                   Minecraft.getMinecraft().thePlayer.swingItem();
               }
        }
    }
    }
}
