import java.util.LinkedList;
public class SupermercadoMgr implements SupermercadoMgt{
    LinkedList<Producto> productosRegistrados= new LinkedList();
    @Override
    public void agregarProducto(String nombre, float precio) throws EntidadYaExiste {
        for(int i =0;i<productosRegistrados.size();i++){
            if(productosRegistrados.get(i).getNombre().equals(nombre)){
                throw new EntidadYaExiste("El producto ya esta registrado");
            }
        }
        Producto productoAAñadir = new Producto(nombre,precio);
        productosRegistrados.add(productoAAñadir);
    }

    @Override
    public void ingresarPedido(long cedula, LinkedList<String> productos) throws EntidadNoExiste, InformacionInvalida {

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
