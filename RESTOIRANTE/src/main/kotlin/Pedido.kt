class Pedido(var estado: String = "Pendiente") {

    val numero: Int = contPedidos
    var platos = mutableListOf<Plato>()

    init {
        contPedidos ++
    }

    companion object{
        var contPedidos = 1
    }

    fun agregarPlato(plato: Plato) {
        platos.add(plato)
    }

    fun eliminarPlato(nombrePlato: String){
        val esta = platos.find { it.nombre == nombrePlato }

        if (esta != null){
            platos.remove(esta)
        }else{
            println("El plato no esta en los platos")
        }
    }

    fun calcularPrecio():Double{
        var total = 0.0
        for(plato in platos){
            total += plato.precio
        }
        return total
    }

    fun calcularTiempo():Int{
        var total = 0
        for(plato in platos){
            total += plato.tiempoPreparacion
        }
        return total
    }

    override fun toString(): String {
        platos.forEach{ println(it)}
        return "Estado: $estado"
    }
}
