<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Bienvenido a Industrias AJ</title>
<style type="text/css"> 
<!-- 
body  {
	font: 100% Verdana, Arial, Helvetica, sans-serif;
	background: #666666;
	margin: 0; /* it's good practice to zero the margin and padding of the body element to account for differing browser defaults */
	padding: 0;
	text-align: center; /* this centers the container in IE 5* browsers. The text is then set to the left aligned default in the #container selector */
	color: #000000;
}
.twoColLiqLtHdr #container {
	width: 100%;  /* this will create a container 80% of the browser width */
	background: #FFFFFF;
	margin: 0 auto;
	text-align: left; /* this overrides the text-align: center on the body element. */
} 
.twoColLiqLtHdr #header { 
	background: #DDDDDD; 
	padding: 0 10px;  /* this padding matches the left alignment of the elements in the divs that appear beneath it. If an image is used in the #header instead of text, you may want to remove the padding. */
} 
.twoColLiqLtHdr #header h1 {
	margin: 0; /* zeroing the margin of the last element in the #header div will avoid margin collapse - an unexplainable space between divs. If the div has a border around it, this is not necessary as that also avoids the margin collapse */
	padding: 10px 0; /* using padding instead of margin will allow you to keep the element away from the edges of the div */
}

/* Tips for sidebar1:
1. since we are working in percentages, it's best not to use padding on the sidebar. It will be added to the width for standards compliant browsers creating an unknown actual width. 
2. Space between the side of the div and the elements within it can be created by placing a left and right margin on those elements as seen in the ".twoColLiqLtHdr #sidebar1 p" rule.
3. Since Explorer calculates widths after the parent element is rendered, you may occasionally run into unexplained bugs with percentage-based columns. If you need more predictable results, you may choose to change to pixel sized columns.
*/
.twoColLiqLtHdr #sidebar1 {
	float: left;
	width: 18%; /* since this element is floated, a width must be given */
	background: #EBEBEB; /* the background color will be displayed for the length of the content in the column, but no further */
	padding: 15px 0; /* top and bottom padding create visual space within this div  */
}
.twoColLiqLtHdr #sidebar1 h3, .twoColLiqLtHdr #sidebar1 p {
	margin-left: 10px; /* the left and right margin should be given to every element that will be placed in the side columns */
	margin-right: 10px;
}

/* Tips for mainContent:
1. the space between the mainContent and sidebar1 is created with the left margin on the mainContent div.  No matter how much content the sidebar1 div contains, the column space will remain. You can remove this left margin if you want the #mainContent div's text to fill the #sidebar1 space when the content in #sidebar1 ends.
2. to avoid float drop at a supported minimum 800 x 600 resolution, elements within the mainContent div should be 430px or smaller (this includes images).
3. in the Internet Explorer Conditional Comment below, the zoom property is used to give the mainContent "hasLayout." This avoids several IE-specific bugs.
*/
.twoColLiqLtHdr #mainContent {
	width: 90%;
	margin-left: 10%;
} 
.twoColLiqLtHdr #footer {
	padding: 0 10px; /* this padding matches the left alignment of the elements in the divs that appear above it. */
	background:#DDDDDD;
} 
.twoColLiqLtHdr #footer p {
	margin: 0; /* zeroing the margins of the first element in the footer will avoid the possibility of margin collapse - a space between divs */
	padding: 10px 0; /* padding on this element will create space, just as the the margin would have, without the margin collapse issue */
}

/* Miscellaneous classes for reuse */
.fltrt { /* this class can be used to float an element right in your page. The floated element must precede the element it should be next to on the page. */
	float: right;
	margin-left: 8px;
}
.fltlft { /* this class can be used to float an element left in your page */
	float: left;
	margin-right: 8px;
}
.clearfloat { /* this class should be placed on a div or break element and should be the final element before the close of a container that should fully contain a float */
	clear:both;
    height:0;
    font-size: 1px;
    line-height: 0px;
}
--> 
</style><!--[if IE]>
<style type="text/css"> 
/* place css fixes for all versions of IE in this conditional comment */
.twoColLiqLtHdr #sidebar1 { padding-top: 30px; }
.twoColLiqLtHdr #mainContent { zoom: 1; padding-top: 15px; }
/* the above proprietary zoom property gives IE the hasLayout it needs to avoid several bugs */
</style>
<![endif]-->
<script src="com/sembd/industriasaj/view/index/css/SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<script src="com/sembd/industriasaj/view/javascript/cargarContenido.js" type="text/javascript"></script>
<script src="com/sembd/industriasaj/view/javascript/cargarPadre.js" type="text/javascript"></script>
<link href="com/sembd/industriasaj/view/index/css/SpryAssets/SpryMenuBarVertical.css" rel="stylesheet" type="text/css" />
</head>

<body class="twoColLiqLtHdr">

<div id="container"> 
  <div id="header">
    <h1 align="center">INDUSTRIAS AJ</h1>
    <!-- end #header --></div>
  <div id="sidebar1">
    <ul id="MenuBar1" class="MenuBarVertical">
      <li><a class="MenuBarItemSubmenu" href="#">Producto</a>
          <ul>
            <li><a href="javascript:Carga('com/sembd/industriasaj/view/listarProductos/listarProductos.jsp', 'mainContent');">Listar Productos</a></li>
            <li><a href="javascript:Carga('com/sembd/industriasaj/view/consultarPedEnt/consultarPedEnt.jsp', 'mainContent');">Consultar Pedidos y Entregas</a></li>
          </ul>
      </li>
      <li><a class="MenuBarItemSubmenu" href="#">Pedido</a>
          <ul>
            <li><a href="javascript:Carga('com/sembd/industriasaj/view/modificarPedido/modificarPedido.jsp', 'mainContent');">Modificar Pedido</a></li>
            <li><a href="javascript:Carga('com/sembd/industriasaj/view/eliminarPedido/eliminarPedido.jsp', 'mainContent');">Eliminar Pedido</a></li>
            <li><a href="javascript:Carga('com/sembd/industriasaj/view/consultarEntregas/consultarEntregas.jsp', 'mainContent');">Consultar Entregas</a></li>
          </ul>
      </li>
      <li><a href="javascript:Carga('com/sembd/industriasaj/view/ingresarEntrega/ingresarEntrega.jsp', 'mainContent');" title="Cargar contenido" >Ingresar Entrega</a></li>
      <li><a class="MenuBarItemSubmenu" href="#">Factura</a>
          <ul>
            <li><a href="javascript:Carga('com/sembd/industriasaj/view/ingresarFactura/ingresarFactura.jsp', 'mainContent');">Ingresar Factura</a></li>
            <li><a href="javascript:Carga('com/sembd/industriasaj/view/consultarEntregasPorFact/consultarEntregasPorFact.jsp', 'mainContent');">Consultar Entregas</a></li>
          </ul>
      </li>
    </ul>
    <h3>&nbsp;</h3>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
  <!-- end #sidebar1 --></div>
  <div id="mainContent">
    <h1>&nbsp;</h1>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>
      <!-- end #mainContent -->
    </p>
  </div>
  <!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats --><br class="clearfloat" />
  <div id="footer">
    <p align="center">Industrias AJ · Carrera 88 # 12-97 · Tel 365 3211 · Medellin - Colombia</p>
    <p align="center">Industrias AJ © 2011</p>
  <!-- end #footer --></div>
<!-- end #container --></div>
<script type="text/javascript">
<!--
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgRight:"SpryAssets/SpryMenuBarRightHover.gif"});
//-->
</script>
</body>
</html>
