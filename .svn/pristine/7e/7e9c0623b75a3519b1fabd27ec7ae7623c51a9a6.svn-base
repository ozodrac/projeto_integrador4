package br.com.shark.XML.exception;

/**
 * Classe que cuida de exce��es relacionada ao format da queryID.
 * 
 * @author Luciano Sampaio
 * @version 1.0
 * 
 */
public class InvalidQueryIDFormatException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final String QUERYID_CANNOT_BE_NULL = "The queryID can not be null.";
	public static final String QUERYID_IS_NOT_IN_THE_VALID_FORMAT = "'%s' is not in the valid format. "
			+ "The format should be: TABLE_NAME-COMMAND_SQL. Ex: PERSON-INSERT";

	public InvalidQueryIDFormatException(String errorID) {
		super(errorID);
	}

	public InvalidQueryIDFormatException(String errorID, String queryID) {
		super(String.format(errorID, queryID));
	}

}