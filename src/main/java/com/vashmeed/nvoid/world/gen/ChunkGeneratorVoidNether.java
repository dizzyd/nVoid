package com.vashmeed.nvoid.world.gen;

import java.util.List;

import com.vashmeed.nvoid.config.Config;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkProviderFlat;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraftforge.common.DimensionManager;

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
		System.out.println("!!!!!!");
		System.out.println("!!!!!!");
		System.out.println("");
		System.out.println("This ran for void nether.");
		System.out.println("");
		System.out.println("!!!!!!");
		System.out.println("!!!!!!");
	}

	@Override
	public Chunk provideChunk(int x, int z) {
		Chunk c = new Chunk(w, new ChunkPrimer(), x, z);
		Biome[] abiome = this.w.getBiomeProvider().loadBlockGeneratorData((Biome[]) null, x * 16, z * 16, 16, 16);
		byte[] ids = c.getBiomeArray();

		for (int i = 0; i < ids.length; ++i) {
			ids[i] = (byte) Biome.getIdForBiome(Biomes.VOID);
		}

		c.generateSkylightMap();
		return c;
	}

}
