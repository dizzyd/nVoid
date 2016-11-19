package com.vashmeed.nvoid.config;

import net.minecraft.block.state.IBlockState;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config {

	private static Configuration config;
	public static boolean voidNether;
	public static boolean voidOverworld;
	public static boolean voidBiomeNether;
	public static boolean voidBiomeOverworld;
	public static int overworldSpawnHeight;

	public static void loadConfig(FMLPreInitializationEvent event) {

		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		voidNether = config.getBoolean("Generate a blockless nether", "alpha", true,
				"If set to true, the nether will only generate the portal.");
		voidOverworld = config.getBoolean("Generate a blockless overworld", "alpha", false,
				"If set to true, the overworld will only generate as a single block of dirt.");

		voidBiomeNether = config.getBoolean("Generate the nether as a void biome", "beta", false,
				"If enabled, the default 'hell' biome will be replaced by a void biome, resulting in no mobs spawning and other biome specific features.");
		voidBiomeOverworld = config.getBoolean("Generate the overworld as a void biome", "beta", false,
				"If enabled, natural biome generation options will be replaced by the void, preventing mobs from spawning and other biome specific features.");
		
		overworldSpawnHeight = config.getInt("Spawn Height", "alpha", 64, 0, 254, "Changes the height at which you spawn at.");

	}

	public static void setConfig(FMLPostInitializationEvent event) {
		if (config.hasChanged()) {
			config.save();
		}
	}

}
