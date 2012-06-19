package br.com.shark.XML;

/**
 * Classe que sabe quais s�o os atributos de um arquivo xml que a classe
 * MapQuery interage.
 * 
 * @author Luciano Sampaio
 * @version 1.0
 * 
 */
public class MapQueryQuery {
	private String queryID;
	private String comment;
	private String sql;
	private String aux;

	public MapQueryQuery(String queryID) {
		this(queryID, null, null, null);
	}

	public MapQueryQuery(String queryID, String comment, String sql, String aux) {
		super();
		setQueryID(queryID);
		setComment(comment);
		setSql(sql);
		setAux(aux);
	}

	public String getAux() {
		return aux;
	}

	public void setAux(String aux) {
		this.aux = aux;
	}

	/**
	 * @return the queryID
	 */
	public String getQueryID() {
		return queryID;
	}

	/**
	 * @param queryID
	 *            the queryID to set
	 */
	public void setQueryID(String queryID) {
		this.queryID = queryID;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the sQL
	 */
	public String getSql() {
		return sql;
	}

	/**
	 * @param sQL
	 *            the sQL to set
	 */
	public void setSql(String sql) {
		this.sql = sql;
	}

	@Override
	public boolean equals(Object obj) {
		if ((this == null) || (obj == null)) {
			return false;
		}

		if (!(obj instanceof MapQueryQuery)) {
			return false;
		}

		MapQueryQuery other = (MapQueryQuery) obj;
		if (this.getQueryID() != null) {
			return this.getQueryID().equals(other.getQueryID());
		}

		return false;
	}

}
