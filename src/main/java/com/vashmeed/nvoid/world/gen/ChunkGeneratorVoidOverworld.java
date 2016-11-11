package com.vashmeed.nvoid.world.gen;

import java.util.List;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkProviderOverworld;

public class ChunkGeneratorVoidOverworld extends ChunkProviderOverworld {

	World world;

	public ChunkGeneratorVoidOverworld(World worldIn, long seed, boolean mapFeaturesEnabledIn, String p_i46668_5_) {
		super(worldIn, seed, false, p_i46668_5_);
	}

	public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		Biome biome = world.getBiomeGenForCoords(pos);
		return biome.getSpawnableList(creatureType);
	}

	@Override
	public BlockPos getStrongholdGen(World worldIn, String structureName, BlockPos position) {
		return null;
	}

	@Override
	public void populate(int x, int z) {

	}

}
