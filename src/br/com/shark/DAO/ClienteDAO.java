package br.com.shark.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.shark.TO.Cliente;

public class ClienteDAO extends BaseDAO<Cliente> {

	private static final String INSERT = "CLIENTE-INSERT";
	private static final String UPDATE = "CLIENTE-UPDATE";
	private static final String DELETE = "CLIENTE-DELETE";
	private static final String SELECT_BY_ID = "CLIENTE-SELECT_BY_ID";
	private static final String SELECT_ALL = "CLIENTE-SELECT_ALL";

	public ClienteDAO() throws SQLException {
		super();
	}

	public boolean inserir(Cliente entidade) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(INSERT));

			pst.setString(1, entidade.getNome());
			pst.setString(2, entidade.getCpf());
			pst.setString(3, entidade.getTelefoneCelular());
			pst.setString(4, String.valueOf(entidade.getSexo().getSexo()));
			if(entidade.getDataNascimento() != null){
				pst.setDate(5, new Date(entidade.getDataNascimento().getTime()));
			} else {
				pst.setNull(5, 0);
			}
			pst.setString(6, entidade.getEmail());
			pst.setString(7, entidade.getTelefoneResidencial());
			pst.setString(8, entidade.getTelefoneComercial());
			pst.setString(9, entidade.getEndereco());
			System.out.println(pst.toString());

			return (pst.executeUpdate() > 0);
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, null);
		}

		return false;
	}

	public boolean alterar(Cliente entidade) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(UPDATE));

			pst.setString(1, entidade.getNome());
			pst.setString(2, entidade.getCpf());
			pst.setString(3, entidade.getTelefoneCelular());
			pst.setString(4, String.valueOf(entidade.getSexo().getSexo()));
			if(entidade.getDataNascimento() != null){
				pst.setDate(5, new Date(entidade.getDataNascimento().getTime()));
			} else {
				pst.setNull(5, 0);
			}
			pst.setString(6, entidade.getEmail());
			pst.setString(7, entidade.getTelefoneResidencial());
			pst.setString(8, entidade.getTelefoneComercial());
			pst.setString(9, entidade.getEndereco());
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

	public boolean remover(Cliente entidade) throws SQLException {
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

	public Cliente consultar(Cliente cliente) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Cliente clienteResult = new Cliente();

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(SELECT_BY_ID));

			pst.setInt(1, cliente.getId());

			rs = pst.executeQuery();
			System.out.println(pst.toString());
			if (rs.next()) {
				clienteResult.setId(rs.getInt("cle_id"));
				clienteResult.setNome(rs.getString("cle_nome"));
				clienteResult.setCpf(rs.getString("cle_cpf"));
				clienteResult.setTelefoneCelular(rs.getString("cle_telefone_celular"));
				clienteResult.setSexo(rs.getString("cle_sexo"));
				clienteResult.setDataNascimento(rs.getDate("cle_data_nascimento"));
				clienteResult.setEmail(rs.getString("cle_email"));
				clienteResult.setTelefoneResidencial(rs.getString("cle_telefone_residencial"));
				clienteResult.setTelefoneComercial(rs.getString("cle_telefone_comercial"));
				clienteResult.setEndereco(rs.getString("cle_endereco"));
			}
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, rs);
		}
		return clienteResult;
	}
	
	public List<Cliente> consultar() throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Cliente> listCliente = new ArrayList<Cliente>();

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(SELECT_ALL));

			rs = pst.executeQuery();
			System.out.println(pst.toString());
			
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("cle_id"));
				cliente.setNome(rs.getString("cle_nome"));
				cliente.setTelefoneCelular(rs.getString("cle_telefone_celular"));
				cliente.setEmail(rs.getString("cle_email"));
				cliente.setSexo(rs.getString("cle_sexo"));
				
				listCliente.add(cliente);
			}
			
			return listCliente;
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, rs);
		}
		return listCliente;
	}

}
