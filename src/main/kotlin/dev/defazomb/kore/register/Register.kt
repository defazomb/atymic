package dev.defazomb.kore.register

class Register {

    companion object {

        fun mod(id: String, initializer: RegistryBuilder.() -> Unit) {
            val builder = RegistryBuilder(id)
            builder.apply(initializer)
        }
    }
}