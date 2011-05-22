package com.sembd.industriasaj.business.factura;

import java.io.Serializable;
import java.util.Date;

import com.sembd.industriasaj.business.pedido.PedidoDTO;


/**
 * The persistent class for the TB_FACTURA database table.
 * 
 */

public class FacturaDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private String codigo;

	private int base;

	private Date fecha;

	private int iva;

	private int total;

	private PedidoDTO tbPedido;

    public FacturaDTO() {}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getBase() {
		return this.base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIva() {
		return this.iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public PedidoDTO getTbPedido() {
		return this.tbPedido;
	}

	public void setTbPedido(PedidoDTO tbPedido) {
		this.tbPedido = tbPedido;
	}
	
}