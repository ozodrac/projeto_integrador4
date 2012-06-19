package br.com.shark.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.shark.TO.ProdutoCategoria;

public class ProdutoCategoriaDAO extends BaseDAO<ProdutoCategoria> {

	private static final String SELECT_ALL = "PRODUTOCATEGORIA-SELECT_ALL";

	public ProdutoCategoriaDAO() throws SQLException {
		super();
	}
	
	public List<ProdutoCategoria> consultar(int lingua) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<ProdutoCategoria> listProdutoCategoria = new ArrayList<ProdutoCategoria>();

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(SELECT_ALL));

			pst.setInt(1, lingua);
			
			rs = pst.executeQuery();
			System.out.println(pst.toString());
			
			while (rs.next()) {
				ProdutoCategoria produtoCategoria = new ProdutoCategoria();
				produtoCategoria.setId(rs.getInt("pra_id"));
				produtoCategoria.setNome(rs.getString("pra_nome"));
				
				listProdutoCategoria.add(produtoCategoria);
			}
			
			return listProdutoCategoria;
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, rs);
		}
		return listProdutoCategoria;
	}

}
