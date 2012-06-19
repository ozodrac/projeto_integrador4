package br.com.shark.enumeration;

import java.util.Locale;
import java.util.ResourceBundle;

import br.com.shark.util.Functions;
import br.com.shark.util.I18N;

/**
 * Enumeração que controla os possíveis tipos de SEXO. <br/>
 * Ex: 'M' - Masculino e 'F' - Feminino.
 * 
 * @author Luciano Sampaio
 * @version 1.0
 */
public enum EnumSexo {
	MASCULINO('M', "Masculino"), FEMININO('F', "Feminino");

	private char sexo;
	private String nomeExibicao;

	private EnumSexo(char sexo, String nomeExibicao) {
		setSexo(sexo);
		setNomeExibicao(nomeExibicao);
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void setSexo(String sexo) {
		if (!Functions.isEmptyorNull(sexo)) {
			setSexo(sexo.charAt(0));
		}
	}

	public String getNomeExibicao() {
		return nomeExibicao;
	}
	
	public String getNomeExibicao(Locale locale) {
		ResourceBundle bundleGlobal = I18N.getBundle("global", locale);
		return bundleGlobal.getString("sexo_" + sexo);
	}

	public void setNomeExibicao(String nomeExibicao) {
		this.nomeExibicao = nomeExibicao;
	}

	@Override
	public String toString() {
		return String.valueOf(getSexo());
	}

	public static EnumSexo getEnumFromString(String value) {
		if (Functions.isEmptyorNull(value)) {
			return null;
		}
		for (EnumSexo sexo : values()) {
			if (sexo.getSexo() == value.charAt(0)) {
				return sexo;
			}
		}

		return null;
	}
}

