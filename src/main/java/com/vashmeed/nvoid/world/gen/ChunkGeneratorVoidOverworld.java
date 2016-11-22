package com.vashmeed.nvoid.world.gen;

import java.util.List;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkProviderOverworld;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraft.world.gen.structure.StructureOceanMonument;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChunkGeneratorVoidOverworld extends ChunkProviderOverworld {

	World world;

	public ChunkGeneratorVoidOverworld(World worldIn, long seed, boolean mapFeaturesEnabledIn, String p_i46668_5_) {
		super(worldIn, seed, false, p_i46668_5_);
	}

	@Override
	public BlockPos getStrongholdGen(World worldIn, String structureName, BlockPos position) {
		return null;
	}
	
	@Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos)
    {
        Biome biome = this.world.getBiomeGenForCoords(pos);
        return biome.getSpawnableList(creatureType);
    }
	
	@Override
	public void populate(int x, int z) {
		System.out.println("!!!!!!");
		System.out.println("!!!!!!");
		System.out.println("");
		System.out.println("This ran.");
		System.out.println("");
		System.out.println("!!!!!!");
		System.out.println("!!!!!!");
	}

}
