function CargaPadre(url,id)
{
	//Creamos un objeto dependiendo del navegador
	var objeto;
	if (window.XMLHttpRequest){
		//Mozilla, Safari, etc
		objeto = new XMLHttpRequest();
	}
	else if (window.ActiveXObject){
		//Internet Explorer
		try {
			objeto = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try { //Version mas antigua
				objeto = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {}
		}
	}
	if (!objeto){
		alert("No ha sido posible crear un objeto de XMLHttpRequest");
	}
	//Cuando XMLHttpRequest cambie de estado, se ejecuta esta funcion
	objeto.onreadystatechange=function(){
		cargarobjeto(objeto,id);
	};
	objeto.open('GET', url, true); // se indica con el método open la url a cargar de manera síncrona
	objeto.send(null); // se envia los datos con el metodo send
}

function cargarobjeto(objeto, id){
	if (objeto.readyState == 4) //si se ha cargado completamente
		parent.document.getElementById(id).innerHTML=objeto.responseText;
	else //en caso contrario, se muestra el mensaje siguiente
		parent.document.getElementById(id).innerHTML='Cargando...';
}