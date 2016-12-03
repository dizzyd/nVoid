package com.vashmeed.nvoid.world;

import com.vashmeed.nvoid.config.Config;
import com.vashmeed.nvoid.world.gen.ChunkGeneratorVoidEnd;

import net.minecraft.init.Biomes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.end.DragonFightManager;

public class WorldProviderVoidEnd extends WorldProviderEnd {

	private DragonFightManager dragonFightManager;
	
	@Override
    public void createBiomeProvider()
    {
        this.biomeProvider = new BiomeProviderSingle(Biomes.SKY);
        this.hasNoSky = true;
        if (Config.endDragonEnabled) {
            NBTTagCompound nbttagcompound = this.worldObj.getWorldInfo().getDimensionData(DimensionType.THE_END);
            this.dragonFightManager = this.worldObj instanceof WorldServer ? new DragonFightManager((WorldServer)this.worldObj, nbttagcompound.getCompoundTag("DragonFight")) : null;
        }
    }
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorVoidEnd(worldObj);
	}

	@Override
	public BlockPos getRandomizedSpawnPoint() {
		BlockPos spawn = new BlockPos(worldObj.getSpawnPoint());
		spawn = worldObj.getTopSolidOrLiquidBlock(spawn);
		return spawn;
	}
	
}
