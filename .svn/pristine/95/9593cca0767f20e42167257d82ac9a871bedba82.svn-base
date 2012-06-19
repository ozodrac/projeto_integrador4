package br.com.shark.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import br.com.shark.BLL.ClienteBLL;
import br.com.shark.BLL.FormaPagamentoBLL;
import br.com.shark.BLL.ProdutoBLL;
import br.com.shark.BLL.ProdutoVendaBLL;
import br.com.shark.TO.Cliente;
import br.com.shark.TO.FormaPagamento;
import br.com.shark.TO.Produto;
import br.com.shark.TO.ProdutoVenda;
import br.com.shark.TO.ProdutoVendaItem;
import br.com.shark.messages.Messages;
import br.com.shark.util.Functions;

/**
 * Servlet implementation class VendaServlet
 */
@WebServlet("/venda/")
public class VendaServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private ProdutoVendaBLL produtoVendaBLL;

	public VendaServlet() {
		super();
	}

	private void novo() throws IOException, ServletException {
		adicionarProduto();
		adicionarFormaPagamento();
		adicionarCliente();
		RequestDispatcher rd = req.getRequestDispatcher(mapconfig.get("CONFIG-DIR_VENDA")
				+ "/novo.jsp");
		rd.forward(req, res);
	}

	private void cadastrar() throws IOException, ServletException {
		ProdutoVenda venda = new ProdutoVenda();
		venda.setUser(Functions.getUserFromSession(req.getSession()));
		venda.setCliente(new Cliente(req.getParameter("cle_id")));
		venda.setFormaPagamento(new FormaPagamento(req.getParameter("fro_id")));
		venda.setListVendaItem(gerarListaItens());
		
		System.out.println(venda.toString());
		if (produtoVendaBLL.inserir(venda)) {
			Messages.addMessage(Messages.SUCCESS, bundleGlobal.getString("msg_saved"));
			consultar();
		} else {
			Messages.addMessage(Messages.ERROR, bundleGlobal.getString("msg_not_saved"));
			novo();
		}
	}

	private void editar() throws IOException, ServletException {
		String prd_id = req.getParameter("prd_id");
		
		if (Functions.isEmptyorNull(prd_id)) {
			String[] Aprd_id = req.getParameterValues("prd_id");
			if (Aprd_id != null && Aprd_id.length > 0) {
				prd_id = Aprd_id[0];
			}
		}
		
		if (prd_id != null) {
			adicionarProduto();
			adicionarFormaPagamento();
			adicionarCliente();
			ProdutoVenda venda = new ProdutoVenda();
			venda.setId(prd_id);
			
			venda = produtoVendaBLL.consultar(venda);

			req.setAttribute("venda", venda);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					mapconfig.get("CONFIG-DIR_VENDA") + "/editar.jsp");
			rd.forward(req, res);
		} else {
			Messages.addMessage(Messages.WARNING,
					bundlePage.getString("msg_selecione_venda_consultar"));
			consultar();
		}
	}
	
	private void consultar() throws ServletException, IOException {
		List<ProdutoVenda> listVenda = produtoVendaBLL.consultar(Functions.getEnumLinguaFromSession(req.getSession()).getId());
		
		ProdutoVenda venda = new ProdutoVenda();
		venda.setListVenda(listVenda);
		
		req.setAttribute("venda", venda);
		
		RequestDispatcher rd = req.getRequestDispatcher(mapconfig.get("CONFIG-DIR_VENDA") + "/consultar.jsp");
		rd.forward(req, res);
	}

	private void apagar() throws IOException, ServletException {
		String prd_id = req.getParameter("prd_id");
		
		if (Functions.isEmptyorNull(prd_id)) {
			String[] Aprd_id = req.getParameterValues("prd_id");
			if (Aprd_id != null && Aprd_id.length > 0) {
				prd_id = Aprd_id[0];
			}
		}

		if (prd_id != null) {
			ProdutoVenda venda = new ProdutoVenda();
			venda.setId(prd_id);
			
			if (produtoVendaBLL.remover(venda)) {
				Messages.addMessage(Messages.SUCCESS, bundleGlobal.getString("msg_deleted"));
				consultar();
			} else {
				Messages.addMessage(Messages.ERROR, bundleGlobal.getString("msg_not_deleted"));
				consultar();
			}
		}
	}

	private void atualizar() throws ServletException, IOException {
		ProdutoVenda venda = new ProdutoVenda();
		venda.setId(req.getParameter("prd_id"));
		venda.setCliente(new Cliente(req.getParameter("cle_id")));
		venda.setFormaPagamento(new FormaPagamento(req.getParameter("fro_id")));
		venda.setListVendaItem(gerarListaItens());

		if (produtoVendaBLL.alterar(venda)) {
			Messages.addMessage(Messages.SUCCESS, bundleGlobal.getString("msg_updated"));
			res.sendRedirect(mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_VENDA") + "/");
		} else {
			Messages.addMessage(Messages.ERROR, bundleGlobal.getString("msg_not_updated"));
			req.setAttribute("venda", venda);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					mapconfig.get("CONFIG-DIR_VENDA") + "/editar.jsp");
			rd.forward(req, res);
		}
	}

	protected void decideAction() throws ServletException {
		produtoVendaBLL = new ProdutoVendaBLL(Functions.getLocaleFromSession(req.getSession()));
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
	
	private List<ProdutoVendaItem> gerarListaItens() {
		List<ProdutoVendaItem> listItem = new ArrayList<ProdutoVendaItem>();
		
		String[] Aproduto = req.getParameterValues("pro_id");
		String[] Aquantidade = req.getParameterValues("prm_quantidade");
		String[] Avalor = req.getParameterValues("prm_valor");
		
		int count = Aproduto.length;
		for (int i = 0; i < count; i++) {
			ProdutoVendaItem item = new ProdutoVendaItem();
			item.setProduto(new Produto(Aproduto[i]));
			item.setQuantidade(Aquantidade[i]);
			item.setValor(Avalor[i]);
			
			listItem.add(item);
		}
		
		return listItem;
	}

	private void adicionarProduto() {
		ProdutoBLL bll = new ProdutoBLL(Functions.getLocaleFromSession(req.getSession()));
		List<Produto> listProduto = bll.consultar(Functions.getEnumLinguaFromSession(req.getSession()).getId());
		req.setAttribute("listProduto", listProduto);
	}

	private void adicionarFormaPagamento() {
		FormaPagamentoBLL bll = new FormaPagamentoBLL();
		List<FormaPagamento> listFormaPagamento = bll.consultar(Functions.getEnumLinguaFromSession(req.getSession()).getId());
		req.setAttribute("listFormaPagamento", listFormaPagamento);
	}

	private void adicionarCliente() {
		ClienteBLL bll = new ClienteBLL(Functions.getLocaleFromSession(req.getSession()));
		List<Cliente> listCliente = bll.consultar();
		req.setAttribute("listCliente", listCliente);
	}
	
}
