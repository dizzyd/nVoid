package com.vashmeed.nvoid.world;

import com.vashmeed.nvoid.world.gen.ChunkGeneratorVoidNether;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldTypeVoidNether extends WorldType {

	public WorldTypeVoidNether() {
		super("void");
	}

	@Override
	public IChunkGenerator getChunkGenerator(World world, String generatorOptions) {
		return new ChunkGeneratorVoidNether(world);
	}

	@Override
	public int getSpawnFuzz(WorldServer ws, MinecraftServer ms) {
		return 1;
	}

}
