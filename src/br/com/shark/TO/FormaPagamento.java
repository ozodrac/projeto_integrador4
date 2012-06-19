package br.com.shark.TO;

import br.com.shark.util.Functions;

public class FormaPagamento {

	private int id;
	private String nome;
	
	public FormaPagamento(){}
	public FormaPagamento(int id) {
		setId(id);
	}
	public FormaPagamento(String id) {
		setId(id);
	}
	
	public FormaPagamento(int id, String nome) {
		setId(id);
		setNome(nome);
	}
	public int getId() {
		return id;
	}
	public void setId(String id) {
		if (!Functions.isEmptyorNull(id)) {
			setId(Integer.parseInt(id));
		}
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
	
}
