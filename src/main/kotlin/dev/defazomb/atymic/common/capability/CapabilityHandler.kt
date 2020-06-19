package dev.defazomb.atymic.common.capability

import dev.defazomb.atymic.api.SunlightProvider
import dev.defazomb.atymic.common.capability.sunlight.DefaultSunlightProvider
import dev.defazomb.atymic.common.capability.sunlight.SunlightProviderStorage
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.capabilities.CapabilityManager

class CapabilityHandler {

    init {
        CapabilityManager.INSTANCE.register(SunlightProvider::class.java, SunlightProviderStorage()) {
            DefaultSunlightProvider()
        }
    }
}