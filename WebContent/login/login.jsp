<%@page import="java.util.ResourceBundle"%>
<%@page import="br.com.shark.messages.Messages"%>
<%@page import="br.com.shark.XML.MapConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% ResourceBundle bundlePage = (ResourceBundle) request.getAttribute("bundlePage"); %>
<html>
<head>
	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/head.jsp\" %>" />
</head>
<body>
<div id="wrapper">

	<form id="formulario" action="<%= MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_LOGIN")+"/" %>" method="post" class="formee">
	
		<div id="content">
			<div class="grid-12-12">
				<img src="<%= MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_IMAGES") %>/icon/shark_logo.png" />
			</div>
			
			<%= Messages.render() %>
		
			<div class="formee-msg-error" id="validate-error" style="display: none"></div>
			
			<div class="grid-6-12 clear">
				<label><%= bundlePage.getString("login") %></label>
				<input type="text" name="login" />
			</div>
			<div class="grid-6-12 clear">
				<label><%= bundlePage.getString("senha") %></label>
				<input type="password" name="senha" />
				<a href="<%= MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_LOGIN") + "/esqueci_minha_senha.jsp" %>" id="esqueci_senha" class="right"><%= bundlePage.getString("esqueci_minha_senha") %></a>
			</div>
			
			<div class="clear">
				<ul class="formee-list">
					<li><input type="submit" name="acao" value="<%= bundlePage.getString("login") %>" /></li>
				</ul>
			</div>
			
		</div>
		
	</form>
	
</div>
</body>
</html>