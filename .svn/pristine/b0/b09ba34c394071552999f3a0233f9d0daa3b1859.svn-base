<%@page import="br.com.shark.enumeration.EnumSexo"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="br.com.shark.messages.Messages"%>
<%@ page import="br.com.shark.XML.MapConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="cliente" class="br.com.shark.TO.Cliente" scope="request" />
<jsp:setProperty property="*" name="cliente" />
<% ResourceBundle bundlePage = (ResourceBundle) request.getAttribute("bundlePage"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/head.jsp\" %>" />
</head>
<body>

<div id="wrapper">
	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/header.jsp\" %>" />

	<form id="formulario"action="<%= MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_CLIENTE") + "/" %>" method="post" class="formee">
	
		<div id="toolbar">
			<h1><a href="<%= MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_CLIENTE")+"/" %>"><%= bundlePage.getString("label_cliente") %></a> &gt;&gt; <%= bundlePage.getString("label_cadastrar") %></h1>
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
				<input type="text" name="cle_nome" class="required" maxlength="100" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("cpf") %> <em class="formee-req">*</em></label>
				<input type="text" name="cle_cpf" class="required cpf digits" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("sexo") %> <em class="formee-req">*</em></label>
				<select name="cle_sexo" class="required">
					<option value=""><%= bundlePage.getString("selecione_uma_opcao") %></option>
					<%
					for (EnumSexo e : EnumSexo.values()) {
						out.print("<option value='" + e.getSexo() + "'>" + e.getNomeExibicao(bundlePage.getLocale()) + "</option>");
					}
					%>
				</select>
			</div>
			
			<div class="grid-3-12 clear">
				<label><%= bundlePage.getString("telefone_celular") %> <em class="formee-req">*</em></label>
				<input type="text" name="cle_telefone_celular" class="required digits" maxlength="10" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("telefone_residencial") %></label>
				<input type="text" name="cle_telefone_residencial" class="digits" maxlength="10" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("telefone_comercial") %></label>
				<input type="text" name="cle_telefone_comercial" class="digits" maxlength="10" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("data_nascimento") %></label>
				<input type="text" name="cle_data_nascimento" class="data" />
			</div>
			
			<div class="grid-5-12 clear">
				<label><%= bundlePage.getString("email") %></label>
				<input type="text" name="cle_email" class="email" maxlength="100" />
			</div>
			<div class="grid-7-12">
				<label><%= bundlePage.getString("endereco") %></label>
				<input type="text" name="cle_endereco" maxlength="250" />
			</div>
		</div>

	</form>

	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/footer.jsp\" %>" />
	
</div>
</body>
</html>