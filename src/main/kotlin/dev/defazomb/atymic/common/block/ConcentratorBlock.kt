package dev.defazomb.atymic.common.block

import dev.defazomb.atymic.common.tileentity.TileEntityHandler
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.material.Material
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.IBlockReader

class ConcentratorBlock : Block(Properties.create(Material.ROCK)) {

    override fun hasTileEntity(state: BlockState): Boolean {
        return true
    }

    override fun createTileEntity(state: BlockState, world: IBlockReader): TileEntity? {
        return TileEntityHandler.CONCENTRATOR.get().create()
    }
}