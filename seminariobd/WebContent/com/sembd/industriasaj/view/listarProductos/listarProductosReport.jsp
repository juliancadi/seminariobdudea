<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.sembd.industriasaj.business.producto.ProductoDTO"%>
<%@page import="com.sembd.industriasaj.business.producto.ProductoManager"%>
<%@page import="java.util.List"%>


<%
String referencia = (String)request.getParameter("ref");
ProductoManager pm = ProductoManager.getProductoManager();
ProductoDTO productoConsultado = null;

if(referencia!=null){
	ProductoDTO producto = new ProductoDTO();
	producto.setReferencia(referencia);
	productoConsultado = pm.getProducto(producto);
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
<script src="javascript/SpryAssets/SpryValidationSelect.js" type="text/javascript"></script>
<link href="javascript/SpryAssets/SpryValidationSelect.css" rel="stylesheet" type="text/css" />


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
    <form id="form1" name="form1" method="post" action="">
    <%if(productoConsultado!=null){ %>
<table width="500" border="0">
  <tr>
    <td width="128"><div align="right" style="font-weight: bold;">Referencia:</div></td>
    <td width="199"><%=productoConsultado.getReferencia() %></td>
  </tr>
  <tr>
    <td><div align="right" style="font-weight: bold;">Descripcion:</div></td>
    <td><%=productoConsultado.getDescripcion() %></td>
  </tr>
  <tr>
    <td><div align="right" style="font-weight: bold;">Precio Unitario:</div></td>
    <td><%=productoConsultado.getPrecioUnitario() %></td>
  </tr>
  <tr>
    <td><div align="right" style="font-weight: bold;">Cantidad en Stock:</div></td>
    <td><%=productoConsultado.getCantStock() %></td>
  </tr>
  <tr>
    <td><div align="right" style="font-weight: bold;">Cantidad en transito:</div></td>
    <td><%=pm.getCantidadPedida(productoConsultado) %></td>
  </tr>
  <tr>
    <td><div align="right" style="font-weight: bold;">Cantidad Total:</div></td>
    <td> 
    <%if((productoConsultado.getCantStock()+pm.getCantidadPedida(productoConsultado))<productoConsultado.getValorMin()){ %>
       <span style="color: red;"> <%= (productoConsultado.getCantStock()+pm.getCantidadPedida(productoConsultado)) %> </span>
     <%}
    else{
    %>
     <%= (productoConsultado.getCantStock()+pm.getCantidadPedida(productoConsultado)) %> 
     <%} %>
     </td>
  </tr>
  <tr>
    <td><div align="right" style="font-weight: bold;">Valor Minimo:</div></td>
    <td><%=productoConsultado.getValorMin() %></td>
  </tr>
  <tr>
    <td><div align="right" style="font-weight: bold;">Valor Optimo:</div></td>
    <td><%=productoConsultado.getValorOptimo() %></td>
  </tr>

</table>
  <%if((productoConsultado.getCantStock()+pm.getCantidadPedida(productoConsultado))<productoConsultado.getValorMin()){ %>
    <div align="center" style="color: red;">La cantidad en stock esta por debajo del minimo.
    &nbsp;
    <input type="button" value="Realizar Pedido Individual" onclick="javascript:CargaPadre('com/sembd/industriasaj/view/listarProductos/listarProductosReport2.jsp?ref=<%=referencia%>','mainContent');"/>
    </div>
  <%} %>
        <%} %>
    </form>
<!-- end #container --></div>
<script type="text/javascript">
<!--
var spryselect1 = new Spry.Widget.ValidationSelect("spryselect1");

//-->
</script>
</body>
</html>


