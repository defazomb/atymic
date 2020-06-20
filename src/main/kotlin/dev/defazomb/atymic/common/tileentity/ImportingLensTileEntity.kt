package dev.defazomb.atymic.common.tileentity

import dev.defazomb.atymic.api.SunlightProvider
import dev.defazomb.atymic.common.block.ImportingLensBlock
import net.minecraft.tileentity.TileEntity
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject

class ImportingLensTileEntity : TileEntity(TileEntityHandler.IMPORTING_LENS.get()) {

    fun import(amount: Long): Long {
        val sunlightProvider = getTargetCapability() ?: return 0

        val amountImported = sunlightProvider.import(amount)
        if (amountImported > 0) {
            world?.getTileEntity(pos.offset(blockState[ImportingLensBlock.facing]))?.markDirty()
        }

        return amountImported
    }

    fun hasCapacity(): Boolean {
        val sunlightProvider = getTargetCapability() ?: return false
        return !sunlightProvider.isFull
    }

    private fun getTargetCapability(): SunlightProvider? {
        val direction = blockState[ImportingLensBlock.facing]
        return world?.getTileEntity(pos.offset(direction))?.getCapability(SUNLIGHT_PROVIDER, direction.opposite)?.orElse(null)
    }

    companion object {

        const val ID = "importing_lens"

        @JvmStatic
        @CapabilityInject(SunlightProvider::class)
        lateinit var SUNLIGHT_PROVIDER: Capability<SunlightProvider>
    }
}