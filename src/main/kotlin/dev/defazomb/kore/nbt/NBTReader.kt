package dev.defazomb.kore.nbt

import net.minecraft.nbt.CompoundNBT
import net.minecraft.nbt.INBT
import java.lang.IllegalStateException

class NBTReader(private val tag: INBT) {

    fun compound(initializer: CompoundNBTReader.() -> Unit) {
        if (tag !is CompoundNBT) {
            throw IllegalStateException("Cannot read compound key from non-compound NBT")
        }

        val reader = CompoundNBTReader(tag)
        reader.apply(initializer)
    }

    class CompoundNBTReader(private val tag: CompoundNBT) {

        fun long(key: String): Long {
            return tag.getLong(key)
        }
    }
}
