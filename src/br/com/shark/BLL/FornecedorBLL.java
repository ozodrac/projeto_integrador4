package br.com.shark.BLL;

import java.util.List;

import br.com.shark.DAO.FornecedorDAO;
import br.com.shark.TO.Fornecedor;

public class FornecedorBLL {

	public List<Fornecedor> consultar() {
		FornecedorDAO dao;
		try {
			dao = new FornecedorDAO();
			return dao.consultar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}