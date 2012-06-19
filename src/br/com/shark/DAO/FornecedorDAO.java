package br.com.shark.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.shark.TO.Fornecedor;

public class FornecedorDAO extends BaseDAO<Fornecedor> {

	private static final String INSERT = "FORNECEDOR-INSERT";
	private static final String UPDATE = "FORNECEDOR-UPDATE";
	private static final String DELETE = "FORNECEDOR-DELETE";
	private static final String SELECT_BY_ID = "FORNECEDOR-SELECT_BY_ID";
	private static final String SELECT_ALL = "FORNECEDOR-SELECT_ALL";

	public FornecedorDAO() throws SQLException {
		super();
	}
	

	public boolean inserir(Fornecedor entidade) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(INSERT));

			pst.setString(1, entidade.getNome_fantasia());
			pst.setString(2, entidade.getRazao_social());
			pst.setString(3, entidade.getCnpj());
			pst.setString(4, entidade.getTelefone1());
			pst.setString(5, entidade.getRepresentante());
			pst.setString(6, entidade.getEmail());
			pst.setString(7, entidade.getSite());
			System.out.println(pst.toString());

			return (pst.executeUpdate() > 0);
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, null);
		}

		return false;
	}

	public boolean alterar(Fornecedor entidade) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(UPDATE));

			pst.setString(1, entidade.getNome_fantasia());
			pst.setString(2, entidade.getRazao_social());
			pst.setString(3, entidade.getCnpj());
			pst.setString(4, entidade.getTelefone1());
			pst.setString(5, entidade.getRepresentante());
			pst.setString(6, entidade.getEmail());
			pst.setString(7, entidade.getSite());
			pst.setInt(8, entidade.getId());
			System.out.println(pst.toString());

			return (pst.executeUpdate() > 0);
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, null);
		}

		return false;
	}

	public boolean remover(Fornecedor entidade) throws SQLException {
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

	public Fornecedor consultar(Fornecedor cliente) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Fornecedor clienteResult = new Fornecedor();

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(SELECT_BY_ID));

			pst.setInt(1, cliente.getId());

			rs = pst.executeQuery();
			System.out.println(pst.toString());
			if (rs.next()) {
				clienteResult.setId(rs.getInt("frr_id"));
				clienteResult.setNome_fantasia(rs.getString("frr_nome_fantasia"));
				clienteResult.setRazao_social(rs.getString("frr_razao_social"));
				clienteResult.setCnpj(rs.getString("frr_cnpj"));
				clienteResult.setTelefone1(rs.getString("frr_telefone1"));
				clienteResult.setRepresentante(rs.getString("frr_representante"));
				clienteResult.setEmail(rs.getString("frr_email"));
				clienteResult.setSite(rs.getString("frr_site"));
			}
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, rs);
		}
		return clienteResult;
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
				fornecedor.setNome_fantasia(rs.getString("frr_nome_fantasia"));
				fornecedor.setCnpj(rs.getString("frr_cnpj"));
				fornecedor.setEmail(rs.getString("frr_email"));
				fornecedor.setRazao_social(rs.getString("frr_razao_social"));
				fornecedor.setTelefone1(rs.getString("frr_telefone1"));
				fornecedor.setRepresentante(rs.getString("frr_representante"));
				fornecedor.setSite(rs.getString("frr_site"));
				
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
