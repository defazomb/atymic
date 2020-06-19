package dev.defazomb.atymic

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import org.apache.logging.log4j.LogManager

@Mod(Atymic.MOD_ID)
class Atymic {

    init {
        BLOCKS.register(FMLJavaModLoadingContext.get().modEventBus)
    }

    companion object {

        const val MOD_ID = "atymic"

        private val LOGGER = LogManager.getLogger(MOD_ID)

        private val BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID)
        private val ROCK_BLOCK = BLOCKS.register("rock") {
            Block(Block.Properties.create(Material.ROCK))
        }
    }
}