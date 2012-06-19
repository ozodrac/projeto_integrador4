package br.com.shark.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import br.com.shark.TO.User;
import br.com.shark.enumeration.EnumLingua;

public class Functions {

	private static final String LAYOUT_DATA = "dd/MM/yyyy";
	private static final String PREFERRED_LANGUAGE = "PREFERRED_LANGUAGE";
	private static final String USER_ID = "USER_ID";
	private static final String USER_NOME = "USER_NOME";

	/**
	 * @param value
	 * @return Verificar se o valor passado como parâmetro é null ou vazio.
	 */
	public static boolean isEmptyorNull(String value) {
		return ((value == null) || ("".equals(value))) ? true : false;
	}

	public static String readFileToString(File inputfile) {
		BufferedReader reader;
		StringBuilder sb = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(inputfile));
			String line = null;
			String ls = System.getProperty("line.separator");

			while ((line = reader.readLine()) != null) {
				sb.append(line).append(ls);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

	private static DateFormat getSimpleDateFormat() {
		// Defino o layout.
		return new SimpleDateFormat(LAYOUT_DATA);
	}

	public static Date converterDate(java.sql.Date date) throws ParseException {
		DateFormat formatter = getSimpleDateFormat();

		// For a data que veio do banco de dados e com o layout proprio dele no
		// meu layout.
		String stringData = formatter.format(date);

		// Converto a string no formato correto para um objeto do tipo Date.
		return formatter.parse(stringData);
	}

	public static String converterDate(Date dataNascimento) {
		DateFormat formatter = getSimpleDateFormat();

		// For a data que veio do banco de dados e com o layout proprio dele no
		// meu layout.
		return formatter.format(dataNascimento);
	}

	public static Date converterDate(String dataNascimento) {
		DateFormat formatter = getSimpleDateFormat();

		// Converto a string no formato correto para um objeto do tipo Date.
		try {
			return formatter.parse(dataNascimento);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static String formatarTelefone(String telefone) {
		return telefone.replace(' ', Character.MIN_VALUE)
				.replace('(', Character.MIN_VALUE)
				.replace(')', Character.MIN_VALUE)
				.replace('-', Character.MIN_VALUE);
	}

	/**
	 * It extracts the page name from the url given as a parameters.
	 * 
	 * @param url
	 *            The requested url.
	 * @return The page name of the requested url.
	 */
	public static String extractPageNameFromURL(String url) {
		if(url.lastIndexOf("/") > 0){
			return url.substring(1, url.lastIndexOf("/"));
		} else{
			String pageName = url.substring(1, url.indexOf("."));
			return pageName.replace('/', '_');
		}
	}

	/**
	 * @param session
	 * @return
	 */
	public static Locale getLocaleFromSession(HttpSession session) {
		return (Locale) session.getAttribute(PREFERRED_LANGUAGE);
	}

	/**
	 * @param session
	 * @return
	 */
	public static void setLocaleToSession(HttpSession session, Locale locale) {
		session.setAttribute(PREFERRED_LANGUAGE, locale);
	}

	/**
	 * @param session
	 * @return
	 */
	public static User getUserFromSession(HttpSession session) {
		Object userId = session.getAttribute(USER_ID);
		Object userName = session.getAttribute(USER_NOME);

		if ((userId != null) && (userName != null)) {
			User user = new User();
			user.setId((Integer) userId);
			user.setNome((String) userName);
			return user;
		} else {
			return null;
		}
	}

	/**
	 * @param session
	 * @return
	 */
	public static void setUserToSession(HttpSession session, User user) {
		session.setAttribute(USER_ID, user.getId());
		session.setAttribute(USER_NOME, user.getNome());
	}

	public static EnumLingua getEnumLinguaFromSession(HttpSession session) {
		return EnumLingua.getEnumFromLocale(getLocaleFromSession(session));
	}
	
	/**
	 * @param session
	 */
	public static void signOut(HttpSession session) {
		session.removeAttribute(PREFERRED_LANGUAGE);
		session.removeAttribute(USER_ID);
		session.removeAttribute(USER_NOME);
		session.invalidate();
	}

}
