package com.vashmeed.nvoid.world;

import com.vashmeed.nvoid.world.biome.VoidBiomeProvider;
import com.vashmeed.nvoid.world.gen.ChunkGeneratorVoidOverworld;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldProviderVoidOverworld extends WorldProviderSurface {

	@Override
	public boolean canCoordinateBeSpawn(int x, int z) {
		return true;
	}

	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorVoidOverworld(world);
	}

	@Override
	protected void init() {
		this.biomeProvider = new VoidBiomeProvider(world);
	}

	@Override
	public BlockPos getRandomizedSpawnPoint() {
		BlockPos spawn = new BlockPos(world.getSpawnPoint());
		spawn = world.getTopSolidOrLiquidBlock(spawn);
		return spawn;
	}

}
