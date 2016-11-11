package com.vashmeed.nvoid;

import com.vashmeed.nvoid.config.Config;
import com.vashmeed.nvoid.proxy.CommonProxy;
import com.vashmeed.nvoid.world.WorldProviderVoidNether;
import com.vashmeed.nvoid.world.WorldProviderVoidOverworld;
import com.vashmeed.nvoid.world.WorldTypeVoid;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Vaheed on 10/31/2016.
 */
@Mod(modid = nVoid.modId, name = nVoid.name, version = nVoid.version, acceptedMinecraftVersions = "[1.9.4, 1.10.2]")
public class nVoid {

	public static final String modId = "nvoid";
	public static final String name = "nVoid";
	public static final String version = "0.2";

	public static boolean voidNether;
	private WorldProviderVoidOverworld world;

	@SidedProxy(serverSide = "com.vashmeed.nvoid.proxy.CommonProxy", clientSide = "com.vashmeed.nvoid.proxy.ClientProxy")
	public static CommonProxy proxy;

	@Mod.Instance(modId)
	public static nVoid instance;
	private WorldTypeVoid wtv;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		event.getModLog().info(name + " is loading!");
		Config.loadConfig(event);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Mod.EventHandler
	public void load(FMLInitializationEvent event) {
		wtv = new WorldTypeVoid();
		if (Config.voidNether == true) {
			DimensionManager.unregisterDimension(-1);
			DimensionManager.registerDimension(-1,
					DimensionType.register("VoidNether", "_nether", -1, WorldProviderVoidNether.class, false));
		}
		if (Config.voidOverworld == true) {
			DimensionManager.unregisterDimension(0);
			DimensionManager.registerDimension(0,
					DimensionType.register("VoidOverworld", "overworld", 0, WorldProviderVoidOverworld.class, true));
		}
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Config.setConfig(event);
	}

}
