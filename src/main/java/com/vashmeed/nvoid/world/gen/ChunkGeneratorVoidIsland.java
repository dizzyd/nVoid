package com.vashmeed.nvoid.world.gen;

import java.util.Random;

import net.minecraft.block.BlockFalling;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.NoiseGeneratorSimplex;
import net.minecraft.world.gen.feature.WorldGenEndIsland;
import net.minecraft.world.gen.structure.MapGenEndCity;

public class ChunkGeneratorVoidIsland extends ChunkProviderEnd {

	private final Random rand;
    private final World worldObj;
    /** are map structures going to be generated (e.g. strongholds) */
    private final boolean mapFeaturesEnabled;
    /** The biomes that are used to generate the chunk */
    private Biome[] biomesForGeneration;
    private final WorldGenEndIsland endIslands = new WorldGenEndIsland();
    // temporary variables used during event handling
    private int chunkX = 0;
    private int chunkZ = 0;
	
	public ChunkGeneratorVoidIsland(World worldObjIn, boolean mapFeaturesEnabledIn, long seed) {
		super(worldObjIn, mapFeaturesEnabledIn, seed);
        this.worldObj = worldObjIn;
        this.mapFeaturesEnabled = mapFeaturesEnabledIn;
        this.rand = new Random(seed);     
	}
	
	@Override
    public Chunk provideChunk(int x, int z)
    {
        this.chunkX = x; this.chunkZ = z;
        this.rand.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
        ChunkPrimer chunkprimer = new ChunkPrimer();
        this.biomesForGeneration = this.worldObj.getBiomeProvider().loadBlockGeneratorData(this.biomesForGeneration, x * 16, z * 16, 16, 16);
        this.setBlocksInChunk(x, z, chunkprimer);
        this.buildSurfaces(chunkprimer);

        Chunk chunk = new Chunk(this.worldObj, chunkprimer, x, z);
        byte[] abyte = chunk.getBiomeArray();

        for (int i = 0; i < abyte.length; ++i)
        {
            abyte[i] = (byte)Biome.getIdForBiome(this.biomesForGeneration[i]);
        }

        chunk.generateSkylightMap();
        return chunk;
    }
	
	@Override
	public void populate(int x, int z) {
        BlockFalling.fallInstantly = true;
        net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(true, this, this.worldObj, this.rand, x, z, false);
        BlockPos blockpos = new BlockPos(x * 16, 0, z * 16);
        
        this.worldObj.getBiomeGenForCoords(blockpos.add(16, 0, 16)).decorate(this.worldObj, this.worldObj.rand, blockpos);
        long i = (long)x * (long)x + (long)z * (long)z;
        
        if (i > 4096L)
        {
        	
        }
        net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(false, this, this.worldObj, this.rand, x, z, false);
        BlockFalling.fallInstantly = false;
	}
	
}
