package com.sembd.industriasaj.business.factura;

public class FacturaDAOHelper {
	
	public static String getFactura() {
        String result = "SELECT f.codigo, f.fecha, f.base, f.iva, f.total, f.pedido.codigo, f.pedido.fecha_pedido, f.pedido.fecha_entrega, f.pedido.cantidad, f.pedido.estado FROM tb_factura f WHERE f.codigo=? ORDER BY f.codigo";
        return result;
    }

    public static String getFacturas() {
    	String result = "SELECT f.codigo, f.fecha, f.base, f.iva, f.total, f.pedido.codigo, f.pedido.fecha_pedido, f.pedido.fecha_entrega, f.pedido.cantidad, f.pedido.estado FROM tb_factura f ORDER BY f.codigo";
        return result;
    }

}
