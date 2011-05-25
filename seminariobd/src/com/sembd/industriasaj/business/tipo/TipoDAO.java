package com.sembd.industriasaj.business.tipo;

import java.util.List;

import com.sembd.industriasaj.business.producto.ProductoManager;
import com.sembd.industriasaj.business.tipo.TipoDTO;
import com.sembd.industriasaj.services.connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TipoDAO {
	
	private static TipoDAO dao;

    private TipoDAO(){}

    public static TipoDAO getTipoDAO(){
        if(dao == null){
            dao = new TipoDAO();
        }
        return dao;
    }

    public TipoDTO getTipo(TipoDTO t){
        TipoDTO result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(TipoDAOHelper.getTipo());

            p.setString(1, t.getCodigo());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                TipoDTO tip = new TipoDTO();
                tip.setCodigo(rs.getString(1));
                tip.setMultiplo(rs.getInt(2));
                ProductoManager pm = ProductoManager.getProductoManager();
                tip.setTbProductos(pm.getProductosPorTipo(t));
                result = tip;
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

    public List<TipoDTO> getTipos(){
            List<TipoDTO> result = null;
            Connection con = null;
            try{
                con = DBConnection.getConnection();
                PreparedStatement p = con.prepareStatement(TipoDAOHelper.getTipos());
                ResultSet rs = p.executeQuery();
                result = new ArrayList<TipoDTO>();
                while(rs.next()){
                	TipoDTO tip = new TipoDTO();
                    tip.setCodigo(rs.getString(1));
                    tip.setMultiplo(rs.getInt(2));
                    ProductoManager pm = ProductoManager.getProductoManager();
                    tip.setTbProductos(pm.getProductosPorTipo(tip));
                    result.add(tip);
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

    public boolean existTipo(TipoDTO t){
        boolean result=false;
        Connection con=null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(TipoDAOHelper.getTipo());
            p.setString(1, t.getCodigo());
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
