package com.vashmeed.nvoid.world;

import com.vashmeed.nvoid.config.Config;
import com.vashmeed.nvoid.world.biome.VoidBiomeProvider;
import com.vashmeed.nvoid.world.gen.ChunkGeneratorVoidNether;

import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.biome.BiomeProviderSingle;
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
		// Always call superclass init and then replace only the biome provider as necessary
		super.init();
		if (Config.voidBiomeNether) {
			this.biomeProvider = new VoidBiomeProvider(world);
		}
	}

	@Override
	public BlockPos getRandomizedSpawnPoint() {
		BlockPos spawn = new BlockPos(world.getSpawnPoint());
		spawn = world.getTopSolidOrLiquidBlock(spawn);
		return spawn;
	}
}
