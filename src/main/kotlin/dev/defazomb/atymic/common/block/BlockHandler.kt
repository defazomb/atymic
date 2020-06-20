package dev.defazomb.atymic.common.block

import dev.defazomb.atymic.Atymic
import net.minecraft.block.Block
import net.minecraftforge.fml.RegistryObject
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

class BlockHandler {

    companion object {

        val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, Atymic.MOD_ID)

        val EXTRACTION_LENS: RegistryObject<Block> = BLOCKS.register("extraction_lens") {
            ExtractionLensBlock()
        }

        val IMPORTING_LENS: RegistryObject<Block> = BLOCKS.register("importing_lens") {
            ImportingLensBlock()
        }

        val SUN_FORGE: RegistryObject<Block> = BLOCKS.register("sun_forge") {
            SunForgeBlock()
        }
    }
}