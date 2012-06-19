package br.com.shark.TO;

import br.com.shark.util.Functions;

public class PerfilUsuario {

	public PerfilUsuario(){}
	public PerfilUsuario(int id) {
		setId(id);
	}
	public PerfilUsuario(String id) {
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
	public void setId(String id) {
		if (! Functions.isEmptyorNull(id)) {
			this.setId(Integer.parseInt(id));
		}
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
