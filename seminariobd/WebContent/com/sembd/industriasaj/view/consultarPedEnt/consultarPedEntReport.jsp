<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.sembd.industriasaj.business.producto.ProductoDTO"%>
<%@page import="com.sembd.industriasaj.business.producto.ProductoManager"%>
<%@page import="com.sembd.industriasaj.business.pedido.PedidoDTO"%>
<%@page import="com.sembd.industriasaj.business.pedido.PedidoManager"%>
<%@page import="com.sembd.industriasaj.business.entrega.EntregaDTO"%>
<%@page import="com.sembd.industriasaj.business.entrega.EntregaManager"%>
<%@page import="java.util.List"%>
<%
String referencia = (String)request.getParameter("ref");

ProductoManager prm = ProductoManager.getProductoManager();
EntregaManager em = EntregaManager.getEntregaManager();

ProductoDTO producto = new ProductoDTO();
ProductoDTO productoConsultado = null;

if(referencia!=null){
	producto.setReferencia(referencia);
	productoConsultado = prm.getProducto(producto);
	for(int i=0;i<productoConsultado.getTbPedidos().size();i++){
		List<EntregaDTO> entregas = em.getEntregasPorPedido(productoConsultado.getTbPedidos().get(i));
		productoConsultado.getTbPedidos().get(i).setTbEntregas(entregas);
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
<table width="835" border="1">
    <%if(productoConsultado==null || productoConsultado.getTbPedidos().size()==0){ %>
    <tr>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
    <td bgcolor="#999999" style="border:none"><div align="center">ESTE PRODUCTO NO TIENE PEDIDOS</div></td>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
  </tr>
    <%}else{ 
    
    for(int i=0;i<productoConsultado.getTbPedidos().size();i++){ 
	PedidoDTO pedidoActual = productoConsultado.getTbPedidos().get(i);
	%>
  <tr>
    <td width="69" bgcolor="#000000" ><div align="center" style="color: #FFFFFF; font-weight: bold;">Codigo</div></td>
    <td width="244" bgcolor="#000000"><div align="center" style="color: #FFFFFF; font-weight: bold;">Fecha Pedido</div></td>
    <td width="195" bgcolor="#000000"><div align="center" style="color: #FFFFFF; font-weight: bold;">Fecha Entrega</div></td>
    <td width="151" bgcolor="#000000"><div align="center" style="color: #FFFFFF; font-weight: bold;">Cantidad</div></td>
    <td width="142" bgcolor="#000000"><div align="center" style="color: #FFFFFF; font-weight: bold;">Estado</div></td>
  </tr>
  <tr>
    <td align="center"><%= pedidoActual.getCodigo() %></td>
    <td align="center"><%= pedidoActual.getFechaPedido() %></td>
    <td align="center"><%= pedidoActual.getFechaEntrega() %></td>
    <td align="center"><%= pedidoActual.getCantidad() %></td>
    <td align="center"><%= pedidoActual.getEstado() %></td>
  </tr>
  <%if(pedidoActual.getTbEntregas()==null || pedidoActual.getTbEntregas().size()==0){ %>
    <tr>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
    <td bgcolor="#999999" style="border:none"><div align="center">ESTE PEDIDO NO TIENE ENTREGAS</div></td>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
  </tr>
    <%}else{ 
     for(int j=0;j<pedidoActual.getTbEntregas().size();j++){ 
  		EntregaDTO entregaActual = pedidoActual.getTbEntregas().get(j);
  %>
  <tr>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
    <td bgcolor="#999999" style="border:none"><div align="center">Entregas</div></td>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
  </tr>
  <tr>
    <td bgcolor="#CCCCCC"><div align="center"><strong>Codigo</strong></div></td>
    <td bgcolor="#CCCCCC"><div align="center"><strong>Fecha</strong></div></td>
    <td bgcolor="#CCCCCC"><div align="center"><strong>Cantidad</strong></div></td>
    <td bgcolor="#CCCCCC" style="border:none">&nbsp;</td>
    <td bgcolor="#CCCCCC" style="border:none">&nbsp;</td>
  </tr>
  <tr>
    <td align="center"><%= entregaActual.getCodigo() %></td>
    <td align="center"><%= entregaActual.getFecha() %></td>
    <td align="center"><%= entregaActual.getCantidad() %></td>
    <td style="border:none">&nbsp;</td>
    <td style="border:none">&nbsp;</td>
  </tr>
  			<%}//FOR entregas %>
  		<%}//IF entregas %>
  	<%}//FOR pedidos %>
  <%}//IF pedidos %>
</table>

    </form>
<!-- end #container --></div>
<script type="text/javascript">
<!--
var spryselect1 = new Spry.Widget.ValidationSelect("spryselect1");
//-->
</script>
</body>
</html>
