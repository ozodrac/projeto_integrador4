/**
 * 
 */
package br.com.shark.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.shark.JDBC.ConnectionFactory;
import br.com.shark.XML.Map;
import br.com.shark.XML.MapQuery;

/**
 * @author Jayson
 *
 */
public abstract class BaseDAO<T> {
	
	// Conexão com o banco de dados.
	private Connection connection;
	protected static Map mapQuery;

	public BaseDAO(Connection connection) {
		setConnection(connection);
		mapQuery = MapQuery.getInstance();
	}

	// Construtor padrão.
	public BaseDAO() throws SQLException {
		this(ConnectionFactory.getConnection());
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	protected Connection getConnection() throws SQLException {
		if ((connection == null) || (connection.isClosed())) {
			setConnection(ConnectionFactory.getConnection());
		}
		return connection;
	}

	/**
	 * @param connection
	 *            the connection to set
	 */
	protected void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**
	 * @param ex
	 */
	protected void showException(Exception ex) {
		System.out.println("\n--- Exception ---\n");
		while (ex != null) {
			System.out.println("Mensagem: " + ex.getMessage());

			if (ex instanceof SQLException) {
				SQLException sqlEx = (SQLException) ex;

				System.out.println("SQLState: " + sqlEx.getSQLState());
				System.out.println("ErrorCode: " + sqlEx.getErrorCode());
				ex = sqlEx.getNextException();
			} else {
				ex = null;
			}
			System.out.println("");
		}
	}

	/**
	 * @param conn
	 * @param pst
	 * @param rs
	 * @throws SQLException
	 */
	protected void closeConnections(Connection conn, PreparedStatement pst, ResultSet rs)
			throws SQLException {
		// Depois de tudo feito, é importante fechar as conexões.
		if (rs != null)
			rs.close();
		if (pst != null)
			pst.close();
		if (conn != null)
			conn.close();
	}

	/**
	 * Obtém a quantidade de registros de uma tabela.
	 * 
	 * @return
	 * @throws SQLException
	 */
	protected int getQuantidadeRegistros(String queryID) throws SQLException {
		// Objeto que possui a conexão com o banco.
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			// Abre a conexão.
			conn = getConnection();

			// Prepara o SQL para ser executado.
			pst = conn.prepareStatement(mapQuery.get(queryID));
			System.out.println(pst.toString());

			// Executa o SQL no banco de dados.
			rs = pst.executeQuery();

			if (rs.next()) {
				return rs.getInt("quantidadeRegistros");
			}
		} catch (Exception ex) {
			showException(ex);
		} finally {
			// Depois de tudo feito, é importante fechar as conexões.
			closeConnections(conn, pst, rs);
		}

		// Se chegar a este ponto é porque houve algum erro.
		return 0;
	}

}
