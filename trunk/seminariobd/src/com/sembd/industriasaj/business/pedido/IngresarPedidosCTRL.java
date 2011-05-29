package com.sembd.industriasaj.business.pedido;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.sembd.industriasaj.business.producto.ProductoDTO;
import com.sembd.industriasaj.business.producto.ProductoManager;

/**
 * Servlet implementation class IngresarPedidosCTRL
 */
@WebServlet("/IngresarPedidosCTRL")
public class IngresarPedidosCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresarPedidosCTRL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String referencia = request.getParameter("producto");
		
		
		
		if(referencia!=null){
			ProductoManager pm = ProductoManager.getProductoManager();
			List<ProductoDTO> productosConsultados = null;
			ProductoDTO producto = new ProductoDTO();
			PedidoManager pem = PedidoManager.getPedidoManager();
			if(referencia.equals("0")){
				productosConsultados = pm.getProductosDebajoDelMin();
			}
			else{
				producto.setReferencia(referencia);
				productosConsultados = new ArrayList<ProductoDTO>();
				productosConsultados.add(pm.getProducto(producto));
			}
			
			try{
				for(int i = 0; i< productosConsultados.size();i++){
					int nuevaCantidad = Integer.parseInt(request.getParameter(productosConsultados.get(i).getIdentificador()+productosConsultados.get(i).getTbTipo().getCodigo()));
				}
			}
			catch(NumberFormatException err){
				String someMessage = "Error !";
				PrintWriter out = response.getWriter();
				out.print("<html><head>");
				out.print("<script type=\"text/javascript\">window.open('" + someMessage + "');</script>");
				out.print("</head><body></body></html>");
				return;
			}
			
			for(int i = 0; i< productosConsultados.size();i++){
				producto = productosConsultados.get(i);
				int nuevaCantidad = Integer.parseInt(request.getParameter(productosConsultados.get(i).getIdentificador()+productosConsultados.get(i).getTbTipo().getCodigo()));
				PedidoDTO nuevoPedido = new PedidoDTO();
				nuevoPedido.setCodigo("0");
				nuevoPedido.setCantidad(nuevaCantidad);
				nuevoPedido.setEstado("Pendiente");
				Calendar calendar = Calendar.getInstance();
				nuevoPedido.setFechaPedido(new Date(calendar.getTime().getTime()));
				calendar.add(Calendar.DAY_OF_MONTH, 3);
				nuevoPedido.setFechaEntrega(new Date(calendar.getTime().getTime()+3));
				nuevoPedido.setTbFactura(null);
				nuevoPedido.setTbEntregas(null);
				nuevoPedido.setTbProducto(producto);
				pem.insertPedido(nuevoPedido);
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}
	
	

}
