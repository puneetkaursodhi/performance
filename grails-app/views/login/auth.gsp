
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">

    <title>Signin</title>

    <asset:stylesheet href="bootstrap.css"/>
    <asset:stylesheet href="signin.css"/>

</head>

<body>

<div class="container">

    <form action='${postUrl}' method='POST' id='loginForm' class='form-signin' autocomplete='off' role="form">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="email" class="sr-only">Email address</label>
        <input type="email" id="email" class="form-control" placeholder="Email address" required autofocus name="j_username">
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" class="form-control" placeholder="Password" required name="j_password">
        <div class="checkbox">
            <label>
                <input type='checkbox'  name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
                 Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>
