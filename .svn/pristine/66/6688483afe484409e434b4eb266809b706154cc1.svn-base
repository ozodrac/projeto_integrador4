package br.com.shark.enumeration;

import java.util.Locale;

import br.com.shark.util.Functions;

public enum EnumLingua {
	Português (1, "Português", new Locale("pt", "BR")), Inglês (2, "English", new Locale("en", "US"));
	
	private int id;
	private String nome;
	private Locale locale;
	
	private EnumLingua(int id, String nome, Locale locale) {
		this.id = id;
		this.nome = nome;
		this.locale = locale;
	}
	
	public Locale getLocale() {
		return locale;
	}

	public int getId() {
		return id;
	}

	public String getNomeExibicao() {
		return nome;
	}
	
	public static EnumLingua getEnum(String id) {
		if (!Functions.isEmptyorNull(id)){
			return getEnum(Integer.parseInt(id));
		}
		return null;
	}
	
	public static EnumLingua getEnum(int id) {
		for (EnumLingua e : values()) {
			if (e.getId() == id){
				return e;
			}
		}
		return null;
	}
	
	public static EnumLingua getEnumFromLocale(Locale locale) {
		for (EnumLingua e : values()) {
			if (e.getLocale().getLanguage().equals(locale.getLanguage()) && e.getLocale().getCountry().equals(locale.getCountry())) {
				return e;
			}
		}
		return null;
	}

}
