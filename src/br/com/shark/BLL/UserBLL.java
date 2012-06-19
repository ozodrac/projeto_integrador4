package br.com.shark.BLL;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import br.com.shark.DAO.UserDAO;
import br.com.shark.TO.User;
import br.com.shark.messages.Messages;
import br.com.shark.util.Functions;
import br.com.shark.util.I18N;

public class UserBLL {
	
	private ResourceBundle bundlePage;
	
	public UserBLL(Locale locale) {
		bundlePage = I18N.getBundle("user", locale);
	}

	public boolean inserir(User entidade) throws IllegalArgumentException {
		UserDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						bundlePage.getString("msg_objeto_nulo"));
			}
			
			if (Functions.isEmptyorNull(entidade.getNome())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_nome_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getEmail())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_email_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getSenha())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_senha_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getLogin())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_login_obrigatorio"));
				return false;
			}
			if (entidade.getLingua() == null) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_lingua_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getCpf())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_cpf_obrigatorio"));
				return false;
			}
			if (entidade.getPerfil() == null) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_perfil_obrigatorio"));
				return false;
			}

			dao = new UserDAO();
			return dao.inserir(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public User validarLogin(User user) {
		UserDAO dao;
		try {
			if (user == null) {
				throw new IllegalArgumentException(
						"O objeto usuário não pode ser nulo.");
			}

			if ("".equals(user.getLogin())) {
				throw new IllegalArgumentException(
						"O login é um campo obrigatório.");
			}

			if ("".equals(user.getSenha())) {
				throw new IllegalArgumentException(
						"A senha é um campo obrigatório.");
			}

			dao = new UserDAO();
			return dao.validarLogin(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String validarRecuperarSenha(User user) {
		UserDAO dao;
		try {
			if (user == null) {
				throw new IllegalArgumentException(
						"O objeto usuário não pode ser nulo.");
			}

			if ("".equals(user.getLogin())) {
				return null;
			}

			if ("".equals(user.getSenha())) {
				return null;
			}

			dao = new UserDAO();
			return dao.validarRecuperarSenha(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean alterar(User entidade) throws IllegalArgumentException {
		UserDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						"O objeto user não pode ser nulo.");
			}

			if (Functions.isEmptyorNull(entidade.getNome())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_nome_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getEmail())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_email_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getSenha())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_senha_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getLogin())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_login_obrigatorio"));
				return false;
			}
			if (entidade.getLingua() == null) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_lingua_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getCpf())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_cpf_obrigatorio"));
				return false;
			}
			if (entidade.getPerfil() == null) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_perfil_obrigatorio"));
				return false;
			}

			dao = new UserDAO();
			return dao.alterar(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean remover(User entidade) throws IllegalArgumentException {
		UserDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						"O objeto user não pode ser nulo.");
			}

			dao = new UserDAO();
			return dao.remover(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public User consultar(User entidade) throws IllegalArgumentException {
		UserDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						"O objeto user não pode ser nulo.");
			}

			dao = new UserDAO();
			return dao.consultar(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	
	public List<User> consultar() {
		UserDAO dao;
		try {
			dao = new UserDAO();
			return dao.consultar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
