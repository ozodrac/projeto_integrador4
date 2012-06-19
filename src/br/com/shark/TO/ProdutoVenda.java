package br.com.shark.TO;

import java.util.Date;
import java.util.List;

import br.com.shark.util.Functions;

public class ProdutoVenda {

	private int id;
	private User user;
	private Cliente cliente;
	private FormaPagamento formaPagamento;
	private Date dataCadastro;
	
	public List<ProdutoVenda> listVenda;
	public List<ProdutoVendaItem> listVendaItem;
	
	public List<ProdutoVendaItem> getListVendaItem() {
		return listVendaItem;
	}
	public void setListVendaItem(List<ProdutoVendaItem> listVendaItem) {
		this.listVendaItem = listVendaItem;
	}
	public List<ProdutoVenda> getListVenda() {
		return listVenda;
	}
	public void setListVenda(List<ProdutoVenda> listVenda) {
		this.listVenda = listVenda;
	}
	public ProdutoVenda(){}
	public ProdutoVenda(int id) {
		setId(id);
	}
	public ProdutoVenda(String id) {
		setId(id);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId(String id) {
		if (! Functions.isEmptyorNull(id)) {
			setId(Integer.parseInt(id));
		}
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public String getDataCadastroFormatada() {
		return Functions.converterDate(getDataCadastro());
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
