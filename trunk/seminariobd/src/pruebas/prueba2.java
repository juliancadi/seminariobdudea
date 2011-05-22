package pruebas;

import java.util.List;

import com.sembd.industriasaj.business.producto.ProductoDTO;
import com.sembd.industriasaj.business.producto.ProductoManager;

public class prueba2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductoManager pm = ProductoManager.getProductoManager();
		List<ProductoDTO> productos = pm.getProductos();
		for(int i=0;i<productos.size();i++){
      		ProductoDTO p = productos.get(i);
      		System.out.println(p.getReferencia());
     }
	}

}
