package dev.defazomb.atymic.common.item.group

import dev.defazomb.atymic.Atymic
import dev.defazomb.atymic.common.item.ItemHandler
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack

class ItemGroup : ItemGroup(Atymic.MOD_ID) {

    override fun createIcon(): ItemStack {
        return ItemStack(ItemHandler.SUN_STONE.get())
    }
}