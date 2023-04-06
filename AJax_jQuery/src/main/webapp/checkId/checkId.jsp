<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %> <%-- XML태그 시작 전의 공백 제거  --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- DB 연동 => 만약에 user_id가 hong이면 이미 DB에 저장된 아이디로 취급(true) --%>
<c:set var="result" value="false"/>
<c:if test="${param.user_id == 'hong' }">
	<c:set var="result" value="true"/>
</c:if>

<%-- XML 로 보내기 --%>
<?xml version="1.0" encoding="UTF-8"?>
<check_id>
	<result>${result }</result>
</check_id>