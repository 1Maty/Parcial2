package Entities;

import Excepciones.EntidadNoExiste;
import Excepciones.EntidadYaExiste;
import Excepciones.InformacionInvalida;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SupermercadoMgr implements SupermercadoMgt {
    public LinkedList<Producto> getProductosRegistrados() {
        return productosRegistrados;
    }

    private LinkedList<Producto> productosRegistrados= new LinkedList();
    private LinkedList<Pedido> pedidosFinalizados = new LinkedList<>();
    private Stack<Pedido> pedidosPrioritarios = new Stack<>();
    private Queue<Pedido> pedidosNormales = new LinkedList<>();
    @Override
    public void agregarProducto(String nombre, float precio) throws EntidadYaExiste {

      Producto nuevoProducto = new Producto(nombre,precio);
      if(productosRegistrados.contains(nuevoProducto)){
          throw new EntidadYaExiste("Ya esta registrado ese producto master");
      }
      else{
          productosRegistrados.add(nuevoProducto);
      }
    }

    @Override
    public void ingresarPedido(long cedula, LinkedList<String> productos) throws EntidadNoExiste, InformacionInvalida {
        boolean esta =true;
        LinkedList<Producto> productosDelPedido = new LinkedList<>();
        for(Pedido pedidos:pedidosPrioritarios){
            if(pedidos.getCliente()==cedula){
                throw new InformacionInvalida("Flaco ya tenes un pedido");
            }
        }
        if(productos.size()<3){ // prioritario
            for(int g = 0 ; g<productos.size();g++){
                for(int p = 0; p<productosRegistrados.size();p++){
                    if(productos.get(g).equals(productosRegistrados.get(p).getNombre())){
                        productosDelPedido.add(productosRegistrados.get(p));
                    }
                }
            }
            for(int i = 0 ;i<productosDelPedido.size();i++){
                if(!(productosRegistrados.contains(productosDelPedido.get(i)))){
                 throw new EntidadNoExiste("Algun producto no estaba");
                }
            }
            Pedido nuevoPedido = new Pedido(cedula,productosDelPedido);
            pedidosPrioritarios.add(nuevoPedido);
        }
    else{
        for(int g=0;g<productos.size();g++){
            for(int p = 0 ; p< productosRegistrados.size();p++){
                if(productos.get(g).equals(productosRegistrados.get(p).getNombre())){
                    productosDelPedido.add(productosRegistrados.get(g));
                }
            }
        }
        for(int t =0 ;t<productosDelPedido.size();t++){
            if(!(productosRegistrados.contains(productosDelPedido.get(t)))){
                //throw new
            }
        }
        }

    }

    @Override
    public Pedido procesarProximoPedido() throws InformacionInvalida {
        return null;
    }

    @Override
    public void cancelarPedido(long cedula) throws EntidadNoExiste {

    }

    @Override
    public Cliente obtenerClienteConTicketMasCaro() {
        return null;
    }
}
