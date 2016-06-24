<%@page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="/resources/css/materialize.min.css" media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <script type="text/javascript" src="/resources/js/jquery-3.0.0.min.js"></script>
    <script type="text/javascript">

            $("#addUserButton").submit(function () {
                var formData = {
                    "login": $("#login").val(),
                    "firstName": $("#firstName").val(),
                    "lastName": $("#lastName").val(),
                    "birthDay": $("#birthDay").val(),
                    "password": $("#password").val(),
                    "aBout": $("#aBout").val(),
                    "address": $("#address").val()
                };
                $.ajax({
                    url: "{pageContext.request.contextPath}/rest/users/",
                    type: 'POST',
                    data: 'jsonData=' + $.toJSON(formData),
                    success: function (res) {
                        alert(res);
                    }
                });
                return false;
            });
    </script>

</head>
<body>

<script type="text/javascript" src="/resources/js/materialize.min.js"></script>


<div class="row">
    <form class="col s12">
        <div class="row">
            <div class="input-field col s6">
                <input placeholder="Placeholder" id="firstName" type="text" class="validate">
                <label for="firstName">First Name</label>
            </div>
            <div class="input-field col s6">
                <input id="lastName" type="text" class="validate">
                <label for="lastName">Last Name</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input id="login" type="text" class="validate">
                <label for="login">Login</label>
            </div>
            <div class="input-field col s6">
                <input id="password" type="password" class="validate">
                <label for="password">Password</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s2">
                <input id="birthDay" type="date" class="datepicker">

            </div>
            <div class="input-field col s4">
                <input id="address" type="text" class="validate">
                <label for="address">address</label>
            </div>
            <div class="input-field col s6">
                <textarea id="aBout" class="materialize-textarea" length="120"></textarea>
                <label for="aBout">about</label>
            </div>
        </div>

        <button id="addUserButton" class="btn waves-effect waves-light" type="submit" name="action">Добавить
            <i class="material-icons right">send</i>
        </button>
    </form>
</div>

</body>
</html>