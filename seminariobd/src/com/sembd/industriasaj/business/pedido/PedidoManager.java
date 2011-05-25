package com.sembd.industriasaj.business.pedido;

import java.util.List;

import com.sembd.industriasaj.business.producto.ProductoDTO;

public class PedidoManager {
	
	private PedidoDAO dao =  PedidoDAO.getPedidoDAO();
    private static PedidoManager manager;

    private PedidoManager(){}

    public static PedidoManager getPedidoManager(){
        if(manager == null){
           manager = new PedidoManager();
        }
       return manager;
    }


   public PedidoDTO getPedido(PedidoDTO p){
       PedidoDTO pedido = dao.getPedido(p);
       return pedido;
   }

   public List<PedidoDTO> getPedidos(){
       List<PedidoDTO> pedidos = null;
       pedidos = dao.getPedidos();
       return pedidos;
	}
   
   public List<PedidoDTO> getPedidosPorProducto(ProductoDTO p){
       List<PedidoDTO> pedidos = null;
       pedidos = dao.getPedidosPorProducto(p);
       return pedidos;
	}

   public boolean existPedido(PedidoDTO p){
       boolean result=dao.existPedido(p);
       return result;
   }

}
