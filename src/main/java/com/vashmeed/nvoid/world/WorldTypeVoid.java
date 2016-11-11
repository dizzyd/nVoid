package com.vashmeed.nvoid.world;

import com.vashmeed.nvoid.world.gen.ChunkGenerator;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkGenerator;

public class WorldTypeVoid extends WorldType {

	public WorldTypeVoid() {
		super("void");
	}

	@Override
	public IChunkGenerator getChunkGenerator(World world, String generatorOptions) {
		return new ChunkGenerator(world);
	}

	@Override
	public int getSpawnFuzz(WorldServer ws, MinecraftServer ms) {
		return 1;
	}

}
