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

   
   public boolean insertPedido(PedidoDTO p){
       return dao.insertPedido(p);
   }
   
   public List<PedidoDTO> getPedidos(){
       List<PedidoDTO> pedidos = null;
       pedidos = dao.getPedidos();
       return pedidos;
	}
   
   public List<PedidoDTO> getPedidosAEliminar(){
       List<PedidoDTO> pedidos = null;
       pedidos = dao.getPedidosAEliminar();
       return pedidos;
	}
   
   public List<PedidoDTO> getPedidosAModificar(){
       List<PedidoDTO> pedidos = null;
       pedidos = dao.getPedidosAModificar();
       return pedidos;
	}
   
   public List<PedidoDTO> getPedidosAFacturar(){
       List<PedidoDTO> pedidos = null;
       pedidos = dao.getPedidosAFacturar();
       return pedidos;
	}
   
   public List<PedidoDTO> getPedidosPorProducto(ProductoDTO p){
       List<PedidoDTO> pedidos = null;
       pedidos = dao.getPedidosPorProducto(p);
       return pedidos;
	}
   
   public boolean borrarPedido(PedidoDTO p){
        return dao.borrarPedido(p);
	}

   public boolean existPedido(PedidoDTO p){
       boolean result=dao.existPedido(p);
       return result;
   }
   
   public boolean updatePedido(PedidoDTO p){
       return dao.updatePedido(p);
	}

}
