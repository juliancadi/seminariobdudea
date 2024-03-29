package com.sembd.industriasaj.business.factura;

import java.util.List;
import com.sembd.industriasaj.business.pedido.PedidoDTO;
import com.sembd.industriasaj.services.connection.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FacturaDAO {
	
	private static FacturaDAO dao;

    private FacturaDAO(){}

    public static FacturaDAO getFacturaDAO(){
        if(dao == null){
            dao = new FacturaDAO();
        }
        return dao;
    }

    public FacturaDTO getFactura(FacturaDTO f){
        FacturaDTO result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(FacturaDAOHelper.getFactura());

            p.setString(1, f.getCodigo());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                FacturaDTO fac = new FacturaDTO();
                fac.setCodigo(rs.getString(1));
                fac.setFecha(new Date(rs.getDate(2).getTime()));
                fac.setBase(rs.getInt(3));
                fac.setIva(rs.getInt(4));
                fac.setTotal(rs.getInt(5));
                PedidoDTO ped = new PedidoDTO();
                ped.setCodigo(rs.getString(6));
                ped.setFechaPedido(new Date(rs.getDate(7).getTime()));
                ped.setFechaEntrega(new Date(rs.getDate(8).getTime()));
                ped.setCantidad(rs.getInt(9));
                ped.setTbProducto(null);
                ped.setTbEntregas(null);
                ped.setTbFactura(null);
                ped.setEstado(rs.getString(6));
                fac.setTbPedido(ped);
                result = fac;
            }
        }
        catch(Exception ex){
                ex.printStackTrace();
        }
        finally{
            try{
            	DBConnection.returnConnection(con);
            }
            catch(Exception clo){}
        }
        return result;
    }
    
    public FacturaDTO getFacturaPorPedido(PedidoDTO pe){
        FacturaDTO result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(FacturaDAOHelper.getFacturaPorPedido());

            p.setString(1, pe.getCodigo());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                FacturaDTO fac = new FacturaDTO();
                fac.setCodigo(rs.getString(1));
                fac.setFecha(new Date(rs.getDate(2).getTime()));
                fac.setBase(rs.getInt(3));
                fac.setIva(rs.getInt(4));
                fac.setTotal(rs.getInt(5));
                PedidoDTO ped = new PedidoDTO();
                ped.setCodigo(rs.getString(6));
                ped.setFechaPedido(new Date(rs.getDate(7).getTime()));
                ped.setFechaEntrega(new Date(rs.getDate(8).getTime()));
                ped.setCantidad(rs.getInt(9));
                ped.setTbProducto(null);
                ped.setTbEntregas(null);
                ped.setTbFactura(null);
                ped.setEstado(rs.getString(6));
                fac.setTbPedido(ped);
                result = fac;
            }
        }
        catch(Exception ex){
                ex.printStackTrace();
        }
        finally{
            try{
            	DBConnection.returnConnection(con);
            }
            catch(Exception clo){}
        }
        return result;
    }
    
    public boolean insertFactura(FacturaDTO f){
        boolean result = false;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(FacturaDAOHelper.insertFactura());
            p.setString(1, f.getCodigo());
            p.setDate(2, f.getFecha());
            p.setInt(3,f.getBase());
            p.setInt(4, f.getIva());
            p.setInt(5, f.getTotal());
            p.setString(6, f.getTbPedido().getCodigo());
            
            p.execute();
            result = true;
        }
        catch(Exception ex){
                ex.printStackTrace();
        }
        finally{
            try{
            	DBConnection.returnConnection(con);
            }
            catch(Exception clo){}
        }
        return result;
    }

    public List<FacturaDTO> getFacturas(){
            List<FacturaDTO> result = null;
            Connection con = null;
            try{
                con = DBConnection.getConnection();
                PreparedStatement p = con.prepareStatement(FacturaDAOHelper.getFacturas());
                ResultSet rs = p.executeQuery();
                result = new ArrayList<FacturaDTO>();
                while(rs.next()){
                	FacturaDTO fac = new FacturaDTO();
                    fac.setCodigo(rs.getString(1));
                    fac.setFecha(new Date(rs.getDate(2).getTime()));
                    fac.setBase(rs.getInt(3));
                    fac.setIva(rs.getInt(4));
                    fac.setTotal(rs.getInt(5));
                    PedidoDTO ped = new PedidoDTO();
                    ped.setCodigo(rs.getString(6));
                    ped.setFechaPedido(new Date(rs.getDate(7).getTime()));
                    ped.setFechaEntrega(new Date(rs.getDate(8).getTime()));
                    ped.setCantidad(rs.getInt(9));
                    ped.setTbProducto(null);
                    ped.setTbEntregas(null);
                    ped.setTbFactura(null);
                    ped.setEstado(rs.getString(6));
                    fac.setTbPedido(ped);
                    result.add(fac);
                }
            }
            catch(Exception ex){
                    ex.printStackTrace();
            }
            finally{
                try{
                	DBConnection.returnConnection(con);
                }
                catch(Exception clo){}
            }
            return result;
	}

    public boolean existFactura(FacturaDTO f){
        boolean result=false;
        Connection con=null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(FacturaDAOHelper.getFactura());
            p.setString(1, f.getCodigo());
            ResultSet rs = p.executeQuery();
            if(rs.next()){
                result=true;
            }
        }
        catch(Exception ex){
                ex.printStackTrace();
        }
        finally{
            try{
            	DBConnection.returnConnection(con);
            }
            catch(Exception clo){}
        }
        return result;
    }

}
