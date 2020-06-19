package dev.defazomb.atymic

import dev.defazomb.atymic.common.block.BlockHandler
import dev.defazomb.atymic.common.tileentity.TileEntityHandler
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext

@Mod(Atymic.MOD_ID)
class Atymic {

    init {
        val modEventBus = FMLJavaModLoadingContext.get().modEventBus

        BlockHandler.BLOCKS.register(modEventBus)
        TileEntityHandler.TILE_ENTITIES.register(modEventBus)
    }

    companion object {

        const val MOD_ID = "atymic"
    }
}