package br.com.shark.TO;

import br.com.shark.util.Functions;

public class ProdutoVendaItem {

	private Produto produto;
	private ProdutoVenda produtoVenda;
	private int quantidade;
	private float valor;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public ProdutoVenda getProdutoVenda() {
		return produtoVenda;
	}
	public void setProdutoVenda(ProdutoVenda produtoVenda) {
		this.produtoVenda = produtoVenda;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public void setQuantidade(String quantidade) {
		if(!Functions.isEmptyorNull(quantidade)){
			setQuantidade(Integer.parseInt(quantidade));
		}
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public void setValor(String valor) {
		if(!Functions.isEmptyorNull(valor)){
			setValor(Float.parseFloat(valor));
		}
	}
}
