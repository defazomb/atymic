package dev.defazomb.atymic

import dev.defazomb.atymic.common.block.BlockHandler
import dev.defazomb.atymic.common.item.ItemHandler
import dev.defazomb.atymic.common.item.group.ItemGroupHandler
import dev.defazomb.atymic.common.tileentity.TileEntityHandler
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.tileentity.TileEntity
import net.minecraftforge.event.AttachCapabilitiesEvent
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext

@Mod(Atymic.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
class Atymic {

    init {
        val modEventBus = FMLJavaModLoadingContext.get().modEventBus

        BlockHandler.BLOCKS.register(modEventBus)
        ItemHandler.ITEMS.register(modEventBus)
        TileEntityHandler.TILE_ENTITIES.register(modEventBus)
    }

    companion object {

        const val MOD_ID = "atymic"

        @JvmStatic
        @SubscribeEvent
        fun onRegisterItems(event: RegistryEvent.Register<Item>) {
            val registry = event.registry

            BlockHandler.BLOCKS.entries
                    .map { it.get() }
                    .forEach {
                        registry.register(BlockItem(it, Item.Properties().group(ItemGroupHandler.ITEM_GROUP)).apply {
                            registryName = it.registryName
                        })
                    }
        }
    }
}