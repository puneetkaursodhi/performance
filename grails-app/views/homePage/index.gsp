<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Test</title>
    <meta name="layout" content="main"/>
</head>

<body>
<div class="row" style="margin-bottom: 20px;">
    <h3 class="col-sm-6">Topics Created By User

    </h3>
</div>
<table class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>User</th>
        <th>Count</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${userTopicCountVOs}" status="i" var="userTopicCountVO">
        <tr>
            <td>
                ${userTopicCountVO.user.firstName}
            </td>
            <td>
                ${userTopicCountVO.count}
            </td>
        </tr>
    </g:each>
    </tbody>
</table>

</body>
</html>