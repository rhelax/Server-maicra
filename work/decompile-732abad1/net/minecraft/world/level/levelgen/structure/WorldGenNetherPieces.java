package net.minecraft.world.level.levelgen.structure;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPosition;
import net.minecraft.core.EnumDirection;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.level.ChunkCoordIntPair;
import net.minecraft.world.level.GeneratorAccessSeed;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.block.BlockFence;
import net.minecraft.world.level.block.BlockStairs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.TileEntity;
import net.minecraft.world.level.block.entity.TileEntityMobSpawner;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.pieces.WorldGenFeatureStructurePieceType;
import net.minecraft.world.level.material.FluidType;
import net.minecraft.world.level.material.FluidTypes;
import net.minecraft.world.level.storage.loot.LootTables;

public class WorldGenNetherPieces {

    private static final int MAX_DEPTH = 30;
    private static final int LOWEST_Y_POSITION = 10;
    public static final int MAGIC_START_Y = 64;
    static final WorldGenNetherPieces.WorldGenNetherPieceWeight[] BRIDGE_PIECE_WEIGHTS = new WorldGenNetherPieces.WorldGenNetherPieceWeight[]{new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece3.class, 30, 0, true), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece1.class, 10, 4), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece13.class, 10, 4), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece14.class, 10, 3), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece12.class, 5, 2), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece6.class, 5, 1)};
    static final WorldGenNetherPieces.WorldGenNetherPieceWeight[] CASTLE_PIECE_WEIGHTS = new WorldGenNetherPieces.WorldGenNetherPieceWeight[]{new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece9.class, 25, 0, true), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece7.class, 15, 5), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece10.class, 5, 10), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece8.class, 5, 10), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece4.class, 10, 3, true), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece5.class, 7, 2), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece11.class, 5, 2)};

    public WorldGenNetherPieces() {}

    static WorldGenNetherPieces.WorldGenNetherPiece findAndCreateBridgePieceFactory(WorldGenNetherPieces.WorldGenNetherPieceWeight worldgennetherpieces_worldgennetherpieceweight, StructurePieceAccessor structurepieceaccessor, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
        Class<? extends WorldGenNetherPieces.WorldGenNetherPiece> oclass = worldgennetherpieces_worldgennetherpieceweight.pieceClass;
        Object object = null;

        if (oclass == WorldGenNetherPieces.WorldGenNetherPiece3.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece3.createPiece(structurepieceaccessor, random, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece1.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece1.createPiece(structurepieceaccessor, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece13.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece13.createPiece(structurepieceaccessor, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece14.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece14.createPiece(structurepieceaccessor, i, j, k, l, enumdirection);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece12.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece12.createPiece(structurepieceaccessor, i, j, k, l, enumdirection);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece6.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece6.createPiece(structurepieceaccessor, random, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece9.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece9.createPiece(structurepieceaccessor, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece10.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece10.createPiece(structurepieceaccessor, random, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece8.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece8.createPiece(structurepieceaccessor, random, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece4.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece4.createPiece(structurepieceaccessor, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece5.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece5.createPiece(structurepieceaccessor, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece7.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece7.createPiece(structurepieceaccessor, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece11.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece11.createPiece(structurepieceaccessor, i, j, k, enumdirection, l);
        }

        return (WorldGenNetherPieces.WorldGenNetherPiece) object;
    }

    private static class WorldGenNetherPieceWeight {

        public final Class<? extends WorldGenNetherPieces.WorldGenNetherPiece> pieceClass;
        public final int weight;
        public int placeCount;
        public final int maxPlaceCount;
        public final boolean allowInRow;

        public WorldGenNetherPieceWeight(Class<? extends WorldGenNetherPieces.WorldGenNetherPiece> oclass, int i, int j, boolean flag) {
            this.pieceClass = oclass;
            this.weight = i;
            this.maxPlaceCount = j;
            this.allowInRow = flag;
        }

        public WorldGenNetherPieceWeight(Class<? extends WorldGenNetherPieces.WorldGenNetherPiece> oclass, int i, int j) {
            this(oclass, i, j, false);
        }

        public boolean doPlace(int i) {
            return this.maxPlaceCount == 0 || this.placeCount < this.maxPlaceCount;
        }

        public boolean isValid() {
            return this.maxPlaceCount == 0 || this.placeCount < this.maxPlaceCount;
        }
    }

    public static class WorldGenNetherPiece3 extends WorldGenNetherPieces.WorldGenNetherPiece {

        private static final int WIDTH = 5;
        private static final int HEIGHT = 10;
        private static final int DEPTH = 19;

        public WorldGenNetherPiece3(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_BRIDGE_STRAIGHT, i, structureboundingbox);
            this.setOrientation(enumdirection);
        }

        public WorldGenNetherPiece3(NBTTagCompound nbttagcompound) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_BRIDGE_STRAIGHT, nbttagcompound);
        }

        @Override
        public void addChildren(StructurePiece structurepiece, StructurePieceAccessor structurepieceaccessor, Random random) {
            this.generateChildForward((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 1, 3, false);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece3 createPiece(StructurePieceAccessor structurepieceaccessor, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.orientBox(i, j, k, -1, -3, 0, 5, 10, 19, enumdirection);

            return isOkBox(structureboundingbox) && structurepieceaccessor.findCollisionPiece(structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece3(l, random, structureboundingbox, enumdirection) : null;
        }

        @Override
        public void postProcess(GeneratorAccessSeed generatoraccessseed, StructureManager structuremanager, ChunkGenerator chunkgenerator, Random random, StructureBoundingBox structureboundingbox, ChunkCoordIntPair chunkcoordintpair, BlockPosition blockposition) {
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 3, 0, 4, 4, 18, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 5, 0, 3, 7, 18, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 5, 0, 0, 5, 18, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 5, 0, 4, 5, 18, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 0, 4, 2, 5, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 13, 4, 2, 18, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 0, 0, 4, 1, 3, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 0, 15, 4, 1, 18, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);

            for (int i = 0; i <= 4; ++i) {
                for (int j = 0; j <= 2; ++j) {
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i, -1, j, structureboundingbox);
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i, -1, 18 - j, structureboundingbox);
                }
            }

            IBlockData iblockdata = (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.NORTH, true)).setValue(BlockFence.SOUTH, true);
            IBlockData iblockdata1 = (IBlockData) iblockdata.setValue(BlockFence.EAST, true);
            IBlockData iblockdata2 = (IBlockData) iblockdata.setValue(BlockFence.WEST, true);

            this.generateBox(generatoraccessseed, structureboundingbox, 0, 1, 1, 0, 4, 1, iblockdata1, iblockdata1, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 3, 4, 0, 4, 4, iblockdata1, iblockdata1, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 3, 14, 0, 4, 14, iblockdata1, iblockdata1, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 1, 17, 0, 4, 17, iblockdata1, iblockdata1, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 1, 1, 4, 4, 1, iblockdata2, iblockdata2, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 3, 4, 4, 4, 4, iblockdata2, iblockdata2, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 3, 14, 4, 4, 14, iblockdata2, iblockdata2, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 1, 17, 4, 4, 17, iblockdata2, iblockdata2, false);
        }
    }

    public static class WorldGenNetherPiece1 extends WorldGenNetherPieces.WorldGenNetherPiece {

        private static final int WIDTH = 19;
        private static final int HEIGHT = 10;
        private static final int DEPTH = 19;

        public WorldGenNetherPiece1(int i, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_BRIDGE_CROSSING, i, structureboundingbox);
            this.setOrientation(enumdirection);
        }

        protected WorldGenNetherPiece1(int i, int j, EnumDirection enumdirection) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_BRIDGE_CROSSING, 0, StructurePiece.makeBoundingBox(i, 64, j, enumdirection, 19, 10, 19));
            this.setOrientation(enumdirection);
        }

        protected WorldGenNetherPiece1(WorldGenFeatureStructurePieceType worldgenfeaturestructurepiecetype, NBTTagCompound nbttagcompound) {
            super(worldgenfeaturestructurepiecetype, nbttagcompound);
        }

        public WorldGenNetherPiece1(NBTTagCompound nbttagcompound) {
            this(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_BRIDGE_CROSSING, nbttagcompound);
        }

        @Override
        public void addChildren(StructurePiece structurepiece, StructurePieceAccessor structurepieceaccessor, Random random) {
            this.generateChildForward((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 8, 3, false);
            this.generateChildLeft((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 3, 8, false);
            this.generateChildRight((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 3, 8, false);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece1 createPiece(StructurePieceAccessor structurepieceaccessor, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.orientBox(i, j, k, -8, -3, 0, 19, 10, 19, enumdirection);

            return isOkBox(structureboundingbox) && structurepieceaccessor.findCollisionPiece(structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece1(l, structureboundingbox, enumdirection) : null;
        }

        @Override
        public void postProcess(GeneratorAccessSeed generatoraccessseed, StructureManager structuremanager, ChunkGenerator chunkgenerator, Random random, StructureBoundingBox structureboundingbox, ChunkCoordIntPair chunkcoordintpair, BlockPosition blockposition) {
            this.generateBox(generatoraccessseed, structureboundingbox, 7, 3, 0, 11, 4, 18, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 3, 7, 18, 4, 11, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 8, 5, 0, 10, 7, 18, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 5, 8, 18, 7, 10, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 7, 5, 0, 7, 5, 7, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 7, 5, 11, 7, 5, 18, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 11, 5, 0, 11, 5, 7, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 11, 5, 11, 11, 5, 18, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 5, 7, 7, 5, 7, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 11, 5, 7, 18, 5, 7, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 5, 11, 7, 5, 11, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 11, 5, 11, 18, 5, 11, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 7, 2, 0, 11, 2, 5, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 7, 2, 13, 11, 2, 18, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 7, 0, 0, 11, 1, 3, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 7, 0, 15, 11, 1, 18, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);

            int i;
            int j;

            for (i = 7; i <= 11; ++i) {
                for (j = 0; j <= 2; ++j) {
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i, -1, j, structureboundingbox);
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i, -1, 18 - j, structureboundingbox);
                }
            }

            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 7, 5, 2, 11, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 13, 2, 7, 18, 2, 11, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 0, 7, 3, 1, 11, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 15, 0, 7, 18, 1, 11, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);

            for (i = 0; i <= 2; ++i) {
                for (j = 7; j <= 11; ++j) {
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i, -1, j, structureboundingbox);
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), 18 - i, -1, j, structureboundingbox);
                }
            }

        }
    }

    public static class WorldGenNetherPiece13 extends WorldGenNetherPieces.WorldGenNetherPiece {

        private static final int WIDTH = 7;
        private static final int HEIGHT = 9;
        private static final int DEPTH = 7;

        public WorldGenNetherPiece13(int i, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_ROOM_CROSSING, i, structureboundingbox);
            this.setOrientation(enumdirection);
        }

        public WorldGenNetherPiece13(NBTTagCompound nbttagcompound) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_ROOM_CROSSING, nbttagcompound);
        }

        @Override
        public void addChildren(StructurePiece structurepiece, StructurePieceAccessor structurepieceaccessor, Random random) {
            this.generateChildForward((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 2, 0, false);
            this.generateChildLeft((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 0, 2, false);
            this.generateChildRight((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 0, 2, false);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece13 createPiece(StructurePieceAccessor structurepieceaccessor, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.orientBox(i, j, k, -2, 0, 0, 7, 9, 7, enumdirection);

            return isOkBox(structureboundingbox) && structurepieceaccessor.findCollisionPiece(structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece13(l, structureboundingbox, enumdirection) : null;
        }

        @Override
        public void postProcess(GeneratorAccessSeed generatoraccessseed, StructureManager structuremanager, ChunkGenerator chunkgenerator, Random random, StructureBoundingBox structureboundingbox, ChunkCoordIntPair chunkcoordintpair, BlockPosition blockposition) {
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 0, 0, 6, 1, 6, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 0, 6, 7, 6, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 0, 1, 6, 0, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 6, 1, 6, 6, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 5, 2, 0, 6, 6, 0, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 5, 2, 6, 6, 6, 6, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 0, 0, 6, 1, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 5, 0, 6, 6, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 6, 2, 0, 6, 6, 1, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 6, 2, 5, 6, 6, 6, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            IBlockData iblockdata = (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.WEST, true)).setValue(BlockFence.EAST, true);
            IBlockData iblockdata1 = (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.NORTH, true)).setValue(BlockFence.SOUTH, true);

            this.generateBox(generatoraccessseed, structureboundingbox, 2, 6, 0, 4, 6, 0, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 2, 5, 0, 4, 5, 0, iblockdata, iblockdata, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 2, 6, 6, 4, 6, 6, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 2, 5, 6, 4, 5, 6, iblockdata, iblockdata, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 6, 2, 0, 6, 4, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 5, 2, 0, 5, 4, iblockdata1, iblockdata1, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 6, 6, 2, 6, 6, 4, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 6, 5, 2, 6, 5, 4, iblockdata1, iblockdata1, false);

            for (int i = 0; i <= 6; ++i) {
                for (int j = 0; j <= 6; ++j) {
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i, -1, j, structureboundingbox);
                }
            }

        }
    }

    public static class WorldGenNetherPiece14 extends WorldGenNetherPieces.WorldGenNetherPiece {

        private static final int WIDTH = 7;
        private static final int HEIGHT = 11;
        private static final int DEPTH = 7;

        public WorldGenNetherPiece14(int i, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_STAIRS_ROOM, i, structureboundingbox);
            this.setOrientation(enumdirection);
        }

        public WorldGenNetherPiece14(NBTTagCompound nbttagcompound) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_STAIRS_ROOM, nbttagcompound);
        }

        @Override
        public void addChildren(StructurePiece structurepiece, StructurePieceAccessor structurepieceaccessor, Random random) {
            this.generateChildRight((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 6, 2, false);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece14 createPiece(StructurePieceAccessor structurepieceaccessor, int i, int j, int k, int l, EnumDirection enumdirection) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.orientBox(i, j, k, -2, 0, 0, 7, 11, 7, enumdirection);

            return isOkBox(structureboundingbox) && structurepieceaccessor.findCollisionPiece(structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece14(l, structureboundingbox, enumdirection) : null;
        }

        @Override
        public void postProcess(GeneratorAccessSeed generatoraccessseed, StructureManager structuremanager, ChunkGenerator chunkgenerator, Random random, StructureBoundingBox structureboundingbox, ChunkCoordIntPair chunkcoordintpair, BlockPosition blockposition) {
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 0, 0, 6, 1, 6, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 0, 6, 10, 6, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 0, 1, 8, 0, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 5, 2, 0, 6, 8, 0, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 1, 0, 8, 6, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 6, 2, 1, 6, 8, 6, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 2, 6, 5, 8, 6, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            IBlockData iblockdata = (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.WEST, true)).setValue(BlockFence.EAST, true);
            IBlockData iblockdata1 = (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.NORTH, true)).setValue(BlockFence.SOUTH, true);

            this.generateBox(generatoraccessseed, structureboundingbox, 0, 3, 2, 0, 5, 4, iblockdata1, iblockdata1, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 6, 3, 2, 6, 5, 2, iblockdata1, iblockdata1, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 6, 3, 4, 6, 5, 4, iblockdata1, iblockdata1, false);
            this.placeBlock(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), 5, 2, 5, structureboundingbox);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 2, 5, 4, 3, 5, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 3, 2, 5, 3, 4, 5, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 2, 2, 5, 2, 5, 5, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 2, 5, 1, 6, 5, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 7, 1, 5, 7, 4, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 6, 8, 2, 6, 8, 4, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 2, 6, 0, 4, 8, 0, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 2, 5, 0, 4, 5, 0, iblockdata, iblockdata, false);

            for (int i = 0; i <= 6; ++i) {
                for (int j = 0; j <= 6; ++j) {
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i, -1, j, structureboundingbox);
                }
            }

        }
    }

    public static class WorldGenNetherPiece12 extends WorldGenNetherPieces.WorldGenNetherPiece {

        private static final int WIDTH = 7;
        private static final int HEIGHT = 8;
        private static final int DEPTH = 9;
        private boolean hasPlacedSpawner;

        public WorldGenNetherPiece12(int i, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_MONSTER_THRONE, i, structureboundingbox);
            this.setOrientation(enumdirection);
        }

        public WorldGenNetherPiece12(NBTTagCompound nbttagcompound) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_MONSTER_THRONE, nbttagcompound);
            this.hasPlacedSpawner = nbttagcompound.getBoolean("Mob");
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurepieceserializationcontext, NBTTagCompound nbttagcompound) {
            super.addAdditionalSaveData(structurepieceserializationcontext, nbttagcompound);
            nbttagcompound.putBoolean("Mob", this.hasPlacedSpawner);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece12 createPiece(StructurePieceAccessor structurepieceaccessor, int i, int j, int k, int l, EnumDirection enumdirection) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.orientBox(i, j, k, -2, 0, 0, 7, 8, 9, enumdirection);

            return isOkBox(structureboundingbox) && structurepieceaccessor.findCollisionPiece(structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece12(l, structureboundingbox, enumdirection) : null;
        }

        @Override
        public void postProcess(GeneratorAccessSeed generatoraccessseed, StructureManager structuremanager, ChunkGenerator chunkgenerator, Random random, StructureBoundingBox structureboundingbox, ChunkCoordIntPair chunkcoordintpair, BlockPosition blockposition) {
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 0, 6, 7, 7, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 0, 0, 5, 1, 7, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 2, 1, 5, 2, 7, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 3, 2, 5, 3, 7, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 4, 3, 5, 4, 7, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 2, 0, 1, 4, 2, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 5, 2, 0, 5, 4, 2, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 5, 2, 1, 5, 3, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 5, 5, 2, 5, 5, 3, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 5, 3, 0, 5, 8, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 6, 5, 3, 6, 5, 8, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 5, 8, 5, 5, 8, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            IBlockData iblockdata = (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.WEST, true)).setValue(BlockFence.EAST, true);
            IBlockData iblockdata1 = (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.NORTH, true)).setValue(BlockFence.SOUTH, true);

            this.placeBlock(generatoraccessseed, (IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.WEST, true), 1, 6, 3, structureboundingbox);
            this.placeBlock(generatoraccessseed, (IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.EAST, true), 5, 6, 3, structureboundingbox);
            this.placeBlock(generatoraccessseed, (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.EAST, true)).setValue(BlockFence.NORTH, true), 0, 6, 3, structureboundingbox);
            this.placeBlock(generatoraccessseed, (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.WEST, true)).setValue(BlockFence.NORTH, true), 6, 6, 3, structureboundingbox);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 6, 4, 0, 6, 7, iblockdata1, iblockdata1, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 6, 6, 4, 6, 6, 7, iblockdata1, iblockdata1, false);
            this.placeBlock(generatoraccessseed, (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.EAST, true)).setValue(BlockFence.SOUTH, true), 0, 6, 8, structureboundingbox);
            this.placeBlock(generatoraccessseed, (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.WEST, true)).setValue(BlockFence.SOUTH, true), 6, 6, 8, structureboundingbox);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 6, 8, 5, 6, 8, iblockdata, iblockdata, false);
            this.placeBlock(generatoraccessseed, (IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.EAST, true), 1, 7, 8, structureboundingbox);
            this.generateBox(generatoraccessseed, structureboundingbox, 2, 7, 8, 4, 7, 8, iblockdata, iblockdata, false);
            this.placeBlock(generatoraccessseed, (IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.WEST, true), 5, 7, 8, structureboundingbox);
            this.placeBlock(generatoraccessseed, (IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.EAST, true), 2, 8, 8, structureboundingbox);
            this.placeBlock(generatoraccessseed, iblockdata, 3, 8, 8, structureboundingbox);
            this.placeBlock(generatoraccessseed, (IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.WEST, true), 4, 8, 8, structureboundingbox);
            if (!this.hasPlacedSpawner) {
                BlockPosition.MutableBlockPosition blockposition_mutableblockposition = this.getWorldPos(3, 5, 5);

                if (structureboundingbox.isInside(blockposition_mutableblockposition)) {
                    this.hasPlacedSpawner = true;
                    generatoraccessseed.setBlock(blockposition_mutableblockposition, Blocks.SPAWNER.defaultBlockState(), 2);
                    TileEntity tileentity = generatoraccessseed.getBlockEntity(blockposition_mutableblockposition);

                    if (tileentity instanceof TileEntityMobSpawner) {
                        ((TileEntityMobSpawner) tileentity).getSpawner().setEntityId(EntityTypes.BLAZE);
                    }
                }
            }

            for (int i = 0; i <= 6; ++i) {
                for (int j = 0; j <= 6; ++j) {
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i, -1, j, structureboundingbox);
                }
            }

        }
    }

    public static class WorldGenNetherPiece6 extends WorldGenNetherPieces.WorldGenNetherPiece {

        private static final int WIDTH = 13;
        private static final int HEIGHT = 14;
        private static final int DEPTH = 13;

        public WorldGenNetherPiece6(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_CASTLE_ENTRANCE, i, structureboundingbox);
            this.setOrientation(enumdirection);
        }

        public WorldGenNetherPiece6(NBTTagCompound nbttagcompound) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_CASTLE_ENTRANCE, nbttagcompound);
        }

        @Override
        public void addChildren(StructurePiece structurepiece, StructurePieceAccessor structurepieceaccessor, Random random) {
            this.generateChildForward((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 5, 3, true);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece6 createPiece(StructurePieceAccessor structurepieceaccessor, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.orientBox(i, j, k, -5, -3, 0, 13, 14, 13, enumdirection);

            return isOkBox(structureboundingbox) && structurepieceaccessor.findCollisionPiece(structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece6(l, random, structureboundingbox, enumdirection) : null;
        }

        @Override
        public void postProcess(GeneratorAccessSeed generatoraccessseed, StructureManager structuremanager, ChunkGenerator chunkgenerator, Random random, StructureBoundingBox structureboundingbox, ChunkCoordIntPair chunkcoordintpair, BlockPosition blockposition) {
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 3, 0, 12, 4, 12, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 5, 0, 12, 13, 12, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 5, 0, 1, 12, 12, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 11, 5, 0, 12, 12, 12, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 2, 5, 11, 4, 12, 12, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 8, 5, 11, 10, 12, 12, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 5, 9, 11, 7, 12, 12, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 2, 5, 0, 4, 12, 1, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 8, 5, 0, 10, 12, 1, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 5, 9, 0, 7, 12, 1, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 2, 11, 2, 10, 12, 10, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 5, 8, 0, 7, 8, 0, Blocks.NETHER_BRICK_FENCE.defaultBlockState(), Blocks.NETHER_BRICK_FENCE.defaultBlockState(), false);
            IBlockData iblockdata = (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.WEST, true)).setValue(BlockFence.EAST, true);
            IBlockData iblockdata1 = (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.NORTH, true)).setValue(BlockFence.SOUTH, true);

            int i;

            for (i = 1; i <= 11; i += 2) {
                this.generateBox(generatoraccessseed, structureboundingbox, i, 10, 0, i, 11, 0, iblockdata, iblockdata, false);
                this.generateBox(generatoraccessseed, structureboundingbox, i, 10, 12, i, 11, 12, iblockdata, iblockdata, false);
                this.generateBox(generatoraccessseed, structureboundingbox, 0, 10, i, 0, 11, i, iblockdata1, iblockdata1, false);
                this.generateBox(generatoraccessseed, structureboundingbox, 12, 10, i, 12, 11, i, iblockdata1, iblockdata1, false);
                this.placeBlock(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i, 13, 0, structureboundingbox);
                this.placeBlock(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i, 13, 12, structureboundingbox);
                this.placeBlock(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), 0, 13, i, structureboundingbox);
                this.placeBlock(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), 12, 13, i, structureboundingbox);
                if (i != 11) {
                    this.placeBlock(generatoraccessseed, iblockdata, i + 1, 13, 0, structureboundingbox);
                    this.placeBlock(generatoraccessseed, iblockdata, i + 1, 13, 12, structureboundingbox);
                    this.placeBlock(generatoraccessseed, iblockdata1, 0, 13, i + 1, structureboundingbox);
                    this.placeBlock(generatoraccessseed, iblockdata1, 12, 13, i + 1, structureboundingbox);
                }
            }

            this.placeBlock(generatoraccessseed, (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.NORTH, true)).setValue(BlockFence.EAST, true), 0, 13, 0, structureboundingbox);
            this.placeBlock(generatoraccessseed, (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.SOUTH, true)).setValue(BlockFence.EAST, true), 0, 13, 12, structureboundingbox);
            this.placeBlock(generatoraccessseed, (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.SOUTH, true)).setValue(BlockFence.WEST, true), 12, 13, 12, structureboundingbox);
            this.placeBlock(generatoraccessseed, (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.NORTH, true)).setValue(BlockFence.WEST, true), 12, 13, 0, structureboundingbox);

            for (i = 3; i <= 9; i += 2) {
                this.generateBox(generatoraccessseed, structureboundingbox, 1, 7, i, 1, 8, i, (IBlockData) iblockdata1.setValue(BlockFence.WEST, true), (IBlockData) iblockdata1.setValue(BlockFence.WEST, true), false);
                this.generateBox(generatoraccessseed, structureboundingbox, 11, 7, i, 11, 8, i, (IBlockData) iblockdata1.setValue(BlockFence.EAST, true), (IBlockData) iblockdata1.setValue(BlockFence.EAST, true), false);
            }

            this.generateBox(generatoraccessseed, structureboundingbox, 4, 2, 0, 8, 2, 12, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 4, 12, 2, 8, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 0, 0, 8, 1, 3, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 0, 9, 8, 1, 12, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 0, 4, 3, 1, 8, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 9, 0, 4, 12, 1, 8, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);

            int j;

            for (i = 4; i <= 8; ++i) {
                for (j = 0; j <= 2; ++j) {
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i, -1, j, structureboundingbox);
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i, -1, 12 - j, structureboundingbox);
                }
            }

            for (i = 0; i <= 2; ++i) {
                for (j = 4; j <= 8; ++j) {
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i, -1, j, structureboundingbox);
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), 12 - i, -1, j, structureboundingbox);
                }
            }

            this.generateBox(generatoraccessseed, structureboundingbox, 5, 5, 5, 7, 5, 7, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 6, 1, 6, 6, 4, 6, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
            this.placeBlock(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), 6, 0, 6, structureboundingbox);
            this.placeBlock(generatoraccessseed, Blocks.LAVA.defaultBlockState(), 6, 5, 6, structureboundingbox);
            BlockPosition.MutableBlockPosition blockposition_mutableblockposition = this.getWorldPos(6, 5, 6);

            if (structureboundingbox.isInside(blockposition_mutableblockposition)) {
                generatoraccessseed.scheduleTick(blockposition_mutableblockposition, (FluidType) FluidTypes.LAVA, 0);
            }

        }
    }

    public static class WorldGenNetherPiece9 extends WorldGenNetherPieces.WorldGenNetherPiece {

        private static final int WIDTH = 5;
        private static final int HEIGHT = 7;
        private static final int DEPTH = 5;

        public WorldGenNetherPiece9(int i, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_CASTLE_SMALL_CORRIDOR, i, structureboundingbox);
            this.setOrientation(enumdirection);
        }

        public WorldGenNetherPiece9(NBTTagCompound nbttagcompound) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_CASTLE_SMALL_CORRIDOR, nbttagcompound);
        }

        @Override
        public void addChildren(StructurePiece structurepiece, StructurePieceAccessor structurepieceaccessor, Random random) {
            this.generateChildForward((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 1, 0, true);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece9 createPiece(StructurePieceAccessor structurepieceaccessor, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.orientBox(i, j, k, -1, 0, 0, 5, 7, 5, enumdirection);

            return isOkBox(structureboundingbox) && structurepieceaccessor.findCollisionPiece(structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece9(l, structureboundingbox, enumdirection) : null;
        }

        @Override
        public void postProcess(GeneratorAccessSeed generatoraccessseed, StructureManager structuremanager, ChunkGenerator chunkgenerator, Random random, StructureBoundingBox structureboundingbox, ChunkCoordIntPair chunkcoordintpair, BlockPosition blockposition) {
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 0, 4, 5, 4, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
            IBlockData iblockdata = (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.NORTH, true)).setValue(BlockFence.SOUTH, true);

            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 0, 0, 5, 4, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 2, 0, 4, 5, 4, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 3, 1, 0, 4, 1, iblockdata, iblockdata, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 3, 3, 0, 4, 3, iblockdata, iblockdata, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 3, 1, 4, 4, 1, iblockdata, iblockdata, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 3, 3, 4, 4, 3, iblockdata, iblockdata, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);

            for (int i = 0; i <= 4; ++i) {
                for (int j = 0; j <= 4; ++j) {
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i, -1, j, structureboundingbox);
                }
            }

        }
    }

    public static class WorldGenNetherPiece10 extends WorldGenNetherPieces.WorldGenNetherPiece {

        private static final int WIDTH = 5;
        private static final int HEIGHT = 7;
        private static final int DEPTH = 5;
        private boolean isNeedingChest;

        public WorldGenNetherPiece10(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_CASTLE_SMALL_CORRIDOR_RIGHT_TURN, i, structureboundingbox);
            this.setOrientation(enumdirection);
            this.isNeedingChest = random.nextInt(3) == 0;
        }

        public WorldGenNetherPiece10(NBTTagCompound nbttagcompound) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_CASTLE_SMALL_CORRIDOR_RIGHT_TURN, nbttagcompound);
            this.isNeedingChest = nbttagcompound.getBoolean("Chest");
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurepieceserializationcontext, NBTTagCompound nbttagcompound) {
            super.addAdditionalSaveData(structurepieceserializationcontext, nbttagcompound);
            nbttagcompound.putBoolean("Chest", this.isNeedingChest);
        }

        @Override
        public void addChildren(StructurePiece structurepiece, StructurePieceAccessor structurepieceaccessor, Random random) {
            this.generateChildRight((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 0, 1, true);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece10 createPiece(StructurePieceAccessor structurepieceaccessor, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.orientBox(i, j, k, -1, 0, 0, 5, 7, 5, enumdirection);

            return isOkBox(structureboundingbox) && structurepieceaccessor.findCollisionPiece(structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece10(l, random, structureboundingbox, enumdirection) : null;
        }

        @Override
        public void postProcess(GeneratorAccessSeed generatoraccessseed, StructureManager structuremanager, ChunkGenerator chunkgenerator, Random random, StructureBoundingBox structureboundingbox, ChunkCoordIntPair chunkcoordintpair, BlockPosition blockposition) {
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 0, 4, 5, 4, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
            IBlockData iblockdata = (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.WEST, true)).setValue(BlockFence.EAST, true);
            IBlockData iblockdata1 = (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.NORTH, true)).setValue(BlockFence.SOUTH, true);

            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 0, 0, 5, 4, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 3, 1, 0, 4, 1, iblockdata1, iblockdata1, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 3, 3, 0, 4, 3, iblockdata1, iblockdata1, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 2, 0, 4, 5, 0, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 2, 4, 4, 5, 4, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 3, 4, 1, 4, 4, iblockdata, iblockdata, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 3, 3, 4, 3, 4, 4, iblockdata, iblockdata, false);
            if (this.isNeedingChest && structureboundingbox.isInside(this.getWorldPos(1, 2, 3))) {
                this.isNeedingChest = false;
                this.createChest(generatoraccessseed, structureboundingbox, random, 1, 2, 3, LootTables.NETHER_BRIDGE);
            }

            this.generateBox(generatoraccessseed, structureboundingbox, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);

            for (int i = 0; i <= 4; ++i) {
                for (int j = 0; j <= 4; ++j) {
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i, -1, j, structureboundingbox);
                }
            }

        }
    }

    public static class WorldGenNetherPiece8 extends WorldGenNetherPieces.WorldGenNetherPiece {

        private static final int WIDTH = 5;
        private static final int HEIGHT = 7;
        private static final int DEPTH = 5;
        private boolean isNeedingChest;

        public WorldGenNetherPiece8(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_CASTLE_SMALL_CORRIDOR_LEFT_TURN, i, structureboundingbox);
            this.setOrientation(enumdirection);
            this.isNeedingChest = random.nextInt(3) == 0;
        }

        public WorldGenNetherPiece8(NBTTagCompound nbttagcompound) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_CASTLE_SMALL_CORRIDOR_LEFT_TURN, nbttagcompound);
            this.isNeedingChest = nbttagcompound.getBoolean("Chest");
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurepieceserializationcontext, NBTTagCompound nbttagcompound) {
            super.addAdditionalSaveData(structurepieceserializationcontext, nbttagcompound);
            nbttagcompound.putBoolean("Chest", this.isNeedingChest);
        }

        @Override
        public void addChildren(StructurePiece structurepiece, StructurePieceAccessor structurepieceaccessor, Random random) {
            this.generateChildLeft((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 0, 1, true);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece8 createPiece(StructurePieceAccessor structurepieceaccessor, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.orientBox(i, j, k, -1, 0, 0, 5, 7, 5, enumdirection);

            return isOkBox(structureboundingbox) && structurepieceaccessor.findCollisionPiece(structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece8(l, random, structureboundingbox, enumdirection) : null;
        }

        @Override
        public void postProcess(GeneratorAccessSeed generatoraccessseed, StructureManager structuremanager, ChunkGenerator chunkgenerator, Random random, StructureBoundingBox structureboundingbox, ChunkCoordIntPair chunkcoordintpair, BlockPosition blockposition) {
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 0, 4, 5, 4, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
            IBlockData iblockdata = (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.WEST, true)).setValue(BlockFence.EAST, true);
            IBlockData iblockdata1 = (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.NORTH, true)).setValue(BlockFence.SOUTH, true);

            this.generateBox(generatoraccessseed, structureboundingbox, 4, 2, 0, 4, 5, 4, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 3, 1, 4, 4, 1, iblockdata1, iblockdata1, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 3, 3, 4, 4, 3, iblockdata1, iblockdata1, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 0, 0, 5, 0, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 4, 3, 5, 4, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 3, 4, 1, 4, 4, iblockdata, iblockdata, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 3, 3, 4, 3, 4, 4, iblockdata, iblockdata, false);
            if (this.isNeedingChest && structureboundingbox.isInside(this.getWorldPos(3, 2, 3))) {
                this.isNeedingChest = false;
                this.createChest(generatoraccessseed, structureboundingbox, random, 3, 2, 3, LootTables.NETHER_BRIDGE);
            }

            this.generateBox(generatoraccessseed, structureboundingbox, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);

            for (int i = 0; i <= 4; ++i) {
                for (int j = 0; j <= 4; ++j) {
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i, -1, j, structureboundingbox);
                }
            }

        }
    }

    public static class WorldGenNetherPiece4 extends WorldGenNetherPieces.WorldGenNetherPiece {

        private static final int WIDTH = 5;
        private static final int HEIGHT = 14;
        private static final int DEPTH = 10;

        public WorldGenNetherPiece4(int i, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_CASTLE_CORRIDOR_STAIRS, i, structureboundingbox);
            this.setOrientation(enumdirection);
        }

        public WorldGenNetherPiece4(NBTTagCompound nbttagcompound) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_CASTLE_CORRIDOR_STAIRS, nbttagcompound);
        }

        @Override
        public void addChildren(StructurePiece structurepiece, StructurePieceAccessor structurepieceaccessor, Random random) {
            this.generateChildForward((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 1, 0, true);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece4 createPiece(StructurePieceAccessor structurepieceaccessor, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.orientBox(i, j, k, -1, -7, 0, 5, 14, 10, enumdirection);

            return isOkBox(structureboundingbox) && structurepieceaccessor.findCollisionPiece(structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece4(l, structureboundingbox, enumdirection) : null;
        }

        @Override
        public void postProcess(GeneratorAccessSeed generatoraccessseed, StructureManager structuremanager, ChunkGenerator chunkgenerator, Random random, StructureBoundingBox structureboundingbox, ChunkCoordIntPair chunkcoordintpair, BlockPosition blockposition) {
            IBlockData iblockdata = (IBlockData) Blocks.NETHER_BRICK_STAIRS.defaultBlockState().setValue(BlockStairs.FACING, EnumDirection.SOUTH);
            IBlockData iblockdata1 = (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.NORTH, true)).setValue(BlockFence.SOUTH, true);

            for (int i = 0; i <= 9; ++i) {
                int j = Math.max(1, 7 - i);
                int k = Math.min(Math.max(j + 5, 14 - i), 13);
                int l = i;

                this.generateBox(generatoraccessseed, structureboundingbox, 0, 0, i, 4, j, i, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
                this.generateBox(generatoraccessseed, structureboundingbox, 1, j + 1, i, 3, k - 1, i, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
                if (i <= 6) {
                    this.placeBlock(generatoraccessseed, iblockdata, 1, j + 1, i, structureboundingbox);
                    this.placeBlock(generatoraccessseed, iblockdata, 2, j + 1, i, structureboundingbox);
                    this.placeBlock(generatoraccessseed, iblockdata, 3, j + 1, i, structureboundingbox);
                }

                this.generateBox(generatoraccessseed, structureboundingbox, 0, k, i, 4, k, i, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
                this.generateBox(generatoraccessseed, structureboundingbox, 0, j + 1, i, 0, k - 1, i, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
                this.generateBox(generatoraccessseed, structureboundingbox, 4, j + 1, i, 4, k - 1, i, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
                if ((i & 1) == 0) {
                    this.generateBox(generatoraccessseed, structureboundingbox, 0, j + 2, i, 0, j + 3, i, iblockdata1, iblockdata1, false);
                    this.generateBox(generatoraccessseed, structureboundingbox, 4, j + 2, i, 4, j + 3, i, iblockdata1, iblockdata1, false);
                }

                for (int i1 = 0; i1 <= 4; ++i1) {
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i1, -1, l, structureboundingbox);
                }
            }

        }
    }

    public static class WorldGenNetherPiece5 extends WorldGenNetherPieces.WorldGenNetherPiece {

        private static final int WIDTH = 9;
        private static final int HEIGHT = 7;
        private static final int DEPTH = 9;

        public WorldGenNetherPiece5(int i, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_CASTLE_CORRIDOR_T_BALCONY, i, structureboundingbox);
            this.setOrientation(enumdirection);
        }

        public WorldGenNetherPiece5(NBTTagCompound nbttagcompound) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_CASTLE_CORRIDOR_T_BALCONY, nbttagcompound);
        }

        @Override
        public void addChildren(StructurePiece structurepiece, StructurePieceAccessor structurepieceaccessor, Random random) {
            byte b0 = 1;
            EnumDirection enumdirection = this.getOrientation();

            if (enumdirection == EnumDirection.WEST || enumdirection == EnumDirection.NORTH) {
                b0 = 5;
            }

            this.generateChildLeft((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 0, b0, random.nextInt(8) > 0);
            this.generateChildRight((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 0, b0, random.nextInt(8) > 0);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece5 createPiece(StructurePieceAccessor structurepieceaccessor, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.orientBox(i, j, k, -3, 0, 0, 9, 7, 9, enumdirection);

            return isOkBox(structureboundingbox) && structurepieceaccessor.findCollisionPiece(structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece5(l, structureboundingbox, enumdirection) : null;
        }

        @Override
        public void postProcess(GeneratorAccessSeed generatoraccessseed, StructureManager structuremanager, ChunkGenerator chunkgenerator, Random random, StructureBoundingBox structureboundingbox, ChunkCoordIntPair chunkcoordintpair, BlockPosition blockposition) {
            IBlockData iblockdata = (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.NORTH, true)).setValue(BlockFence.SOUTH, true);
            IBlockData iblockdata1 = (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.WEST, true)).setValue(BlockFence.EAST, true);

            this.generateBox(generatoraccessseed, structureboundingbox, 0, 0, 0, 8, 1, 8, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 0, 8, 5, 8, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 6, 0, 8, 6, 5, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 0, 2, 5, 0, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 6, 2, 0, 8, 5, 0, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 3, 0, 1, 4, 0, iblockdata1, iblockdata1, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 7, 3, 0, 7, 4, 0, iblockdata1, iblockdata1, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 4, 8, 2, 8, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 1, 4, 2, 2, 4, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 6, 1, 4, 7, 2, 4, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 3, 8, 7, 3, 8, iblockdata1, iblockdata1, false);
            this.placeBlock(generatoraccessseed, (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.EAST, true)).setValue(BlockFence.SOUTH, true), 0, 3, 8, structureboundingbox);
            this.placeBlock(generatoraccessseed, (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.WEST, true)).setValue(BlockFence.SOUTH, true), 8, 3, 8, structureboundingbox);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 3, 6, 0, 3, 7, iblockdata, iblockdata, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 8, 3, 6, 8, 3, 7, iblockdata, iblockdata, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 3, 4, 0, 5, 5, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 8, 3, 4, 8, 5, 5, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 3, 5, 2, 5, 5, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 6, 3, 5, 7, 5, 5, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 1, 4, 5, 1, 5, 5, iblockdata1, iblockdata1, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 7, 4, 5, 7, 5, 5, iblockdata1, iblockdata1, false);

            for (int i = 0; i <= 5; ++i) {
                for (int j = 0; j <= 8; ++j) {
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), j, -1, i, structureboundingbox);
                }
            }

        }
    }

    public static class WorldGenNetherPiece7 extends WorldGenNetherPieces.WorldGenNetherPiece {

        private static final int WIDTH = 5;
        private static final int HEIGHT = 7;
        private static final int DEPTH = 5;

        public WorldGenNetherPiece7(int i, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_CASTLE_SMALL_CORRIDOR_CROSSING, i, structureboundingbox);
            this.setOrientation(enumdirection);
        }

        public WorldGenNetherPiece7(NBTTagCompound nbttagcompound) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_CASTLE_SMALL_CORRIDOR_CROSSING, nbttagcompound);
        }

        @Override
        public void addChildren(StructurePiece structurepiece, StructurePieceAccessor structurepieceaccessor, Random random) {
            this.generateChildForward((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 1, 0, true);
            this.generateChildLeft((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 0, 1, true);
            this.generateChildRight((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 0, 1, true);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece7 createPiece(StructurePieceAccessor structurepieceaccessor, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.orientBox(i, j, k, -1, 0, 0, 5, 7, 5, enumdirection);

            return isOkBox(structureboundingbox) && structurepieceaccessor.findCollisionPiece(structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece7(l, structureboundingbox, enumdirection) : null;
        }

        @Override
        public void postProcess(GeneratorAccessSeed generatoraccessseed, StructureManager structuremanager, ChunkGenerator chunkgenerator, Random random, StructureBoundingBox structureboundingbox, ChunkCoordIntPair chunkcoordintpair, BlockPosition blockposition) {
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 0, 4, 5, 4, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 0, 0, 5, 0, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 2, 0, 4, 5, 0, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 4, 0, 5, 4, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 2, 4, 4, 5, 4, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);

            for (int i = 0; i <= 4; ++i) {
                for (int j = 0; j <= 4; ++j) {
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i, -1, j, structureboundingbox);
                }
            }

        }
    }

    public static class WorldGenNetherPiece11 extends WorldGenNetherPieces.WorldGenNetherPiece {

        private static final int WIDTH = 13;
        private static final int HEIGHT = 14;
        private static final int DEPTH = 13;

        public WorldGenNetherPiece11(int i, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_CASTLE_STALK_ROOM, i, structureboundingbox);
            this.setOrientation(enumdirection);
        }

        public WorldGenNetherPiece11(NBTTagCompound nbttagcompound) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_CASTLE_STALK_ROOM, nbttagcompound);
        }

        @Override
        public void addChildren(StructurePiece structurepiece, StructurePieceAccessor structurepieceaccessor, Random random) {
            this.generateChildForward((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 5, 3, true);
            this.generateChildForward((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, structurepieceaccessor, random, 5, 11, true);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece11 createPiece(StructurePieceAccessor structurepieceaccessor, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.orientBox(i, j, k, -5, -3, 0, 13, 14, 13, enumdirection);

            return isOkBox(structureboundingbox) && structurepieceaccessor.findCollisionPiece(structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece11(l, structureboundingbox, enumdirection) : null;
        }

        @Override
        public void postProcess(GeneratorAccessSeed generatoraccessseed, StructureManager structuremanager, ChunkGenerator chunkgenerator, Random random, StructureBoundingBox structureboundingbox, ChunkCoordIntPair chunkcoordintpair, BlockPosition blockposition) {
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 3, 0, 12, 4, 12, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 5, 0, 12, 13, 12, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 5, 0, 1, 12, 12, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 11, 5, 0, 12, 12, 12, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 2, 5, 11, 4, 12, 12, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 8, 5, 11, 10, 12, 12, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 5, 9, 11, 7, 12, 12, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 2, 5, 0, 4, 12, 1, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 8, 5, 0, 10, 12, 1, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 5, 9, 0, 7, 12, 1, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 2, 11, 2, 10, 12, 10, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            IBlockData iblockdata = (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.WEST, true)).setValue(BlockFence.EAST, true);
            IBlockData iblockdata1 = (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.NORTH, true)).setValue(BlockFence.SOUTH, true);
            IBlockData iblockdata2 = (IBlockData) iblockdata1.setValue(BlockFence.WEST, true);
            IBlockData iblockdata3 = (IBlockData) iblockdata1.setValue(BlockFence.EAST, true);

            int i;

            for (i = 1; i <= 11; i += 2) {
                this.generateBox(generatoraccessseed, structureboundingbox, i, 10, 0, i, 11, 0, iblockdata, iblockdata, false);
                this.generateBox(generatoraccessseed, structureboundingbox, i, 10, 12, i, 11, 12, iblockdata, iblockdata, false);
                this.generateBox(generatoraccessseed, structureboundingbox, 0, 10, i, 0, 11, i, iblockdata1, iblockdata1, false);
                this.generateBox(generatoraccessseed, structureboundingbox, 12, 10, i, 12, 11, i, iblockdata1, iblockdata1, false);
                this.placeBlock(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i, 13, 0, structureboundingbox);
                this.placeBlock(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), i, 13, 12, structureboundingbox);
                this.placeBlock(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), 0, 13, i, structureboundingbox);
                this.placeBlock(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), 12, 13, i, structureboundingbox);
                if (i != 11) {
                    this.placeBlock(generatoraccessseed, iblockdata, i + 1, 13, 0, structureboundingbox);
                    this.placeBlock(generatoraccessseed, iblockdata, i + 1, 13, 12, structureboundingbox);
                    this.placeBlock(generatoraccessseed, iblockdata1, 0, 13, i + 1, structureboundingbox);
                    this.placeBlock(generatoraccessseed, iblockdata1, 12, 13, i + 1, structureboundingbox);
                }
            }

            this.placeBlock(generatoraccessseed, (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.NORTH, true)).setValue(BlockFence.EAST, true), 0, 13, 0, structureboundingbox);
            this.placeBlock(generatoraccessseed, (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.SOUTH, true)).setValue(BlockFence.EAST, true), 0, 13, 12, structureboundingbox);
            this.placeBlock(generatoraccessseed, (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.SOUTH, true)).setValue(BlockFence.WEST, true), 12, 13, 12, structureboundingbox);
            this.placeBlock(generatoraccessseed, (IBlockData) ((IBlockData) Blocks.NETHER_BRICK_FENCE.defaultBlockState().setValue(BlockFence.NORTH, true)).setValue(BlockFence.WEST, true), 12, 13, 0, structureboundingbox);

            for (i = 3; i <= 9; i += 2) {
                this.generateBox(generatoraccessseed, structureboundingbox, 1, 7, i, 1, 8, i, iblockdata2, iblockdata2, false);
                this.generateBox(generatoraccessseed, structureboundingbox, 11, 7, i, 11, 8, i, iblockdata3, iblockdata3, false);
            }

            IBlockData iblockdata4 = (IBlockData) Blocks.NETHER_BRICK_STAIRS.defaultBlockState().setValue(BlockStairs.FACING, EnumDirection.NORTH);

            int j;
            int k;

            for (j = 0; j <= 6; ++j) {
                int l = j + 4;

                for (k = 5; k <= 7; ++k) {
                    this.placeBlock(generatoraccessseed, iblockdata4, k, 5 + j, l, structureboundingbox);
                }

                if (l >= 5 && l <= 8) {
                    this.generateBox(generatoraccessseed, structureboundingbox, 5, 5, l, 7, j + 4, l, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
                } else if (l >= 9 && l <= 10) {
                    this.generateBox(generatoraccessseed, structureboundingbox, 5, 8, l, 7, j + 4, l, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
                }

                if (j >= 1) {
                    this.generateBox(generatoraccessseed, structureboundingbox, 5, 6 + j, l, 7, 9 + j, l, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
                }
            }

            for (j = 5; j <= 7; ++j) {
                this.placeBlock(generatoraccessseed, iblockdata4, j, 12, 11, structureboundingbox);
            }

            this.generateBox(generatoraccessseed, structureboundingbox, 5, 6, 7, 5, 7, 7, iblockdata3, iblockdata3, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 7, 6, 7, 7, 7, 7, iblockdata2, iblockdata2, false);
            this.generateBox(generatoraccessseed, structureboundingbox, 5, 13, 12, 7, 13, 12, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 2, 5, 2, 3, 5, 3, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 2, 5, 9, 3, 5, 10, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 2, 5, 4, 2, 5, 8, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 9, 5, 2, 10, 5, 3, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 9, 5, 9, 10, 5, 10, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 10, 5, 4, 10, 5, 8, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            IBlockData iblockdata5 = (IBlockData) iblockdata4.setValue(BlockStairs.FACING, EnumDirection.EAST);
            IBlockData iblockdata6 = (IBlockData) iblockdata4.setValue(BlockStairs.FACING, EnumDirection.WEST);

            this.placeBlock(generatoraccessseed, iblockdata6, 4, 5, 2, structureboundingbox);
            this.placeBlock(generatoraccessseed, iblockdata6, 4, 5, 3, structureboundingbox);
            this.placeBlock(generatoraccessseed, iblockdata6, 4, 5, 9, structureboundingbox);
            this.placeBlock(generatoraccessseed, iblockdata6, 4, 5, 10, structureboundingbox);
            this.placeBlock(generatoraccessseed, iblockdata5, 8, 5, 2, structureboundingbox);
            this.placeBlock(generatoraccessseed, iblockdata5, 8, 5, 3, structureboundingbox);
            this.placeBlock(generatoraccessseed, iblockdata5, 8, 5, 9, structureboundingbox);
            this.placeBlock(generatoraccessseed, iblockdata5, 8, 5, 10, structureboundingbox);
            this.generateBox(generatoraccessseed, structureboundingbox, 3, 4, 4, 4, 4, 8, Blocks.SOUL_SAND.defaultBlockState(), Blocks.SOUL_SAND.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 8, 4, 4, 9, 4, 8, Blocks.SOUL_SAND.defaultBlockState(), Blocks.SOUL_SAND.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 3, 5, 4, 4, 5, 8, Blocks.NETHER_WART.defaultBlockState(), Blocks.NETHER_WART.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 8, 5, 4, 9, 5, 8, Blocks.NETHER_WART.defaultBlockState(), Blocks.NETHER_WART.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 2, 0, 8, 2, 12, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 2, 4, 12, 2, 8, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 0, 0, 8, 1, 3, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 0, 9, 8, 1, 12, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 0, 4, 3, 1, 8, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            this.generateBox(generatoraccessseed, structureboundingbox, 9, 0, 4, 12, 1, 8, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);

            int i1;

            for (k = 4; k <= 8; ++k) {
                for (i1 = 0; i1 <= 2; ++i1) {
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), k, -1, i1, structureboundingbox);
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), k, -1, 12 - i1, structureboundingbox);
                }
            }

            for (k = 0; k <= 2; ++k) {
                for (i1 = 4; i1 <= 8; ++i1) {
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), k, -1, i1, structureboundingbox);
                    this.fillColumnDown(generatoraccessseed, Blocks.NETHER_BRICKS.defaultBlockState(), 12 - k, -1, i1, structureboundingbox);
                }
            }

        }
    }

    public static class WorldGenNetherPiece2 extends WorldGenNetherPieces.WorldGenNetherPiece {

        private static final int WIDTH = 5;
        private static final int HEIGHT = 10;
        private static final int DEPTH = 8;
        private final int selfSeed;

        public WorldGenNetherPiece2(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_BRIDGE_END_FILLER, i, structureboundingbox);
            this.setOrientation(enumdirection);
            this.selfSeed = random.nextInt();
        }

        public WorldGenNetherPiece2(NBTTagCompound nbttagcompound) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_BRIDGE_END_FILLER, nbttagcompound);
            this.selfSeed = nbttagcompound.getInt("Seed");
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece2 createPiece(StructurePieceAccessor structurepieceaccessor, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.orientBox(i, j, k, -1, -3, 0, 5, 10, 8, enumdirection);

            return isOkBox(structureboundingbox) && structurepieceaccessor.findCollisionPiece(structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece2(l, random, structureboundingbox, enumdirection) : null;
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurepieceserializationcontext, NBTTagCompound nbttagcompound) {
            super.addAdditionalSaveData(structurepieceserializationcontext, nbttagcompound);
            nbttagcompound.putInt("Seed", this.selfSeed);
        }

        @Override
        public void postProcess(GeneratorAccessSeed generatoraccessseed, StructureManager structuremanager, ChunkGenerator chunkgenerator, Random random, StructureBoundingBox structureboundingbox, ChunkCoordIntPair chunkcoordintpair, BlockPosition blockposition) {
            Random random1 = new Random((long) this.selfSeed);

            int i;
            int j;
            int k;

            for (j = 0; j <= 4; ++j) {
                for (k = 3; k <= 4; ++k) {
                    i = random1.nextInt(8);
                    this.generateBox(generatoraccessseed, structureboundingbox, j, k, 0, j, k, i, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
                }
            }

            j = random1.nextInt(8);
            this.generateBox(generatoraccessseed, structureboundingbox, 0, 5, 0, 0, 5, j, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            j = random1.nextInt(8);
            this.generateBox(generatoraccessseed, structureboundingbox, 4, 5, 0, 4, 5, j, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);

            for (j = 0; j <= 4; ++j) {
                k = random1.nextInt(5);
                this.generateBox(generatoraccessseed, structureboundingbox, j, 2, 0, j, 2, k, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
            }

            for (j = 0; j <= 4; ++j) {
                for (k = 0; k <= 1; ++k) {
                    i = random1.nextInt(3);
                    this.generateBox(generatoraccessseed, structureboundingbox, j, k, 0, j, k, i, Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.NETHER_BRICKS.defaultBlockState(), false);
                }
            }

        }
    }

    public static class WorldGenNetherPiece15 extends WorldGenNetherPieces.WorldGenNetherPiece1 {

        public WorldGenNetherPieces.WorldGenNetherPieceWeight previousPiece;
        public List<WorldGenNetherPieces.WorldGenNetherPieceWeight> availableBridgePieces;
        public List<WorldGenNetherPieces.WorldGenNetherPieceWeight> availableCastlePieces;
        public final List<StructurePiece> pendingChildren = Lists.newArrayList();

        public WorldGenNetherPiece15(Random random, int i, int j) {
            super(i, j, getRandomHorizontalDirection(random));
            this.availableBridgePieces = Lists.newArrayList();
            WorldGenNetherPieces.WorldGenNetherPieceWeight[] aworldgennetherpieces_worldgennetherpieceweight = WorldGenNetherPieces.BRIDGE_PIECE_WEIGHTS;
            int k = aworldgennetherpieces_worldgennetherpieceweight.length;

            WorldGenNetherPieces.WorldGenNetherPieceWeight worldgennetherpieces_worldgennetherpieceweight;
            int l;

            for (l = 0; l < k; ++l) {
                worldgennetherpieces_worldgennetherpieceweight = aworldgennetherpieces_worldgennetherpieceweight[l];
                worldgennetherpieces_worldgennetherpieceweight.placeCount = 0;
                this.availableBridgePieces.add(worldgennetherpieces_worldgennetherpieceweight);
            }

            this.availableCastlePieces = Lists.newArrayList();
            aworldgennetherpieces_worldgennetherpieceweight = WorldGenNetherPieces.CASTLE_PIECE_WEIGHTS;
            k = aworldgennetherpieces_worldgennetherpieceweight.length;

            for (l = 0; l < k; ++l) {
                worldgennetherpieces_worldgennetherpieceweight = aworldgennetherpieces_worldgennetherpieceweight[l];
                worldgennetherpieces_worldgennetherpieceweight.placeCount = 0;
                this.availableCastlePieces.add(worldgennetherpieces_worldgennetherpieceweight);
            }

        }

        public WorldGenNetherPiece15(NBTTagCompound nbttagcompound) {
            super(WorldGenFeatureStructurePieceType.NETHER_FORTRESS_START, nbttagcompound);
        }
    }

    private abstract static class WorldGenNetherPiece extends StructurePiece {

        protected WorldGenNetherPiece(WorldGenFeatureStructurePieceType worldgenfeaturestructurepiecetype, int i, StructureBoundingBox structureboundingbox) {
            super(worldgenfeaturestructurepiecetype, i, structureboundingbox);
        }

        public WorldGenNetherPiece(WorldGenFeatureStructurePieceType worldgenfeaturestructurepiecetype, NBTTagCompound nbttagcompound) {
            super(worldgenfeaturestructurepiecetype, nbttagcompound);
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurepieceserializationcontext, NBTTagCompound nbttagcompound) {}

        private int updatePieceWeight(List<WorldGenNetherPieces.WorldGenNetherPieceWeight> list) {
            boolean flag = false;
            int i = 0;

            WorldGenNetherPieces.WorldGenNetherPieceWeight worldgennetherpieces_worldgennetherpieceweight;

            for (Iterator iterator = list.iterator(); iterator.hasNext(); i += worldgennetherpieces_worldgennetherpieceweight.weight) {
                worldgennetherpieces_worldgennetherpieceweight = (WorldGenNetherPieces.WorldGenNetherPieceWeight) iterator.next();
                if (worldgennetherpieces_worldgennetherpieceweight.maxPlaceCount > 0 && worldgennetherpieces_worldgennetherpieceweight.placeCount < worldgennetherpieces_worldgennetherpieceweight.maxPlaceCount) {
                    flag = true;
                }
            }

            return flag ? i : -1;
        }

        private WorldGenNetherPieces.WorldGenNetherPiece generatePiece(WorldGenNetherPieces.WorldGenNetherPiece15 worldgennetherpieces_worldgennetherpiece15, List<WorldGenNetherPieces.WorldGenNetherPieceWeight> list, StructurePieceAccessor structurepieceaccessor, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
            int i1 = this.updatePieceWeight(list);
            boolean flag = i1 > 0 && l <= 30;
            int j1 = 0;

            while (j1 < 5 && flag) {
                ++j1;
                int k1 = random.nextInt(i1);
                Iterator iterator = list.iterator();

                while (iterator.hasNext()) {
                    WorldGenNetherPieces.WorldGenNetherPieceWeight worldgennetherpieces_worldgennetherpieceweight = (WorldGenNetherPieces.WorldGenNetherPieceWeight) iterator.next();

                    k1 -= worldgennetherpieces_worldgennetherpieceweight.weight;
                    if (k1 < 0) {
                        if (!worldgennetherpieces_worldgennetherpieceweight.doPlace(l) || worldgennetherpieces_worldgennetherpieceweight == worldgennetherpieces_worldgennetherpiece15.previousPiece && !worldgennetherpieces_worldgennetherpieceweight.allowInRow) {
                            break;
                        }

                        WorldGenNetherPieces.WorldGenNetherPiece worldgennetherpieces_worldgennetherpiece = WorldGenNetherPieces.findAndCreateBridgePieceFactory(worldgennetherpieces_worldgennetherpieceweight, structurepieceaccessor, random, i, j, k, enumdirection, l);

                        if (worldgennetherpieces_worldgennetherpiece != null) {
                            ++worldgennetherpieces_worldgennetherpieceweight.placeCount;
                            worldgennetherpieces_worldgennetherpiece15.previousPiece = worldgennetherpieces_worldgennetherpieceweight;
                            if (!worldgennetherpieces_worldgennetherpieceweight.isValid()) {
                                list.remove(worldgennetherpieces_worldgennetherpieceweight);
                            }

                            return worldgennetherpieces_worldgennetherpiece;
                        }
                    }
                }
            }

            return WorldGenNetherPieces.WorldGenNetherPiece2.createPiece(structurepieceaccessor, random, i, j, k, enumdirection, l);
        }

        private StructurePiece generateAndAddPiece(WorldGenNetherPieces.WorldGenNetherPiece15 worldgennetherpieces_worldgennetherpiece15, StructurePieceAccessor structurepieceaccessor, Random random, int i, int j, int k, @Nullable EnumDirection enumdirection, int l, boolean flag) {
            if (Math.abs(i - worldgennetherpieces_worldgennetherpiece15.getBoundingBox().minX()) <= 112 && Math.abs(k - worldgennetherpieces_worldgennetherpiece15.getBoundingBox().minZ()) <= 112) {
                List<WorldGenNetherPieces.WorldGenNetherPieceWeight> list = worldgennetherpieces_worldgennetherpiece15.availableBridgePieces;

                if (flag) {
                    list = worldgennetherpieces_worldgennetherpiece15.availableCastlePieces;
                }

                WorldGenNetherPieces.WorldGenNetherPiece worldgennetherpieces_worldgennetherpiece = this.generatePiece(worldgennetherpieces_worldgennetherpiece15, list, structurepieceaccessor, random, i, j, k, enumdirection, l + 1);

                if (worldgennetherpieces_worldgennetherpiece != null) {
                    structurepieceaccessor.addPiece(worldgennetherpieces_worldgennetherpiece);
                    worldgennetherpieces_worldgennetherpiece15.pendingChildren.add(worldgennetherpieces_worldgennetherpiece);
                }

                return worldgennetherpieces_worldgennetherpiece;
            } else {
                return WorldGenNetherPieces.WorldGenNetherPiece2.createPiece(structurepieceaccessor, random, i, j, k, enumdirection, l);
            }
        }

        @Nullable
        protected StructurePiece generateChildForward(WorldGenNetherPieces.WorldGenNetherPiece15 worldgennetherpieces_worldgennetherpiece15, StructurePieceAccessor structurepieceaccessor, Random random, int i, int j, boolean flag) {
            EnumDirection enumdirection = this.getOrientation();

            if (enumdirection != null) {
                switch (enumdirection) {
                    case NORTH:
                        return this.generateAndAddPiece(worldgennetherpieces_worldgennetherpiece15, structurepieceaccessor, random, this.boundingBox.minX() + i, this.boundingBox.minY() + j, this.boundingBox.minZ() - 1, enumdirection, this.getGenDepth(), flag);
                    case SOUTH:
                        return this.generateAndAddPiece(worldgennetherpieces_worldgennetherpiece15, structurepieceaccessor, random, this.boundingBox.minX() + i, this.boundingBox.minY() + j, this.boundingBox.maxZ() + 1, enumdirection, this.getGenDepth(), flag);
                    case WEST:
                        return this.generateAndAddPiece(worldgennetherpieces_worldgennetherpiece15, structurepieceaccessor, random, this.boundingBox.minX() - 1, this.boundingBox.minY() + j, this.boundingBox.minZ() + i, enumdirection, this.getGenDepth(), flag);
                    case EAST:
                        return this.generateAndAddPiece(worldgennetherpieces_worldgennetherpiece15, structurepieceaccessor, random, this.boundingBox.maxX() + 1, this.boundingBox.minY() + j, this.boundingBox.minZ() + i, enumdirection, this.getGenDepth(), flag);
                }
            }

            return null;
        }

        @Nullable
        protected StructurePiece generateChildLeft(WorldGenNetherPieces.WorldGenNetherPiece15 worldgennetherpieces_worldgennetherpiece15, StructurePieceAccessor structurepieceaccessor, Random random, int i, int j, boolean flag) {
            EnumDirection enumdirection = this.getOrientation();

            if (enumdirection != null) {
                switch (enumdirection) {
                    case NORTH:
                        return this.generateAndAddPiece(worldgennetherpieces_worldgennetherpiece15, structurepieceaccessor, random, this.boundingBox.minX() - 1, this.boundingBox.minY() + i, this.boundingBox.minZ() + j, EnumDirection.WEST, this.getGenDepth(), flag);
                    case SOUTH:
                        return this.generateAndAddPiece(worldgennetherpieces_worldgennetherpiece15, structurepieceaccessor, random, this.boundingBox.minX() - 1, this.boundingBox.minY() + i, this.boundingBox.minZ() + j, EnumDirection.WEST, this.getGenDepth(), flag);
                    case WEST:
                        return this.generateAndAddPiece(worldgennetherpieces_worldgennetherpiece15, structurepieceaccessor, random, this.boundingBox.minX() + j, this.boundingBox.minY() + i, this.boundingBox.minZ() - 1, EnumDirection.NORTH, this.getGenDepth(), flag);
                    case EAST:
                        return this.generateAndAddPiece(worldgennetherpieces_worldgennetherpiece15, structurepieceaccessor, random, this.boundingBox.minX() + j, this.boundingBox.minY() + i, this.boundingBox.minZ() - 1, EnumDirection.NORTH, this.getGenDepth(), flag);
                }
            }

            return null;
        }

        @Nullable
        protected StructurePiece generateChildRight(WorldGenNetherPieces.WorldGenNetherPiece15 worldgennetherpieces_worldgennetherpiece15, StructurePieceAccessor structurepieceaccessor, Random random, int i, int j, boolean flag) {
            EnumDirection enumdirection = this.getOrientation();

            if (enumdirection != null) {
                switch (enumdirection) {
                    case NORTH:
                        return this.generateAndAddPiece(worldgennetherpieces_worldgennetherpiece15, structurepieceaccessor, random, this.boundingBox.maxX() + 1, this.boundingBox.minY() + i, this.boundingBox.minZ() + j, EnumDirection.EAST, this.getGenDepth(), flag);
                    case SOUTH:
                        return this.generateAndAddPiece(worldgennetherpieces_worldgennetherpiece15, structurepieceaccessor, random, this.boundingBox.maxX() + 1, this.boundingBox.minY() + i, this.boundingBox.minZ() + j, EnumDirection.EAST, this.getGenDepth(), flag);
                    case WEST:
                        return this.generateAndAddPiece(worldgennetherpieces_worldgennetherpiece15, structurepieceaccessor, random, this.boundingBox.minX() + j, this.boundingBox.minY() + i, this.boundingBox.maxZ() + 1, EnumDirection.SOUTH, this.getGenDepth(), flag);
                    case EAST:
                        return this.generateAndAddPiece(worldgennetherpieces_worldgennetherpiece15, structurepieceaccessor, random, this.boundingBox.minX() + j, this.boundingBox.minY() + i, this.boundingBox.maxZ() + 1, EnumDirection.SOUTH, this.getGenDepth(), flag);
                }
            }

            return null;
        }

        protected static boolean isOkBox(StructureBoundingBox structureboundingbox) {
            return structureboundingbox != null && structureboundingbox.minY() > 10;
        }
    }
}
