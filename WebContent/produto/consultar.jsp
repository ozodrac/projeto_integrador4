<%@page import="br.com.shark.TO.Produto"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.List"%>
<%@page import="br.com.shark.messages.Messages"%>
<%@page import="br.com.shark.XML.MapConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	
	<form id="formulario" action="<%=MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_PRODUTO")+"/"%>" method="post" class="formee">
	
		<div id="toolbar">
			<div id="toolbar-content">
				<h1><a href="<%=MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_PRODUTO")+"/"%>"><%= bundlePage.getString("label_produto") %></a> &gt;&gt; <%= bundlePage.getString("label_consultar") %></h1>
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
						<th width="4%"><input type="checkbox" class="marcar_todos" id="pro_id" /></th>
						<th><%= bundlePage.getString("categoria") %></th>
						<th><%= bundlePage.getString("descricao") %></th>
						<th><%= bundlePage.getString("marca") %></th>
						<th><%= bundlePage.getString("valor_avista") %></th>
						<th><%= bundlePage.getString("quantidade") %></th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Produto> lista = produto.getListProduto();
					if (lista != null && ! lista.isEmpty()) {
						for(Produto linha : lista){
							String link = "<a href='" + MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_PRODUTO") + "?acao="+bundlePage.getString("editar")+"&pro_id="+ linha.getId() +"'>";
							out.print("<tr>");
							out.print("<td align='center'><input type='checkbox' name='pro_id' value='"+ linha.getId() +"' /></td>");
							out.print("<td>" + link + linha.getCategoria().getNome() +"</a></td>");
							out.print("<td>" + link + linha.getDescricao() +"</a></td>");
							out.print("<td>" + link + linha.getMarca() +"</a></td>");
							out.print("<td>" + link + linha.getValor_venda_avista() +"</a></td>");
							out.print("<td>" + link + linha.getQuantidade() +"</a></td>");
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