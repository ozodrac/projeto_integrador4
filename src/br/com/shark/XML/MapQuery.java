package br.com.shark.XML;


public class MapQuery extends Map{

	private static Map instance = null;
	
	private MapQuery(){
		XML_TAG_NAME_QUERY = "query";
		XML_TAG_NAME_COMMENTS = "comments";
		XML_TAG_NAME_SQL = "sql";
		XML_TAG_NAME_AUX = null;
		XML_ATTRIBUTE_NAME_QUERYID = "id";
	}
	
	/**
	 * @return The only instance that will ever exist from this class.
	 */
	public static synchronized Map getInstance() {
		// http://en.wikipedia.org/wiki/Singleton_pattern
		if (instance == null) {
			instance = new MapQuery();
		}

		return instance;
	}
}
