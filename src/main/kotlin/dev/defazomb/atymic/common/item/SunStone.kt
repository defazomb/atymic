package dev.defazomb.atymic.common.item

import dev.defazomb.atymic.common.item.group.ItemGroupHandler
import net.minecraft.item.Item

class SunStone : Item(PROPERTIES) {

    companion object {

        val PROPERTIES: Properties = Properties()
                .group(ItemGroupHandler.ITEM_GROUP)
                .maxStackSize(1)
    }
}