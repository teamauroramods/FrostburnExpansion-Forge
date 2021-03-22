package com.teamaurora.frostburn_expansion.core.registry;

import com.minecraftabnormals.abnormals_core.common.blocks.AbnormalsStairsBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.VerticalSlabBlock;
import com.minecraftabnormals.abnormals_core.core.util.registry.BlockSubRegistryHelper;
import com.teamaurora.frostburn_expansion.common.block.ImprovedFlowerPotBlock;
import com.teamaurora.frostburn_expansion.core.FrostburnExpansion;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FrostburnExpansion.MODID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class FBExBlocks {

    public static final BlockSubRegistryHelper HELPER = FrostburnExpansion.REGISTRY_HELPER.getBlockSubHelper();

    // Frozen Spore stuff
    public static final RegistryObject<Block> POTTED_BRISK = HELPER.createBlockNoItem("potted_frozen_spores", ()->new ImprovedFlowerPotBlock(FBExItems.FROZEN_SPORES, AbstractBlock.Properties.from(Blocks.FLOWER_POT)));
    public static final RegistryObject<Block> FROZEN_SPORE_SACK = HELPER.createCompatBlock("quark", "frozen_spore_sack", ()->new Block(AbstractBlock.Properties.create(Material.WOOL, MaterialColor.LIGHT_BLUE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH)), ItemGroup.DECORATIONS);

    // Borealene
    public static final RegistryObject<Block> BOREALENE = HELPER.createBlock("borealene", ()->new Block(Properties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BOREALENE_SLAB = HELPER.createBlock("borealene_slab", ()->new SlabBlock(Properties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BOREALENE_STAIRS = HELPER.createBlock("borealene_stairs", ()->new AbnormalsStairsBlock(BOREALENE.get().getDefaultState(),Properties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BOREALENE_WALL = HELPER.createBlock("borealene_wall", ()->new WallBlock(Properties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BOREALENE_BRICKS = HELPER.createBlock("borealene_bricks", ()->new Block(Properties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BOREALENE_BRICK_SLAB = HELPER.createBlock("borealene_brick_slab", ()->new SlabBlock(Properties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BOREALENE_BRICK_STAIRS = HELPER.createBlock("borealene_brick_stairs", ()->new AbnormalsStairsBlock(BOREALENE_BRICKS.get().getDefaultState(),Properties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BOREALENE_BRICK_WALL = HELPER.createBlock("borealene_brick_wall", ()->new WallBlock(Properties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CRACKED_BOREALENE_BRICKS = HELPER.createBlock("cracked_borealene_bricks", ()->new Block(Properties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CHISELED_BOREALENE_BRICKS = HELPER.createBlock("chiseled_borealene_bricks", ()->new Block(Properties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BOREALENE_PILLAR = HELPER.createBlock("borealene_pillar", ()->new RotatedPillarBlock(Properties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BOREALENE_LAMP = HELPER.createBlock("borealene_lamp", ()->new Block(Properties.BOREALENE.setLightLevel((p_235464_0_) -> { return 14; })), ItemGroup.BUILDING_BLOCKS);

    public static final RegistryObject<Block> BOREALENE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "borealene_vertical_slab", ()->new VerticalSlabBlock(Properties.BOREALENE), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BOREALENE_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "borealene_brick_vertical_slab", ()->new VerticalSlabBlock(Properties.BOREALENE), ItemGroup.BUILDING_BLOCKS);

    public static final class Properties {
        public static final Block.Properties BOREALENE = Block.Properties.from(Blocks.STONE); //TODO: Custom borealene properties?
    }
}
