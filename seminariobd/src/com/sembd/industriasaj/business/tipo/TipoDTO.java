package com.sembd.industriasaj.business.tipo;

import java.io.Serializable;
import java.util.List;

import com.sembd.industriasaj.business.producto.ProductoDTO;


/**
 * The persistent class for the TB_TIPO database table.
 * 
 */

public class TipoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codigo;

	private int multiplo;

	private List<ProductoDTO> tbProductos;

    public TipoDTO() {
    }

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getMultiplo() {
		return this.multiplo;
	}

	public void setMultiplo(int multiplo) {
		this.multiplo = multiplo;
	}

	public List<ProductoDTO> getTbProductos() {
		return this.tbProductos;
	}

	public void setTbProductos(List<ProductoDTO> tbProductos) {
		this.tbProductos = tbProductos;
	}
	
}