package br.com.shark.TO;


import java.util.List;


import br.com.shark.util.Functions;

public class Fornecedor {
	
	private int id;
	private String nome_fantasia, cnpj, telefone1;
	private String razao_social, representante, email, site;

	private List<Fornecedor> listFornecedor;

	public Fornecedor() {
	}

	public Fornecedor(int id) {
		setId(id);
	}

	public Fornecedor(String id) {
		setId(id);
	}

	public Fornecedor(int id, String nome_fantasia) {
		setId(id);
		setNome_fantasia(nome_fantasia);
	}

	public List<Fornecedor> getlistFornecedor() {
		return listFornecedor;
	}

	public void setlistFornecedor(List<Fornecedor> listFornecedor) {
		this.listFornecedor = listFornecedor;
	}

	public int getId() {
		return id;
	}

	public void setId(String id) {
		if (!Functions.isEmptyorNull(id)) {
			setId(Integer.parseInt(id));
		}
	}

	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getRazao_social() {
		return razao_social;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Fornecedor> getListFornecedor() {
		return listFornecedor;
	}

	public void setListFornecedor(List<Fornecedor> listFornecedor) {
		this.listFornecedor = listFornecedor;
	}

	
	
	
}
