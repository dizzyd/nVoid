package com.vashmeed.nvoid.world;

import com.vashmeed.nvoid.config.Config;
import com.vashmeed.nvoid.world.biome.BiomeProviderVoidOverworld;
import com.vashmeed.nvoid.world.biome.ModBiomes;
import com.vashmeed.nvoid.world.gen.ChunkGenerator;

import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.biome.BiomeProviderSingle;
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
		return new ChunkGenerator(worldObj);
	}

	@Override
	protected void createBiomeProvider() {
		if (Config.voidBiomeOverworld)
			// this.biomeProvider = new BiomeProviderSingle(Biomes.VOID);
			this.biomeProvider = new BiomeProviderSingle(ModBiomes.N_VOID);
		else
			this.biomeProvider = new BiomeProviderVoidOverworld(worldObj);
	}

	@Override
	public BlockPos getRandomizedSpawnPoint() {
		BlockPos spawn = new BlockPos(worldObj.getSpawnPoint());
		spawn = worldObj.getTopSolidOrLiquidBlock(spawn);
		return spawn;
	}

}
