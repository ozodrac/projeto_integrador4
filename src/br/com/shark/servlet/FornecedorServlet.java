package br.com.shark.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import br.com.shark.BLL.FornecedorBLL;
import br.com.shark.TO.Fornecedor;
import br.com.shark.messages.Messages;
import br.com.shark.util.Functions;

/**
 * Servlet implementation class FornecedorServlet
 */
@WebServlet("/fornecedor/")
public class FornecedorServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private FornecedorBLL fornecedorBLL;

    public FornecedorServlet() {
        super();
    }
    private void novo() throws IOException, ServletException {
		RequestDispatcher rd = req.getRequestDispatcher(mapconfig.get("CONFIG-DIR_FORNECEDOR")
				+ "/novo.jsp");
		rd.forward(req, res);
	}

	private void cadastrar() throws IOException, ServletException {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome_fantasia(req.getParameter("frr_nome_fantasia"));
		fornecedor.setRazao_social(req.getParameter("frr_razao_social"));
		fornecedor.setCnpj(req.getParameter("frr_cnpj"));
		fornecedor.setTelefone1(req.getParameter("frr_telefone1"));
		fornecedor.setRepresentante(req.getParameter("frr_representante"));
		fornecedor.setEmail(req.getParameter("frr_email"));
		fornecedor.setSite(req.getParameter("frr_site"));

		if (fornecedorBLL.inserir(fornecedor)) {
			Messages.addMessage(Messages.SUCCESS, bundleGlobal.getString("msg_saved"));
			consultar();
		} else {
			Messages.addMessage(Messages.ERROR, bundleGlobal.getString("msg_not_saved"));
			novo();
		}
	}

	private void editar() throws IOException, ServletException {
		String frr_id = req.getParameter("frr_id");
		
		if (Functions.isEmptyorNull(frr_id)) {
			String[] Afrr_id = req.getParameterValues("frr_id");
			if (Afrr_id != null && Afrr_id.length > 0) {
				frr_id = Afrr_id[0];
			}
		}
		
		if (frr_id != null) {
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setId(frr_id);
			
			fornecedor = fornecedorBLL.consultar(fornecedor);

			req.setAttribute("fornecedor", fornecedor);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					mapconfig.get("CONFIG-DIR_FORNECEDOR") + "/editar.jsp");
			rd.forward(req, res);
		} else {
			Messages.addMessage(Messages.WARNING,
					bundlePage.getString("msg_selecione_fornecedor_consultar"));
			consultar();
		}
	}
	
	private void consultar() throws ServletException, IOException {
		List<Fornecedor> listFornecedor = fornecedorBLL.consultar();
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setListFornecedor(listFornecedor);
		
		req.setAttribute("fornecedor", fornecedor);
		
		RequestDispatcher rd = req.getRequestDispatcher(mapconfig.get("CONFIG-DIR_FORNECEDOR") + "/consultar.jsp");
		rd.forward(req, res);
	}

	private void apagar() throws IOException, ServletException {
		String frr_id = req.getParameter("frr_id");
		
		if (Functions.isEmptyorNull(frr_id)) {
			String[] Afrr_id = req.getParameterValues("frr_id");
			if (Afrr_id != null && Afrr_id.length > 0) {
				frr_id = Afrr_id[0];
			}
		}

		if (frr_id != null) {
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setId(frr_id);
			
			if (fornecedorBLL.remover(fornecedor)) {
				Messages.addMessage(Messages.SUCCESS, bundleGlobal.getString("msg_deleted"));
				consultar();
			} else {
				Messages.addMessage(Messages.ERROR, bundleGlobal.getString("msg_not_deleted"));
				consultar();
			}
		}
	}

	private void atualizar() throws ServletException, IOException {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(req.getParameter("frr_id"));
		fornecedor.setNome_fantasia(req.getParameter("frr_nome_fantasia"));
		fornecedor.setRazao_social(req.getParameter("frr_razao_social"));
		fornecedor.setCnpj(req.getParameter("frr_cnpj"));
		fornecedor.setTelefone1(req.getParameter("frr_telefone1"));
		fornecedor.setRepresentante(req.getParameter("frr_representante"));
		fornecedor.setEmail(req.getParameter("frr_email"));
		fornecedor.setSite(req.getParameter("frr_site"));

		if (fornecedorBLL.alterar(fornecedor)) {
			Messages.addMessage(Messages.SUCCESS, bundleGlobal.getString("msg_updated"));
			res.sendRedirect(mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_FORNECEDOR") + "/");
		} else {
			Messages.addMessage(Messages.ERROR, bundleGlobal.getString("msg_not_updated"));
			req.setAttribute("fornecedor", fornecedor);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					mapconfig.get("CONFIG-DIR_FORNECEDOR") + "/editar.jsp");
			rd.forward(req, res);
		}
	}

	@Override
	protected void decideAction() throws ServletException {
		fornecedorBLL = new FornecedorBLL(Functions.getLocaleFromSession(req.getSession()));
		try {
			System.out.println("------------2"+getAcao());
			System.out.println("------------1"+bundlePage.getString("cadastrar"));
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
