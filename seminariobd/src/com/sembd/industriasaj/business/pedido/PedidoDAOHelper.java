package com.sembd.industriasaj.business.pedido;

public class PedidoDAOHelper {
	
	public static String getPedido() {
        String result = "SELECT p.codigo, p.fecha_pedido, p.fecha_entrega, p.cantidad, p.referencia.referencia, p.referencia.identificador, p.referencia.descripcion,p.referencia.cant_stock,p.referencia.precio_unitario,p.referencia.valor_min,p.referencia.valor_optimo, p.estado, f.codigo, f.fecha, f.base, f.iva, f.total FROM tb_pedido p, tb_factura f WHERE p.codigo=? AND f.pedido.codigo=p.codigo ORDER BY p.codigo";
        return result;
    }

    public static String getPedidos() {
    	String result = "SELECT p.codigo, p.fecha_pedido, p.fecha_entrega, p.cantidad, p.referencia.referencia, p.referencia.identificador, p.referencia.descripcion,p.referencia.cant_stock,p.referencia.precio_unitario,p.referencia.valor_min,p.referencia.valor_optimo, p.estado, f.codigo, f.fecha, f.base, f.iva, f.total FROM tb_pedido p, tb_factura f WHERE f.pedido.codigo=p.codigo ORDER BY p.codigo";
        return result;
    }
    
    public static String getPedidosPorProducto() {
    	String result = "SELECT p.codigo, p.fecha_pedido, p.fecha_entrega, p.cantidad, p.referencia.referencia, p.referencia.identificador, p.referencia.descripcion,p.referencia.cant_stock,p.referencia.precio_unitario,p.referencia.valor_min,p.referencia.valor_optimo, p.estado, f.codigo, f.fecha, f.base, f.iva, f.total FROM tb_pedido p, tb_factura f WHERE f.pedido.codigo=p.codigo AND p.referencia.referencia=? ORDER BY p.codigo";
        return result;
    }

}
