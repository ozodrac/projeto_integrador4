package br.com.shark.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.shark.TO.FormaPagamento;

public class FormaPagamentoDAO extends BaseDAO<FormaPagamento> {

	private static final String SELECT_ALL = "FORMAPAGAMENTO-SELECT_ALL";

	public FormaPagamentoDAO() throws SQLException {
		super();
	}
	
	public List<FormaPagamento> consultar(int lingua) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<FormaPagamento> listFormaPagamento = new ArrayList<FormaPagamento>();

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(SELECT_ALL));
			
			pst.setInt(1, lingua);

			rs = pst.executeQuery();
			System.out.println(pst.toString());
			
			while (rs.next()) {
				FormaPagamento formaPagamento = new FormaPagamento();
				formaPagamento.setId(rs.getInt("fro_id"));
				formaPagamento.setNome(rs.getString("fro_nome"));
				
				listFormaPagamento.add(formaPagamento);
			}
			
			return listFormaPagamento;
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, rs);
		}
		return listFormaPagamento;
	}

}
