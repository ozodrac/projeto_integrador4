package br.com.shark.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import br.com.shark.BLL.FornecedorBLL;
import br.com.shark.BLL.ProdutoBLL;
import br.com.shark.BLL.ProdutoCategoriaBLL;
import br.com.shark.TO.Fornecedor;
import br.com.shark.TO.Produto;
import br.com.shark.TO.ProdutoCategoria;
import br.com.shark.messages.Messages;
import br.com.shark.util.Functions;

/**
 * Servlet implementation class ProdutoServlet
 */
@WebServlet("/produto/")
public class ProdutoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private ProdutoBLL produtoBLL;

	public ProdutoServlet() {
		super();
	}

	private void novo() throws IOException, ServletException {
		adicionarCategoria();
		adicionarFornecedor();
		RequestDispatcher rd = req.getRequestDispatcher(mapconfig.get("CONFIG-DIR_PRODUTO")
				+ "/novo.jsp");
		rd.forward(req, res);
	}

	private void cadastrar() throws IOException, ServletException {
		Produto produto = new Produto();
		produto.setFornecedor(new Fornecedor(req.getParameter("frr_id")));
		produto.setCategoria(new ProdutoCategoria(req.getParameter("pra_id")));
		produto.setDescricao(req.getParameter("pro_descricao"));
		produto.setMarca(req.getParameter("pro_marca"));
		produto.setValor_compra(req.getParameter("pro_valor_compra"));
		produto.setValor_venda_avista(req.getParameter("pro_valor_venda_avista"));
		produto.setValor_venda_prazo(req.getParameter("pro_valor_venda_prazo"));
		produto.setGarantia(req.getParameter("pro_garantia"));
		produto.setQuantidade(req.getParameter("pro_quantidade"));

		if (produtoBLL.inserir(produto)) {
			Messages.addMessage(Messages.SUCCESS, bundleGlobal.getString("msg_saved"));
			consultar();
		} else {
			Messages.addMessage(Messages.ERROR, bundleGlobal.getString("msg_not_saved"));
			novo();
		}
	}

	private void editar() throws IOException, ServletException {
		String pro_id = req.getParameter("pro_id");
		
		if (Functions.isEmptyorNull(pro_id)) {
			String[] Apro_id = req.getParameterValues("pro_id");
			if (Apro_id != null && Apro_id.length > 0) {
				pro_id = Apro_id[0];
			}
		}
		
		if (pro_id != null) {
			adicionarCategoria();
			adicionarFornecedor();
			Produto produto = new Produto();
			produto.setId(pro_id);
			
			produto = produtoBLL.consultar(produto);

			req.setAttribute("produto", produto);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					mapconfig.get("CONFIG-DIR_PRODUTO") + "/editar.jsp");
			rd.forward(req, res);
		} else {
			Messages.addMessage(Messages.WARNING,
					bundlePage.getString("msg_selecione_produto_consultar"));
			consultar();
		}
	}
	
	private void consultar() throws ServletException, IOException {
		List<Produto> listProduto = produtoBLL.consultar(Functions.getEnumLinguaFromSession(req.getSession()).getId());
		
		Produto produto = new Produto();
		produto.setListProduto(listProduto);
		
		req.setAttribute("produto", produto);
		
		RequestDispatcher rd = req.getRequestDispatcher(mapconfig.get("CONFIG-DIR_PRODUTO") + "/consultar.jsp");
		rd.forward(req, res);
	}

	private void apagar() throws IOException, ServletException {
		String pro_id = req.getParameter("pro_id");
		
		if (Functions.isEmptyorNull(pro_id)) {
			String[] Apro_id = req.getParameterValues("pro_id");
			if (Apro_id != null && Apro_id.length > 0) {
				pro_id = Apro_id[0];
			}
		}

		if (pro_id != null) {
			Produto produto = new Produto();
			produto.setId(pro_id);
			
			if (produtoBLL.remover(produto)) {
				Messages.addMessage(Messages.SUCCESS, bundleGlobal.getString("msg_deleted"));
				consultar();
			} else {
				Messages.addMessage(Messages.ERROR, bundleGlobal.getString("msg_not_deleted"));
				consultar();
			}
		}
	}

	private void atualizar() throws ServletException, IOException {
		Produto produto = new Produto();
		produto.setId(req.getParameter("pro_id"));
		produto.setFornecedor(new Fornecedor(req.getParameter("frr_id")));
		produto.setCategoria(new ProdutoCategoria(req.getParameter("pra_id")));
		produto.setDescricao(req.getParameter("pro_descricao"));
		produto.setMarca(req.getParameter("pro_marca"));
		produto.setValor_compra(req.getParameter("pro_valor_compra"));
		produto.setValor_venda_avista(req.getParameter("pro_valor_venda_avista"));
		produto.setValor_venda_prazo(req.getParameter("pro_valor_venda_prazo"));
		produto.setGarantia(req.getParameter("pro_garantia"));
		produto.setQuantidade(req.getParameter("pro_quantidade"));

		if (produtoBLL.alterar(produto)) {
			Messages.addMessage(Messages.SUCCESS, bundleGlobal.getString("msg_updated"));
			res.sendRedirect(mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_PRODUTO") + "/");
		} else {
			Messages.addMessage(Messages.ERROR, bundleGlobal.getString("msg_not_updated"));
			req.setAttribute("produto", produto);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					mapconfig.get("CONFIG-DIR_PRODUTO") + "/editar.jsp");
			rd.forward(req, res);
		}
	}

	@Override
	protected void decideAction() throws ServletException {
		produtoBLL = new ProdutoBLL(Functions.getLocaleFromSession(req.getSession()));
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

	private void adicionarCategoria() {
		ProdutoCategoriaBLL bll = new ProdutoCategoriaBLL();
		List<ProdutoCategoria> listProdutoCategoria = bll.consultar(Functions.getEnumLinguaFromSession(req.getSession()).getId());
		req.setAttribute("listProdutoCategoria", listProdutoCategoria);
	}
	
	private void adicionarFornecedor() {
		FornecedorBLL bll = new FornecedorBLL();
		List<Fornecedor> listFornecedor = bll.consultar();
		req.setAttribute("listFornecedor", listFornecedor);
	}
	
}
