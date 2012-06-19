package br.com.shark.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import br.com.shark.BLL.ClienteBLL;
import br.com.shark.TO.Cliente;
import br.com.shark.messages.Messages;
import br.com.shark.util.Functions;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/cliente/")
public class ClienteServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private ClienteBLL clienteBLL;

	public ClienteServlet() {
		super();
	}

	private void novo() throws IOException, ServletException {
		RequestDispatcher rd = req.getRequestDispatcher(mapconfig.get("CONFIG-DIR_CLIENTE")
				+ "/novo.jsp");
		rd.forward(req, res);
	}

	private void cadastrar() throws IOException, ServletException {
		Cliente cliente = new Cliente();
		cliente.setNome(req.getParameter("cle_nome"));
		cliente.setCpf(req.getParameter("cle_cpf"));
		cliente.setTelefoneCelular(req.getParameter("cle_telefone_celular"));
		cliente.setSexo(req.getParameter("cle_sexo"));
		cliente.setDataNascimento(req.getParameter("cle_data_nascimento"));
		cliente.setEmail(req.getParameter("cle_email"));
		cliente.setTelefoneResidencial(req.getParameter("cle_telefone_residencial"));
		cliente.setTelefoneComercial(req.getParameter("cle_telefone_comercial"));
		cliente.setEndereco(req.getParameter("cle_endereco"));

		if (clienteBLL.inserir(cliente)) {
			Messages.addMessage(Messages.SUCCESS, bundleGlobal.getString("msg_saved"));
			consultar();
		} else {
			Messages.addMessage(Messages.ERROR, bundleGlobal.getString("msg_not_saved"));
			novo();
		}
	}

	private void editar() throws IOException, ServletException {
		String cle_id = req.getParameter("cle_id");
		
		if (Functions.isEmptyorNull(cle_id)) {
			String[] Acle_id = req.getParameterValues("cle_id");
			if (Acle_id != null && Acle_id.length > 0) {
				cle_id = Acle_id[0];
			}
		}
		
		if (cle_id != null) {
			Cliente cliente = new Cliente();
			cliente.setId(cle_id);
			
			cliente = clienteBLL.consultar(cliente);

			req.setAttribute("cliente", cliente);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					mapconfig.get("CONFIG-DIR_CLIENTE") + "/editar.jsp");
			rd.forward(req, res);
		} else {
			Messages.addMessage(Messages.WARNING,
					bundlePage.getString("msg_selecione_cliente_consultar"));
			consultar();
		}
	}
	
	private void consultar() throws ServletException, IOException {
		List<Cliente> listCliente = clienteBLL.consultar();
		
		Cliente cliente = new Cliente();
		cliente.setListCliente(listCliente);
		
		req.setAttribute("cliente", cliente);
		
		RequestDispatcher rd = req.getRequestDispatcher(mapconfig.get("CONFIG-DIR_CLIENTE") + "/consultar.jsp");
		rd.forward(req, res);
	}

	private void apagar() throws IOException, ServletException {
		String cle_id = req.getParameter("cle_id");
		
		if (Functions.isEmptyorNull(cle_id)) {
			String[] Acle_id = req.getParameterValues("cle_id");
			if (Acle_id != null && Acle_id.length > 0) {
				cle_id = Acle_id[0];
			}
		}

		if (cle_id != null) {
			Cliente cliente = new Cliente();
			cliente.setId(cle_id);
			
			if (clienteBLL.remover(cliente)) {
				Messages.addMessage(Messages.SUCCESS, bundleGlobal.getString("msg_deleted"));
				consultar();
			} else {
				Messages.addMessage(Messages.ERROR, bundleGlobal.getString("msg_not_deleted"));
				consultar();
			}
		}
	}

	private void atualizar() throws ServletException, IOException {
		Cliente cliente = new Cliente();
		cliente.setId(req.getParameter("cle_id"));
		cliente.setNome(req.getParameter("cle_nome"));
		cliente.setCpf(req.getParameter("cle_cpf"));
		cliente.setTelefoneCelular(req.getParameter("cle_telefone_celular"));
		cliente.setSexo(req.getParameter("cle_sexo"));
		cliente.setDataNascimento(req.getParameter("cle_data_nascimento"));
		cliente.setEmail(req.getParameter("cle_email"));
		cliente.setTelefoneResidencial(req.getParameter("cle_telefone_residencial"));
		cliente.setTelefoneComercial(req.getParameter("cle_telefone_comercial"));
		cliente.setEndereco(req.getParameter("cle_endereco"));

		if (clienteBLL.alterar(cliente)) {
			Messages.addMessage(Messages.SUCCESS, bundleGlobal.getString("msg_updated"));
			res.sendRedirect(mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_CLIENTE") + "/");
		} else {
			Messages.addMessage(Messages.ERROR, bundleGlobal.getString("msg_not_updated"));
			req.setAttribute("cliente", cliente);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					mapconfig.get("CONFIG-DIR_CLIENTE") + "/editar.jsp");
			rd.forward(req, res);
		}
	}

	@Override
	protected void decideAction() throws ServletException {
		clienteBLL = new ClienteBLL(Functions.getLocaleFromSession(req.getSession()));
		try {
			if (bundlePage.getString("cadastrar").equalsIgnoreCase(getAcao())) {
				cadastrar();
			} else if (bundlePage.getString("editar").equalsIgnoreCase(getAcao())) {
				editar();
			} else if (bundlePage.getString("apagar").equalsIgnoreCase(getAcao())) {
				apagar();
			} else if (bundlePage.getString("atualizar").equalsIgnoreCase(getAcao())) {
				atualizar();
			} else if (bundlePage.getString("novo").equalsIgnoreCase(getAcao())) {
				novo();
			} else {
				consultar();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
