<%--
  Created by IntelliJ IDEA.
  User: jorji
  Date: 11/09/2021
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ticket</title>
</head>

<body>
<h2>Liste des projets</h2>

<ul>
    <s:iterator value="listProjet">
        <li>
            <s:a action="projet_detail">
                <s:param name="id" value="id" />
                <s:property value="nom"/>
            </s:a>

            - Responsable :
            <s:a action="utilisateur_detail">
                <s:param name="id" value="responsable.id" />
                <s:property value="responsable.prenom"/> <s:property value="responsable.nom"/>
            </s:a>
        </li>
    </s:iterator>
</ul>
</body>
</html>
