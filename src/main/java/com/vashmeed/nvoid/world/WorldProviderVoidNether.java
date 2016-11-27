package com.vashmeed.nvoid.world;

import com.vashmeed.nvoid.world.biome.VoidBiomeProvider;
import com.vashmeed.nvoid.world.gen.ChunkGeneratorVoidNether;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.chunk.IChunkGenerator;

/**
 * Created by Vaheed on 10/31/2016.
 */
public class WorldProviderVoidNether extends WorldProviderHell {

	@Override
	public boolean canCoordinateBeSpawn(int x, int z) {
		return true;
	}

	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorVoidNether(worldObj);
	}

	@Override
	public void createBiomeProvider() {
		this.biomeProvider = new VoidBiomeProvider(worldObj);
	}

	@Override
	public BlockPos getRandomizedSpawnPoint() {
		BlockPos spawn = new BlockPos(worldObj.getSpawnPoint());
		spawn = worldObj.getTopSolidOrLiquidBlock(spawn);
		return spawn;
	}
}
