package br.com.shark.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.shark.TO.PerfilUsuario;

public class PerfilUsuarioDAO extends BaseDAO<PerfilUsuario> {

	private static final String SELECT_ALL = "PERFILUSUARIO-SELECT_ALL";

	public PerfilUsuarioDAO() throws SQLException {
		super();
	}
	
	public List<PerfilUsuario> consultar(int lingua) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<PerfilUsuario> listPerfilUsuario = new ArrayList<PerfilUsuario>();

		try {
			conn = getConnection();

			pst = conn.prepareStatement(mapQuery.get(SELECT_ALL));
			
			pst.setInt(1, lingua);

			rs = pst.executeQuery();
			System.out.println(pst.toString());
			
			while (rs.next()) {
				PerfilUsuario perfilUsuario = new PerfilUsuario();
				perfilUsuario.setId(rs.getInt("pro_id"));
				perfilUsuario.setNome(rs.getString("pro_nome"));
				
				listPerfilUsuario.add(perfilUsuario);
			}
			
			return listPerfilUsuario;
		} catch (Exception ex) {
			showException(ex);
		} finally {
			closeConnections(conn, pst, rs);
		}
		return listPerfilUsuario;
	}

}
