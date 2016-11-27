package com.vashmeed.nvoid.world;

import com.vashmeed.nvoid.world.biome.VoidBiomeProvider;
import com.vashmeed.nvoid.world.gen.ChunkGeneratorVoidOverworld;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.chunk.IChunkGenerator;

/**
 * Created by Vaheed on 11/1/2016.
 */
public class WorldProviderVoidOverworld extends WorldProviderSurface {

	@Override
	public boolean canCoordinateBeSpawn(int x, int z) {
		return true;
	}

	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorVoidOverworld(worldObj);
	}

	@Override
	protected void createBiomeProvider() {
		this.biomeProvider = new VoidBiomeProvider(worldObj);
	}

	@Override
	public BlockPos getRandomizedSpawnPoint() {
		BlockPos spawn = new BlockPos(worldObj.getSpawnPoint());
		spawn = worldObj.getTopSolidOrLiquidBlock(spawn);
		return spawn;
	}

}
