<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.sembd.industriasaj.business.producto.ProductoDTO"%>
<%@page import="com.sembd.industriasaj.business.producto.ProductoManager"%>
<%@page import="com.sembd.industriasaj.business.pedido.PedidoDTO"%>
<%@page import="com.sembd.industriasaj.business.pedido.PedidoManager"%>
<%@page import="com.sembd.industriasaj.business.entrega.EntregaDTO"%>
<%@page import="com.sembd.industriasaj.business.entrega.EntregaManager"%>
<%@page import="com.sembd.industriasaj.business.factura.FacturaDTO"%>
<%@page import="com.sembd.industriasaj.business.factura.FacturaManager"%>
<%@page import="java.util.List"%>
<%
String codigo = (String)request.getParameter("cod");

PedidoManager pm = PedidoManager.getPedidoManager();
FacturaManager fm = FacturaManager.getFacturaManager();
EntregaManager em = EntregaManager.getEntregaManager();

FacturaDTO factura = new FacturaDTO();
FacturaDTO facturaConsultada = null;

if(codigo!=null){
	factura.setCodigo(codigo);
	facturaConsultada = fm.getFactura(factura);
	facturaConsultada.getTbPedido().setTbEntregas(em.getEntregasPorPedido(facturaConsultada.getTbPedido()));
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
    <%if(facturaConsultada!=null){ %>
  <tr>
    <td width="69" bgcolor="#000000" ><div align="center" style="color: #FFFFFF; font-weight: bold;">Codigo</div></td>
    <td width="244" bgcolor="#000000"><div align="center" style="color: #FFFFFF; font-weight: bold;">Fecha</div></td>
    <td width="195" bgcolor="#000000"><div align="center" style="color: #FFFFFF; font-weight: bold;">Base</div></td>
    <td width="151" bgcolor="#000000"><div align="center" style="color: #FFFFFF; font-weight: bold;">IVA</div></td>
    <td width="142" bgcolor="#000000"><div align="center" style="color: #FFFFFF; font-weight: bold;">Total</div></td>
    <td width="142" bgcolor="#000000"><div align="center" style="color: #FFFFFF; font-weight: bold;">Pedido</div></td>
  </tr>
  <tr>
    <td align="center"><%= facturaConsultada.getCodigo() %></td>
    <td align="center"><%= facturaConsultada.getFecha() %></td>
    <td align="center"><%= facturaConsultada.getBase() %></td>
    <td align="center"><%= facturaConsultada.getIva() %></td>
    <td align="center"><%= facturaConsultada.getTotal() %></td>
    <td align="center"><%= facturaConsultada.getTbPedido().getCodigo() %></td>
  </tr>
  <%if(facturaConsultada.getTbPedido().getTbEntregas()==null || facturaConsultada.getTbPedido().getTbEntregas().size()==0){ %>
    <tr>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
    <td bgcolor="#999999" style="border:none"><div align="center">ESTA FACTURA NO TIENE ENTREGAS</div></td>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
  </tr>
    <%}else{ 
     for(int j=0;j<facturaConsultada.getTbPedido().getTbEntregas().size();j++){ 
  		EntregaDTO entregaActual = facturaConsultada.getTbPedido().getTbEntregas().get(j);
  %>
  <tr>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
    <td bgcolor="#999999" style="border:none"><div align="center">Entregas</div></td>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
  </tr>
  <tr>
    <td bgcolor="#CCCCCC"><div align="center"><strong>Codigo</strong></div></td>
    <td bgcolor="#CCCCCC"><div align="center"><strong>Fecha</strong></div></td>
    <td bgcolor="#CCCCCC"><div align="center"><strong>Cantidad</strong></div></td>
    <td bgcolor="#CCCCCC" style="border:none">&nbsp;</td>
    <td bgcolor="#CCCCCC" style="border:none">&nbsp;</td>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
  </tr>
  <tr>
    <td align="center"><%= entregaActual.getCodigo() %></td>
    <td align="center"><%= entregaActual.getFecha() %></td>
    <td align="center"><%= entregaActual.getCantidad() %></td>
    <td style="border:none">&nbsp;</td>
    <td style="border:none">&nbsp;</td>
    <td bgcolor="#999999" style="border:none">&nbsp;</td>
  </tr>
  			<%}//FOR entregas %>
  		<%}//IF entregas %>
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
