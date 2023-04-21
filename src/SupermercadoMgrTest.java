import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupermercadoMgrTest {

    @Test
    void agregarProducto() {
        SupermercadoMgr macro = new SupermercadoMgr();
        try{
            macro.agregarProducto("oreos",523);
            macro.agregarProducto("coca",723);
            assertEquals(macro.productosRegistrados.size(),2);
        } catch (EntidadYaExiste e) {
            System.out.println(e);;
        }
    }

    @Test
    void ingresarPedido() {
    }

    @Test
    void procesarProximoPedido() {
    }

    @Test
    void cancelarPedido() {
    }

    @Test
    void obtenerClienteConTicketMasCaro() {
    }
}