package dev.defazomb.atymic.api

import net.minecraft.nbt.CompoundNBT
import net.minecraftforge.common.util.INBTSerializable

interface SunlightProvider : INBTSerializable<CompoundNBT> {

    /**
     * The capacity of this [SunlightProvider].
     *
     * This is the maximum amount of sunlight that can be contained.
     */
    var capacity: Long

    /**
     * The current amount of sunlight in this [SunlightProvider].
     *
     * This value should never be greater than [capacity].
     */
    var value: Long

    /**
     * Whether this [SunlightProvider] is full of sunlight.
     */
    val isFull: Boolean

    /**
     * Whether this [SunlightProvider] has no sunlight.
     */
    val isEmpty: Boolean
}