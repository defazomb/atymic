package dev.defazomb.atymic.common.tileentity

import dev.defazomb.atymic.Atymic
import dev.defazomb.atymic.api.SunlightProvider
import dev.defazomb.atymic.common.capability.sunlight.DefaultSunlightProvider
import net.minecraft.network.NetworkManager
import net.minecraft.network.play.server.SUpdateTileEntityPacket
import net.minecraft.tileentity.ITickableTileEntity
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ResourceLocation
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.util.LazyOptional

class SunForgeTileEntity : TileEntity(TileEntityHandler.SUN_FORGE.get()), ITickableTileEntity {

    val sunlight = DefaultSunlightProvider(capacity = 100)

    override fun tick() {
        sunlight.value += 1

        // Since we've updated the value, mark the chunk as dirty.
        markDirty()
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T> getCapability(capability: Capability<T>): LazyOptional<T> {
        if (capability == SUNLIGHT_PROVIDER) {
            // This cast is safe since we are checking the capability.
            return LazyOptional.of { sunlight as T }
        }

        return super.getCapability(capability)
    }

    companion object {

        val NAME = "sun_forge"
        val RESOURCE_LOCATION = ResourceLocation(Atymic.MOD_ID, NAME)

        @CapabilityInject(SunlightProvider::class)
        lateinit var SUNLIGHT_PROVIDER: Capability<SunlightProvider>;
    }
}
