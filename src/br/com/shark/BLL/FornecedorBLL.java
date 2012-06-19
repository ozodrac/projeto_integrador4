package br.com.shark.BLL;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import br.com.shark.DAO.FornecedorDAO;

import br.com.shark.TO.Fornecedor;

import br.com.shark.messages.Messages;
import br.com.shark.util.Functions;
import br.com.shark.util.I18N;

public class FornecedorBLL {
	
	private ResourceBundle bundlePage;
	
    public FornecedorBLL(Locale locale) {
		bundlePage = I18N.getBundle("fornecedor", locale);
	}
	
	
	public FornecedorBLL() {
	// TODO Auto-generated constructor stub
	}


	public boolean inserir(Fornecedor entidade) throws IllegalArgumentException {
		FornecedorDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						bundlePage.getString("msg_objeto_nulo"));
			}
			
			//if (entidade.getId() <= 0) {
				//Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_id_obrigatorio"));
				//return false;
			//}
			if (Functions.isEmptyorNull(entidade.getNome_fantasia())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_nome_fantasia_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getRazao_social())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_nome_razao_social_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getCnpj())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_cnpj_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getTelefone1())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_telefone1_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getRepresentante())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_representante_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getEmail())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_email_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getSite())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_site_obrigatorio"));
				return false;
			}
			

			dao = new FornecedorDAO();
			return dao.inserir(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean alterar(Fornecedor entidade) throws IllegalArgumentException {
		FornecedorDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						bundlePage.getString("msg_objeto_nulo"));
			}

			if (entidade.getId() <= 0) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_id_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getNome_fantasia())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_nome_fantasia_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getRazao_social())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_nome_razao_social_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getCnpj())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_cnpj_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getTelefone1())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_telefone1_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getRepresentante())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_representante_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getEmail())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_email_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getSite())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_site_obrigatorio"));
				return false;
			}

			dao = new FornecedorDAO();
			return dao.alterar(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean remover(Fornecedor entidade) throws IllegalArgumentException {
		FornecedorDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						bundlePage.getString("msg_objeto_nulo"));
			}
			if (entidade.getId() <= 0) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_id_obrigatorio"));
				return false;
			}

			dao = new FornecedorDAO();
			return dao.remover(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public Fornecedor consultar(Fornecedor entidade) throws IllegalArgumentException {
		FornecedorDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						bundlePage.getString("msg_objeto_nulo"));
			}
			if (entidade.getId() <= 0) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_id_obrigatorio"));
				return null;
			}

			dao = new FornecedorDAO();
			return dao.consultar(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
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