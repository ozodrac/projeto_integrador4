package br.com.shark.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.shark.TO.Produto;
import br.com.shark.TO.ProdutoVenda;
import br.com.shark.TO.ProdutoVendaItem;

public class ProdutoVendaItemDAO extends BaseDAO<ProdutoVenda> {

	private static final String INSERT = "PRODUTOVENDAITEM-INSERT";
	private static final String DELETE = "PRODUTOVENDAITEM-DELETE";
	private static final String SELECT_BY_ID = "PRODUTOVENDAITEM-SELECT_BY_ID";

	public ProdutoVendaItemDAO() throws SQLException {
		super();
	}

	public boolean inserir(ProdutoVendaItem entidade) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(INSERT));

			pst.setInt(1, entidade.getProduto().getId());
			pst.setInt(2, entidade.getProdutoVenda().getId());
			pst.setFloat(3, entidade.getQuantidade());
			pst.setFloat(4, entidade.getValor());
			System.out.println(pst.toString());

			return (pst.executeUpdate() > 0);
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, null);
		}

		return false;
	}

	public boolean remover(ProdutoVenda entidade) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(DELETE));

			pst.setInt(1, entidade.getId());

			System.out.println(pst.toString());

			return (pst.executeUpdate() > 0);
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, null);
		}

		return false;
	}

	public List<ProdutoVendaItem> consultar(ProdutoVenda produtoVenda) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<ProdutoVendaItem> listProdutoVendaItem = new ArrayList<ProdutoVendaItem>();

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(SELECT_BY_ID));

			pst.setInt(1, produtoVenda.getId());

			rs = pst.executeQuery();
			System.out.println(pst.toString());
			while (rs.next()) {
				ProdutoVendaItem item = new ProdutoVendaItem();
				item.setProduto(new Produto(rs.getInt("pro_id")));
				item.setProdutoVenda(new ProdutoVenda(rs.getInt("prd_id")));
				item.setQuantidade(rs.getInt("prm_quantidade"));
				item.setValor(rs.getFloat("prm_valor"));
				
				listProdutoVendaItem.add(item);
			}
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, rs);
		}
		return listProdutoVendaItem;
	}

}
