package br.com.shark.XML;


public class MapConfig extends Map{

	private static Map instance = null;
	
	private MapConfig(){
		XML_TAG_NAME_QUERY = "config";
		XML_TAG_NAME_COMMENTS = "comments";
		XML_TAG_NAME_SQL = "value";
		XML_TAG_NAME_AUX = "parent";
		XML_ATTRIBUTE_NAME_QUERYID = "name";
	}
	
	/**
	 * @return The only instance that will ever exist from this class.
	 */
	public static synchronized Map getInstance() {
		// http://en.wikipedia.org/wiki/Singleton_pattern
		if (instance == null) {
			instance = new MapConfig();
		}

		return instance;
	}
	
	public String get(String... queryID) {
		String result = "";
		
		for(String query : queryID){
			super.get(query);
			MapQueryQuery mqq = super.getSQLFromCache(query);
			if(mqq.getAux() != null){
				result += this.get(mqq.getAux());
			}
			result += mqq.getSql();
		}
		
		return result;
	}
	
	public String get(String queryID) {
		String result = "";
		
		super.get(queryID);
		MapQueryQuery mqq = super.getSQLFromCache(queryID);
		if(mqq.getAux() != null){
			result += this.get(mqq.getAux());
		}
		result += mqq.getSql();
		
		return result;
	}
}
