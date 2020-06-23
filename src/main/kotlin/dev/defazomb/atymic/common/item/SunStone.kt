package dev.defazomb.atymic.common.item

import dev.defazomb.atymic.common.item.group.ItemGroupHandler
import dev.defazomb.atymic.common.tileentity.ExtractionLensTileEntity
import dev.defazomb.atymic.common.tileentity.ImportingLensTileEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemUseContext
import net.minecraft.util.ActionResultType

class SunStone : Item(PROPERTIES) {

    private var targetExtractingLens: ExtractionLensTileEntity? = null

    override fun onItemUse(context: ItemUseContext): ActionResultType {
        return when(val tileEntity = context.world.getTileEntity(context.pos)) {
            is ImportingLensTileEntity -> handleImportLens(context, tileEntity)
            is ExtractionLensTileEntity -> handleExtractLens(context, tileEntity)
            else -> ActionResultType.PASS
        }
    }

    private fun handleImportLens(context: ItemUseContext, tileEntity: ImportingLensTileEntity): ActionResultType {
        if (targetExtractingLens == null) {
            return ActionResultType.FAIL
        }

        targetExtractingLens?.destination = tileEntity
        targetExtractingLens = null

        return ActionResultType.SUCCESS
    }

    private fun handleExtractLens(context: ItemUseContext, tileEntity: ExtractionLensTileEntity): ActionResultType {
        targetExtractingLens = tileEntity
        return ActionResultType.SUCCESS
    }

    companion object {

        val PROPERTIES: Properties = Properties()
                .group(ItemGroupHandler.ITEM_GROUP)
                .maxStackSize(1)
    }
}