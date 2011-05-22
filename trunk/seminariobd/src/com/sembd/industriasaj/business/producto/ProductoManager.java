package com.sembd.industriasaj.business.producto;

import java.util.List;

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

   public boolean existProducto(ProductoDTO p){
       boolean result=dao.existProducto(p);
       return result;
   }

}
