package com.vashmeed.nvoid.world.gen;

import com.vashmeed.nvoid.config.Settings;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.IChunkGenerator;

/**
 * Created by Vaheed on 10/31/2016.
 */
public class WorldProviderVoidNether extends WorldProviderHell {

	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorVoidNether(worldObj, worldObj.getSeed());
	}

	@Override
	public void createBiomeProvider() {
		this.biomeProvider = new BiomeProviderSingle(Settings.biomeType);
		this.isHellWorld = false;
		this.hasNoSky = Settings.hasNoSky;
	}

	@Override
	public DimensionType getDimensionType() {
		return Settings.dimension;
	}

	@Override
	public boolean canCoordinateBeSpawn(int x, int z) {
		return Settings.canCoordinateBeSpawn;
	}

	@Override
	public boolean canRespawnHere() {
		return Settings.canRespawn;
	}
}
