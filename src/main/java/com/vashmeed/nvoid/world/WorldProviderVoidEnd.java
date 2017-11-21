package com.vashmeed.nvoid.world;

import com.vashmeed.nvoid.config.Config;
import com.vashmeed.nvoid.world.biome.VoidBiomeProvider;
import com.vashmeed.nvoid.world.end.DragonFightVoid;
import com.vashmeed.nvoid.world.gen.ChunkGeneratorVoidEnd;

import net.minecraft.init.Biomes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldProviderVoidEnd extends WorldProviderEnd {

	private DragonFightVoid dragonFightManager;
	
	@Override
    public void init()
    {
    	if (Config.voidBiomeEnd) {
    		this.biomeProvider = new BiomeProviderSingle(Biomes.SKY);
		} else {
			this.biomeProvider = new VoidBiomeProvider(world);
		}

        if (Config.endDragonEnabled) {
            NBTTagCompound nbttagcompound = this.world.getWorldInfo().getDimensionData(DimensionType.THE_END.getId());
            this.dragonFightManager = this.world instanceof WorldServer ? new DragonFightVoid((WorldServer)this.world,
					nbttagcompound.getCompoundTag("DragonFight")) : null;
        }
	}

	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorVoidEnd(world);
	}

	@Override
	public BlockPos getRandomizedSpawnPoint() {
		BlockPos spawn = new BlockPos(world.getSpawnPoint());
		spawn = world.getTopSolidOrLiquidBlock(spawn);
		return spawn;
	}
	
}
