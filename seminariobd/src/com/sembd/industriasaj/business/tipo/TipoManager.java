package com.sembd.industriasaj.business.tipo;

import java.util.List;

public class TipoManager {
	
	private TipoDAO dao =  TipoDAO.getTipoDAO();
    private static TipoManager manager;

    private TipoManager(){}

    public static TipoManager getTipoManager(){
        if(manager == null){
           manager = new TipoManager();
        }
       return manager;
    }


   public TipoDTO getTipo(TipoDTO t){
       TipoDTO tipo = dao.getTipo(t);
       return tipo;
   }

   public List<TipoDTO> getTipos(){
       List<TipoDTO> tipos = null;
       tipos = dao.getTipos();
       return tipos;
	}

   public boolean existTipo(TipoDTO t){
       boolean result=dao.existTipo(t);
       return result;
   }

}
