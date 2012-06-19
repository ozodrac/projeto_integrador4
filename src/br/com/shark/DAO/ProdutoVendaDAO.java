package br.com.shark.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.shark.TO.Cliente;
import br.com.shark.TO.FormaPagamento;
import br.com.shark.TO.ProdutoVenda;
import br.com.shark.TO.User;

public class ProdutoVendaDAO extends BaseDAO<ProdutoVenda> {

	private static final String INSERT = "PRODUTOVENDA-INSERT";
	private static final String UPDATE = "PRODUTOVENDA-UPDATE";
	private static final String DELETE = "PRODUTOVENDA-DELETE";
	private static final String SELECT_BY_ID = "PRODUTOVENDA-SELECT_BY_ID";
	private static final String SELECT_ALL = "PRODUTOVENDA-SELECT_ALL";
	private static final String LAST_INSERT_ID = "PRODUTOVENDA-LAST_INSERT_ID";

	public ProdutoVendaDAO() throws SQLException {
		super();
	}

	public boolean inserir(ProdutoVenda entidade) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(INSERT));

			pst.setInt(1, entidade.getUser().getId());
			pst.setInt(2, entidade.getCliente().getId());
			pst.setInt(3, entidade.getFormaPagamento().getId());
			System.out.println(pst.toString());

			return (pst.executeUpdate() > 0);
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, null);
		}

		return false;
	}

	public boolean alterar(ProdutoVenda entidade) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(UPDATE));

			pst.setInt(1, entidade.getCliente().getId());
			pst.setInt(2, entidade.getFormaPagamento().getId());
			pst.setInt(3, entidade.getId());
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

	public ProdutoVenda consultar(ProdutoVenda produtoVenda) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ProdutoVenda produtoVendaResult = new ProdutoVenda();

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(SELECT_BY_ID));

			pst.setInt(1, produtoVenda.getId());

			rs = pst.executeQuery();
			System.out.println(pst.toString());
			if (rs.next()) {
				produtoVendaResult.setId(rs.getInt("prd_id"));
				produtoVendaResult.setUser(new User(rs.getInt("uso_id")));
				produtoVendaResult.setCliente(new Cliente(rs.getInt("cle_id")));
				produtoVendaResult.setFormaPagamento(new FormaPagamento(rs.getInt("fro_id")));
				produtoVendaResult.setDataCadastro(rs.getDate("prd_data_cadastro"));
			}
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, rs);
		}
		return produtoVendaResult;
	}
	
	public List<ProdutoVenda> consultar(int lingua) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<ProdutoVenda> listProdutoVenda = new ArrayList<ProdutoVenda>();

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(SELECT_ALL));
			
			pst.setInt(1, lingua);
			
			rs = pst.executeQuery();
			System.out.println(pst.toString());
			
			while (rs.next()) {
				ProdutoVenda produtoVenda = new ProdutoVenda();
				produtoVenda.setId(rs.getInt("prd_id"));
				produtoVenda.setDataCadastro(rs.getDate("prd_data_cadastro"));
				produtoVenda.setUser(new User(rs.getInt("uso_id"), rs.getString("uso_nome")));
				produtoVenda.setCliente(new Cliente(rs.getInt("cle_id"), rs.getString("cle_nome")));
				produtoVenda.setFormaPagamento(new FormaPagamento(rs.getInt("fro_id"), rs.getString("fro_nome")));
				
				listProdutoVenda.add(produtoVenda);
			}
			
			return listProdutoVenda;
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, rs);
		}
		return listProdutoVenda;
	}

	public int lastInsertId() throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int id = 0;

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(LAST_INSERT_ID));

			rs = pst.executeQuery();
			System.out.println(pst.toString());
			if (rs.next()) {
				id = rs.getInt("max");
			}
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, rs);
		}
		return id;
	}
	
}
