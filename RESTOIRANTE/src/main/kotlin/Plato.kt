import java.lang.IllegalArgumentException

class Plato(nombre: String, precio: Double, tiempoPreparacion: Int, var ingredientes: MutableList<String>) {

    var nombre: String = nombre
        set(value) {
            require(field.isNotEmpty()) {"El nombre no puede estar vacio"}
            field = value
        }

    var precio: Double = precio
        set(value) {
            require(field > 0.0) {"El precio del plato debe ser mayor que 0."}
            field = value
        }

    var tiempoPreparacion: Int = tiempoPreparacion
        set(value) {
            require(field > 1) {"El tiempo de preparación no podrá ser igual o inferior a 1."}
            field= value
        }

    init {
        this.nombre = nombre
        this.precio = precio
        this.tiempoPreparacion = tiempoPreparacion
    }

    fun agregarIngrediente(ingrediente: String){
        if (ingrediente.isNotBlank()) {
            ingredientes.add(ingrediente)
        }else{
            println("El ingrediente no puede estar vacio")
        }
    }

    override fun toString(): String {
        return "$nombre ($tiempoPreparacion min.) -> ${precio}€ ($ingredientes)"
    }
}
//a