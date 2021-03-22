package com.teamaurora.frostburn_expansion.core.registry;

import com.minecraftabnormals.abnormals_core.common.items.AbnormalsSpawnEggItem;
import com.minecraftabnormals.abnormals_core.core.util.registry.ItemSubRegistryHelper;
import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import com.teamaurora.frostburn_expansion.common.item.BrisksongDiscItem;
import com.teamaurora.frostburn_expansion.common.item.FrozenSporesItem;
import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FrostburnExpansion.MODID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class FBExItems {
    public static final ItemSubRegistryHelper HELPER = FrostburnExpansion.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<AbnormalsSpawnEggItem> BRISK_SPAWN_EGG = HELPER.createSpawnEggItem("brisk", ()->FBExEntities.BRISK.get(), 0x84D6DB, 0x359289);
    public static final RegistryObject<Item> FROZEN_SPORES = HELPER.createItem("frozen_spores", ()->new FrozenSporesItem(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> BRISKSONG_RECORD = HELPER.createItem("music_disc_brisksong", ()->new BrisksongDiscItem(14, ()->FBExSounds.BRISKSONG, new Item.Properties().maxStackSize(1).group(ItemGroup.MISC).rarity(Rarity.RARE)));

}
