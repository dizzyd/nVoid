package com.vashmeed.nvoid.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config {

	private static Configuration config;
	public static boolean voidNether;
	public static boolean voidOverworld;
	public static boolean voidEnd;
	public static boolean voidBiomeNether;
	public static boolean voidBiomeOverworld;
	public static boolean voidBiomeEnd;
	public static boolean endDragonEnabled;
	public static boolean firstBlockChest;
	public static int overworldSpawnHeight;

	public static void loadConfig(FMLPreInitializationEvent event) {

		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		voidNether = config.getBoolean("Generate a blockless nether", "nether", true,
				"If set to true, the nether will only generate the portal.");
		voidBiomeNether = config.getBoolean("Generate the nether as a void biome", "nether", false,
				"If enabled, the default 'hell' biome will be replaced by a void biome, resulting in no mobs spawning and other biome specific features.");

		voidBiomeOverworld = config.getBoolean("Generate the overworld as a void biome", "overworld", false,
				"If enabled, natural biome generation options will be replaced by the void, preventing mobs from spawning and other biome specific features.");
		voidOverworld = config.getBoolean("Generate a blockless overworld", "overworld", false,
				"If set to true, the overworld will only generate as a single block of dirt.");
		overworldSpawnHeight = config.getInt("Spawn Height", "overworld", 64, 0, 254,
				"Changes the height at which you spawn at in the overworld and the end.");
		firstBlockChest = config.getBoolean("Replace the spawn block in the overworld with a chest", "overworld", false,
				"Enabling this feature will replace the dirt block that spawns with you in the overworld with an empty chest.");
		
		voidBiomeEnd = config.getBoolean("Generate the end as a void biome", "end", false,
				"If enabled, natural biome generation options will be replaced by the void, preventing mobs from spawning and other biome specific features.");
		voidEnd = config.getBoolean("Generate a blockless End", "end", false,
				"If set to true, the end will only generate as a single block of dirt.");
		endDragonEnabled = config.getBoolean("Spawn the end dragon", "end", false,
				"If enabled, the end dragon will spawn as default when the end is void.");


	}

	public static void setConfig(FMLPostInitializationEvent event) {
		if (config.hasChanged()) {
			config.save();
		}
	}

}
