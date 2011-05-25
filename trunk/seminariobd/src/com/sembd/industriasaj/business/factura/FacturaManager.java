package com.sembd.industriasaj.business.factura;

import java.util.List;

public class FacturaManager {
	
	private FacturaDAO dao =  FacturaDAO.getFacturaDAO();
    private static FacturaManager manager;

    private FacturaManager(){}

    public static FacturaManager getFacturaManager(){
        if(manager == null){
           manager = new FacturaManager();
        }
       return manager;
    }


   public FacturaDTO getFactura(FacturaDTO f){
       FacturaDTO factura = dao.getFactura(f);
       return factura;
   }

   public List<FacturaDTO> getFacturas(){
       List<FacturaDTO> facturas = null;
       facturas = dao.getFacturas();
       return facturas;
	}

   public boolean existFactura(FacturaDTO f){
       boolean result=dao.existFactura(f);
       return result;
   }

}
