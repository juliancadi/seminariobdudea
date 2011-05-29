package com.sembd.industriasaj.business.pedido;

import java.util.Calendar;
import java.util.List;

import com.sembd.industriasaj.business.entrega.EntregaManager;
import com.sembd.industriasaj.business.factura.FacturaDTO;
import com.sembd.industriasaj.business.factura.FacturaManager;
import com.sembd.industriasaj.business.producto.ProductoDTO;
import com.sembd.industriasaj.services.connection.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PedidoDAO {
	
	private static PedidoDAO dao;

    private PedidoDAO(){}

    public static PedidoDAO getPedidoDAO(){
        if(dao == null){
            dao = new PedidoDAO();
        }
        return dao;
    }

    public PedidoDTO getPedido(PedidoDTO pd){
        PedidoDTO result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(PedidoDAOHelper.getPedido());

            p.setString(1, pd.getCodigo());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
            	PedidoDTO ped = new PedidoDTO();
            	ped.setCodigo(rs.getString(1));
            	ped.setFechaPedido(new Date(rs.getDate(2).getTime()));
            	ped.setFechaEntrega(new Date(rs.getDate(3).getTime()));
            	ped.setCantidad(rs.getInt(4));
                ProductoDTO pro = new ProductoDTO();
                pro.setReferencia(rs.getString(5));
                pro.setIdentificador(rs.getString(6));
                pro.setTbTipo(null);
                pro.setDescripcion(rs.getString(7));
                pro.setCantStock(rs.getInt(8));
                pro.setPrecioUnitario(rs.getInt(9));
                pro.setValorMin(rs.getInt(10));
                pro.setValorOptimo(rs.getInt(11));
                ped.setTbProducto(pro);
                ped.setEstado(rs.getString(12));
                EntregaManager em = EntregaManager.getEntregaManager();
                ped.setTbEntregas(em.getEntregasPorPedido(pd));
                result = ped;
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
    
    public boolean insertPedido(PedidoDTO pd){
        boolean result = false;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(PedidoDAOHelper.insertPedido());
                        p.setString(1, pd.getCodigo());
            p.setDate(2, pd.getFechaPedido());
            p.setDate(3,pd.getFechaEntrega());
            p.setInt(4, pd.getCantidad());
            p.setString(5, pd.getTbProducto().getReferencia());
            p.setString(6, pd.getEstado());
            
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
    
    public boolean updatePedido(PedidoDTO pd){
        boolean result = false;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(PedidoDAOHelper.updatePedido());
            p.setInt(1, pd.getCantidad());
            p.setString(2, pd.getEstado());
            p.setString(3, pd.getCodigo());
            
            
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
    
    
    public boolean borrarPedido(PedidoDTO pd){
     
        Connection con = null;
        boolean result = false;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(PedidoDAOHelper.borrarPedido());

            p.setString(1, pd.getCodigo());
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

    public List<PedidoDTO> getPedidos(){
            List<PedidoDTO> result = null;
            Connection con = null;
            try{
                con = DBConnection.getConnection();
                PreparedStatement p = con.prepareStatement(PedidoDAOHelper.getPedidos());
                ResultSet rs = p.executeQuery();
                result = new ArrayList<PedidoDTO>();
                while(rs.next()){
                	PedidoDTO ped = new PedidoDTO();
                	ped.setCodigo(rs.getString(1));
                	ped.setFechaPedido(new Date(rs.getDate(2).getTime()));
                	ped.setFechaEntrega(new Date(rs.getDate(3).getTime()));
                	ped.setCantidad(rs.getInt(4));
                    ProductoDTO pro = new ProductoDTO();
                    pro.setReferencia(rs.getString(5));
                    pro.setIdentificador(rs.getString(6));
                    pro.setTbTipo(null);
                    pro.setDescripcion(rs.getString(7));
                    pro.setCantStock(rs.getInt(8));
                    pro.setPrecioUnitario(rs.getInt(9));
                    pro.setValorMin(rs.getInt(10));
                    pro.setValorOptimo(rs.getInt(11));
                    ped.setTbProducto(pro);
                    /*FacturaDTO fac = new FacturaDTO();
                    fac.setCodigo(rs.getString(12));
                    fac.setFecha(rs.getDate(13));
                    fac.setBase(rs.getInt(14));
                    fac.setIva(rs.getInt(15));
                    fac.setTotal(rs.getInt(16));
                    fac.setTbPedido(null);*/
                    ped.setTbFactura(null);
                    ped.setEstado(rs.getString(12));
                    EntregaManager em = EntregaManager.getEntregaManager();
                    ped.setTbEntregas(em.getEntregasPorPedido(ped));
                    result.add(ped);
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
    
    public List<PedidoDTO> getPedidosAEliminar(){
        List<PedidoDTO> result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(PedidoDAOHelper.getPedidosAEliminar());
            ResultSet rs = p.executeQuery();
            result = new ArrayList<PedidoDTO>();
            while(rs.next()){
            	PedidoDTO ped = new PedidoDTO();
            	ped.setCodigo(rs.getString(1));
            	ped.setFechaPedido(new Date(rs.getDate(2).getTime()));
            	ped.setFechaEntrega(new Date(rs.getDate(3).getTime()));
            	ped.setCantidad(rs.getInt(4));
                ProductoDTO pro = new ProductoDTO();
                pro.setReferencia(rs.getString(5));
                pro.setIdentificador(rs.getString(6));
                pro.setTbTipo(null);
                pro.setDescripcion(rs.getString(7));
                pro.setCantStock(rs.getInt(8));
                pro.setPrecioUnitario(rs.getInt(9));
                pro.setValorMin(rs.getInt(10));
                pro.setValorOptimo(rs.getInt(11));
                ped.setTbProducto(pro);
                ped.setEstado(rs.getString(12));
                EntregaManager em = EntregaManager.getEntregaManager();
                ped.setTbEntregas(em.getEntregasPorPedido(ped));
                result.add(ped);
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
    
    public List<PedidoDTO> getPedidosAFacturar(){
        List<PedidoDTO> result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(PedidoDAOHelper.getPedidosAFacturar());
            ResultSet rs = p.executeQuery();
            result = new ArrayList<PedidoDTO>();
            while(rs.next()){
            	PedidoDTO ped = new PedidoDTO();
            	ped.setCodigo(rs.getString(1));
            	ped.setFechaPedido(new Date(rs.getDate(2).getTime()));
            	ped.setFechaEntrega(new Date(rs.getDate(3).getTime()));
            	ped.setCantidad(rs.getInt(4));
                ProductoDTO pro = new ProductoDTO();
                pro.setReferencia(rs.getString(5));
                pro.setIdentificador(rs.getString(6));
                pro.setTbTipo(null);
                pro.setDescripcion(rs.getString(7));
                pro.setCantStock(rs.getInt(8));
                pro.setPrecioUnitario(rs.getInt(9));
                pro.setValorMin(rs.getInt(10));
                pro.setValorOptimo(rs.getInt(11));
                ped.setTbProducto(pro);
                ped.setEstado(rs.getString(12));
                EntregaManager em = EntregaManager.getEntregaManager();
                ped.setTbEntregas(em.getEntregasPorPedido(ped));
                FacturaManager fm = FacturaManager.getFacturaManager();
                FacturaDTO fac = fm.getFacturaPorPedido(ped);
                if(fac==null){
                	result.add(ped);	
                }
                
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
    
    public List<PedidoDTO> getPedidosAModificar(){
        List<PedidoDTO> result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(PedidoDAOHelper.getPedidosAModificar());
            ResultSet rs = p.executeQuery();
            result = new ArrayList<PedidoDTO>();
            while(rs.next()){
            	PedidoDTO ped = new PedidoDTO();
            	ped.setCodigo(rs.getString(1));
            	ped.setFechaPedido(new Date(rs.getDate(2).getTime()));
            	ped.setFechaEntrega(new Date(rs.getDate(3).getTime()));
            	ped.setCantidad(rs.getInt(4));
                ProductoDTO pro = new ProductoDTO();
                pro.setReferencia(rs.getString(5));
                pro.setIdentificador(rs.getString(6));
                pro.setTbTipo(null);
                pro.setDescripcion(rs.getString(7));
                pro.setCantStock(rs.getInt(8));
                pro.setPrecioUnitario(rs.getInt(9));
                pro.setValorMin(rs.getInt(10));
                pro.setValorOptimo(rs.getInt(11));
                ped.setTbProducto(pro);
                ped.setEstado(rs.getString(12));
                EntregaManager em = EntregaManager.getEntregaManager();
                ped.setTbEntregas(em.getEntregasPorPedido(ped));
                result.add(ped);
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
    
    public List<PedidoDTO> getPedidosPorProducto(ProductoDTO pr){
        List<PedidoDTO> result = null;
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(PedidoDAOHelper.getPedidosPorProducto());
            
            p.setString(1, pr.getReferencia());
            ResultSet rs = p.executeQuery();
            result = new ArrayList<PedidoDTO>();
            while(rs.next()){
            	PedidoDTO ped = new PedidoDTO();
            	ped.setCodigo(rs.getString(1));
            	ped.setFechaPedido(new Date(rs.getDate(2).getTime()));
            	ped.setFechaEntrega(new Date(rs.getDate(3).getTime()));
            	ped.setCantidad(rs.getInt(4));
                ProductoDTO pro = new ProductoDTO();
                pro.setReferencia(rs.getString(5));
                pro.setIdentificador(rs.getString(6));
                pro.setTbTipo(null);
                pro.setDescripcion(rs.getString(7));
                pro.setCantStock(rs.getInt(8));
                pro.setPrecioUnitario(rs.getInt(9));
                pro.setValorMin(rs.getInt(10));
                pro.setValorOptimo(rs.getInt(11));
                ped.setTbProducto(pro);
                /*FacturaDTO fac = new FacturaDTO();
                fac.setCodigo(rs.getString(12));
                fac.setFecha(rs.getDate(13));
                fac.setBase(rs.getInt(14));
                fac.setIva(rs.getInt(15));
                fac.setTotal(rs.getInt(16));
                fac.setTbPedido(null);*/
                ped.setTbFactura(null);
                ped.setEstado(rs.getString(12));
                EntregaManager em = EntregaManager.getEntregaManager();
                ped.setTbEntregas(em.getEntregasPorPedido(ped));
                result.add(ped);
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

    public boolean existPedido(PedidoDTO pd){
        boolean result=false;
        Connection con=null;
        try{
            con = DBConnection.getConnection();
            PreparedStatement p = con.prepareStatement(PedidoDAOHelper.getPedido());
            p.setString(1, pd.getCodigo());
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
