package br.com.shark.XML.exception;

/**
 * Classe que cuida de exce��es relacionada aos arquivos br.com.shark.XML nos quais ficam os
 * SQL's que interagem com a base de dados.
 * 
 * @author Luciano Sampaio
 * @version 1.0
 * 
 */
public class MapQueryFileNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final String FILE_NOT_FOUND = "The file '%s' was not found.";

	public MapQueryFileNotFoundException(String errorID, String queryID) {
		super(String.format(errorID, queryID));
	}
}