package br.com.shark.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.shark.TO.Fornecedor;

public class FornecedorDAO extends BaseDAO<Fornecedor> {

	private static final String SELECT_ALL = "FORNECEDOR-SELECT_ALL";

	public FornecedorDAO() throws SQLException {
		super();
	}
	
	public List<Fornecedor> consultar() throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Fornecedor> listFornecedor = new ArrayList<Fornecedor>();

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(SELECT_ALL));

			rs = pst.executeQuery();
			System.out.println(pst.toString());
			
			while (rs.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(rs.getInt("frr_id"));
				fornecedor.setNome(rs.getString("frr_nome_fantasia"));
				
				listFornecedor.add(fornecedor);
			}
			
			return listFornecedor;
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, rs);
		}
		return listFornecedor;
	}

}
