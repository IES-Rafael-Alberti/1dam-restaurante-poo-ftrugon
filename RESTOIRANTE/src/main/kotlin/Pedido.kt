class Pedido(val numero: Int,var platos: MutableList<Plato>,val estado: String) {

    val id: Int = contPedidos

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

    fun calcularPrecio(){

    }

    fun calcularTiempo(){

    }

    override fun toString(): String {
        return super.toString()
    }
}
//a