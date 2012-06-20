<%@page import="br.com.shark.TO.Produto"%>
<%@page import="br.com.shark.TO.FormaPagamento"%>
<%@page import="br.com.shark.TO.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="br.com.shark.messages.Messages"%>
<%@ page import="br.com.shark.XML.MapConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="venda" class="br.com.shark.TO.ProdutoVenda" scope="request" />
<jsp:setProperty property="*" name="venda" />
<% ResourceBundle bundlePage = (ResourceBundle) request.getAttribute("bundlePage"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/head.jsp\" %>" />
	
	<script type="text/javascript" src="js/venda.js"></script>
</head>
<body>

<div id="wrapper">
	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/header.jsp\" %>" />

	<form id="formulario"action="<%= MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_VENDA") + "/" %>" method="post" class="formee">
		<input type="hidden" id="produto_repetido" value="<%= bundlePage.getString("msg_produto_repetido") %>" />
	
		<div id="toolbar">
			<h1><a href="<%= MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_VENDA")+"/" %>"><%= bundlePage.getString("label_venda") %></a> &gt;&gt; <%= bundlePage.getString("label_cadastrar") %></h1>
			<ul id="buttons">
				<li><input type="submit" name="acao" value="<%= bundlePage.getString("cadastrar") %>" /></li>
				<li><input type="button" value="<%= bundlePage.getString("cancelar") %>" class="bt-cancelar" /></li>
			</ul>
		</div>
	
		<div id="content">
		
			<%= Messages.render() %>
		
			<div class="formee-msg-error" id="validate-error" style="display: none"></div>
			
			<div class="grid-3-12">
				<label><%= bundlePage.getString("cliente") %> <em class="formee-req">*</em></label>
				<select name="cle_id" class="required">
					<option value=""><%= bundlePage.getString("selecione_uma_opcao") %></option>
					<%
					List<Cliente> listCliente = (List<Cliente>) request.getAttribute("listCliente");
					if (listCliente != null && ! listCliente.isEmpty()) {
						for (Cliente linha : listCliente) {
							out.print("<option value='" + linha.getId() + "'>" + linha.getNome() + "</option>");
						}
					}
					%>
				</select>
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("forma_pagamento") %> <em class="formee-req">*</em></label>
				<select name="fro_id" class="required">
					<option value=""><%= bundlePage.getString("selecione_uma_opcao") %></option>
					<%
					List<FormaPagamento> listFormaPagamento = (List<FormaPagamento>) request.getAttribute("listFormaPagamento");
					if (listFormaPagamento != null && ! listFormaPagamento.isEmpty()) {
						for (FormaPagamento linha : listFormaPagamento) {
							out.print("<option value='" + linha.getId() + "'>" + linha.getNome() + "</option>");
						}
					}
					%>
				</select>
			</div>
			<div class="grid-3-12 right">
				<label>Valor Total</label>
				<input type="text" id="valor_total" value="0.00" disabled="disabled" />
			</div>
			
			<table width="100%" class="tabela_consulta" cellpadding="0" cellspacing="0">
				<thead>
					<tr>
						<th><span><%= bundlePage.getString("produto") %></span></th>
						<th><span><%= bundlePage.getString("quantidade") %></span></th>
						<th><span><%= bundlePage.getString("valor") %></span></th>
						<th><span><%= bundlePage.getString("adicionar_remover") %></span></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
						<select name="pro_id" class="pro_id produto_repetido required">
							<option value=""><%= bundlePage.getString("selecione_uma_opcao") %></option>
							<%
							List<Produto> listProduto = (List<Produto>) request.getAttribute("listProduto");
							if (listProduto != null && ! listProduto.isEmpty()) {
								for (Produto linha : listProduto) {
									out.print("<option value='" + linha.getId() + "' data-valor='" + linha.getValor_venda_avista() + "'>" + linha.getDescricao() + "</option>");
								}
							}
							%>
						</select>
						</td>
						<td><input type="text" name="prm_quantidade" class="required prm_quantidade digits" /></td>
						<td><input type="text" name="prm_valor" class="number required prm_valor" /></td>
						<td align="center"><a href="#" id="adicionar_produto" class="adicionar_linha"></a></td>
					</tr>
				</tbody>
			</table>
		</div>

	</form>

	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/footer.jsp\" %>" />
	
</div>
</body>
</html>