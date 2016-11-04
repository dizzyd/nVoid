package com.vashmeed.nvoid;

import com.vashmeed.nvoid.proxy.CommonProxy;
import com.vashmeed.nvoid.world.WorldProviderVoidNether;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Vaheed on 10/31/2016.
 */
@Mod(modid = nVoid.modId, name = nVoid.name, version = nVoid.version, acceptedMinecraftVersions = "[1.10.2]")
public class nVoid {

	public static final String modId = "nvoid";
	public static final String name = "nVoid";
	public static final String version = "0.1";

	@SidedProxy(serverSide = "com.vashmeed.nvoid.proxy.CommonProxy", clientSide = "com.vashmeed.nvoid.proxy.ClientProxy")
	public static CommonProxy proxy;

	@Mod.Instance(modId)
	public static nVoid instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		event.getModLog().info(name + " is loading!");
	}

	@Mod.EventHandler
	public void load(FMLInitializationEvent event) {
		DimensionManager.unregisterDimension(-1);
		DimensionManager.registerDimension(-1,
				DimensionType.register("VoidNether", "_nether", -1, WorldProviderVoidNether.class, true));
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

}
