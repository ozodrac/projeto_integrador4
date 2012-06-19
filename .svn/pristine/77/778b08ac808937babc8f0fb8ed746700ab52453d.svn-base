package br.com.shark.BLL;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import br.com.shark.DAO.ProdutoVendaDAO;
import br.com.shark.DAO.ProdutoVendaItemDAO;
import br.com.shark.TO.ProdutoVenda;
import br.com.shark.TO.ProdutoVendaItem;
import br.com.shark.messages.Messages;
import br.com.shark.util.I18N;

public class ProdutoVendaBLL {
	
	private ResourceBundle bundlePage;
	
	public ProdutoVendaBLL(Locale locale) {
		bundlePage = I18N.getBundle("venda", locale);
	}

	public boolean inserir(ProdutoVenda entidade) throws IllegalArgumentException {
		ProdutoVendaDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						bundlePage.getString("msg_objeto_nulo"));
			}
			
			if (entidade.getCliente() == null) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_cliente_obrigatorio"));
				return false;
			}
			if (entidade.getFormaPagamento() == null) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_formapagamento_obrigatorio"));
				return false;
			}
			if (entidade.getUser() == null) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_usuario_obrigatorio"));
				return false;
			}
			List<ProdutoVendaItem> listVendaItem = entidade.getListVendaItem();
			if (listVendaItem == null || listVendaItem.isEmpty()) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_item_obrigatorio"));
				return false;
			}

			dao = new ProdutoVendaDAO();
			if (! dao.inserir(entidade)) {
				return false;
			}
			int idVenda = lastInsertId();
			if (idVenda == 0) {
				return false;
			}
			
			boolean inserido = false;
			ProdutoVendaItemDAO itemDAO = new ProdutoVendaItemDAO();
			for (ProdutoVendaItem item : listVendaItem) {
				item.setProdutoVenda(new ProdutoVenda(idVenda));
				if (itemDAO.inserir(item)) {
					inserido = true;
				}
			}
			
			return inserido;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean alterar(ProdutoVenda entidade) throws IllegalArgumentException {
		ProdutoVendaDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						bundlePage.getString("msg_objeto_nulo"));
			}

			if (entidade.getId() <= 0) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_id_obrigatorio"));
				return false;
			}
			if (entidade.getCliente() == null) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_cliente_obrigatorio"));
				return false;
			}
			if (entidade.getFormaPagamento() == null) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_formapagamento_obrigatorio"));
				return false;
			}
			List<ProdutoVendaItem> listVendaItem = entidade.getListVendaItem();
			if (listVendaItem == null || listVendaItem.isEmpty()) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_item_obrigatorio"));
				return false;
			}

			dao = new ProdutoVendaDAO();
			if(! dao.alterar(entidade)) {
				return false;
			}

			boolean inserido = false;
			ProdutoVendaItemDAO itemDAO = new ProdutoVendaItemDAO();
			itemDAO.remover(entidade);
			for (ProdutoVendaItem item : listVendaItem) {
				item.setProdutoVenda(new ProdutoVenda(entidade.getId()));
				if (itemDAO.inserir(item)) {
					inserido = true;
				}
			}
			
			return inserido;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean remover(ProdutoVenda entidade) throws IllegalArgumentException {
		ProdutoVendaDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						bundlePage.getString("msg_objeto_nulo"));
			}
			if (entidade.getId() <= 0) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_id_obrigatorio"));
				return false;
			}

			ProdutoVendaItemDAO itemDAO = new ProdutoVendaItemDAO();
			itemDAO.remover(entidade);
			
			dao = new ProdutoVendaDAO();
			return dao.remover(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public ProdutoVenda consultar(ProdutoVenda entidade) throws IllegalArgumentException {
		ProdutoVendaDAO dao;
		try {
			if (entidade == null) {
				throw new IllegalArgumentException(
						bundlePage.getString("msg_objeto_nulo"));
			}
			if (entidade.getId() <= 0) {
				Messages.addMessage(Messages.WARNING, bundlePage.getString("msg_id_obrigatorio"));
				return null;
			}

			dao = new ProdutoVendaDAO();
			ProdutoVenda venda = dao.consultar(entidade);
			

			ProdutoVendaItemDAO itemDAO = new ProdutoVendaItemDAO();
			venda.setListVendaItem(itemDAO.consultar(venda));
			return venda;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<ProdutoVenda> consultar(int lingua) {
		ProdutoVendaDAO dao;
		try {
			dao = new ProdutoVendaDAO();
			return dao.consultar(lingua);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int lastInsertId() {
		ProdutoVendaDAO dao;
		try {
			dao = new ProdutoVendaDAO();
			return dao.lastInsertId();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
}
