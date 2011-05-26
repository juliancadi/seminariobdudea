<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.sembd.industriasaj.business.producto.ProductoDTO"%>
<%@page import="com.sembd.industriasaj.business.producto.ProductoManager"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
String referencia = (String)request.getParameter("ref");
ProductoManager pm = ProductoManager.getProductoManager();
List<ProductoDTO> productosConsultados = null;

if(referencia!=null){
	if(referencia.equals("0")){
		productosConsultados = pm.getProductosDebajoDelMin();
	}
	else{
		ProductoDTO producto = new ProductoDTO();
		producto.setReferencia(referencia);
		productosConsultados = new ArrayList<ProductoDTO>();
		productosConsultados.add(pm.getProducto(producto));
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
<script src="../javascript/cargarContenido.js" type="text/javascript"></script>
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
    <h1 align="center">Listar Productos con Cantidad Insuficiente</h1>
    <form id="form1" name="form1" method="post" action="">
<% if(productosConsultados!=null){%>

<table width="835" border="1">
  <tr>
    <td width="137"><div align="center"><strong>Referencia</strong></div></td>
    <td width="146"><div align="center"><strong>Descripción</strong></div></td>
    <td width="223"><div align="center"><strong>Precio Unitario</strong></div></td>
    <td width="89"><div align="center"><strong>Cantidad en Stock</strong></div></td>
    <td width="11"><div align="center"><strong>Cantidad Pedida</strong></div></td>
    <td width="11"><div align="center"><strong>Cantidad Total</strong></div></td>
    <td width="11"><div align="center"><strong>Cantidad Mínima</strong></div></td>
    <td width="155"><div align="center"><strong>Cantidad Óptima</strong></div></td>
    <td width="155"><div align="center"><strong>Cantidad Recomendada</strong></div></td>
    <td width="155"><div align="center"><strong>Pedido</strong></div></td>
  </tr>
  <%for(int i=0; i<productosConsultados.size();i++){
	  ProductoDTO productoTabla = productosConsultados.get(i);
  %>
  <tr>
    <td><div align="center"><%=productoTabla.getReferencia() %></div></td>
    <td><div align="center"><%=productoTabla.getDescripcion() %></div></td>
    <td><div align="center"><%=productoTabla.getPrecioUnitario() %></div></td>
    <td><div align="center"><%=productoTabla.getCantStock() %></div></td>
    <td><div align="center"><%=pm.getCantidadPedida(productoTabla) %></div></td>
    <td><div align="center" style="color: red;"><%=(productoTabla.getCantStock() + pm.getCantidadPedida(productoTabla))%></div></td>
    <td><div align="center" style="color: blue;"><%=productoTabla.getValorMin()%></div></td>
    <td><div align="center"><%=productoTabla.getValorOptimo()%></div></td>
    <td><div align="center" style="color: green;">CALCULO</div></td>
    <td><div align="center"><input type="text" value="CALCULO" id="cell_<%=productoTabla.getReferencia() %>" name="cell_<%=productoTabla.getReferencia() %>"></input></div></td>
  </tr>
  <%} %>
  
  <tr>
    <td style="border: none;">&nbsp;</td>
    <td style="border: none;">&nbsp;</td>
    <td style="border: none;">&nbsp;</td>
    <td style="border: none;">&nbsp;</td>
    <td style="border: none;">&nbsp;</td>
    <td style="border: none;">&nbsp;</td>
    <td style="border: none;">&nbsp;</td>
    <td style="border: none;">&nbsp;</td>
    <td style="border: none;">&nbsp;</td>
    <td style="border: none;"><div align="center"><input type="button" value="Realizar Pedido"  onclick="javascript:CargaPadre('com/sembd/industriasaj/view/listarProductos/listarProductos.jsp','mainContent');"/></div></td>
  </tr>
  
</table>

<%
}
%>
        
    </form>
    <p>&nbsp;</p>
    <div id="informacion"> </div>
  <!-- end #mainContent --></div>
<!-- end #container --></div>
<script type="text/javascript">
<!--
var spryselect1 = new Spry.Widget.ValidationSelect("spryselect1");
//-->
</script>
</body>
</html>