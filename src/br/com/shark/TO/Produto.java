package br.com.shark.TO;

import java.util.List;

import br.com.shark.util.Functions;

public class Produto {

	private int id;
	private Fornecedor fornecedor;
	private ProdutoCategoria categoria;
	private String descricao, marca;
	private float valor_compra, valor_venda_avista, valor_venda_prazo;
	private int garantia, quantidade;
	
	private List<Produto> listProduto;
	
	public Produto(){}
	public Produto(int id) {
		setId(id);
	}
	public Produto(String id) {
		setId(id);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId(String id) {
		if(! Functions.isEmptyorNull(id)){
			setId(Integer.parseInt(id));
		}
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public ProdutoCategoria getCategoria() {
		return categoria;
	}
	public void setCategoria(ProdutoCategoria categoria) {
		this.categoria = categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public float getValor_compra() {
		return valor_compra;
	}
	public void setValor_compra(float valor_compra) {
		this.valor_compra = valor_compra;
	}
	public void setValor_compra(String valor_compra) {
		if(! Functions.isEmptyorNull(valor_compra)){
			setValor_compra(Float.parseFloat(valor_compra));
		}
	}
	public float getValor_venda_avista() {
		return valor_venda_avista;
	}
	public void setValor_venda_avista(float valor_venda_avista) {
		this.valor_venda_avista = valor_venda_avista;
	}
	public void setValor_venda_avista(String valor_venda_avista) {
		if(! Functions.isEmptyorNull(valor_venda_avista)){
			setValor_venda_avista(Float.parseFloat(valor_venda_avista));
		}
	}
	public float getValor_venda_prazo() {
		return valor_venda_prazo;
	}
	public void setValor_venda_prazo(float valor_venda_prazo) {
		this.valor_venda_prazo = valor_venda_prazo;
	}
	public void setValor_venda_prazo(String valor_venda_prazo) {
		if(! Functions.isEmptyorNull(valor_venda_prazo)){
			setValor_venda_prazo(Float.parseFloat(valor_venda_prazo));
		}
	}
	public int getGarantia() {
		return garantia;
	}
	public void setGarantia(int garantia) {
		this.garantia = garantia;
	}
	public void setGarantia(String garantia) {
		if(! Functions.isEmptyorNull(garantia)){
			setGarantia(Integer.parseInt(garantia));
		}
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public void setQuantidade(String quantidade) {
		if(! Functions.isEmptyorNull(quantidade)){
			setQuantidade(Integer.parseInt(quantidade));
		}
	}
	public List<Produto> getListProduto() {
		return listProduto;
	}
	public void setListProduto(List<Produto> listProduto) {
		this.listProduto = listProduto;
	}
	
	
}
