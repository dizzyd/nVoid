package com.vashmeed.nvoid.world.gen;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkProviderHell;

import java.util.List;

/**
 * Created by Vaheed on 10/31/2016.
 */
public class ChunkGeneratorVoidNether extends ChunkProviderHell {

    World world;

    public ChunkGeneratorVoidNether(World par1world, long par2) {
        super(par1world, false, par2);
        world = par1world;
    }

    @Override
    public void prepareHeights(int p_185936_1_, int p_185936_2_, ChunkPrimer primer) {

    }

    @Override
    public void buildSurfaces(int p_185937_1_, int p_185937_2_, ChunkPrimer primer) {

    }

    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
        Biome biome = world.getBiomeGenForCoords(pos);
        return biome.getSpawnableList(creatureType);
    }

    @Override
    public void populate(int x, int z) {

    }

}
