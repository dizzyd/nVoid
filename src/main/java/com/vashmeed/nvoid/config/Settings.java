package com.vashmeed.nvoid.config;

import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;

public class Settings {
	public static final Settings config = new Settings();

	public static Blocks platformBlockType;
	public static Biome biomeType = Biomes.VOID;
	public static DimensionType dimension = DimensionType.NETHER;
	public static boolean hasNoSky = true;

	/** Experimental */
	public static boolean canRespawn = false;
	public static boolean canCoordinateBeSpawn = true;

}
