package com.teamaurora.frostburn_expansion.core.other;

import com.teamaurora.frostburn_expansion.common.entity.BriskEntity;
import com.teamaurora.frostburn_expansion.core.FBExConfig;
import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import com.teamaurora.frostburn_expansion.core.registry.FBExBlocks;
import com.teamaurora.frostburn_expansion.core.registry.FBExEffects;
import com.teamaurora.frostburn_expansion.core.registry.FBExEntities;
import com.teamaurora.frostburn_expansion.core.registry.FBExItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FrostburnExpansion.MODID)
public class FBExEvents {
    @SubscribeEvent
    public static void onSpecialSpawn(LivingSpawnEvent.SpecialSpawn event) {
        if (event.getSpawnReason() == SpawnReason.NATURAL && event.getEntityLiving().getType() == EntityType.CREEPER) {
            Biome biomeIn = event.getWorld().getBiome(new BlockPos(event.getX(), event.getY(), event.getZ()));
            //if (biomeIn == Biomes.SNOWY_BEACH || biomeIn == Biomes.SNOWY_MOUNTAINS || biomeIn == Biomes.SNOWY_TAIGA || biomeIn == Biomes.SNOWY_TAIGA_HILLS || biomeIn == Biomes.SNOWY_TAIGA_MOUNTAINS || biomeIn == Biomes.SNOWY_TUNDRA || biomeIn == Biomes.ICE_SPIKES) {
            if (FBExConfig.COMMON.briskBiomes.get().contains(biomeIn.getRegistryName().toString()) && (event.getWorld().getRandom().nextInt(5) > 0 || FBExConfig.COMMON.alwaysBriskSpawn.get())) {
                // brisk time!
                BriskEntity brisk = FBExEntities.BRISK.get().create((World) event.getWorld());
                if (brisk != null) {
                    brisk.setPosition(event.getX(), event.getY(), event.getZ());
                    event.getWorld().addEntity(brisk);
                }
                event.getEntityLiving().remove();
                event.setResult(Event.Result.DENY);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        if (event.getEntity() instanceof BriskEntity) {
            // code shamelessly stolen from Savage & Ravage since my loot table solution wasn't working
            BriskEntity brisk = (BriskEntity) event.getEntity();
            if (event.getSource().isExplosion()) {
                brisk.entityDropItem(new ItemStack(FBExItems.FROZEN_SPORES.get(), 1 + brisk.world.rand.nextInt(5)));
            }
        }
    }

    @SuppressWarnings("deprecation")
    @SubscribeEvent
    public static void onInteractWithBlock(PlayerInteractEvent.RightClickBlock event) {
        ItemStack itemStack = event.getItemStack();
        Item item = itemStack.getItem();
        PlayerEntity player = event.getPlayer();
        BlockPos pos = event.getPos();
        if (event.getWorld().getBlockState(pos).getBlock() == Blocks.FLOWER_POT && item == FBExItems.FROZEN_SPORES.get()) {
            event.getWorld().setBlockState(pos, FBExBlocks.POTTED_BRISK.get().getDefaultState());
            event.getPlayer().swingArm(event.getHand());
            player.addStat(Stats.POT_FLOWER);
            if (!event.getPlayer().abilities.isCreativeMode) {
                itemStack.shrink(1);
            }
        }
    }

    @SubscribeEvent
    public static void onEntityHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof LivingEntity) {
            LivingEntity entity = event.getEntityLiving();
            if (entity.isPotionActive(FBExEffects.FRAILTY.get())) {
                int lv = entity.getActivePotionEffect(FBExEffects.FRAILTY.get()).getAmplifier();
                float fulldamage = event.getAmount() * ((lv*0.2F));
                event.setAmount(event.getAmount()+fulldamage);
            }
        }
    }
}
