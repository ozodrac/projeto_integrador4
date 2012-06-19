<%@page import="br.com.shark.TO.Fornecedor"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.List"%>
<%@page import="br.com.shark.messages.Messages"%>
<%@page import="br.com.shark.XML.MapConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	
	<form id="formulario" action="<%=MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_FORNECEDOR")+"/"%>" method="post" class="formee">
	
		<div id="toolbar">
			<div id="toolbar-content">
				<h1><a href="<%=MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_FORNECEDOR")+"/"%>"><%= bundlePage.getString("label_fornecedor") %></a> &gt;&gt; <%= bundlePage.getString("label_consultar") %></h1>
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
						<th width="4%"><input type="checkbox" class="marcar_todos" id="frr_id" /></th>
						<th><%= bundlePage.getString("nome_fantasia") %></th>
						<th><%= bundlePage.getString("razao_social") %></th>
						<th><%= bundlePage.getString("cnpj") %></th>
						<th><%= bundlePage.getString("telefone1") %></th>
						<th><%= bundlePage.getString("representante") %></th>						
						<th><%= bundlePage.getString("email") %></th>
						<th><%= bundlePage.getString("site") %></th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Fornecedor> lista = fornecedor.getListFornecedor();
					if (lista != null && ! lista.isEmpty()) {
						for(Fornecedor linha : lista){
							String link = "<a href='" + MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_FORNECEDOR") + "?acao="+bundlePage.getString("editar")+"&frr_id="+ linha.getId() +"'>";
							out.print("<tr>");
							out.print("<td align='center'><input type='checkbox' name='frr_id' value='"+ linha.getId() +"' /></td>");
							out.print("<td>" + link + linha.getNome_fantasia() +"</a></td>");
							out.print("<td>" + link + linha.getRazao_social() +"</a></td>");
							out.print("<td>" + link + linha.getCnpj() +"</a></td>");
							out.print("<td>" + link + linha.getTelefone1() +"</a></td>");
							out.print("<td>" + link + linha.getRepresentante() +"</a></td>");
							out.print("<td>" + link + linha.getEmail() +"</a></td>");
							out.print("<td>" + link + linha.getSite() +"</a></td>");
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