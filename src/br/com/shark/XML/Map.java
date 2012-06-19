package br.com.shark.XML;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.shark.XML.exception.InvalidMapQueryFileFormatException;
import br.com.shark.XML.exception.InvalidQueryIDFormatException;
import br.com.shark.XML.exception.MapQueryFileNotFoundException;
import br.com.shark.XML.exception.QueryIDNotFoundException;

/**
 * The class that handles br.com.shark.XML files with the SQL scripts that are used by the
 * application to interact with the data source.
 * 
 * @author Luciano Sampaio
 * @version 1.0
 * 
 */
public abstract class Map {

	private static final boolean debug = false;

	/** ^ -> The beginning of a line. */
	private static final String REGEX_TABLE_NAME = "^(\\w+)";

	private static final Pattern patternTableName;
	private static List<MapQueryQuery> listQueries;

	private static final String MAPQUERY_FILE_EXTENSION = ".xml";
	/**
	 * The format should be: TABLE_NAME-COMMAND_SQL.<br />
	 * e.g. PERSON-INSERT
	 */
	protected static String REGEX_SCRIPT_FORMAT = "(\\w+)([-]{1,1})(\\w+)";

	/**
	 * Variáveis que poderão ser modificadas por classes que herdem a Map
	 */
	protected static String XML_TAG_NAME_QUERY = "query";
	protected static String XML_TAG_NAME_COMMENTS = "comments";
	protected static String XML_TAG_NAME_SQL = "sql";
	/**
	 * Nova tag auxiliar, caso preenchida também será procurada no arquivo xml e
	 * adicionada à lista de queries.
	 */
	protected static String XML_TAG_NAME_AUX = null;
	protected static String XML_ATTRIBUTE_NAME_QUERYID = "id";

	/**
	 * Static block will guarantee that these lines of code only get executed
	 * once. The compile method from the regular expression, takes lots of time
	 * and resources.
	 */
	static {
		patternTableName = Pattern.compile(REGEX_TABLE_NAME);
		listQueries = new ArrayList<MapQueryQuery>();
		if (debug)
			System.out.println("The static block was executed.");
	}
	
	public String get(String... queryIDS){
		String result = "";
		for(String query : queryIDS){
			result += get(query);
		}
		return result;
	}

	/**
	 * Based on the queryID, this method goes into the mapquery folder where all
	 * the xml files that have SQL scripts are stored, and look for the queryID
	 * so it can retrieve the sql script that was asked for.
	 * 
	 * @param queryID
	 *            The id that will be used to identify the query among all the
	 *            other queries inside the br.com.shark.XML file.
	 * @return The SQL script that was asked for based on the queryID.
	 * @throws InvalidQueryIDFormatException
	 * @throws MapQueryFileNotFoundException
	 * @throws QueryIDNotFoundException
	 * @throws InvalidMapQueryFileFormatException
	 */
	public String get(String queryID) {

		String errorMessage = null;
		try {
			if (queryID != null) {
				/**
				 * By default all database related names, should be written in
				 * capitalized letters.
				 */
				queryID = queryID.toUpperCase();

				// Check if the queryID is in the valid format.
				if (isQueryIDInTheValidFormat(queryID)) {
					// It gets the SQL Script based on the queryID.
					return getSQLFromMapQueryFile(queryID);
				} else {
					errorMessage = InvalidQueryIDFormatException.QUERYID_IS_NOT_IN_THE_VALID_FORMAT;
				}
			} else {
				errorMessage = InvalidQueryIDFormatException.QUERYID_CANNOT_BE_NULL;
			}
			throw new InvalidQueryIDFormatException(errorMessage, queryID);
		} catch (MapQueryFileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (QueryIDNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (InvalidMapQueryFileFormatException e) {
			System.out.println(e.getMessage());
		} catch (InvalidQueryIDFormatException e) {
			System.out.println(e.getMessage());
		}

		return null;

	}

	/**
	 * Check if the format of the queryID is valid based on
	 * TABLE_NAME-COMMAND_SQL. e.g. PERSON-INSERT
	 * 
	 * @param queryID
	 * @return True if the format of the queryID is valid, otherwise false.
	 */
	private boolean isQueryIDInTheValidFormat(String queryID) {
		return (queryID.matches(REGEX_SCRIPT_FORMAT));
	}

	/**
	 * @param fileName
	 * @param commandName
	 * @return
	 * @throws MapQueryFileNotFoundException
	 * @throws QueryIDNotFoundException
	 * @throws InvalidMapQueryFileFormatException
	 */
	private String getSQLFromMapQueryFile(String queryID)
			throws MapQueryFileNotFoundException, QueryIDNotFoundException,
			InvalidMapQueryFileFormatException {
		long startTimeMs = System.currentTimeMillis();
		/**
		 * Before we do any processing, we check to see if this queryID was
		 * already asked for, in case of yes, the queryID is already stored in
		 * the cache, otherwise we will have to search for it into the xml
		 * files.
		 */
		MapQueryQuery mapQueryQuery = getSQLFromCache(queryID);

		/**
		 * If the returned object is null, it means this is the first time this
		 * queryID is asked for.
		 */
		if (mapQueryQuery == null) {
			// It gets the table name from the queryID.
			String tableName = getTableNameFromQueryID(queryID);

			/**
			 * It concats the table name + the mapquery file extension. <br />
			 * e.g. TABLE_NAME + .br.com.shark.XML
			 */
			String fileName = tableName.concat(MAPQUERY_FILE_EXTENSION);

			/** Nothing can be done if the file does not exist. */
			if (mapQueryFileExists(fileName)) {
				/**
				 * It loads the hole xml file into the cache to avoid future
				 * reads on the hard drive.
				 */
				loadMapQueryFileIntoCache(fileName);
				/**
				 * Now that all the queries from the file that was opened are
				 * loaded into the cache, we try to find the queryID again.
				 */
				mapQueryQuery = getSQLFromCache(queryID);
				// If it is null again, it means that the queryID was not found.
				if (mapQueryQuery == null) {
					throw new QueryIDNotFoundException(
							QueryIDNotFoundException.QUERYID_NOT_FOUND, queryID);
				}
				// This is just to see performance.
				if (debug)
					System.out
							.printf("The queryID: '%s' was retrieved from MapQuery file in : %d milliseconds\r\n",
									queryID,
									(System.currentTimeMillis() - startTimeMs));
			} else {
				throw new MapQueryFileNotFoundException(
						MapQueryFileNotFoundException.FILE_NOT_FOUND, fileName);
			}
		} else {
			// This is just to see performance.
			if (debug)
				System.out
						.printf("The queryID: '%s' was retrieved from cache in : %d milliseconds\r\n",
								queryID,
								(System.currentTimeMillis() - startTimeMs));
		}

		// Return the SQL script that was asked for.
		return mapQueryQuery.getSql();
	} 

	/**
	 * Based on the queryID, it tries to find it into the cache/list that was
	 * created to avoid hard drive reads all the time.
	 * 
	 * @param queryID
	 * @return
	 */
	protected MapQueryQuery getSQLFromCache(String queryID) {
		for (MapQueryQuery mapQueryQuery : listQueries) {
			if (queryID.equals(mapQueryQuery.getQueryID())) {
				return mapQueryQuery;
			}
		}

		return null;
	}

	/**
	 * Extract the table name from the queryID.<br/>
	 * e.g. PERSON_INSERT -> PERSON
	 * 
	 * @param queryID
	 * @return The table name found into the queryID.
	 */
	private String getTableNameFromQueryID(String queryID) {
		Matcher m = patternTableName.matcher(queryID);

		/**
		 * Because the regular expression only has on group, we know that if it
		 * finds something, it will be on group 1.
		 */
		return (m.find()) ? m.group(1) : null;
	}

	/**
	 * Check if the file exists in the server's hard drive.
	 * 
	 * @param fileName
	 * @return True if it exists, otherwise false.
	 */
	private boolean mapQueryFileExists(String fileName) {
		return (getMapQueryFile(fileName) != null);
	}

	/**
	 * It gets the mapquery file in the server's hard drive.
	 * 
	 * @param fileName
	 * @return True if it exists, otherwise false.
	 */
	private InputStream getMapQueryFile(String fileName) {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		return classLoader.getResourceAsStream(fileName);
	}

	/**
	 * It loads the hole xml file into the cache to avoid future reads on the
	 * hard drive
	 * 
	 * @param fileName
	 * @throws InvalidMapQueryFileFormatException
	 */
	private void loadMapQueryFileIntoCache(String fileName)
			throws InvalidMapQueryFileFormatException {
		// It gets the object that knows how to handle br.com.shark.XML files.
		Document document = getDocument(fileName);

		// It gets the list of element by the type of "query".
		NodeList nodeListQuery = document
				.getElementsByTagName(XML_TAG_NAME_QUERY);
		int length = nodeListQuery.getLength();

		// It iterates over all the "query" elements in the xml file.
		for (int i = 0; i < length; i++) {

			Node node = nodeListQuery.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				Element element = (Element) node;

				String queryID = getAttributeValueFromElement(element,
						XML_ATTRIBUTE_NAME_QUERYID);
				/**
				 * If the id attribute was not found, there is an error on the
				 * format of the xml.
				 */
				if (queryID != null) {
					String comment = getTagValueFromElement(element,
							XML_TAG_NAME_COMMENTS);
					/**
					 * If the comment tag was not found, there is an error on
					 * the format of the xml.
					 */
					if (comment != null) {
						String sql = getCDataFromElement(element,
								XML_TAG_NAME_SQL);

						/**
						 * If the sql tag was not found, there is an error on
						 * the format of the xml.
						 */
						if (sql != null) {

							String aux = null;
							if (XML_TAG_NAME_AUX != null) {
								aux = getTagValueFromElement(element,
										XML_TAG_NAME_AUX);
							}

							// It adds the new object to the list/cache.
							listQueries.add(new MapQueryQuery(queryID, comment,
									sql, aux));
							continue;
						}
					}
				}
				/**
				 * If it gets to this point, it means one of these errors have
				 * happened: The id attribute, comment tag or sql tag was not
				 * found into the br.com.shark.XML file.
				 */
				throw new InvalidMapQueryFileFormatException(
						InvalidMapQueryFileFormatException.MAPQUERY_IS_NOT_IN_THE_VALID_FORMAT);
			}
		}
	}

	/**
	 * @param fileName
	 * @return
	 */
	private Document getDocument(String fileName) {
		Document document = null;
		try {
			// Create a DocumentBuilderFactory
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

			// It is the DocumentBuilder instance that is the DOM
			// parser. Using this DOM parser you can parse br.com.shark.XML files
			// into DOM objects
			DocumentBuilder db = dbf.newDocumentBuilder();

			// Parse the input file to get a Document object
			document = db.parse(getMapQueryFile(fileName));

			document.getDocumentElement().normalize();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return document;
	}

	/**
	 * @param element
	 * @return
	 */
	private String getAttributeValueFromElement(Element element,
			String AttributeName) {
		String attr = element.getAttribute(AttributeName);

		return ("".equals(attr)) ? null : attr;
	}

	/**
	 * @param sTag
	 * @param element
	 * @return
	 */
	private String getTagValueFromElement(Element element, String sTag) {
		Node node = getNodeByTagNameAndIndex(element, sTag, 0);

		return (node == null) ? null : node.getNodeValue();
	}

	/**
	 * @param sTag
	 * @param element
	 * @return
	 */
	private String getCDataFromElement(Element element, String sTag) {
		Node child = getNodeByTagNameAndIndex(element, sTag, 1);

		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}

		return null;
	}

	/**
	 * @param sTag
	 * @param element
	 * @param index
	 * @return
	 */
	private Node getNodeByTagNameAndIndex(Element element, String sTag,
			int index) {
		/**
		 * <pre>
		 * <query id="TABLE_NAME-COMMAND_NAME">
		 * 		<comments>Comments</comments>
		 * 		<sql>
		 * 			<![CDATA[SQL]]>
		 * 		</sql>
		 * 	</query>
		 * </pre>
		 */
		Node child = element.getElementsByTagName(sTag).item(0);

		return (child == null) ? null : child.getChildNodes().item(index);
	}
}