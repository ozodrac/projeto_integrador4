package br.com.shark.BLL;

import java.util.List;

import br.com.shark.DAO.FormaPagamentoDAO;
import br.com.shark.TO.FormaPagamento;

public class FormaPagamentoBLL {

	public List<FormaPagamento> consultar(int lingua) {
		FormaPagamentoDAO dao;
		try {
			dao = new FormaPagamentoDAO();
			return dao.consultar(lingua);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}