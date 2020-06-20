package dev.defazomb.kore.register

import net.minecraft.block.Block
import net.minecraftforge.fml.RegistryObject
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import java.util.function.Supplier

class TileEntityBuilder(modId: String, private val tileEntityId: String) {

    val blocks: MutableSet<RegistryObject<out Block>> = mutableSetOf()

    private val register = DeferredRegister.create(ForgeRegistries.BLOCKS, modId)

    fun <T : Block> block(id: String, supplier: () -> T): RegistryObject<T> {
        register.register(id, Supplier(supplier)).apply {
            blocks.add(this)
            return this
        }
    }

    fun <T : Block> block(supplier: () -> T): RegistryObject<T> {
        return block(tileEntityId, supplier)
    }
}