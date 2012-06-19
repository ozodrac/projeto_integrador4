<%@page import="br.com.shark.XML.MapConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="header">
	<a href="<%= MapConfig.getInstance().get("CONFIG-DIR_ROOT") %>/home/">
		<img src="<%= MapConfig.getInstance().get("CONFIG-DIR_ROOT", "CONFIG-DIR_IMAGES") %>/icon/shark_logo.png" />
	</a>
</div>

<div id="navigation"><jsp:include page="<%= MapConfig.getInstance().get(\"CONFIG-DIR_INCLUDE\") + \"/nav.jsp\" %>" /></div>