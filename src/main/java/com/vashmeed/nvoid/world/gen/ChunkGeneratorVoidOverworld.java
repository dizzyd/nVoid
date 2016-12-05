package com.vashmeed.nvoid.world.gen;

import com.vashmeed.nvoid.config.Config;

import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkProviderFlat;

public class ChunkGeneratorVoidOverworld extends ChunkProviderFlat {

	private World w;

	public ChunkGeneratorVoidOverworld(World w) {
		super(w, w.getSeed(), false, null);
		this.w = w;
	}

	@Override
	public void populate(int x, int y) {
		if (x == 0 && y == 0)
			if (Config.firstBlockChest)
				this.w.setBlockState(new BlockPos(0, Config.overworldSpawnHeight, 0), Blocks.CHEST.getDefaultState());
			else
				this.w.setBlockState(new BlockPos(0, Config.overworldSpawnHeight, 0), Blocks.DIRT.getDefaultState());
	}

	@Override
	public Chunk provideChunk(int x, int z) {
		Chunk c = new Chunk(w, new ChunkPrimer(), x, z);
		Biome[] abiome = this.w.getBiomeProvider().loadBlockGeneratorData((Biome[]) null, x * 16, z * 16, 16, 16);
		byte[] ids = c.getBiomeArray();

		for (int i = 0; i < ids.length; ++i) {
			if (Config.voidBiomeOverworld)
				ids[i] = (byte) Biome.getIdForBiome(Biomes.VOID);
			else
				ids[i] = (byte) Biome.getIdForBiome(abiome[i]);
		}

		c.generateSkylightMap();
		return c;
	}

}
