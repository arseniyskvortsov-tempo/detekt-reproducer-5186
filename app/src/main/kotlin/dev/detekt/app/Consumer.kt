package dev.detekt.app

import dev.detekt.utils.Model

typealias XxxFunction = (Int) -> java.util.Map.Entry<String?, Integer?>?

class Consumer {
    fun printName(model: Model?) {
        val name = model?.name ?: return

        println("Name: $name")
    }

    private fun validateNames(models: List<Model?>) {
        val transformed = models.mapNotNull {
            val name = it?.name ?: return@mapNotNull null
            val whatever = it?.whatever ?: return@mapNotNull null

            println("Name: $name")
            name to whatever
        }
        println(transformed)
    }

    private fun formMap(f: XxxFunction) {
        val objs = PlatformDefinition.getSample()
//        val byNullable = objs.associateBy { it.nullable }
        val byNonNullable = objs.associateBy { it.nonNullable }
//        val byPlatformDependent = objs.associateBy { it.undefined }
        sequenceOf(1, 2).forEach {
            val obj = f(it) ?: return@forEach
            val key = obj.key
//            val value1 = byNullable[key] ?: return@forEach
//            println(value1)
            val value2 = byNonNullable[key] ?: return@forEach
            println(value2)
//            val value3 = byPlatformDependent[key] ?: return@forEach
//            println(value3)
        }
    }

    private fun platformEntries(f: XxxFunction) {
        val objs = PlatformDefinition.getSampleEntries()
        val byDependent = objs.associateBy { it.key }
        sequenceOf(1, 2).forEach {
            val obj = f(it) ?: return@forEach
            val key = obj.key
            val value2 = byDependent[key] ?: return@forEach
            println(value2)
        }
    }
}
