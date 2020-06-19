package dev.defazomb.kore.nbt

import net.minecraft.nbt.CompoundNBT

class CompoundNBTBuilder(private val tag: CompoundNBT = CompoundNBT()) {

    fun long(key: String, value: Long) {
        tag.putLong(key, value)
    }

    fun build(): CompoundNBT {
        return tag
    }
}