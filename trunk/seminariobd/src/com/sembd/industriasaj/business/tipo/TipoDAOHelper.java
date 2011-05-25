package com.sembd.industriasaj.business.tipo;

public class TipoDAOHelper {
	
	public static String getTipo() {
        String result = "SELECT codigo, multiplo FROM tb_tipo WHERE codigo=?";
        return result;
    }

    public static String getTipos() {
    	String result = "SELECT codigo, multiplo FROM tb_tipo ORDER BY codigo";
        return result;
    }

}
