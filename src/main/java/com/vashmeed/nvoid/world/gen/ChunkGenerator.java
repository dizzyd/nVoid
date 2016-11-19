package com.vashmeed.nvoid.world.gen;

import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkProviderFlat;

public class ChunkGenerator extends ChunkProviderFlat {

	private World w;

	public ChunkGenerator(World w) {
		super(w, w.getSeed(), false, null);
		this.w = w;
	}

	@Override
	public void populate(int par2, int par3) {

	}

	@Override
	public Chunk provideChunk(int x, int z) {
		Chunk c = new Chunk(w, new ChunkPrimer(), x, z);
		Biome[] abiome = this.w.getBiomeProvider().loadBlockGeneratorData((Biome[]) null, x * 16, z * 16, 16, 16);
		byte[] ids = c.getBiomeArray();

		for (int i = 0; i < ids.length; ++i) {
			ids[i] = (byte) Biome.getIdForBiome(abiome[i]);
		}

		c.generateSkylightMap();
		return c;
	}

}
