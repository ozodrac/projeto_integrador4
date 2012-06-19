package br.com.shark.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.shark.TO.Fornecedor;
import br.com.shark.TO.Produto;
import br.com.shark.TO.ProdutoCategoria;

public class ProdutoDAO extends BaseDAO<Produto> {

	private static final String INSERT = "PRODUTO-INSERT";
	private static final String UPDATE = "PRODUTO-UPDATE";
	private static final String DELETE = "PRODUTO-DELETE";
	private static final String SELECT_BY_ID = "PRODUTO-SELECT_BY_ID";
	private static final String SELECT_ALL = "PRODUTO-SELECT_ALL";

	public ProdutoDAO() throws SQLException {
		super();
	}

	public boolean inserir(Produto entidade) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(INSERT));

			pst.setInt(1, entidade.getFornecedor().getId());
			pst.setInt(2, entidade.getCategoria().getId());
			pst.setString(3, entidade.getDescricao());
			pst.setString(4, entidade.getMarca());
			pst.setFloat(5, entidade.getValor_compra());
			pst.setFloat(6, entidade.getValor_venda_avista());
			pst.setFloat(7, entidade.getValor_venda_prazo());
			pst.setInt(8, entidade.getGarantia());
			pst.setInt(9, entidade.getQuantidade());
			System.out.println(pst.toString());

			return (pst.executeUpdate() > 0);
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, null);
		}

		return false;
	}

	public boolean alterar(Produto entidade) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(UPDATE));

			pst.setInt(1, entidade.getFornecedor().getId());
			pst.setInt(2, entidade.getCategoria().getId());
			pst.setString(3, entidade.getDescricao());
			pst.setString(4, entidade.getMarca());
			pst.setFloat(5, entidade.getValor_compra());
			pst.setFloat(6, entidade.getValor_venda_avista());
			pst.setFloat(7, entidade.getValor_venda_prazo());
			pst.setInt(8, entidade.getGarantia());
			pst.setInt(9, entidade.getQuantidade());
			pst.setInt(10, entidade.getId());
			System.out.println(pst.toString());

			return (pst.executeUpdate() > 0);
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, null);
		}

		return false;
	}

	public boolean remover(Produto entidade) throws SQLException {
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

	public Produto consultar(Produto produto) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Produto produtoResult = new Produto();

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(SELECT_BY_ID));

			pst.setInt(1, produto.getId());

			rs = pst.executeQuery();
			System.out.println(pst.toString());
			if (rs.next()) {
				produtoResult.setId(rs.getInt("pro_id"));
				produtoResult.setFornecedor(new Fornecedor(rs.getInt("frr_id")));
				produtoResult.setCategoria(new ProdutoCategoria(rs.getString("pra_id")));
				produtoResult.setDescricao(rs.getString("pro_descricao"));
				produtoResult.setMarca(rs.getString("pro_marca"));
				produtoResult.setValor_compra(rs.getFloat("pro_valor_compra"));
				produtoResult.setValor_venda_avista(rs.getFloat("pro_valor_venda_avista"));
				produtoResult.setValor_venda_prazo(rs.getFloat("pro_valor_venda_prazo"));
				produtoResult.setGarantia(rs.getInt("pro_garantia"));
				produtoResult.setQuantidade(rs.getInt("pro_quantidade"));
			}
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, rs);
		}
		return produtoResult;
	}
	
	public List<Produto> consultar(int lingua) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Produto> listProduto = new ArrayList<Produto>();

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(SELECT_ALL));

			pst.setInt(1, lingua);
			
			rs = pst.executeQuery();
			System.out.println(pst.toString());
			
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("pro_id"));
				produto.setDescricao(rs.getString("pro_descricao"));
				produto.setMarca(rs.getString("pro_marca"));
				produto.setValor_venda_avista(rs.getFloat("pro_valor_venda_avista"));
				produto.setQuantidade(rs.getInt("pro_quantidade"));
				
				ProdutoCategoria produtoCategoria = new ProdutoCategoria();
				produtoCategoria.setNome(rs.getString("pra_nome"));
				
				produto.setCategoria(produtoCategoria);
				
				listProduto.add(produto);
			}
			
			return listProduto;
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, rs);
		}
		return listProduto;
	}

}
