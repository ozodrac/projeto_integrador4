<%@page import="br.com.shark.TO.ProdutoVenda"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.List"%>
<%@page import="br.com.shark.messages.Messages"%>
<%@page import="br.com.shark.XML.MapConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="venda" class="br.com.shark.TO.ProdutoVenda" scope="request" />
<jsp:setProperty property="*" name="venda" />
<% ResourceBundle bundlePage = (ResourceBundle) request.getAttribute("bundlePage"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/head.jsp\" %>" />
</head>
<body>

<div id="wrapper">
	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/header.jsp\" %>" />
	
	<form id="formulario" action="<%=MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_VENDA")+"/"%>" method="post" class="formee">
	
		<div id="toolbar">
			<div id="toolbar-content">
				<h1><a href="<%=MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_VENDA")+"/"%>"><%= bundlePage.getString("label_venda") %></a> &gt;&gt; <%= bundlePage.getString("label_consultar") %></h1>
				<ul id="buttons">
					<li><input type="submit" name="acao" value="<%= bundlePage.getString("novo") %>" /></li>
					<li><input type="submit" name="acao" value="<%= bundlePage.getString("editar") %>" /></li>
					<li><input type="submit" name="acao" value="<%= bundlePage.getString("apagar") %>" /></li>
				</ul>
			</div>
		</div>
		
		<div id="content">
		
			<%=Messages.render()%>
		
			<table width="100%" class="tabela_consulta" cellpadding="0" cellspacing="0">
				<thead>
					<tr>
						<th width="4%"><input type="checkbox" class="marcar_todos" id="prd_id" /></th>
						<th><%= bundlePage.getString("data") %></th>
						<th><%= bundlePage.getString("cliente") %></th>
						<th><%= bundlePage.getString("forma_pagamento") %></th>
						<th><%= bundlePage.getString("funcionario") %></th>
					</tr>
				</thead>
				<tbody>
					<%
					List<ProdutoVenda> lista = venda.getListVenda();
					if (lista != null && ! lista.isEmpty()) {
						for(ProdutoVenda linha : lista){
							String link = "<a href='" + MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_VENDA") + "?acao="+bundlePage.getString("editar")+"&prd_id="+ linha.getId() +"'>";
							out.print("<tr>");
							out.print("<td align='center'><input type='checkbox' name='prd_id' value='"+ linha.getId() +"' /></td>");
							out.print("<td>" + link + linha.getDataCadastroFormatada() +"</a></td>");
							out.print("<td>" + link + linha.getCliente().getNome() +"</a></td>");
							out.print("<td>" + link + linha.getFormaPagamento().getNome() +"</a></td>");
							out.print("<td>" + link + linha.getUser().getNome() +"</a></td>");
							out.print("</tr>");
						}
					}
					%>
				</tbody>
			</table>
		</div>
	
	</form>

	<jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/footer.jsp\" %>" />
	
</div>
</body>
</html>