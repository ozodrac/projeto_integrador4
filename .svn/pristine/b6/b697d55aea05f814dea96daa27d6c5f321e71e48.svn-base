package br.com.shark.enumeration;

import br.com.shark.util.Functions;

/**
 * Enumeração que controla se o animal come carne ou não. <br/>
 * Ex: 'S' - Sim e 'N' - Não.
 * 
 * @author Luciano Sampaio
 * @version 1.0
 */
public enum EnumSimNao {
	SIM('Y', "Sim"), NAO('N', "Não");

	private char opcao;
	private String nomeExibicao;

	private EnumSimNao(char opcao, String nomeExibicao) {
		setOpcao(opcao);
		setNomeExibicao(nomeExibicao);
	}

	public char getOpcao() {
		return opcao;
	}

	public void setOpcao(char opcao) {
		this.opcao = opcao;
	}

	public void setOpcao(String opcao) {
		if (!Functions.isEmptyorNull(opcao)) {
			setOpcao(opcao.charAt(0));
		}
	}

	public String getNomeExibicao() {
		return nomeExibicao;
	}

	public void setNomeExibicao(String nomeExibicao) {
		this.nomeExibicao = nomeExibicao;
	}

	@Override
	public String toString() {
		return String.valueOf(getOpcao());
	}

	public static EnumSimNao getEnumFromString(String value) {
		if (Functions.isEmptyorNull(value)) {
			return null;
		}
		for (EnumSimNao opcao : values()) {
			if (opcao.getOpcao() == value.charAt(0)) {
				return opcao;
			}
		}

		return null;
	}
}
