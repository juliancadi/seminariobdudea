package com.sembd.industriasaj.business.producto;

import java.util.List;

import com.sembd.industriasaj.business.entrega.EntregaManager;
import com.sembd.industriasaj.business.tipo.TipoDTO;

public class ProductoManager {
	
	private ProductoDAO dao =  ProductoDAO.getProductoDAO();
    private static ProductoManager manager;

    private ProductoManager(){}

    public static ProductoManager getProductoManager(){
        if(manager == null){
           manager = new ProductoManager();
        }
       return manager;
    }


   public ProductoDTO getProducto(ProductoDTO p){
       ProductoDTO producto = dao.getProducto(p);
       return producto;
   }

   public List<ProductoDTO> getProductos(){
       List<ProductoDTO> productos = null;
       productos = dao.getProductos();
       return productos;
	}
   
   public List<ProductoDTO> getProductosPorTipo(TipoDTO t){
       List<ProductoDTO> productos = null;
       productos = dao.getProductosPorTipo(t);
       return productos;
	}
   
   public List<ProductoDTO> getProductosDebajoDelMin(){
       List<ProductoDTO> productos = null;
       productos = dao.getProductosDebajoDelMin();
       return productos;
	}
   
   public int getCantidadPedida(ProductoDTO p){
	   int cantidadPedida = 0;
	  
       if(p.getTbPedidos()!=null){
           for(int i=0; i<p.getTbPedidos().size();i++){
        	   if(!p.getTbPedidos().get(i).getEstado().equals("Completo")){
		           	int cantidadEntregada = 0;
		           	EntregaManager em = EntregaManager.getEntregaManager();
		           	p.getTbPedidos().get(i).setTbEntregas(em.getEntregasPorPedido(p.getTbPedidos().get(i)));
		           	for(int j=0; j<p.getTbPedidos().get(i).getTbEntregas().size();j++){
		               	cantidadEntregada = cantidadEntregada + p.getTbPedidos().get(i).getTbEntregas().get(j).getCantidad();
		           	}
		           	cantidadPedida = cantidadPedida + p.getTbPedidos().get(i).getCantidad() - cantidadEntregada;
        	   }
           }
       }
       return cantidadPedida;
   }

   public boolean existProducto(ProductoDTO p){
       boolean result=dao.existProducto(p);
       return result;
   }
   
   public boolean updateProducto(ProductoDTO p){
	   return dao.updateProducto(p);
   }

}
