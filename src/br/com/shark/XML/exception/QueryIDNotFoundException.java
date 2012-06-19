package br.com.shark.XML.exception;

/**
 * Classe que cuida de exce��es relacionada aos arquivos br.com.shark.XML nos quais ficam os
 * SQL's que interagem com a base de dados.
 * 
 * @author Luciano Sampaio
 * @version 1.0
 * 
 */
public class QueryIDNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final String QUERYID_NOT_FOUND = "The queryID '%s' was not found.";

	public QueryIDNotFoundException(String errorID, String queryID) {
		super(String.format(errorID, queryID));
	}
}