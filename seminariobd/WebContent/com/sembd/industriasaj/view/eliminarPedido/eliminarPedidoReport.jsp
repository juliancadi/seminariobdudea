<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.sembd.industriasaj.business.pedido.PedidoDTO"%>
<%@page import="com.sembd.industriasaj.business.pedido.PedidoManager"%>
<%@page import="java.util.List"%>
<%
String codigo = (String)request.getParameter("cod");
PedidoManager pm = PedidoManager.getPedidoManager();
PedidoDTO pedido = new PedidoDTO();
PedidoDTO pedidoConsultado = null;
if(codigo!=null){
	pedido.setCodigo(codigo);
	pedidoConsultado = pm.getPedido(pedido);
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
<script src="../javascript/cargarPadre.js" type="text/javascript"></script>

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
    <%if(pedidoConsultado!=null){ %>
<table width="500" border="0">
  <tr>
    <td width="128"><div align="right" style="font-weight: bold;">Codigo:</div></td>
    <td width="199"><%=pedidoConsultado.getCodigo() %></td>
  </tr>
  <tr>
    <td><div align="right" style="font-weight: bold;">Fecha de Pedido:</div></td>
    <td><%=pedidoConsultado.getFechaPedido() %></td>
  </tr>
  <tr>
    <td><div align="right" style="font-weight: bold;">Fecha de entrega:</div></td>
    <td><%=pedidoConsultado.getFechaEntrega() %></td>
  </tr>
  <tr>
    <td><div align="right" style="font-weight: bold;">Cantidad:</div></td>
    <td> 
    <%=pedidoConsultado.getCantidad() %>
     </td>
  </tr>
  <tr>
    <td><div align="right" style="font-weight: bold;">Producto:</div></td>
    <td><%=pedidoConsultado.getTbProducto().getReferencia() %></td>
  </tr>
  <tr>
    <td><div align="right" style="font-weight: bold;">Estado:</div></td>
    <td><%=pedidoConsultado.getEstado()%></td>
  </tr>

</table>
  
    <div align="center" style="color: red;"> &nbsp;
    <input type="button" value="Eliminar Pedido" onclick="javascript:CargaPadre('com/sembd/industriasaj/view/eliminarPedido/eliminarPedido.jsp?codPed=<%=pedidoConsultado.getCodigo() %>','mainContent');" ></input>
    </div>

        <%} %>
    </form>
<!-- end #container --></div>
<script type="text/javascript">
<!--
<div id="informacion"></div>
<p>&nbsp;</p>
<!-- end mainContent -->
</div>
var spryselect1 = new Spry.Widget.ValidationSelect("spryselect1");
//-->
</script>
</body>
</html>


