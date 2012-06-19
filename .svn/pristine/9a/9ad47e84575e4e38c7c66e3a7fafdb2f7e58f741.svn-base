package br.com.shark.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import br.com.shark.BLL.PerfilUsuarioBLL;
import br.com.shark.BLL.UserBLL;
import br.com.shark.TO.PerfilUsuario;
import br.com.shark.TO.User;
import br.com.shark.messages.Messages;
import br.com.shark.util.Functions;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user/")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserBLL userBLL;

	public UserServlet() {
		super();
	}

	private void novo() throws IOException, ServletException {
		adicionarPerfilUsuario();
		RequestDispatcher rd = req.getRequestDispatcher(mapconfig.get("CONFIG-DIR_USER")
				+ "/novo.jsp");
		rd.forward(req, res);
	}

	private void cadastrar() throws IOException, ServletException {
		User user = new User();
		user.setNome(req.getParameter("uso_nome"));
		user.setEmail(req.getParameter("uso_email"));
		user.setLogin(req.getParameter("uso_login"));
		user.setSenha(req.getParameter("uso_senha"));
		user.setLingua(req.getParameter("lna_id"));
		user.setCpf(req.getParameter("uso_cpf"));
		user.setPerfil(new PerfilUsuario(req.getParameter("pro_id")));

		if (userBLL.inserir(user)) {
			Messages.addMessage(Messages.SUCCESS, bundleGlobal.getString("msg_saved"));
			consultar();
		} else {
			Messages.addMessage(Messages.ERROR, bundleGlobal.getString("msg_not_saved"));
			novo();
		}
	}

	private void editar(String uso_id) throws IOException, ServletException {
		if (uso_id != null) {
			adicionarPerfilUsuario();
			User user = new User();
			user.setId(uso_id);
			
			user = userBLL.consultar(user);

			req.setAttribute("user", user);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					mapconfig.get("CONFIG-DIR_USER") + "/editar.jsp");
			rd.forward(req, res);
		} else {
			Messages.addMessage(Messages.WARNING,
					bundlePage.getString("msg_selecione_usuario_consultar"));
			consultar();
		}
	}
	
	private void editarMeuUsuario() throws IOException, ServletException {
		editar(String.valueOf(Functions.getUserFromSession(req.getSession()).getId()));
	}
	
	private void editarUsuario() throws IOException, ServletException {
		String uso_id = req.getParameter("uso_id");
		
		if (Functions.isEmptyorNull(uso_id)) {
			String[] Auso_id = req.getParameterValues("uso_id");
			if (Auso_id != null && Auso_id.length > 0) {
				uso_id = Auso_id[0];
			}
		}
		editar(uso_id);
	}
	
	private void consultar() throws ServletException, IOException {
		List<User> listUser = userBLL.consultar();
		
		User user = new User();
		user.setListUser(listUser);
		
		req.setAttribute("user", user);
		
		RequestDispatcher rd = req.getRequestDispatcher(mapconfig.get("CONFIG-DIR_USER") + "/consultar.jsp");
		rd.forward(req, res);
	}

	private void apagar() throws IOException, ServletException {
		String uso_id = req.getParameter("uso_id");
		
		if (Functions.isEmptyorNull(uso_id)) {
			String[] Auso_id = req.getParameterValues("uso_id");
			if (Auso_id != null && Auso_id.length > 0) {
				uso_id = Auso_id[0];
			}
		}

		if (uso_id != null) {
			User user = new User();
			user.setId(uso_id);

			if (user.getId() == Functions.getUserFromSession(req.getSession()).getId()) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_impossivel_apagar_proprio_usuario"));
				consultar();
				return;
			}
			
			if (userBLL.remover(user)) {
				Messages.addMessage(Messages.SUCCESS, bundleGlobal.getString("msg_deleted"));
				consultar();
			} else {
				Messages.addMessage(Messages.ERROR, bundleGlobal.getString("msg_not_deleted"));
				consultar();
			}
		}
	}

	private void atualizar() throws ServletException, IOException {
		User user = new User();
		user.setId(req.getParameter("uso_id"));
		user.setNome(req.getParameter("uso_nome"));
		user.setEmail(req.getParameter("uso_email"));
		user.setLogin(req.getParameter("uso_login"));
		user.setSenha(req.getParameter("uso_senha"));
		user.setLingua(req.getParameter("lna_id"));
		user.setCpf(req.getParameter("uso_cpf"));
		user.setPerfil(new PerfilUsuario(req.getParameter("pro_id")));

		if (userBLL.alterar(user)) {
			if (user.getId() == Functions.getUserFromSession(req.getSession()).getId()) {
				Functions.setLocaleToSession(req.getSession(), user.getLingua().getLocale());
			}
			Messages.addMessage(Messages.SUCCESS, bundleGlobal.getString("msg_updated"));
			res.sendRedirect(mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_USER") + "/");
		} else {
			Messages.addMessage(Messages.ERROR, bundleGlobal.getString("msg_not_updated"));
			req.setAttribute("user", user);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					mapconfig.get("CONFIG-DIR_USER") + "/editar.jsp");
			rd.forward(req, res);
		}
	}

	@Override
	protected void decideAction() throws ServletException {
		userBLL = new UserBLL(Functions.getLocaleFromSession(req.getSession()));
		try {
			if (bundlePage.getString("cadastrar").equalsIgnoreCase(getAcao())) {
				cadastrar();
			} else if (bundlePage.getString("editar").equalsIgnoreCase(getAcao())) {
				editarUsuario();
			} else if (bundlePage.getString("apagar").equalsIgnoreCase(getAcao())) {
				apagar();
			} else if (bundlePage.getString("atualizar").equalsIgnoreCase(getAcao())) {
				atualizar();
			} else if (bundlePage.getString("novo").equalsIgnoreCase(getAcao())) {
				novo();
			} else if ("editarmeuusuario".equalsIgnoreCase(getAcao())) {
				editarMeuUsuario();
			} else {
				consultar();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private void adicionarPerfilUsuario() {
		PerfilUsuarioBLL bll = new PerfilUsuarioBLL();
		List<PerfilUsuario> listPerfilUsuario = bll.consultar(Functions.getEnumLinguaFromSession(req.getSession()).getId());
		req.setAttribute("listPerfilUsuario", listPerfilUsuario);
	}
	
}
