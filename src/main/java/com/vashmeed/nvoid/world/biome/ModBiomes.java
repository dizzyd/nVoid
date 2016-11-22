package com.vashmeed.nvoid.world.biome;

import com.vashmeed.nvoid.nVoid;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.common.registry.IForgeRegistry;

@SuppressWarnings("WeakerAccess")
@ObjectHolder(nVoid.modId)
public class ModBiomes {

	@ObjectHolder("NVOID")
	public static final VoidBiome N_VOID = new VoidBiome(
			new Biome.BiomeProperties("Void Biome").setBaseHeight(64));
	
	@Mod.EventBusSubscriber
	public static class RegistrationHandler {
		/**
		 * Register this mod's {@link Biome}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerBiomes(RegistryEvent.Register<Biome> event) {
			final IForgeRegistry<Biome> registry = event.getRegistry();

			registerBiome(registry, N_VOID, "NVOID", BiomeManager.BiomeType.COOL, 1000);
		}

		private static <T extends Biome> T registerBiome(IForgeRegistry<Biome> registry, T biome, String biomeName, BiomeManager.BiomeType biomeType, int weight) {
			registry.register(biome.setRegistryName(nVoid.modId, biomeName));
			BiomeDictionary.registerBiomeType(biome);
			BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(biome, weight));

			return biome;
		}

	}

}
