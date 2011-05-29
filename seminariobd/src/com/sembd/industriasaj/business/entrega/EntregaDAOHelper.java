package com.sembd.industriasaj.business.entrega;

public class EntregaDAOHelper {
	
	public static String getEntrega() {
        String result = "SELECT e.codigo, e.pedido.codigo, e.pedido.fecha_pedido, e.pedido.fecha_entrega, e.pedido.cantidad, e.pedido.estado, e.fecha, e.cantidad FROM tb_entrega e WHERE e.codigo=? ORDER BY e.codigo";
        return result;
    }

    public static String getEntregas() {
    	String result = "SELECT e.codigo, e.pedido.codigo, e.pedido.fecha_pedido, e.pedido.fecha_entrega, e.pedido.cantidad, e.pedido.estado, e.fecha, e.cantidad FROM tb_entrega e ORDER BY e.codigo";
        return result;
    }
    
    public static String getEntregasPorPedido() {
    	String result = "SELECT e.codigo, e.pedido.codigo, e.pedido.fecha_pedido, e.pedido.fecha_entrega, e.pedido.cantidad, e.pedido.estado, e.fecha, e.cantidad FROM tb_entrega e WHERE e.pedido.codigo=? ORDER BY e.codigo";
        return result;
    }
    
    public static String insertEntrega() {
        String result = "INSERT INTO tb_entrega  values(?, (select ref(p) from tb_pedido p where p.codigo=?), ?,?) ";
        return result;
    }

}
