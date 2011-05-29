package com.sembd.industriasaj.business.producto;

public class ProductoDAOHelper {
	
	public static String getProducto() {
        String result = "SELECT p.referencia, p.identificador, p.tipo.codigo, p.tipo.multiplo, p.descripcion,p.cant_stock,p.precio_unitario,p.valor_min,p.valor_optimo FROM tb_producto p WHERE p.referencia=? ORDER BY p.referencia";
        return result;
    }

    public static String getProductos() {
        String result = "SELECT p.referencia, p.identificador, p.tipo.codigo, p.tipo.multiplo, p.descripcion,p.cant_stock,p.precio_unitario,p.valor_min,p.valor_optimo FROM tb_producto p ORDER BY p.referencia";
        return result;
    }
    
    public static String getProductosPorTipo() {
        String result = "SELECT p.referencia, p.identificador, p.tipo.codigo, p.tipo.multiplo, p.descripcion,p.cant_stock,p.precio_unitario,p.valor_min,p.valor_optimo FROM tb_producto p WHERE p.tipo.codigo=? ORDER BY p.referencia";
        return result;
    }
    
    public static String updateProducto() {
        String result = "UPDATE tb_producto SET cant_stock=? WHERE referencia=?";
        return result;
    }

}
