package br.com.shark.BLL;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import br.com.shark.DAO.ClienteDAO;
import br.com.shark.TO.Cliente;
import br.com.shark.messages.Messages;
import br.com.shark.util.Functions;
import br.com.shark.util.I18N;

public class ClienteBLL {
	
	private ResourceBundle bundlePage;
	
	public ClienteBLL(Locale locale) {
		bundlePage = I18N.getBundle("cliente", locale);
	}

	public boolean inserir(Cliente entidade) throws IllegalArgumentException {
		ClienteDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						bundlePage.getString("msg_objeto_nulo"));
			}
			
			if (Functions.isEmptyorNull(entidade.getNome())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_nome_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getCpf())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_cpf_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getTelefoneCelular())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_telefone_celular_obrigatorio"));
				return false;
			}
			if (entidade.getSexo() == null) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_sexo_obrigatorio"));
				return false;
			}

			dao = new ClienteDAO();
			return dao.inserir(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean alterar(Cliente entidade) throws IllegalArgumentException {
		ClienteDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						bundlePage.getString("msg_objeto_nulo"));
			}

			if (entidade.getId() <= 0) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_id_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getNome())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_nome_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getCpf())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_cpf_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getTelefoneCelular())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_telefone_celular_obrigatorio"));
				return false;
			}
			if (entidade.getSexo() == null) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_sexo_obrigatorio"));
				return false;
			}

			dao = new ClienteDAO();
			return dao.alterar(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean remover(Cliente entidade) throws IllegalArgumentException {
		ClienteDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						bundlePage.getString("msg_objeto_nulo"));
			}
			if (entidade.getId() <= 0) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_id_obrigatorio"));
				return false;
			}

			dao = new ClienteDAO();
			return dao.remover(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public Cliente consultar(Cliente entidade) throws IllegalArgumentException {
		ClienteDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						bundlePage.getString("msg_objeto_nulo"));
			}
			if (entidade.getId() <= 0) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_id_obrigatorio"));
				return null;
			}

			dao = new ClienteDAO();
			return dao.consultar(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public List<Cliente> consultar() {
		ClienteDAO dao;
		try {
			dao = new ClienteDAO();
			return dao.consultar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}