<%@page import="java.util.ResourceBundle"%>
<%@page import="br.com.shark.XML.Map"%>
<%@page import="br.com.shark.XML.MapConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Map mapconfig = MapConfig.getInstance();
ResourceBundle bundleGlobal = (ResourceBundle) request.getAttribute("bundleGlobal");
%>
<ul id="nav">
	<li>
		<a href="#"><span>
			<%= bundleGlobal.getString("usuario") %>
			&nbsp; <em><img src="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_IMAGES") %>/nav/zonebar-downarrow.png" /></em>
		</span></a>
		<ul>
			<li><a href="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_USER") + "/?acao=" + bundleGlobal.getString("novo") %>"><%= bundleGlobal.getString("novo") %> <%= bundleGlobal.getString("usuario") %></a></li>
			<li><a href="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_USER") + "/" %>"><%= bundleGlobal.getString("consultar") %></a></li>
		</ul>
	</li>
	<li>
		<a href="#"><span>
			<%= bundleGlobal.getString("produto") %>
			&nbsp; <em><img src="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_IMAGES") %>/nav/zonebar-downarrow.png" /></em>
		</span></a>
		<ul>
			<li><a href="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_PRODUTO") + "/?acao=" + bundleGlobal.getString("novo") %>"><%= bundleGlobal.getString("novo") %> <%= bundleGlobal.getString("produto") %></a></li>
			<li><a href="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_PRODUTO") + "/" %>"><%= bundleGlobal.getString("consultar") %></a></li>
		</ul>
	</li>
	<li>
		<a href="#"><span>
			<%= bundleGlobal.getString("cliente") %>
			&nbsp; <em><img src="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_IMAGES") %>/nav/zonebar-downarrow.png" /></em>
		</span></a>
		<ul>
			<li><a href="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_CLIENTE") + "/?acao=" + bundleGlobal.getString("novo") %>"><%= bundleGlobal.getString("novo") %> <%= bundleGlobal.getString("cliente") %></a></li>
			<li><a href="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_CLIENTE") + "/" %>"><%= bundleGlobal.getString("consultar") %></a></li>
		</ul>
	</li>
	<li>
		<a href="#"><span>
			<%= bundleGlobal.getString("fornecedor") %>
			&nbsp; <em><img src="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_IMAGES") %>/nav/zonebar-downarrow.png" /></em>
		</span></a>
		<ul>
			<li><a href="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_FORNECEDOR") + "/?acao=" + bundleGlobal.getString("novo") %>"><%= bundleGlobal.getString("novo") %> <%= bundleGlobal.getString("fornecedor") %></a></li>
			<li><a href="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_FORNECEDOR") + "/" %>"><%= bundleGlobal.getString("consultar") %></a></li>
		</ul>
	</li>
	<li>
		<a href="#"><span>
			<%= bundleGlobal.getString("venda") %>
			&nbsp; <em><img src="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_IMAGES") %>/nav/zonebar-downarrow.png" /></em>
		</span></a>
		<ul>
			<li><a href="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_VENDA") + "/?acao=" + bundleGlobal.getString("novo") %>"><%= bundleGlobal.getString("nova") %> <%= bundleGlobal.getString("venda") %></a></li>
			<li><a href="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_VENDA") + "/" %>"><%= bundleGlobal.getString("consultar") %></a></li>
		</ul>
	</li>
	
	<li>
		<a href="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_USER") + "?acao=editarmeuusuario" %>"><span>
			<%= bundleGlobal.getString("editarmeuusuario") %>
		</span></a>
	</li>
	<li>
		<a href="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_LOGIN") + "?acao=" + bundleGlobal.getString("sair") %>"><span><%= bundleGlobal.getString("sair") %></span></a>
	</li>
</ul>