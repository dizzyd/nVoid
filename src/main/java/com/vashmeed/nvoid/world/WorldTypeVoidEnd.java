package com.vashmeed.nvoid.world;

import com.vashmeed.nvoid.world.gen.ChunkGeneratorVoidEnd;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldTypeVoidEnd extends WorldType {

	public WorldTypeVoidEnd() {
		super("void");
	}

	@Override
	public IChunkGenerator getChunkGenerator(World world, String generatorOptions) {
		return new ChunkGeneratorVoidEnd(world);
	}

	@Override
	public int getSpawnFuzz(WorldServer ws, MinecraftServer ms) {
		return 1;
	}

}
