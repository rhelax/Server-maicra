package net.minecraft.data.worldgen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.world.level.levelgen.structure.pools.WorldGenFeatureDefinedStructurePoolStructure;
import net.minecraft.world.level.levelgen.structure.pools.WorldGenFeatureDefinedStructurePoolTemplate;

public class WorldGenFeatureBastionExtra {

    public WorldGenFeatureBastionExtra() {}

    public static void bootstrap() {}

    static {
        WorldGenFeaturePieces.register(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("bastion/mobs/piglin"), new MinecraftKey("empty"), ImmutableList.of(Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/mobs/melee_piglin"), 1), Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/mobs/sword_piglin"), 4), Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/mobs/crossbow_piglin"), 4), Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/mobs/empty"), 1)), WorldGenFeatureDefinedStructurePoolTemplate.Matching.RIGID));
        WorldGenFeaturePieces.register(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("bastion/mobs/hoglin"), new MinecraftKey("empty"), ImmutableList.of(Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/mobs/hoglin"), 2), Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/mobs/empty"), 1)), WorldGenFeatureDefinedStructurePoolTemplate.Matching.RIGID));
        WorldGenFeaturePieces.register(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("bastion/blocks/gold"), new MinecraftKey("empty"), ImmutableList.of(Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/blocks/air"), 3), Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/blocks/gold"), 1)), WorldGenFeatureDefinedStructurePoolTemplate.Matching.RIGID));
        WorldGenFeaturePieces.register(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("bastion/mobs/piglin_melee"), new MinecraftKey("empty"), ImmutableList.of(Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/mobs/melee_piglin_always"), 1), Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/mobs/melee_piglin"), 5), Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/mobs/sword_piglin"), 1)), WorldGenFeatureDefinedStructurePoolTemplate.Matching.RIGID));
    }
}
