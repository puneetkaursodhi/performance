
<%@ page import="com.intelligrape.linksharing.Topic" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'topic.label', default: 'Topic')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
    <g:if test="${flash.message}">
        <div class="alert alert-success">
            <button type="button" class="close" data-dismiss="alert">×</button>
            ${flash.message}
        </div>
    </g:if>

    <div class="row" style="margin-bottom: 20px;">
        <h1 class="col-sm-6">Manage Topics
            <g:link controller="topic" action="create" class="btn btn-success btn-sm">
                <i class="icon-plus"></i>
                Create
            </g:link>
        </h1>

    </div>

    <table class="table table-striped table-bordered table-condensed">
			<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'topic.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'topic.description.label', default: 'Description')}" />
					
						<th><g:message code="topic.creator.label" default="Creator" /></th>
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'topic.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'topic.lastUpdated.label', default: 'Last Updated')}" />
					
						<g:sortableColumn property="visibility" title="${message(code: 'topic.visibility.label', default: 'Visibility')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${topicInstanceList}" status="i" var="topicInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="edit" id="${topicInstance.id}">${fieldValue(bean: topicInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: topicInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: topicInstance, field: "creator")}</td>
					
						<td><g:formatDate date="${topicInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${topicInstance.lastUpdated}" /></td>
					
						<td>${fieldValue(bean: topicInstance, field: "visibility")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${topicInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
