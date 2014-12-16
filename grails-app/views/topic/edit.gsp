<%@ page import="com.intelligrape.linksharing.Topic" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'topic.label', default: 'Topic')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
    <g:if test="${flash.message}">
        <div class="alert alert-block" role="status">
            <button type="button" class="close" data-dismiss="alert">×</button>
            ${flash.message}
        </div>
    </g:if>
    <h1>Edit Topic</h1>
    <hr class="span12" style="margin-left: 0">
			<g:form url="[resource:topicInstance, action:'update']" method="PUT" class="form-horizontal" >
				<g:hiddenField name="version" value="${topicInstance?.version}" />
                <g:render template="form"/>
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <g:submitButton name="create" class="save btn btn-primary" value="Edit"/>
                    </div>
                </div>
			</g:form>
	</body>
</html>
