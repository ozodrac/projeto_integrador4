package br.com.shark.TO;

import br.com.shark.util.Functions;

public class Fornecedor {
	
	public Fornecedor(){}
	public Fornecedor(int id) {
		setId(id);
	}
	public Fornecedor(String id){
		setId(id);
	}
	

	private int id;
	private String nome;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setId(String id) {
		if (! Functions.isEmptyorNull(id)){
			setId(Integer.parseInt(id));
		}
	}
	
	
}
