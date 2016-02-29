<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Driver Routes Admin Panel</title>

<spring:url value="/static/css/main.css" var="mainCss" />
<spring:url value="/static/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/static/css/bootstrap-theme.min.css" var="bootstrapThemeCss" />
<spring:url value="/static/js/jquery.min.js" var="jqueryJs" />
<spring:url value="/static/js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/static/js/jquery.classyqr.min.js" var="classyqrJs" />
<spring:url value="/static/js/truck.admin.js" var="truckAdminJs" />

<link rel="stylesheet" type="text/css" href="${bootstrapCss}" />
<link rel="stylesheet" type="text/css" href="${bootstrapThemeCss}" />
<link rel="stylesheet" type="text/css" href="${mainCss}" />

<link rel="icon" 
      type="image/png" 
      href="<spring:url value="/static/images/favicon.png" />">

<script type="text/javascript" src="${jqueryJs}"></script>
<script type="text/javascript" src="${bootstrapJs}"></script>
<script type="text/javascript" src="${classyqrJs}"></script>
<script type="text/javascript" src="${truckAdminJs}"></script>

<style type="text/css">
#footer {
	height: 30px;
}
body {
	padding-top: 70px;
}
</style>

</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<spring:url value="/" />">Driver</a>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="<spring:url value="/" />">Map <span class="sr-only">(current)</span></a></li>
					<li class="active"><a href="<spring:url value="/admin"/>">Truck settings</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<spring:url value="/log"/>">Daily logs</a></li>
					<li>
						<security:authorize access="isAuthenticated()">
							<a href="<spring:url value="/logout" />">Exit</a>
						</security:authorize>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div class="row">
		<div class="col-xs-4"></div>
		<div class="col-xs-4">
			<table class="table">
				<c:forEach items="${mules}" var="mule">
					<tr>
						<c:if test="${mule.active eq false}">
							<td><input id="active-${mule.id}" type="checkbox" value="${mule.active}"></td>
						</c:if>
						<c:if test="${mule.active eq true}">
							<td><input checked id="active-${mule.id}" type="checkbox" value="${mule.active}"></td>
						</c:if>
						<td><input id="name-${mule.id}" maxlength="30" type="text" class="form-control" value="${mule.name}"></td>
						<td><button id="conn-${mule.id}" type="button" class="btn btn-success">Connect Android Device</button></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="col-xs-2">
			<div id="myModal" class="modal fade bs-example-modal-sm">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<div id="qr" class="modal-body" align="center"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-2"></div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div id="footer"></div>
			<div class="row">
				<div class="col-xs-3"></div>
				<div class="col-xs-7">
					<p align="center">
						<a href="http://solveast.com/">(c) Solveast Development LLC 2016</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
