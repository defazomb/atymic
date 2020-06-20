package dev.defazomb.atymic.common.block

import dev.defazomb.atymic.common.tileentity.TileEntityHandler
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.material.Material
import net.minecraft.item.BlockItemUseContext
import net.minecraft.state.DirectionProperty
import net.minecraft.state.StateContainer
import net.minecraft.state.properties.BlockStateProperties
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.IBlockReader

class ExtractionLensBlock : Block(Properties.create(Material.ROCK)) {

    override fun hasTileEntity(state: BlockState): Boolean {
        return true
    }

    override fun createTileEntity(state: BlockState, world: IBlockReader): TileEntity? {
        return TileEntityHandler.EXTRACTION_LENS.get().create()
    }

    override fun fillStateContainer(builder: StateContainer.Builder<Block, BlockState>) {
        builder.add(facing)
    }

    override fun getStateForPlacement(context: BlockItemUseContext): BlockState? {
        var blockState = super.getStateForPlacement(context)
        if (blockState != null) {
            blockState = blockState.with(BlockStateProperties.FACING, context.nearestLookingDirection)
        }

        return blockState
    }

    companion object {

        val facing: DirectionProperty = BlockStateProperties.FACING
    }
}
