package com.teamaurora.frostburn_expansion.core;

import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import com.teamaurora.frostburn_expansion.common.entity.BriskEntity;
import com.teamaurora.frostburn_expansion.core.other.FBExCompat;
import com.teamaurora.frostburn_expansion.core.registry.FBExEffects;
import com.teamaurora.frostburn_expansion.core.registry.FBExEntities;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(FrostburnExpansion.MODID)
public class FrostburnExpansion
{
    public static final String MODID = "frostburn_expansion";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);

    public FrostburnExpansion() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        REGISTRY_HELPER.register(eventBus);

        FBExEffects.POTION_EFFECTS.register(eventBus);
        FBExEffects.POTIONS.register(eventBus);

        eventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            FBExCompat.registerDispenserBehaviors();
            FBExEffects.registerBrewingRecipes();
            GlobalEntityTypeAttributes.put(FBExEntities.BRISK.get(), BriskEntity.setCustomAttributes().create());
        });
    }
}