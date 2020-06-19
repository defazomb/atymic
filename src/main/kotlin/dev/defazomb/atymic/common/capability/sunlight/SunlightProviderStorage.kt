package dev.defazomb.atymic.common.capability.sunlight

import dev.defazomb.atymic.api.SunlightProvider
import dev.defazomb.kore.nbt.NBT
import net.minecraft.nbt.CompoundNBT
import net.minecraft.nbt.INBT
import net.minecraft.util.Direction
import net.minecraftforge.common.capabilities.Capability

class SunlightProviderStorage : Capability.IStorage<SunlightProvider> {

    override fun readNBT(capability: Capability<SunlightProvider>, instance: SunlightProvider, side: Direction, nbt: INBT) {
        if (nbt !is CompoundNBT) {
            return;
        }

        instance.deserializeNBT(nbt)
    }

    override fun writeNBT(capability: Capability<SunlightProvider>, instance: SunlightProvider, side: Direction): INBT {
        return instance.serializeNBT()
    }
}