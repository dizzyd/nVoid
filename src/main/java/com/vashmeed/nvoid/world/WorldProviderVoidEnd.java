package com.vashmeed.nvoid.world;

import com.vashmeed.nvoid.world.gen.ChunkGeneratorVoidEnd;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.chunk.IChunkGenerator;

public class WorldProviderVoidEnd extends WorldProviderEnd {

	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorVoidEnd(worldObj);
	}

	@Override
	public BlockPos getRandomizedSpawnPoint() {
		BlockPos spawn = new BlockPos(worldObj.getSpawnPoint());
		spawn = worldObj.getTopSolidOrLiquidBlock(spawn);
		return spawn;
	}
	
}
