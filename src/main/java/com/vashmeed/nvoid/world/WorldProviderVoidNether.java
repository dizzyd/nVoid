package com.vashmeed.nvoid.world;

import com.vashmeed.nvoid.world.gen.ChunkGenerator;

import net.minecraft.init.Biomes;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.IChunkGenerator;

/**
 * Created by Vaheed on 10/31/2016.
 */
public class WorldProviderVoidNether extends WorldProviderHell {

	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkGenerator(worldObj);
	}

	@Override
	public void createBiomeProvider() {
		this.biomeProvider = new BiomeProviderSingle(Biomes.VOID);
	}
}
