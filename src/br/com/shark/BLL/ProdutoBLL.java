package br.com.shark.BLL;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import br.com.shark.DAO.ProdutoDAO;
import br.com.shark.TO.Produto;
import br.com.shark.messages.Messages;
import br.com.shark.util.Functions;
import br.com.shark.util.I18N;

public class ProdutoBLL {
	
	private ResourceBundle bundlePage;
	
	public ProdutoBLL(Locale locale) {
		bundlePage = I18N.getBundle("produto", locale);
	}

	public boolean inserir(Produto entidade) throws IllegalArgumentException {
		ProdutoDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						bundlePage.getString("msg_objeto_nulo"));
			}
			
			if (Functions.isEmptyorNull(entidade.getDescricao())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_descricao_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getMarca())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_marca_obrigatorio"));
				return false;
			}
			if (entidade.getCategoria() == null) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_categoria_obrigatorio"));
				return false;
			}
			if (entidade.getFornecedor() == null) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_fornecedor_obrigatorio"));
				return false;
			}

			dao = new ProdutoDAO();
			return dao.inserir(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean alterar(Produto entidade) throws IllegalArgumentException {
		ProdutoDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						bundlePage.getString("msg_objeto_nulo"));
			}

			if (entidade.getId() <= 0) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_id_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getDescricao())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_descricao_obrigatorio"));
				return false;
			}
			if (Functions.isEmptyorNull(entidade.getMarca())) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_marca_obrigatorio"));
				return false;
			}
			if (entidade.getCategoria() == null) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_categoria_obrigatorio"));
				return false;
			}
			if (entidade.getFornecedor() == null) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_fornecedor_obrigatorio"));
				return false;
			}

			dao = new ProdutoDAO();
			return dao.alterar(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean remover(Produto entidade) throws IllegalArgumentException {
		ProdutoDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						bundlePage.getString("msg_objeto_nulo"));
			}
			if (entidade.getId() <= 0) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_id_obrigatorio"));
				return false;
			}

			dao = new ProdutoDAO();
			return dao.remover(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public Produto consultar(Produto entidade) throws IllegalArgumentException {
		ProdutoDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						bundlePage.getString("msg_objeto_nulo"));
			}
			if (entidade.getId() <= 0) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_id_obrigatorio"));
				return null;
			}

			dao = new ProdutoDAO();
			return dao.consultar(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public List<Produto> consultar(int lingua) {
		ProdutoDAO dao;
		try {
			dao = new ProdutoDAO();
			return dao.consultar(lingua);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
