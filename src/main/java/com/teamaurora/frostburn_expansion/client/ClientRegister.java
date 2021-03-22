package com.teamaurora.frostburn_expansion.client;

import com.teamaurora.frostburn_expansion.common.entity.BriskEntity;
import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import com.teamaurora.frostburn_expansion.core.registry.FBExEntities;
import com.teamaurora.frostburn_expansion.core.registry.FBExSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = FrostburnExpansion.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegister {

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            setupRenderLayer();
        });

        FBExEntities.registerRendering();
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.getSoundHandler().addListener((sound, accessor) -> {
            if (sound.getSoundLocation().toString().contentEquals(FBExSounds.BRISKSONG.getRegistryName().toString())) {
                minecraft.world.getEntitiesWithinAABB(BriskEntity.class, new AxisAlignedBB(new BlockPos(sound.getX(), sound.getY(), sound.getZ())).grow(3.0D)).forEach(entity -> {
                    System.out.println("pog");
                    if (entity.isNoEndimationPlaying()) {
                        entity.setPlayingEndimation(BriskEntity.DANCE);
                    }
                });
            }
        });
    }

    public static void setupRenderLayer() {
    }
}
