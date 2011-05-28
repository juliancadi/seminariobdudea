<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.sembd.industriasaj.business.pedido.PedidoDTO"%>
<%@page import="com.sembd.industriasaj.business.pedido.PedidoManager"%>
<%@page import="java.util.List"%>


<%

String codigo = (String)request.getParameter("codPed");

PedidoManager pm = PedidoManager.getPedidoManager();
PedidoDTO pedido = new PedidoDTO();
boolean borrado = false;

if(codigo!=null){
	pedido.setCodigo(codigo);
	borrado = pm.borrarPedido(pedido);
}

List<PedidoDTO> pedidos = pm.getPedidosAEliminar();


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
</head>

<body class="oneColLiqCtrHdr">

<div id="container">
  <div id="mainContent">
    <h1 align="center">Eliminar Pedido</h1>
    <form id="form1" name="form1" method="post" action="">
        <span id="spryselect1"><strong>

        <label>Pedido:</label>
        </strong></span><span id="spryselect1"><label>
        <select name="lista_pedidos" id="lista_pedidos" onchange="javascript:Carga('com/sembd/industriasaj/view/eliminarPedido/eliminarPedidoReport.jsp?cod='+this.value,'informacion');">
         <option value="0"> - </option>
          <% 
          if(pedidos.size()!=0){
          for(int i=0;i<pedidos.size();i++){
          		PedidoDTO p = pedidos.get(i);
          	%>
          <option value="<%=p.getCodigo()%>"><%=p.getCodigo()%></option>
          <% }
             }%>
        </select>
      </label>
        <span class="selectRequiredMsg">Por favor seleccione un pedido.</span></span>
    </form>
    <p>&nbsp;</p>
    <div id="informacion">
            <%if(borrado){ %>
        	<span style="color: green;">El pedido ha sido eliminado exitosamente.</span>
        <%}else{ 
        	if(codigo!=null){%>
        	<span style="color: red;">No se pudo eliminar el pedido.</span>
        <%	}
        } %>
    </div>
    <p>&nbsp;</p>
  <!-- end #mainContent --></div>
<!-- end #container --></div>
<script type="text/javascript">
<!--
var spryselect1 = new Spry.Widget.ValidationSelect("spryselect1");
//-->
</script>
</body>
</html>
