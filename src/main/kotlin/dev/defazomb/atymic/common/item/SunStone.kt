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
        val tileEntity = context.world.getTileEntity(context.pos)
        if (tileEntity is ImportingLensTileEntity) {
            return handleImportLens(context, tileEntity)
        }
        if (tileEntity is ExtractionLensTileEntity) {
            return handleExtractLens(context, tileEntity)
        }
        return ActionResultType.PASS
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