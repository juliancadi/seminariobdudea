package com.sembd.industriasaj.business.entrega;

import java.util.List;

import com.sembd.industriasaj.business.pedido.PedidoDAOHelper;
import com.sembd.industriasaj.business.pedido.PedidoDTO;
import com.sembd.industriasaj.services.connection.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EntregaDAO {
	
	private static EntregaDAO dao;

    private EntregaDAO(){}

    public static EntregaDAO getEntregaDAO(){
        if(dao == null){
            dao = new EntregaDAO();
        }
        return dao;
    }
    
    public boolean insertEntrega(EntregaDTO e){
        boolean result = false;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(EntregaDAOHelper.insertEntrega());
            p.setString(1, e.getCodigo());
            p.setString(2, e.getTbPedido().getCodigo());
            p.setDate(3,e.getFecha());
            p.setInt(4, e.getCantidad());
            
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

    public EntregaDTO getEntrega(EntregaDTO en){
        EntregaDTO result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(EntregaDAOHelper.getEntrega());

            p.setString(1, en.getCodigo());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                EntregaDTO ent = new EntregaDTO();
                ent.setCodigo(rs.getString(1));
                PedidoDTO ped = new PedidoDTO();
                ped.setCodigo(rs.getString(2));
                ped.setFechaPedido(new Date(rs.getDate(3).getTime()));
                ped.setFechaEntrega(new Date(rs.getDate(4).getTime()));
                ped.setCantidad(rs.getInt(5));
                ped.setTbProducto(null);
                ped.setTbEntregas(null);
                ped.setTbFactura(null);
                ped.setEstado(rs.getString(6));
                ent.setTbPedido(ped);
                ent.setFecha(rs.getDate(7));
                ent.setCantidad(rs.getInt(8));
                result = ent;
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

    public List<EntregaDTO> getEntregas(){
            List<EntregaDTO> result = null;
            Connection con = null;
            try{
                con = DBConnection.getConnection();
                PreparedStatement p = con.prepareStatement(EntregaDAOHelper.getEntregas());
                ResultSet rs = p.executeQuery();
                result = new ArrayList<EntregaDTO>();
                while(rs.next()){
                	EntregaDTO ent = new EntregaDTO();
                    ent.setCodigo(rs.getString(1));
                    PedidoDTO ped = new PedidoDTO();
                    ped.setCodigo(rs.getString(2));
                    ped.setFechaPedido(new Date(rs.getDate(3).getTime()));
                    ped.setFechaEntrega(new Date(rs.getDate(4).getTime()));
                    ped.setCantidad(rs.getInt(5));
                    ped.setTbProducto(null);
                    ped.setTbEntregas(null);
                    ped.setTbFactura(null);
                    ped.setEstado(rs.getString(6));
                    ent.setTbPedido(ped);
                    ent.setFecha(rs.getDate(7));
                    ent.setCantidad(rs.getInt(8));
                    result.add(ent);
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
    
    public List<EntregaDTO> getEntregasPorPedido(PedidoDTO pe){
        List<EntregaDTO> result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(EntregaDAOHelper.getEntregasPorPedido());
            
            p.setString(1, pe.getCodigo());
            ResultSet rs = p.executeQuery();
            result = new ArrayList<EntregaDTO>();
            while(rs.next()){
            	EntregaDTO ent = new EntregaDTO();
                ent.setCodigo(rs.getString(1));
                PedidoDTO ped = new PedidoDTO();
                ped.setCodigo(rs.getString(2));
                ped.setFechaPedido(new Date(rs.getDate(3).getTime()));
                ped.setFechaEntrega(new Date(rs.getDate(4).getTime()));
                ped.setCantidad(rs.getInt(5));
                ped.setTbProducto(null);
                ped.setTbEntregas(null);
                ped.setTbFactura(null);
                ped.setEstado(rs.getString(6));
                ent.setTbPedido(ped);
                ent.setFecha(rs.getDate(7));
                ent.setCantidad(rs.getInt(8));
                result.add(ent);
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

    public boolean existEntrega(EntregaDTO en){
        boolean result=false;
        Connection con=null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(EntregaDAOHelper.getEntrega());
            p.setString(1, en.getCodigo());
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
