package com.sembd.industriasaj.business.pedido;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import com.sembd.industriasaj.business.producto.ProductoDTO;;

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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List<ProductoDTO> productosConsultados = (List<ProductoDTO>) request.getAttribute("productosConsultados");
		//System.out.println(request.getAttribute(productosConsultados.get(1).getReferencia()));
		System.out.println(request.getAttribute("productosConsultados"));
	}

}
