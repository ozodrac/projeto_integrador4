package br.com.shark.TO;

import java.util.Date;
import java.util.List;

import br.com.shark.enumeration.EnumSexo;
import br.com.shark.util.Functions;

public class Cliente {

	private int id;
	private String nome, cpf, telefoneCelular;
	private EnumSexo sexo;
	private Date dataNascimento;
	private String email, telefoneResidencial, telefoneComercial, endereco;

	private List<Cliente> listCliente;

	public Cliente() {
	}

	public Cliente(int id) {
		setId(id);
	}

	public Cliente(String id) {
		setId(id);
	}

	public Cliente(int id, String nome) {
		setId(id);
		setNome(nome);
	}

	public List<Cliente> getListCliente() {
		return listCliente;
	}

	public void setListCliente(List<Cliente> listCliente) {
		this.listCliente = listCliente;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public EnumSexo getSexo() {
		return sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public void setSexo(String sexo) {
		setSexo(EnumSexo.getEnumFromString(sexo));
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getDataNascimentoFormatada() {
		if(getDataNascimento() != null){
			return Functions.converterDate(getDataNascimento());
		}
		return "";
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		if (!Functions.isEmptyorNull(dataNascimento)) {
			setDataNascimento(Functions.converterDate(dataNascimento));
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
