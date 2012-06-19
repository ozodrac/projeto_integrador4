package br.com.shark.BLL;

import java.util.List;

import br.com.shark.DAO.PerfilUsuarioDAO;
import br.com.shark.TO.PerfilUsuario;

public class PerfilUsuarioBLL {

	public List<PerfilUsuario> consultar(int lingua) {
		PerfilUsuarioDAO dao;
		try {
			dao = new PerfilUsuarioDAO();
			return dao.consultar(lingua);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}