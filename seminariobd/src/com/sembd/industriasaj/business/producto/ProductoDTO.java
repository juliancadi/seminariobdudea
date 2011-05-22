package com.sembd.industriasaj.business.producto;

import java.io.Serializable;
import java.util.List;

import com.sembd.industriasaj.business.pedido.PedidoDTO;
import com.sembd.industriasaj.business.tipo.TipoDTO;


/**
 * The persistent class for the TB_PRODUCTO database table.
 * 
 */

public class ProductoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String referencia;

	private int cantStock;

	private String descripcion;

	private String identificador;

	private int precioUnitario;

	private int valorMin;

	private int valorOptimo;

	private TipoDTO tbTipo;

	private List<PedidoDTO> tbPedidos;

    public ProductoDTO() {
    }

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public int getCantStock() {
		return this.cantStock;
	}

	public void setCantStock(int cantStock) {
		this.cantStock = cantStock;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public int getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getValorMin() {
		return this.valorMin;
	}

	public void setValorMin(int valorMin) {
		this.valorMin = valorMin;
	}

	public int getValorOptimo() {
		return this.valorOptimo;
	}

	public void setValorOptimo(int valorOptimo) {
		this.valorOptimo = valorOptimo;
	}

	public TipoDTO getTbTipo() {
		return this.tbTipo;
	}

	public void setTbTipo(TipoDTO tbTipo) {
		this.tbTipo = tbTipo;
	}
	
	public List<PedidoDTO> getTbPedidos() {
		return this.tbPedidos;
	}

	public void setTbPedidos(List<PedidoDTO> tbPedidos) {
		this.tbPedidos = tbPedidos;
	}
	
}