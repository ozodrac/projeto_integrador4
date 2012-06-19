<%@page import="br.com.shark.TO.PerfilUsuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="br.com.shark.enumeration.EnumLingua"%>
<%@page import="br.com.shark.messages.Messages"%>
<%@ page import="br.com.shark.XML.MapConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="user" class="br.com.shark.TO.User" scope="request" />
<jsp:setProperty property="*" name="user" />
<% ResourceBundle bundlePage = (ResourceBundle) request.getAttribute("bundlePage"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/head.jsp\" %>" />
	
	<script type="text/javascript" src="js/user.js"></script>
</head>
<body>

<div id="wrapper">
	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/header.jsp\" %>" />

	<form id="formulario"action="<%= MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_USER") + "/" %>" method="post" class="formee">
	
		<div id="toolbar">
			<h1><a href="<%= MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_USER")+"/" %>"><%= bundlePage.getString("label_usuario") %></a> &gt;&gt; <%= bundlePage.getString("label_cadastrar") %></h1>
			<ul id="buttons">
				<li><input type="submit" name="acao" value="<%= bundlePage.getString("cadastrar") %>" /></li>
				<li><input type="button" value="<%= bundlePage.getString("cancelar") %>" class="bt-cancelar" /></li>
			</ul>
		</div>
	
		<div id="content">
		
			<%= Messages.render() %>
		
			<div class="formee-msg-error" id="validate-error" style="display: none"></div>
			
			<div class="grid-6-12 clear">
				<label><%= bundlePage.getString("nome") %> <em class="formee-req">*</em></label>
				<input type="text" name="uso_nome" class="required" />
			</div>
			<div class="grid-5-12">
				<label><%= bundlePage.getString("email") %> <em class="formee-req">*</em></label>
				<input type="text" name="uso_email" class="required email" />
			</div>
			
			<div class="grid-4-12 clear">
				<label><%= bundlePage.getString("login") %> <em class="formee-req">*</em></label>
				<input type="text" name="uso_login" class="required" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("senha") %> <em class="formee-req">*</em></label>
				<input type="password" id="senha" name="uso_senha" class="required" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("confirmacao") %> <em class="formee-req">*</em></label>
				<input type="password" name="confirmacao" class="confirmacao" />
			</div>
			
			<div class="grid-3-12 clear">
				<label><%= bundlePage.getString("lingua") %> <em class="formee-req">*</em></label>
				<select name="lna_id" class="required">
					<option value=""><%= bundlePage.getString("selecione_uma_opcao") %></option>
					<%
					EnumLingua[] Alingua = EnumLingua.values();
					for (EnumLingua lingua : Alingua) {
						out.print("<option value='"+ lingua.getId() +"'>"+ lingua.getNomeExibicao() +"</option>");
					}
					%>
				</select>
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("perfilusuario") %> <em class="formee-req">*</em></label>
				<select name="pro_id" class="required">
					<option value=""><%= bundlePage.getString("selecione_uma_opcao") %></option>
					<%
					List<PerfilUsuario> listPerfilUsuario = (List<PerfilUsuario>) request.getAttribute("listPerfilUsuario");
					for (PerfilUsuario perfil : listPerfilUsuario) {
						out.print("<option value='"+ perfil.getId() +"'>"+ perfil.getNome() +"</option>");
					}
					%>
				</select>
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("cpf") %> <em class="formee-req">*</em></label>
				<input type="text" name="uso_cpf" class="cpf required" />
			</div>
		</div>

	</form>

	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/footer.jsp\" %>" />
	
</div>
</body>
</html>