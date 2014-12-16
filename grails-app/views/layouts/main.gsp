<%@ page import="com.intelligrape.linksharing.utils.Constants" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">

    <asset:stylesheet href="bootstrap.css"/>
    <asset:stylesheet href="bootstrap-theme.css"/>
    <asset:stylesheet href="theme.css"/>

    <g:layoutHead/>
</head>

<body role="document">
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Bootstrap theme</a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-expanded="false">Topic Stats <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Total Topics : <ls:showTotalTopicsCount/></a></li>
                        %{--<cache:block><li><a href="#">Total Topics : <ls:showTotalTopicsCount/></a></li></cache:block>--}%
                        <li><a
                                href="#">Total Created Topics : <ls:showCreatedTopicsCount/></a></li>
                        %{--<cache:block key="${sec.loggedInUserInfo(field: 'id')}"><li><a--}%
                        %{--href="#">Total Created Topics : <ls:showCreatedTopicsCount/></a></li></cache:block>--}%
                        <li><a href="#">Total Subscribed Topics : <ls:showSubscribedTopicsCount/></a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="divider-vertical"></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <sec:loggedInUserInfo field="username"/>
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">

                        <li><a href="/g/admin/user/edit?id=4">Account</a></li>
                        <li><a href="/logout/index">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container theme-showcase" role="main">
    <g:layoutBody/>
</div>
<asset:javascript src="jquery-1.11.1.js"/>
<asset:javascript src="bootstrap.js"/>

</body>
</html>
