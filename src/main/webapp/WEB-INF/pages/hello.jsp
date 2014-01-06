<html lang="en" ng-app="sMongoApp">
<head>
    <meta charset="utf-8">
    <title>Spring MongoDB Demo</title>

    <link rel="stylesheet" href="/lib/bootstrap/css/bootstrap.min.css" >
    <link rel="stylesheet" href="/lib/bootstrap/css/bootstrap-theme.min.css" >

    <script src="/lib/angularjs/angular.js"></script>
    <script src="/lib/angularjs/angular-animate.js"></script>
    <script src="/lib/angularjs/angular-resource.js"></script>
    <script src="/lib/angularjs/angular-route.js"></script>
    <script src="/lib/jquery/jquery-1.10.2.min.js"></script>

    <script src="/app/js/app.js"></script>
    <script src="/app/js/controllers.js"></script>
    <script src="/app/js/filters.js"></script>
    <script src="/app/js/services.js"></script>
</head>
<body>
	<h1>${message}</h1>
    <div>
        <div ng-view></div>
    </div>
</body>
</html>