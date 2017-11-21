package com.vashmeed.nvoid;

import com.vashmeed.nvoid.config.Config;
import com.vashmeed.nvoid.world.WorldProviderVoidEnd;
import com.vashmeed.nvoid.world.WorldProviderVoidNether;
import com.vashmeed.nvoid.world.WorldProviderVoidOverworld;
import com.vashmeed.nvoid.world.WorldTypeVoidEnd;
import com.vashmeed.nvoid.world.WorldTypeVoidNether;
import com.vashmeed.nvoid.world.WorldTypeVoidOverworld;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Vaheed on 10/31/2016.
 */
@Mod(modid = nVoid.modId, name = nVoid.name, version = nVoid.version, acceptedMinecraftVersions = "[1.12]")
public class nVoid {

	public static final String modId = "nvoid";
	public static final String name = "nVoid";
	public static final String version = "1.1.0";

	@Mod.Instance(modId)
	public static nVoid instance;
	private WorldTypeVoidOverworld wtvo;
	private WorldTypeVoidNether wtvn;
	private WorldTypeVoidEnd wtve;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		event.getModLog().info(name + " is loading!");
		Config.loadConfig(event);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Mod.EventHandler
	public void load(FMLInitializationEvent event) {
		if (Config.voidNether == true) {
			wtvn = new WorldTypeVoidNether();
			DimensionManager.unregisterDimension(-1);
			DimensionManager.registerDimension(-1,
					DimensionType.register("VoidNether", "_nether", -1, WorldProviderVoidNether.class, false));
		}
		if (Config.voidOverworld == true) {
			wtvo = new WorldTypeVoidOverworld();
			DimensionManager.unregisterDimension(0);
			DimensionManager.registerDimension(0,
					DimensionType.register("VoidOverworld", "overworld", 0, WorldProviderVoidOverworld.class, false));
		}
		if (Config.voidEnd == true) {
			wtve = new WorldTypeVoidEnd();
			DimensionManager.unregisterDimension(1);
			DimensionManager.registerDimension(1,
					DimensionType.register("VoidEnd", "end", 1, WorldProviderVoidEnd.class, false));
		}
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Config.setConfig(event);
	}

}
