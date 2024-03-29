<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.sembd.industriasaj.business.producto.ProductoDTO"%>
<%@page import="com.sembd.industriasaj.business.producto.ProductoManager"%>
<%@page import="com.sembd.industriasaj.business.pedido.PedidoManager"%>
<%@page import="com.sembd.industriasaj.business.pedido.PedidoDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%

ProductoManager pm = ProductoManager.getProductoManager();
List<ProductoDTO> productos = pm.getProductos();


String referencia = request.getParameter("producto");
String msgError = "No se pudo ingresar la entrega porque hay un problema con la base de datos.";
boolean insertados = false;

if(referencia!=null){
	
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
		insertados=true;
		for(int i = 0; i< productosConsultados.size();i++){
			producto = productosConsultados.get(i);
			int nuevaCantidad = Integer.parseInt(request.getParameter(productosConsultados.get(i).getIdentificador()+productosConsultados.get(i).getTbTipo().getCodigo()));
			PedidoDTO nuevoPedido = new PedidoDTO();
			nuevoPedido.setCodigo("0");
			int modulo = nuevaCantidad % productosConsultados.get(i).getTbTipo().getMultiplo();
			if (modulo != 0){
				  nuevaCantidad = nuevaCantidad - modulo + productosConsultados.get(i).getTbTipo().getMultiplo();
			}
			nuevoPedido.setCantidad(nuevaCantidad);
			nuevoPedido.setEstado("Pendiente");
			Calendar calendar = Calendar.getInstance();
			nuevoPedido.setFechaPedido(new Date(calendar.getTime().getTime()));
			calendar.add(Calendar.DAY_OF_MONTH, 3);
			nuevoPedido.setFechaEntrega(new Date(calendar.getTime().getTime()+3));
			nuevoPedido.setTbFactura(null);
			nuevoPedido.setTbEntregas(null);
			nuevoPedido.setTbProducto(producto);
			insertados = pem.insertPedido(nuevoPedido)&& insertados;
			
		}
	}
	catch(NumberFormatException err){
		
		msgError = "Los valores no pueden quedar en blanco o contener caracteres alfabeticos.";
	}
	
	
}

%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
<!--
body {
	font: 100% Verdana, Arial, Helvetica, sans-serif;
	background: #666666;
	margin: 0; /* it's good practice to zero the margin and padding of the body element to account for differing browser defaults */
	padding: 0;
	text-align: center; /* this centers the container in IE 5* browsers. The text is then set to the left aligned default in the #container selector */
	color: #000000;
}
.oneColLiqCtrHdr #container {
	width: 100%;  /* this will create a container 80% of the browser width */
	background: #FFFFFF;
	margin: 0 auto; /* the auto margins (in conjunction with a width) center the page */
	border: 1px solid #000000;
	text-align: left; /* this overrides the text-align: center on the body element. */
}
.oneColLiqCtrHdr #mainContent {
	padding: 0 20px; /* remember that padding is the space inside the div box and margin is the space outside the div box */
	background: #FFFFFF;
}
-->
</style>
<script src="css/SpryAssets/SpryValidationSelect.js" type="text/javascript"></script>
<link href="css/SpryAssets/SpryValidationSelect.css" rel="stylesheet" type="text/css" />

<style type="text/css">
<!--
.style1 {
	font-size: x-large
}
-->
</style>
</head>

<body class="oneColLiqCtrHdr">

<div id="container">
  <div id="mainContent">
    <h1 align="center">Listar Producto</h1>
    <form id="form1" name="form1" method="post" action="">
    <span id="spryselect1">
        <label><span style="font-weight: bold;">Producto:</span>
          <select name="lista_productos" id="lista_productos" onchange="javascript:Carga('com/sembd/industriasaj/view/listarProductos/listarProductosReport.jsp?ref='+this.value,'informacion');">
          <option value="0"> - </option>
          <% 
          if(productos.size()!=0){
          for(int i=0;i<productos.size();i++){
          		ProductoDTO p = productos.get(i);
          	%>
            <option value="<%=p.getReferencia()%>"><%=p.getReferencia()%></option>
          <% }
             }%>
        </select>
      </label>
        <span class="selectRequiredMsg">Por favor seleccione un producto.</span></span>
        &nbsp;
        <input type="button" value="Ver lista productos debajo del minimo" onclick="javascript:CargaPadre('com/sembd/industriasaj/view/listarProductos/listarProductosReport2.jsp?ref=0','mainContent');"/>
    </form>
    <p>&nbsp;</p>
    <div id="informacion"> 
    <%if(insertados){ %>
        	<span style="color: green;">Los pedidos han sido insertados exitosamente.</span>
        <%}else{ 
        	if(referencia!=null){%>
        	<span style="color: red;"><%= msgError %></span>
        <%	}
        } %>
    </div>
  <!-- end #mainContent --></div>
<!-- end #container --></div>
<script type="text/javascript">
<!--
var spryselect1 = new Spry.Widget.ValidationSelect("spryselect1");
//-->
</script>
</body>
</html>
