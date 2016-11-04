package com.vashmeed.nvoid.world;

import com.vashmeed.nvoid.world.gen.WorldProviderVoidNether;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

/**
 * Created by Vaheed on 10/31/2016.
 */
public class World {

	public static void registerWorldProviders() {
		DimensionManager.unregisterDimension(-1);
		DimensionManager.registerDimension(-1,
				DimensionType.register("VoidNether", "_nether", -1, WorldProviderVoidNether.class, true));
	}
}
