package br.com.shark.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import br.com.shark.BLL.UserBLL;
import br.com.shark.TO.User;
import br.com.shark.messages.Messages;
import br.com.shark.util.Functions;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login/")
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserBLL userBLL;
	private HttpSession sessao;

	public LoginServlet() {
		super();
	}

	@Override
	protected void decideAction() {
		setSessao(req.getSession());
		userBLL = new UserBLL(Functions.getLocaleFromSession(req.getSession()));
		Boolean logado = (Boolean) getSessao().getAttribute("logado");
		try {
			if (bundleGlobal.getString("sair").equalsIgnoreCase(getAcao())) {
				sair();
			} else if (Boolean.TRUE.equals(logado)) {
				res.sendRedirect(mapconfig.get("CONFIG-DIR_ROOT",
						"CONFIG-DIR_HOME"));
			} else if (bundlePage.getString("login").equalsIgnoreCase(getAcao())) {
				login();
			} else if (bundlePage.getString("resetar_senha").equalsIgnoreCase(getAcao())) {
				resetarSenha();
			} else {
				index();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private void resetarSenha() throws IOException {
		User user = new User();
		user.setLogin(req.getParameter("login"));
		user.setEmail(req.getParameter("email"));

		String novaSenha = userBLL.validarRecuperarSenha(user);
		if (novaSenha != null) {
			Messages.addMessage(Messages.INFO, bundlePage.getString("msg_nova_senha") + novaSenha);
			index();
		} else {
			Messages.addMessage(Messages.ERROR, bundlePage.getString("msg_usuario_nao_cadastrado"));
			res.sendRedirect(mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_LOGIN")
					+ "/esqueci_minha_senha.jsp");
		}
	}

	private void index() throws IOException {
		res.sendRedirect(mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_LOGIN")
				+ "/login.jsp");
	}

	private void sair() throws IOException {
		getSessao().invalidate();
		index();
	}

	private void login() throws IOException {
		User user = new User();
		user.setLogin(req.getParameter("login"));
		user.setSenha(req.getParameter("senha"));

		user = userBLL.validarLogin(user);
		if (user != null) {
			Functions.setUserToSession(getSessao(), user);
			Functions.setLocaleToSession(getSessao(), user.getLingua().getLocale());

			res.sendRedirect(mapconfig
					.get("CONFIG-DIR_ROOT", "CONFIG-DIR_HOME"));
		} else {
			Messages.addMessage(Messages.ERROR, bundlePage.getString("msg_usuario_senha_invalido"));
			index();
		}
	}

	private HttpSession getSessao() {
		return sessao;
	}

	private void setSessao(HttpSession sessao) {
		this.sessao = sessao;
	}

}
