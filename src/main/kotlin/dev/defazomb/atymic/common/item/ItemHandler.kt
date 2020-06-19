package dev.defazomb.atymic.common.item

import dev.defazomb.atymic.Atymic
import net.minecraft.item.Item
import net.minecraftforge.fml.RegistryObject
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

class ItemHandler {

    companion object {

        val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, Atymic.MOD_ID)

        val SUN_STONE: RegistryObject<Item> = ITEMS.register("sun_stone") {
            SunStone()
        }
    }
}