class SistemaGestionRestaurante(private val mesas: List<Mesa>) {

    fun realizarPedido(numeroMesa: Int, pedido: Pedido) {
        val mimesa = mesas.find { it.numero == numeroMesa }
        if (mimesa != null){
            mimesa.agregarPedido(pedido)
        }else println("La mesa no existe")
    }

    fun cerrarPedido(numeroMesa: Int, numeroPedido: Int? = null) {
        val mimesa = mesas.find { it.numero == numeroMesa }

        if (mimesa != null && numeroPedido != null){

            val elpedido = mimesa.pedidos.find { it.numero == numeroPedido }

            if (elpedido != null){
                elpedido.estado = "servido"
            }else println("El pedido no existe")


        }else if (mimesa != null){

            val elpedido = mimesa.pedidos.lastOrNull()

            if (elpedido != null){
                elpedido.estado = "servido"
            }else println("El pedido no existe")

        }else println("La mesa no existe")
    }

    fun cerrarMesa(numeroMesa: Int) {
        val mimesa = mesas.find { it.numero == numeroMesa }
        if (mimesa != null){
            if (mimesa.pedidos.ifEmpty { true } == true) mimesa.estado = "libre" else println("la mesa sigue teniendo pedidos")
        }else println("la mesa no existe")
    }

    fun buscarPlatos(): List<String>? {
        val platos = mesas.flatMap { it.pedidos }.flatMap { it.platos }.map { it.nombre }
        return platos.ifEmpty { null }
    }

    fun contarPlato(nombre: String): Int? {
        val count = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .count { it.nombre == nombre }
        return if (count > 0) count else null
    }

    fun buscarPlatoMasPedido(): List<String>? {
        val platoCounts = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .groupingBy { it.nombre }
            .eachCount()

        val maxCount = platoCounts.maxByOrNull { it.value }?.value
        return maxCount?.let { max -> platoCounts.filter { it.value == max }.keys.toList() }
    }
}