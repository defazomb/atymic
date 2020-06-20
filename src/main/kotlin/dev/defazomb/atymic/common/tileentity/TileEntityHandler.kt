package dev.defazomb.atymic.common.tileentity

import dev.defazomb.atymic.Atymic
import dev.defazomb.atymic.common.block.BlockHandler
import net.minecraft.tileentity.TileEntityType
import net.minecraftforge.fml.RegistryObject
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import java.util.function.Supplier

class TileEntityHandler {

    companion object {

        val TILE_ENTITIES: DeferredRegister<TileEntityType<*>> = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Atymic.MOD_ID)

        val CONCENTRATOR: RegistryObject<TileEntityType<ConcentratorTileEntity>> = TILE_ENTITIES.register(ConcentratorTileEntity.ID) {
            TileEntityType.Builder.create(Supplier { ConcentratorTileEntity() }, BlockHandler.CONCENTRATOR.get()).build(null)
        }

        val EXTRACTION_LENS: RegistryObject<TileEntityType<ExtractionLensTileEntity>> = TILE_ENTITIES.register(ExtractionLensTileEntity.ID) {
            TileEntityType.Builder.create(Supplier { ExtractionLensTileEntity() }, BlockHandler.EXTRACTION_LENS.get()).build(null)
        }

        val IMPORTING_LENS: RegistryObject<TileEntityType<ImportingLensTileEntity>> = TILE_ENTITIES.register(ImportingLensTileEntity.ID) {
            TileEntityType.Builder.create(Supplier { ImportingLensTileEntity() }, BlockHandler.IMPORTING_LENS.get()).build(null)
        }

        val SUN_FORGE: RegistryObject<TileEntityType<SunForgeTileEntity>> = TILE_ENTITIES.register(SunForgeTileEntity.ID) {
            TileEntityType.Builder.create(Supplier { SunForgeTileEntity() }, BlockHandler.SUN_FORGE.get()).build(null)
        }
    }
}