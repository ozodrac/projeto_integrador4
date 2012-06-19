package br.com.shark.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.shark.TO.User;
import br.com.shark.util.Functions;
import br.com.shark.util.I18N;

@WebFilter({ "/", "*.jsp", "/user/*", "/login/*", "/produto/*", "/venda/*", "/cliente/*", "/fornecedor/*" })
public class Initializer implements Filter {

	protected FilterConfig filterConfig;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			String pageName = null;
			if (request instanceof HttpServletRequest) {
				HttpServletRequest httpRequest = (HttpServletRequest) request;
				if(httpRequest.getServletPath().endsWith(".js")){
					chain.doFilter(request, response);
					return;
				}

				// Get the session object.
				HttpSession session = httpRequest.getSession();
				Locale preferredlanguage = Functions.getLocaleFromSession(session);

				if (preferredlanguage == null) {
					preferredlanguage = httpRequest.getLocale();
					Functions.setLocaleToSession(session, preferredlanguage);
				}

				// If the user is signed in, we retrieve the information from the session and pass
				// it to the page.
				User user = Functions.getUserFromSession(session);
				request.setAttribute("user", user);

				pageName = Functions.extractPageNameFromURL(httpRequest.getServletPath());

				// The resource br.com.shark.bundle for the page.
				ResourceBundle bundlePage = I18N.getBundle(pageName, preferredlanguage);
				// Add the resource Bundle to the request so the JSP can have access to it.
				request.setAttribute("bundlePage", bundlePage);

				// The resource br.com.shark.bundle that contains shared information.
				ResourceBundle bundleGlobal = I18N.getBundle("global", preferredlanguage);
				// Add the resource Bundle to the request so the JSP can have access to it.
				request.setAttribute("bundleGlobal", bundleGlobal);

				// pass the request along the filter chain
				chain.doFilter(request, response);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			PrintWriter out = response.getWriter();
			out.print("SYSTEM FAILURE!");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}