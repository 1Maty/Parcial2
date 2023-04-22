package Entities;

import Excepciones.EntidadNoExiste;
import Excepciones.EntidadYaExiste;
import Excepciones.InformacionInvalida;

import java.util.LinkedList;

public interface SupermercadoMgt {
    void agregarProducto(String nombre, float precio) throws EntidadYaExiste;
    void ingresarPedido(long cedula, LinkedList<String> productos) throws EntidadNoExiste, InformacionInvalida;
    Pedido procesarProximoPedido() throws InformacionInvalida;
    void cancelarPedido(long cedula) throws EntidadNoExiste;
    Cliente obtenerClienteConTicketMasCaro();
}
