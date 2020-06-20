package dev.defazomb.kore.register

import net.minecraft.tileentity.TileEntity
import net.minecraft.tileentity.TileEntityType
import net.minecraftforge.fml.RegistryObject
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import java.util.function.Supplier

class RegistryBuilder(private val modId: String) {

    private val register = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, modId)

    fun <T : TileEntity> tileEntity(id: String, supplier: () -> T, initializer: TileEntityBuilder.() -> Unit): RegistryObject<TileEntityType<T>> {
        val builder = TileEntityBuilder(modId, id)
        builder.apply(initializer)

        return register.register(id) {
            TileEntityType.Builder
                    .create(Supplier(supplier), *builder.blocks.map {
                        it.get()
                    }.toTypedArray())
                    .build(null)
        }
    }
}