<%@page import="java.util.ResourceBundle"%>
<%@page import="br.com.shark.messages.Messages"%>
<%@ page import="br.com.shark.XML.MapConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="fornecedor" class="br.com.shark.TO.Fornecedor" scope="request" />
<jsp:setProperty property="*" name="fornecedor" />
<% ResourceBundle bundlePage = (ResourceBundle) request.getAttribute("bundlePage"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/head.jsp\" %>" />
</head>
<body>

<div id="wrapper">
	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/header.jsp\" %>" />

	<form id="formulario"action="<%= MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_FORNECEDOR") + "/" %>" method="post" class="formee">
	
		<div id="toolbar">
			<h1><a href="<%= MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_FORNECEDOR")+"/" %>"><%= bundlePage.getString("label_fornecedor") %></a> &gt;&gt; <%= bundlePage.getString("label_cadastrar") %></h1>
			<ul id="buttons">
				<li><input type="submit" name="acao" value="<%= bundlePage.getString("cadastrar") %>" /></li>
				<li><input type="button" value="<%= bundlePage.getString("cancelar") %>" class="bt-cancelar" /></li>
			</ul>
		</div>
	
		<div id="content">
		
			<%= Messages.render() %>
		
			<div class="formee-msg-error" id="validate-error" style="display: none"></div>
			
			<div class="grid-6-12 clear">
				<label><%= bundlePage.getString("nome_fantasia") %> <em class="formee-req">*</em></label>
				<input type="text" name="frr_nome_fantasia" class="required" maxlength="100" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("razao_social") %> <em class="formee-req">*</em></label>
				<input type="text" name="frr_razao_social" class="required" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("cnpj") %> <em class="formee-req">*</em></label>
				<input type="text" name="frr_cnpj" class="required cnpj digits" />
			</div>
			
			<div class="grid-3-12 clear">
				<label><%= bundlePage.getString("telefone1") %> <em class="formee-req">*</em></label>
				<input type="text" name="frr_telefone1" class="required digits" maxlength="10" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("representante") %></label>
				<input type="text" name="frr_representante" class="required" maxlength="100" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("email") %> <em class="formee-req">*</em></label>
				<input type="text" name="frr_email" class="required " maxlength="100" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("site") %> <em class="formee-req">*</em></label>
				<input type="text" name="frr_site" class="required " />
			</div>

		</div>
	</form>

	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/footer.jsp\" %>" />
	
</div>
</body>
</html>