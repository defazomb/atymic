package dev.defazomb.atymic.common.tileentity

import dev.defazomb.atymic.Atymic
import dev.defazomb.atymic.api.SunlightProvider
import dev.defazomb.atymic.common.capability.sunlight.DefaultSunlightProvider
import net.minecraft.nbt.CompoundNBT
import net.minecraft.network.NetworkManager
import net.minecraft.network.play.server.SUpdateTileEntityPacket
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.Direction
import net.minecraft.util.ResourceLocation
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.util.LazyOptional


class ConcentratorTileEntity : TileEntity(TileEntityHandler.CONCENTRATOR.get()) {

    val sunlight = DefaultSunlightProvider(capacity = 10000)

    override fun write(tag: CompoundNBT): CompoundNBT {
        tag.put("sunlight", sunlight.serializeNBT())

        return super.write(tag)
    }

    override fun read(tag: CompoundNBT) {
        sunlight.deserializeNBT(tag.getCompound("sunlight"))

        super.read(tag)
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T> getCapability(capability: Capability<T>, side: Direction?): LazyOptional<T> {
        if (capability == SUNLIGHT_PROVIDER) {
            // This cast is safe since we are checking the capability.
            return LazyOptional.of { sunlight as T }
        }

        return super.getCapability(capability, side)
    }

    override fun getUpdatePacket(): SUpdateTileEntityPacket? {
        return SUpdateTileEntityPacket(getPos(), -1, write(CompoundNBT()))
    }

    override fun onDataPacket(net: NetworkManager?, pkt: SUpdateTileEntityPacket) {
        read(pkt.nbtCompound)
    }

    companion object {

        const val ID = "concentrator"

        val RESOURCE_LOCATION = ResourceLocation(Atymic.MOD_ID, ID)

        @JvmStatic
        @CapabilityInject(SunlightProvider::class)
        lateinit var SUNLIGHT_PROVIDER: Capability<SunlightProvider>
    }
}
