package br.com.shark.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.shark.TO.User;
import br.com.shark.XML.MapConfig;
import br.com.shark.util.Functions;

/**
 * Servlet Filter implementation class LogadoFilter
 */
@WebFilter(description = "Filtro que verifica se o usuário está logado", 
	urlPatterns = {"/produto/*", "/home/*", "/user/*", "/", "/venda/*", "/cliente/*"})
public class LogadoFilter implements Filter {
	
	private HttpSession sessao;
	private HttpServletResponse res;

	/**
	 * Default constructor.
	 */
	public LogadoFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		if(request instanceof HttpServletRequest){
			HttpServletRequest req = (HttpServletRequest) request;
			setSessao(req.getSession());
		}
		if(response instanceof HttpServletResponse){
			setRes((HttpServletResponse) response);
		}

		if(validarSessao()){
			chain.doFilter(request, response);
		} else {
			getRes().sendRedirect(MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_LOGIN"));
		}
	}

	private boolean validarSessao() throws IOException {
		User user = Functions.getUserFromSession(getSessao());
		return user != null;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	private HttpSession getSessao() {
		return sessao;
	}

	private void setSessao(HttpSession sessao) {
		this.sessao = sessao;
	}

	private HttpServletResponse getRes() {
		return res;
	}

	private void setRes(HttpServletResponse res) {
		this.res = res;
	}

}
