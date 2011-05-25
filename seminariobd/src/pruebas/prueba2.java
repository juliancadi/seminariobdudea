package pruebas;

import java.util.List;


import com.sembd.industriasaj.business.pedido.PedidoDTO;
import com.sembd.industriasaj.business.pedido.PedidoManager;
import com.sembd.industriasaj.business.producto.ProductoDTO;
import com.sembd.industriasaj.business.producto.ProductoManager;

public class prueba2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PedidoManager em = PedidoManager.getPedidoManager();
		List<PedidoDTO> entregas = em.getPedidos();
		for(int i=0;i<entregas.size();i++){
      		PedidoDTO e = entregas.get(i);
      		System.out.println(e.getCodigo()+" "+e.getFechaPedido());
     }
	}

}
