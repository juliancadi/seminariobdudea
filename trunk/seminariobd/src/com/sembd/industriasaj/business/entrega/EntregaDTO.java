package com.sembd.industriasaj.business.entrega;

import java.io.Serializable;
import java.sql.Date;

import com.sembd.industriasaj.business.pedido.PedidoDTO;


/**
 * The persistent class for the TB_ENTREGA database table.
 * 
 */

public class EntregaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	public EntregaDTO() {}
	
	private String codigo;

	private int cantidad;

	private Date fecha;

	private PedidoDTO tbPedido;

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

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public PedidoDTO getTbPedido() {
		return this.tbPedido;
	}

	public void setTbPedido(PedidoDTO tbPedido) {
		this.tbPedido = tbPedido;
	}
	
}