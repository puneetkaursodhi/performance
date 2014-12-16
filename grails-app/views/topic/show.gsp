
<%@ page import="com.intelligrape.linksharing.Topic" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'topic.label', default: 'Topic')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
    <g:if test="${flash.message}">
        <div class="alert alert-success" role="status">
            <button type="button" class="close" data-dismiss="alert">×</button>
            ${flash.message}
        </div>
    </g:if>

    <div class="row">
        <h1 class="col-md-6">
            Show Topic
            <span class="font-size: 12px;">
                <g:link class="btn btn-primary" action="edit" id="${topicInstance?.id}">
                    Edit
                </g:link>
            </span>
        </h1>
    </div>

    <br>
    <br>

    <div class="col-md-5 zeroLeftPadding">
        <table class="table table-bordered table-condensed">
            <tr>
                <td>
                    <strong>Title</strong>
                </td>
                <td>
                    <g:fieldValue bean="${topicInstance}" field="title"/>
                </td>
            </tr>
            <tr>
                <td>
                    <strong>Description</strong>
                </td>
                <td>
                    <g:fieldValue bean="${topicInstance}" field="description"/>
                </td>
            </tr>
            <tr>
                <td>
                    <strong>Visibility</strong>
                </td>
                <td>
                    <g:fieldValue bean="${topicInstance}" field="visibility"/>
                </td>
            </tr>


        </table>
    </div>
	</body>
</html>
