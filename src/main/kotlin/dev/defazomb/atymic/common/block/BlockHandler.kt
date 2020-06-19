package dev.defazomb.atymic.common.block

import dev.defazomb.atymic.Atymic
import net.minecraft.block.Block
import net.minecraftforge.fml.RegistryObject
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

class BlockHandler {

    companion object {

        val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, Atymic.MOD_ID)

        val SUN_FORGE: RegistryObject<Block> = BLOCKS.register("sun_forge") {
            SunForgeBlock()
        }
    }
}