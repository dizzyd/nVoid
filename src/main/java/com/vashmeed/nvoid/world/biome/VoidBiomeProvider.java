package com.vashmeed.nvoid.world.biome;

import java.util.List;
import java.util.Random;

import com.vashmeed.nvoid.config.Config;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class VoidBiomeProvider extends BiomeProvider {

	private World w;
	private EntityPlayer player;
	FMLPreInitializationEvent event;

	public VoidBiomeProvider(World w) {
		super(w.getWorldInfo());
		this.w = w;
	}

	@Override
	public BlockPos findBiomePosition(int x, int z, int range, List<Biome> biomes, Random rand) {
		BlockPos pos = new BlockPos(x, Config.overworldSpawnHeight, z);
		return pos;
	}

}
