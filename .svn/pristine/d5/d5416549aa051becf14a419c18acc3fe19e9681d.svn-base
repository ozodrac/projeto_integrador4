package br.com.shark.BLL;

import java.util.List;

import br.com.shark.DAO.ProdutoCategoriaDAO;
import br.com.shark.TO.ProdutoCategoria;

public class ProdutoCategoriaBLL {

	public List<ProdutoCategoria> consultar(int lingua) {
		ProdutoCategoriaDAO dao;
		try {
			dao = new ProdutoCategoriaDAO();
			return dao.consultar(lingua);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}