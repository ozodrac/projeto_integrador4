package br.com.shark.XML.exception;

/**
 * Classe que cuida de exce��es relacionada ao format do arquivo xml do
 * MapQuery.
 * 
 * @author Luciano Sampaio
 * @version 1.0
 * 
 */
public class InvalidMapQueryFileFormatException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final String MAPQUERY_IS_NOT_IN_THE_VALID_FORMAT = "The mapquery file is not in the valid format."
			+ "The format should be:"
			+ "<query id='TABLE_NAME-COMMAND_NAME'>"
			+ "<comments>Comments</comments><sql><![CDATA[SQL script]]>"
			+ "</sql></query>";

	public InvalidMapQueryFileFormatException(String errorID) {
		super(errorID);
	}

}