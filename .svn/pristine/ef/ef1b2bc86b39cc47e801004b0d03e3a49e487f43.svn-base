<%@page import="br.com.shark.enumeration.EnumSexo"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="br.com.shark.messages.Messages"%>
<%@page import="java.util.List"%>
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
	
	<form id="formulario"action="<%= MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_CLIENTE")+"/" %>" method="post" class="formee">
		<input type="hidden" name="cle_id" value="<%= cliente.getId() %>" />
	
		<div id="toolbar">
			<h1><a href="<%= MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_CLIENTE")+"/" %>"><%= bundlePage.getString("label_cliente") %></a> &gt;&gt; <%= bundlePage.getString("label_editar") %></h1>
			<ul id="buttons">
				<li><input type="submit" name="acao" value="<%= bundlePage.getString("atualizar") %>" /></li>
				<li><input type="button" value="<%= bundlePage.getString("cancelar") %>" class="bt-cancelar" /></li>
			</ul>
		</div>
		
		<div id="content">
		
			<%= Messages.render() %>
		
			<div class="formee-msg-error" id="validate-error" style="display: none"></div>
			
			<div class="grid-6-12 clear">
				<label><%= bundlePage.getString("nome") %> <em class="formee-req">*</em></label>
				<input type="text" name="cle_nome" value="<%= cliente.getNome() %>" class="required" maxlength="100" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("cpf") %> <em class="formee-req">*</em></label>
				<input type="text" name="cle_cpf" value="<%= cliente.getCpf() %>" class="required cpf digits" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("sexo") %> <em class="formee-req">*</em></label>
				<select name="cle_sexo" class="required">
					<option value=""><%= bundlePage.getString("selecione_uma_opcao") %></option>
					<%
					for (EnumSexo e : EnumSexo.values()) {
						String selected = e.getSexo() == cliente.getSexo().getSexo() ? "selected='selected'" : "";
						out.print("<option value='" + e.getSexo() + "' "+selected+">" + e.getNomeExibicao(bundlePage.getLocale()) + "</option>");
					}
					%>
				</select>
			</div>
			
			<div class="grid-3-12 clear">
				<label><%= bundlePage.getString("telefone_celular") %> <em class="formee-req">*</em></label>
				<input type="text" name="cle_telefone_celular" value="<%= cliente.getTelefoneCelular() %>" class="required digits" maxlength="10" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("telefone_residencial") %></label>
				<input type="text" name="cle_telefone_residencial" value="<%= cliente.getTelefoneResidencial() %>" class="digits" maxlength="10" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("telefone_comercial") %></label>
				<input type="text" name="cle_telefone_comercial" value="<%= cliente.getTelefoneComercial() %>" class="digits" maxlength="10" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("data_nascimento") %></label>
				<input type="text" name="cle_data_nascimento" value="<%= cliente.getDataNascimentoFormatada() %>" class="data" />
			</div>
			
			<div class="grid-5-12 clear">
				<label><%= bundlePage.getString("email") %></label>
				<input type="text" name="cle_email" value="<%= cliente.getEmail() %>" class="email" maxlength="100" />
			</div>
			<div class="grid-7-12">
				<label><%= bundlePage.getString("endereco") %></label>
				<input type="text" name="cle_endereco" value="<%= cliente.getEndereco() %>" maxlength="250" />
			</div>
		</div>

	</form>

	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/footer.jsp\" %>" />
	
</div>
</body>
</html>