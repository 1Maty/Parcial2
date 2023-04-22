package Entities;

import Entities.Producto;

import java.util.LinkedList;

public class Pedido {
    private long cliente;
    private LinkedList<Producto> productosDelPedido = new LinkedList<>();

    public long getCliente() {
        return cliente;
    }

    public Pedido(long cliente, LinkedList<Producto> productosDelPedido) {
        this.cliente = cliente;
        this.productosDelPedido = productosDelPedido;
    }
}
