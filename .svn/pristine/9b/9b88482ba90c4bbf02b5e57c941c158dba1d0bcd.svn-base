/**
 * 
 */
package br.com.shark.messages;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por renderizar mensagens para o usuário 
 * 
 * @author Jayson
 */
public class Messages {
	
	public static final byte SUCCESS = 1;
	public static final byte ERROR = 2;
	public static final byte INFO = 3;
	public static final byte WARNING = 4;
	
	public static List<String> messages = new ArrayList<String>();
	
	public static void addMessage(byte tipo, String mensagem) {
		switch (tipo) {
			case SUCCESS:
				messages.add("<div class='formee-msg-success'><a href='#' title='Fechar'>" + mensagem + "</a></div>");
				break;
			case ERROR:
				messages.add("<div class='formee-msg-error'><a href='#' title='Fechar'>" + mensagem + "</a></div>");
				break;
			case INFO:
				messages.add("<div class='formee-msg-info'><a href='#' title='Fechar'>" + mensagem + "</a></div>");
				break;
			case WARNING:
				messages.add("<div class='formee-msg-warning'><a href='#' title='Fechar'>" + mensagem + "</a></div>");
				break;
		}
	}
	
	public static String render() {
		String html = "";
		if(!messages.isEmpty()){
			html = "<div class='panel-msgs'>";
			for (String mensagem : messages) {
				html += mensagem;
			}
			html += "</div>";
			messages.clear();
		}
		return html;
	}
}
