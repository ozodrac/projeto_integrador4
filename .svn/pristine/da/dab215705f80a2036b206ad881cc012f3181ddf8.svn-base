package br.com.shark.TO;

import java.util.Date;
import java.util.List;

import br.com.shark.enumeration.EnumLingua;
import br.com.shark.util.Functions;

public class User {

	private int id;
	private PerfilUsuario perfil;
	private String nome;
	private String login;
	private String senha;
	private String email;
	private String cpf;
	private Date dt_cadastro;
	private EnumLingua lingua;
	
	private List<User> listUser;
	
	public User(){}
	public User(int id) {
		setId(id);
	}


	public User(int id, String nome) {
		setId(id);
		setNome(nome);
	}
	public PerfilUsuario getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilUsuario perfil) {
		this.perfil = perfil;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setId(String id) {
		if (!Functions.isEmptyorNull(id)){
			this.id = Integer.parseInt(id);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDt_cadastro() {
		return dt_cadastro;
	}

	public void setDt_cadastro(Date dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}

	public void setDt_cadastro(String dt_cadastro) {
		this.dt_cadastro = Functions.converterDate(dt_cadastro);
	}

	public EnumLingua getLingua() {
		return lingua;
	}

	public void setLingua(int lingua) {
		this.lingua = EnumLingua.getEnum(lingua);
	}
	
	public void setLingua(String lingua) {
		this.lingua = EnumLingua.getEnum(lingua);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}
	

}
