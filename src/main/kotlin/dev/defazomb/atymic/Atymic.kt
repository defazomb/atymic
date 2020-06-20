package dev.defazomb.atymic

import dev.defazomb.atymic.common.block.BlockHandler
import dev.defazomb.atymic.common.block.ConcentratorBlock
import dev.defazomb.atymic.common.block.ExtractionLensBlock
import dev.defazomb.atymic.common.block.ImportingLensBlock
import dev.defazomb.atymic.common.block.SunForgeBlock
import dev.defazomb.atymic.common.capability.CapabilityHandler
import dev.defazomb.atymic.common.item.ItemHandler
import dev.defazomb.atymic.common.item.group.ItemGroupHandler
import dev.defazomb.atymic.common.tileentity.ConcentratorTileEntity
import dev.defazomb.atymic.common.tileentity.ExtractionLensTileEntity
import dev.defazomb.atymic.common.tileentity.ImportingLensTileEntity
import dev.defazomb.atymic.common.tileentity.SunForgeTileEntity
import dev.defazomb.atymic.common.tileentity.TileEntityHandler
import dev.defazomb.kore.register.Register
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.tileentity.TileEntity
import net.minecraftforge.event.AttachCapabilitiesEvent
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext

@Mod(Atymic.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
class Atymic {

    init {
        val modEventBus = FMLJavaModLoadingContext.get().modEventBus

        BlockHandler.BLOCKS.register(modEventBus)
        ItemHandler.ITEMS.register(modEventBus)
        TileEntityHandler.TILE_ENTITIES.register(modEventBus)

        Register.mod(MOD_ID) {
            tileEntity("concentrator", { ConcentratorTileEntity() }) {
                block { ConcentratorBlock() }
            }
            tileEntity("extraction_lens", { ExtractionLensTileEntity() }) {
                block { ExtractionLensBlock() }
            }
            tileEntity("importing_lens", { ImportingLensTileEntity() }) {
                block { ImportingLensBlock() }
            }
            tileEntity("sun_forge", { SunForgeTileEntity() }) {
                block { SunForgeBlock() }
            }
        }
    }

    companion object {

        const val MOD_ID = "atymic"

        @JvmStatic
        @SubscribeEvent
        fun onCommonSetup(event: FMLCommonSetupEvent) {
            CapabilityHandler()
        }

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