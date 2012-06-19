package br.com.shark.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.shark.TO.PerfilUsuario;
import br.com.shark.TO.User;

public class UserDAO extends BaseDAO<User> {

	// Nomes dos SQL's que estão no arquivo user.xml(mapquery).
	private static final String USER_INSERT = "USER-INSERT";
	private static final String USER_UPDATE = "USER-UPDATE";
	private static final String USER_DELETE = "USER-DELETE";
	private static final String USER_SELECT_BY_ID = "USER-SELECT_BY_ID";
	private static final String USER_VALIDAR_LOGIN = "USER-VALIDAR_LOGIN";
	private static final String USER_VALIDAR_RECUPERAR_SENHA = "USER-VALIDAR_RECUPERAR_SENHA";
	private static final String USER_ALTERAR_SENHA = "USER-ALTERAR_SENHA";
	private static final String USER_SELECT_ALL = "USER-SELECT_ALL";

	public UserDAO() throws SQLException {
		super();
	}

	public boolean inserir(User entidade) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(USER_INSERT));

			pst.setInt(1, entidade.getPerfil().getId());
			pst.setString(2, entidade.getNome());
			pst.setString(3, entidade.getLogin());
			pst.setString(4, entidade.getSenha());
			pst.setString(5, entidade.getEmail());
			pst.setInt(6, entidade.getLingua().getId());
			pst.setString(7, entidade.getCpf());
			System.out.println(pst.toString());

			return (pst.executeUpdate() > 0);
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, null);
		}

		return false;
	}

	public boolean alterar(User entidade) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(USER_UPDATE));

			pst.setString(1, entidade.getNome());
			pst.setString(2, entidade.getLogin());
			pst.setString(3, entidade.getSenha());
			pst.setString(4, entidade.getEmail());
			pst.setInt(5, entidade.getLingua().getId());
			pst.setInt(6, entidade.getPerfil().getId());
			pst.setString(7, entidade.getCpf());
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

	public boolean remover(User entidade) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(USER_DELETE));

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

	public User consultar(User user) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User userResult = new User();

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(USER_SELECT_BY_ID));

			pst.setInt(1, user.getId());

			rs = pst.executeQuery();
			System.out.println(pst.toString());
			if (rs.next()) {
				userResult.setId(rs.getInt("uso_id"));
				userResult.setNome(rs.getString("uso_nome"));
				userResult.setLogin(rs.getString("uso_login"));
				userResult.setSenha(rs.getString("uso_senha"));
				userResult.setEmail(rs.getString("uso_email"));
				userResult.setLingua(rs.getInt("lna_id"));
				userResult.setDt_cadastro(rs.getDate("uso_dt_cadastro"));
				userResult.setCpf(rs.getString("uso_cpf"));
				userResult.setPerfil(new PerfilUsuario(rs.getInt("pro_id")));
			}
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, rs);
		}
		return userResult;
	}

	public User validarLogin(User entidade) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(USER_VALIDAR_LOGIN));

			pst.setString(1, entidade.getLogin());
			pst.setString(2, entidade.getSenha());

			rs = pst.executeQuery();
			
			if (rs.next()) {
				user = new User();
				user.setId(rs.getString("uso_id"));
				user.setNome(rs.getString("uso_nome"));
				user.setLingua(rs.getInt("lna_id"));
			}
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, rs);
		}
		return user;
	}

	public String validarRecuperarSenha(User entidade) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String novaSenha = null;

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery
					.get(USER_VALIDAR_RECUPERAR_SENHA));

			pst.setString(1, entidade.getLogin());
			pst.setString(2, entidade.getEmail());

			rs = pst.executeQuery();

			if (rs.next()) {
				entidade.setId(rs.getInt("uso_id"));

				novaSenha = String.valueOf(Math.random()).substring(0, 6);

				pst = conn.prepareStatement(mapQuery.get(USER_ALTERAR_SENHA));

				pst.setString(1, novaSenha);
				pst.setInt(2, entidade.getId());

				if (pst.executeUpdate() < 1) {
					throw new Exception("Ocorreu um erro ao redefinir a senha.");
				}
			}
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, rs);
		}
		return novaSenha;
	}

	
	public List<User> consultar() throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<User> listUser = new ArrayList<User>();

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(USER_SELECT_ALL));

			rs = pst.executeQuery();
			System.out.println(pst.toString());
			
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("uso_id"));
				user.setNome(rs.getString("uso_nome"));
				user.setLogin(rs.getString("uso_login"));
				user.setEmail(rs.getString("uso_email"));
				user.setDt_cadastro(rs.getDate("uso_dt_cadastro"));
				
				listUser.add(user);
			}
			
			return listUser;
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, rs);
		}
		return listUser;
	}

}
