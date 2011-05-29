package com.sembd.industriasaj.business.entrega;

import java.util.List;

import com.sembd.industriasaj.business.pedido.PedidoDTO;

public class EntregaManager {
	
	private EntregaDAO dao =  EntregaDAO.getEntregaDAO();
    private static EntregaManager manager;

    private EntregaManager(){}

    public static EntregaManager getEntregaManager(){
        if(manager == null){
           manager = new EntregaManager();
        }
       return manager;
    }


   public EntregaDTO getEntrega(EntregaDTO en){
       EntregaDTO entrega = dao.getEntrega(en);
       return entrega;
   }

   public List<EntregaDTO> getEntregas(){
       List<EntregaDTO> entregas = null;
       entregas = dao.getEntregas();
       return entregas;
	}
   
   public List<EntregaDTO> getEntregasPorPedido(PedidoDTO p){
       List<EntregaDTO> entregas = null;
       entregas = dao.getEntregasPorPedido(p);
       return entregas;
	}
   
   public boolean insertEntrega(EntregaDTO e){

       return dao.insertEntrega(e);

	}

   public boolean existEntrega(EntregaDTO en){
       boolean result=dao.existEntrega(en);
       return result;
   }

}
