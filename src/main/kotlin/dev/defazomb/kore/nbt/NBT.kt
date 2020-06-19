package dev.defazomb.kore.nbt

import net.minecraft.nbt.CompoundNBT
import net.minecraft.nbt.INBT

class NBT {

    companion object {

        fun read(tag: INBT, initializer: NBTReader.() -> Unit) {
            val reader = NBTReader(tag)
            reader.apply(initializer)
        }

        fun compound(initializer: CompoundNBTBuilder.() -> Unit): CompoundNBT {
            val builder = CompoundNBTBuilder()
            builder.apply(initializer)
            return builder.build()
        }
    }
}
