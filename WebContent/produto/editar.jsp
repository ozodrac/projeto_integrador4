<%@page import="br.com.shark.TO.Fornecedor"%>
<%@page import="br.com.shark.TO.ProdutoCategoria"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="br.com.shark.messages.Messages"%>
<%@page import="java.util.List"%>
<%@ page import="br.com.shark.XML.MapConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="produto" class="br.com.shark.TO.Produto" scope="request" />
<jsp:setProperty property="*" name="produto" />
<% ResourceBundle bundlePage = (ResourceBundle) request.getAttribute("bundlePage"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/head.jsp\" %>" />
</head>
<body>

<div id="wrapper">
	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/header.jsp\" %>" />
	
	<form id="formulario"action="<%= MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_PRODUTO")+"/" %>" method="post" class="formee">
		<input type="hidden" name="pro_id" value="<%= produto.getId() %>" />
	
		<div id="toolbar">
			<h1><a href="<%= MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_PRODUTO")+"/" %>"><%= bundlePage.getString("label_produto") %></a> &gt;&gt; <%= bundlePage.getString("label_editar") %></h1>
			<ul id="buttons">
				<li><input type="submit" name="acao" value="<%= bundlePage.getString("atualizar") %>" /></li>
				<li><input type="button" value="<%= bundlePage.getString("cancelar") %>" class="bt-cancelar" /></li>
			</ul>
		</div>
		
		<div id="content">
		
			<%= Messages.render() %>
		
			<div class="formee-msg-error" id="validate-error" style="display: none"></div>
			
			<div class="grid-6-12 clear">
				<label><%= bundlePage.getString("descricao") %> <em class="formee-req">*</em></label>
				<input type="text" name="pro_descricao" value="<%= produto.getDescricao() %>" class="required" />
			</div>
			<div class="grid-5-12">
				<label><%= bundlePage.getString("marca") %> <em class="formee-req">*</em></label>
				<input type="text" name="pro_marca" value="<%= produto.getMarca() %>" class="required" />
			</div>
			
			<div class="grid-3-12 clear">
				<label><%= bundlePage.getString("valor_avista") %> <em class="formee-req">*</em></label>
				<input type="text" name="pro_valor_venda_avista" value="<%= produto.getValor_venda_avista() %>" class="required number" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("valor_prazo") %> <em class="formee-req">*</em></label>
				<input type="text" name="pro_valor_venda_prazo" value="<%= produto.getValor_venda_prazo() %>" class="required number" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("valor_compra") %> <em class="formee-req">*</em></label>
				<input type="text" name="pro_valor_compra" value="<%= produto.getValor_compra() %>" class="required number" />
			</div>
			
			<div class="grid-3-12 clear">
				<label><%= bundlePage.getString("garantia") %> <em class="formee-req">*</em></label>
				<input type="text" name="pro_garantia" value="<%= produto.getGarantia() %>" class="digits" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("quantidade") %> <em class="formee-req">*</em></label>
				<input type="text" name="pro_quantidade" value="<%= produto.getQuantidade() %>" class="required" />
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("categoria") %> <em class="formee-req">*</em></label>
				<select name="pra_id" class="required">
					<option value=""><%= bundlePage.getString("selecione_uma_opcao") %></option>
					<%
					List<ProdutoCategoria> listProdutoCategoria = (List<ProdutoCategoria>) request.getAttribute("listProdutoCategoria");
					if (listProdutoCategoria != null && ! listProdutoCategoria.isEmpty()) {
						for (ProdutoCategoria linha : listProdutoCategoria) {
							String selected = linha.getId() == produto.getCategoria().getId() ? "selected='selected'" : "";
							out.print("<option value='" + linha.getId() + "' "+selected+">" + linha.getNome() + "</option>");
						}
					}
					%>
				</select>
			</div>
			<div class="grid-3-12">
				<label><%= bundlePage.getString("fornecedor") %> <em class="formee-req">*</em></label>
				<select name="frr_id" class="required">
					<option value=""><%= bundlePage.getString("selecione_uma_opcao") %></option>
					<%
					List<Fornecedor> listFornecedor = (List<Fornecedor>) request.getAttribute("listFornecedor");
					if (listFornecedor != null && ! listFornecedor.isEmpty()) {
						for (Fornecedor linha : listFornecedor) {
							String selected = linha.getId() == produto.getFornecedor().getId() ? "selected='selected'" : "";
							out.print("<option value='" + linha.getId() + "' "+selected+">" + linha.getNome() + "</option>");
						}
					}
					%>
				</select>
			</div>
		</div>

	</form>

	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/footer.jsp\" %>" />
	
</div>
</body>
</html>