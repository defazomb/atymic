package dev.defazomb.atymic.common.tileentity

import dev.defazomb.atymic.Atymic
import dev.defazomb.atymic.api.SunlightProvider
import dev.defazomb.atymic.common.block.ExtractionLensBlock
import net.minecraft.tileentity.ITickableTileEntity
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ResourceLocation
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject

class ExtractionLensTileEntity : TileEntity(TileEntityHandler.EXTRACTION_LENS.get()), ITickableTileEntity {

    var destination: ImportingLensTileEntity? = null

    override fun tick() {
        val dest = destination ?: return
        if (!dest.hasCapacity()) {
            return
        }

        val direction = blockState[ExtractionLensBlock.facing]
        val facing = world?.getTileEntity(pos.offset(direction))
        val capability = facing?.getCapability(SUNLIGHT_PROVIDER, direction.opposite)
        val sunlight = capability?.orElse(null) ?: return

        val attemptingAmount = sunlight.value.coerceAtMost(2)
        val importedAmount = dest.import(attemptingAmount)
        sunlight.extract(importedAmount)
    }

    companion object {

        const val ID = "extraction_lens"

        val RESOURCE_LOCATION = ResourceLocation(Atymic.MOD_ID, SunForgeTileEntity.ID)

        @JvmStatic
        @CapabilityInject(SunlightProvider::class)
        lateinit var SUNLIGHT_PROVIDER: Capability<SunlightProvider>
    }
}