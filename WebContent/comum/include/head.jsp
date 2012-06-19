<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="br.com.shark.minify.JsAggregator"%>
<%@page import="br.com.shark.minify.CssAggregator"%>
<%@page import="br.com.shark.XML.Map"%>
<%@page import="br.com.shark.XML.MapConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Map mapconfig = MapConfig.getInstance();
ResourceBundle bundleGlobal = (ResourceBundle) request.getAttribute("bundleGlobal");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= mapconfig.get("CONFIG-SYS_TITLE") %></title>
<link rel="icon" href="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_IMAGES") + "/icon/favicon.ico" %>" type="image/x-icon" />
<%
CssAggregator cssAggregator = new CssAggregator();
cssAggregator.add("formee-structure.css", mapconfig.get("CONFIG-DIR_ROOT_REAL", "CONFIG-DIR_FORMEE") + "/css/");
cssAggregator.add("formee-style.css", mapconfig.get("CONFIG-DIR_ROOT_REAL", "CONFIG-DIR_FORMEE") + "/css/");
cssAggregator.add("/smoothness/jqueryui.css", mapconfig.get("CONFIG-DIR_ROOT_REAL", "CONFIG-DIR_JQUERY"));
cssAggregator.add("nav.css").add("screen.css");
out.print(cssAggregator.run());
%>
<script type="text/javascript" src="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_JQUERY") + "/jquery.js" %>"></script>
<script type="text/javascript" src="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_JQUERY") + "/jqueryui.js" %>"></script>
<% 
if((bundleGlobal.getLocale().getLanguage() + "_" + bundleGlobal.getLocale().getCountry()).equals("pt_BR")) { %>
	<script type="text/javascript" src="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_JQUERY") + "/validate.js" %>"></script>
<% } else { %>
	<script type="text/javascript" src="<%= mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_JQUERY") + "/validate_en.js" %>"></script>
<% }
JsAggregator jsAggregator = new JsAggregator();
jsAggregator.add("navmenu.js").add("datepicker.js").add("mask.js");
jsAggregator.add("/js/formee.js", mapconfig.get("CONFIG-DIR_ROOT_REAL", "CONFIG-DIR_FORMEE"));
jsAggregator.add("/comum.js", mapconfig.get("CONFIG-DIR_ROOT_REAL", "CONFIG-DIR_JS"));
out.print(jsAggregator.run());
%>