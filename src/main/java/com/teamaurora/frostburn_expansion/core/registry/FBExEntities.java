package com.teamaurora.frostburn_expansion.core.registry;

import com.minecraftabnormals.abnormals_core.core.util.registry.EntitySubRegistryHelper;
import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import com.teamaurora.frostburn_expansion.client.render.entity.BriskRenderer;
import com.teamaurora.frostburn_expansion.common.entity.BriskEntity;
import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = FrostburnExpansion.MODID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class FBExEntities {
    public static final EntitySubRegistryHelper HELPER = FrostburnExpansion.REGISTRY_HELPER.getEntitySubHelper();
    public static final RegistryObject<EntityType<BriskEntity>> BRISK = HELPER.createLivingEntity("brisk", BriskEntity::new, EntityClassification.MONSTER, 0.6F, 1.7F);
    // Put RegistryObjects here

    @OnlyIn(Dist.CLIENT)
    public static void registerRendering() {
        RenderingRegistry.registerEntityRenderingHandler(BRISK.get(), BriskRenderer::new);

    }

    public static void addEntitySpawns() {
        ForgeRegistries.BIOMES.getValues().stream().forEach(FBExEntities::processSpawning);
    }

    private static void processSpawning(Biome biome) {
        // Process entity spawning here
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        // Register entities into EntitySpawnPlacementRegistry
    }
}
