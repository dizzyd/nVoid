package com.vashmeed.nvoid.world.gen;

import com.vashmeed.nvoid.config.Config;

import net.minecraft.init.Biomes;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkProviderFlat;

/**
 * Created by Vaheed on 10/31/2016.
 */
public class ChunkGeneratorVoidNether extends ChunkProviderFlat {

	private World w;

	public ChunkGeneratorVoidNether(World w) {
		super(w, w.getSeed(), false, null);
		this.w = w;
	}

	@Override
	public void populate(int x, int y) {

	}

	@Override
	public Chunk provideChunk(int x, int z) {
		Chunk c = new Chunk(w, new ChunkPrimer(), x, z);
		Biome[] abiome = this.w.getBiomeProvider().loadBlockGeneratorData((Biome[]) null, x * 16, z * 16, 16, 16);
		byte[] ids = c.getBiomeArray();

		for (int i = 0; i < ids.length; ++i) {
			if (Config.voidBiomeNether)
				ids[i] = (byte) Biome.getIdForBiome(Biomes.VOID);
			else
				//ids[i] = (byte) Biome.getIdForBiome(abiome[i]);
				ids[i] = (byte) Biome.getIdForBiome(Biomes.HELL);

		}

		c.generateSkylightMap();
		return c;
	}

}
