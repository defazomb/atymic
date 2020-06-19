package dev.defazomb.atymic.common.capability.sunlight

import dev.defazomb.atymic.api.SunlightProvider
import dev.defazomb.kore.nbt.NBT
import net.minecraft.nbt.CompoundNBT
import java.lang.IllegalStateException

/**
 * The default implementation of [SunlightProvider].
 */
class DefaultSunlightProvider(override var capacity: Long = 0) : SunlightProvider {

    override var value: Long = 0
        set(value) {
            field = value.coerceAtMost(capacity)
        }

    override val isFull: Boolean
        get() = this.value >= this.capacity

    override val isEmpty: Boolean
        get() = this.value <= 0

    override fun deserializeNBT(nbt: CompoundNBT) {
        return NBT.read(nbt) {
            compound {
                capacity = long("capacity")
                value = long("value")
            }
        }
    }

    override fun serializeNBT(): CompoundNBT {
        return NBT.compound {
            long("capacity", capacity)
            long("value", value)
        }
    }
}
