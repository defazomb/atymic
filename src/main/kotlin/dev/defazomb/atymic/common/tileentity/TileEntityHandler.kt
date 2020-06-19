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

        val SUN_FORGE: RegistryObject<TileEntityType<SunForgeTileEntity>> = TILE_ENTITIES.register("sun_forge") {
            TileEntityType.Builder.create(Supplier { SunForgeTileEntity() }, BlockHandler.SUN_FORGE.get()).build(null)
        }
    }
}