package dev.defazomb.atymic.common.block

import dev.defazomb.atymic.common.tileentity.TileEntityHandler
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.material.Material
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ActionResultType
import net.minecraft.util.Hand
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.BlockRayTraceResult
import net.minecraft.world.IBlockReader
import net.minecraft.world.World

class SunForgeBlock : Block(Properties.create(Material.ROCK)) {

    override fun hasTileEntity(state: BlockState): Boolean {
        return true
    }

    override fun createTileEntity(state: BlockState, world: IBlockReader): TileEntity? {
        return TileEntityHandler.SUN_FORGE.get().create()
    }
}
