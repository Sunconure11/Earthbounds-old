package com.github.klyser8.earthbounds.registry.features;

import com.github.klyser8.earthbounds.Earthbounds;
import com.github.klyser8.earthbounds.registry.EarthboundBlocks;
import com.github.klyser8.earthbounds.world.features.coalden.CoalDenFeatureConfig;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;

public class EarthboundConfiguredFeatures {

    public static ConfiguredFeature<?, ?> REDSTONE_FOSSIL =
            new ConfiguredFeature<>(Feature.REPLACE_SINGLE_BLOCK,
            new EmeraldOreFeatureConfig(Blocks.STONE.getDefaultState(),
                    EarthboundBlocks.REDSTONE_FOSSIL_BLOCK.getDefaultState()));
    public static ConfiguredFeature<?, ?> GILDED_REDSTONE_FOSSIL =
            new ConfiguredFeature<>(Feature.REPLACE_SINGLE_BLOCK,
            new EmeraldOreFeatureConfig(Blocks.STONE.getDefaultState(),
                    EarthboundBlocks.GILDED_REDSTONE_FOSSIL_BLOCK.getDefaultState()));
    public static ConfiguredFeature<?, ?> CRYSTALLINE_REDSTONE_FOSSIL =
            new ConfiguredFeature<>(Feature.REPLACE_SINGLE_BLOCK,
            new EmeraldOreFeatureConfig(Blocks.STONE.getDefaultState(),
                    EarthboundBlocks.CRYSTALLINE_REDSTONE_FOSSIL_BLOCK.getDefaultState()));
    public static ConfiguredFeature<?, ?> CHARRED_REDSTONE_FOSSIL =
            new ConfiguredFeature<>(Feature.REPLACE_SINGLE_BLOCK,
            new EmeraldOreFeatureConfig(Blocks.STONE.getDefaultState(),
                    EarthboundBlocks.CHARRED_REDSTONE_FOSSIL_BLOCK.getDefaultState()));
    public static ConfiguredFeature<?, ?> VERDANT_REDSTONE_FOSSIL =
            new ConfiguredFeature<>(Feature.REPLACE_SINGLE_BLOCK,
            new EmeraldOreFeatureConfig(Blocks.STONE.getDefaultState(),
                    EarthboundBlocks.VERDANT_REDSTONE_FOSSIL_BLOCK.getDefaultState()));
    public static ConfiguredFeature<?, ?> CRIMSON_REDSTONE_FOSSIL =
            new ConfiguredFeature<>(Feature.REPLACE_SINGLE_BLOCK,
            new EmeraldOreFeatureConfig(Blocks.STONE.getDefaultState(),
                    EarthboundBlocks.CRIMSON_REDSTONE_FOSSIL_BLOCK.getDefaultState()));

    public static ConfiguredFeature<?, ?> DEEPSLATE_REDSTONE_FOSSIL =
            new ConfiguredFeature<>(Feature.REPLACE_SINGLE_BLOCK,
            new EmeraldOreFeatureConfig(Blocks.DEEPSLATE.getDefaultState(),
                    EarthboundBlocks.DEEPSLATE_REDSTONE_FOSSIL_BLOCK.getDefaultState()));
    public static ConfiguredFeature<?, ?> DEEPSLATE_GILDED_REDSTONE_FOSSIL =
            new ConfiguredFeature<>(Feature.REPLACE_SINGLE_BLOCK,
            new EmeraldOreFeatureConfig(Blocks.DEEPSLATE.getDefaultState(),
                    EarthboundBlocks.DEEPSLATE_GILDED_REDSTONE_FOSSIL_BLOCK.getDefaultState()));
    public static ConfiguredFeature<?, ?> DEEPSLATE_CRYSTALLINE_REDSTONE_FOSSIL =
            new ConfiguredFeature<>(Feature.REPLACE_SINGLE_BLOCK,
            new EmeraldOreFeatureConfig(Blocks.DEEPSLATE.getDefaultState(),
                    EarthboundBlocks.DEEPSLATE_CRYSTALLINE_REDSTONE_FOSSIL_BLOCK.getDefaultState()));
    public static ConfiguredFeature<?, ?> DEEPSLATE_CHARRED_REDSTONE_FOSSIL =
            new ConfiguredFeature<>(Feature.REPLACE_SINGLE_BLOCK,
            new EmeraldOreFeatureConfig(Blocks.DEEPSLATE.getDefaultState(),
                    EarthboundBlocks.DEEPSLATE_CHARRED_REDSTONE_FOSSIL_BLOCK.getDefaultState()));
    public static ConfiguredFeature<?, ?> DEEPSLATE_VERDANT_REDSTONE_FOSSIL =
            new ConfiguredFeature<>(Feature.REPLACE_SINGLE_BLOCK,
            new EmeraldOreFeatureConfig(Blocks.DEEPSLATE.getDefaultState(),
                    EarthboundBlocks.DEEPSLATE_VERDANT_REDSTONE_FOSSIL_BLOCK.getDefaultState()));
    public static ConfiguredFeature<?, ?> DEEPSLATE_CRIMSON_REDSTONE_FOSSIL =
            new ConfiguredFeature<>(Feature.REPLACE_SINGLE_BLOCK,
            new EmeraldOreFeatureConfig(Blocks.DEEPSLATE.getDefaultState(),
                    EarthboundBlocks.DEEPSLATE_CRIMSON_REDSTONE_FOSSIL_BLOCK.getDefaultState()));

    public static ConfiguredFeature<?, ?> SMALL_COAL_DEN =
            new ConfiguredFeature<>(EarthboundFeatures.COAL_DEN,
            new CoalDenFeatureConfig(
                    ConstantIntProvider.create(-8), ConstantIntProvider.create(12)));
    public static ConfiguredFeature<?, ?> GLOW_GREASE_SPLAT =
            new ConfiguredFeature<>(EarthboundFeatures.GLOW_GREASE_SPLAT,
            new DefaultFeatureConfig());


    //Discard on air chance = Chance that if the block is exposed to air, it is discarded.
    public static void register() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Earthbounds.MOD_ID,
                "redstone_fossil"), REDSTONE_FOSSIL);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Earthbounds.MOD_ID,
                "gilded_redstone_fossil"), GILDED_REDSTONE_FOSSIL);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Earthbounds.MOD_ID,
                "crystalline_redstone_fossil"), CRYSTALLINE_REDSTONE_FOSSIL);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Earthbounds.MOD_ID,
                "charred_redstone_fossil"), CHARRED_REDSTONE_FOSSIL);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Earthbounds.MOD_ID,
                "verdant_redstone_fossil"), VERDANT_REDSTONE_FOSSIL);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Earthbounds.MOD_ID,
                "crimson_redstone_fossil"), CRIMSON_REDSTONE_FOSSIL);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Earthbounds.MOD_ID,
                "deepslate_redstone_fossil"), DEEPSLATE_REDSTONE_FOSSIL);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Earthbounds.MOD_ID,
                        "deepslate_gilded_redstone_fossil"), DEEPSLATE_GILDED_REDSTONE_FOSSIL);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Earthbounds.MOD_ID,
                        "deepslate_crystalline_redstone_fossil"), DEEPSLATE_CRYSTALLINE_REDSTONE_FOSSIL);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Earthbounds.MOD_ID,
                        "deepslate_charred_redstone_fossil"), DEEPSLATE_CHARRED_REDSTONE_FOSSIL);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Earthbounds.MOD_ID,
                        "deepslate_verdant_redstone_fossil"), DEEPSLATE_VERDANT_REDSTONE_FOSSIL);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Earthbounds.MOD_ID,
                        "deepslate_crimson_redstone_fossil"), DEEPSLATE_CRIMSON_REDSTONE_FOSSIL);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(Earthbounds.MOD_ID, "small_coal_den"), SMALL_COAL_DEN);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(Earthbounds.MOD_ID, "glow_grease_splat"), GLOW_GREASE_SPLAT);
    }

}
