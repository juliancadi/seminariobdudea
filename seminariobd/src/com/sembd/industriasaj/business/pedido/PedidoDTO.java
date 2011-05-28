package com.sembd.industriasaj.business.pedido;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.sembd.industriasaj.business.entrega.EntregaDTO;
import com.sembd.industriasaj.business.factura.FacturaDTO;
import com.sembd.industriasaj.business.producto.ProductoDTO;


/**
 * The persistent class for the TB_PEDIDO database table.
 * 
 */

public class PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private String codigo;

	private int cantidad;

	private String estado;

	private Date fechaEntrega;

	private Date fechaPedido;

	private ProductoDTO tbProducto;

	private List<EntregaDTO> tbEntregas;

	private FacturaDTO tbFactura;

    public PedidoDTO() {
    }

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaEntrega() {
		return this.fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Date getFechaPedido() {
		return this.fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public ProductoDTO getTbProducto() {
		return this.tbProducto;
	}

	public void setTbProducto(ProductoDTO tbProducto) {
		this.tbProducto = tbProducto;
	}
	
	public List<EntregaDTO> getTbEntregas() {
		return this.tbEntregas;
	}

	public void setTbEntregas(List<EntregaDTO> tbEntregas) {
		this.tbEntregas = tbEntregas;
	}
	
	public FacturaDTO getTbFactura() {
		return this.tbFactura;
	}

	public void setTbFactura(FacturaDTO tbFactura) {
		this.tbFactura = tbFactura;
	}
	
}