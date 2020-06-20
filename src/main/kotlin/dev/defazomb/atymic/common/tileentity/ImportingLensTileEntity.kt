package dev.defazomb.atymic.common.tileentity

import net.minecraft.tileentity.TileEntity

class ImportingLensTileEntity : TileEntity(TileEntityHandler.IMPORTING_LENS.get()) {

    companion object {

        const val ID = "importing_lens"
    }
}