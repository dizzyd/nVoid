package com.vashmeed.nvoid.world;

import com.vashmeed.nvoid.world.biome.VoidBiomeProvider;
import com.vashmeed.nvoid.world.gen.ChunkGeneratorVoidNether;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.gen.IChunkGenerator;


public class WorldProviderVoidNether extends WorldProviderHell {

	@Override
	public boolean canCoordinateBeSpawn(int x, int z) {
		return true;
	}

	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorVoidNether(world);
	}

	@Override
	public void init() {
		this.biomeProvider = new VoidBiomeProvider(world);
		this.doesWaterVaporize = true;
		this.nether = true;
	}

	@Override
	public BlockPos getRandomizedSpawnPoint() {
		BlockPos spawn = new BlockPos(world.getSpawnPoint());
		spawn = world.getTopSolidOrLiquidBlock(spawn);
		return spawn;
	}
}
