package br.com.shark.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.shark.XML.Map;
import br.com.shark.XML.MapConfig;

/**
 * Classe base para todos os servlets
 * @author Jayson
 *
 */
abstract class BaseServlet extends HttpServlet {

	protected static final long serialVersionUID = 1L;
	protected Map mapconfig;
	protected HttpServletRequest req;
	protected HttpServletResponse res;
	protected String acao;
	protected ResourceBundle bundlePage, bundleGlobal;

	public BaseServlet() {
		super();
		mapconfig = MapConfig.getInstance();
	}

	protected void service(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		this.req = req;
		this.res = res;
		bundlePage = (ResourceBundle) req.getAttribute("bundlePage");
		bundleGlobal = (ResourceBundle) req.getAttribute("bundleGlobal");
		try {
			this.handleData();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	protected void handleData() throws ServletException, ParseException{
		setAcao(req.getParameter("acao"));
		decideAction();
	}
	
	protected abstract void decideAction() throws ServletException, ParseException;

	protected String getAcao() {
		return acao;
	}

	protected void setAcao(String acao) {
		this.acao = acao;
	}
}
