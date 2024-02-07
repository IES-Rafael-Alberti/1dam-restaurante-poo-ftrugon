class Mesa(var numero: Int, capacidad: Int , var estado: String = "libre" ) {

    var capacidad = capacidad
        set(value) {
            require(value<= 6){"La capacidad de la mesa no puede ser mayor a 6"}
            require(value > 0){"La capacidad de la mesa no puede ser 1 o menor a 1 "}
            field = value
        }
    init {
        this.capacidad = capacidad
    }

    var pedidos = mutableListOf<Pedido>()

    fun ocuparMesa(){
        if (this.estado == "libre"){
            this.estado = "ocupada"
        }else if (this.estado == "reserva") println("Esta mesa esta reservada") else println("Esta mesa esta ocupada")
    }

    fun ocuparReserva(){
        if (this.estado == "reserva"){
            this.estado = "ocupada"
        }else if (estado == "libre")println("Esta mesa no esta reservada" ) else println("Esta mesa esta ocupada")
    }


    fun liberarMesa(){
        this.estado = "libre"
    }

    fun agregarPedido(pedido:Pedido){
        pedidos.add(pedido)
    }
}