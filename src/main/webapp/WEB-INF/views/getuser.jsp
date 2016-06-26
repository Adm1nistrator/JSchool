<%@page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <script type="text/javascript" src="/resources/js/materialize.min.js"></script>

    <script type="text/javascript">
        var login ="${login}";
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "${pageContext.request.contextPath}/rest/users/"+login,
            success: function (item) {
                $('#firstName').val(item.firstName);
                $('#lastName').val(item.lastName);
                $('#login').val(item.login);
                $('#password').val(item.password);
                $('#birthDay').val(item.birthDay);
                $('#address').val(item.address);
                $('#aBout').val(item.aBout);
            },
            error: function () {
                alert("Пользователя нет ");
            },
            complete: function () {
                $(".waiting").hide();
            }
        });

        <!--Обновлякем данные пользователя-->
        $(function () {
            $("form").submit(function (event) {
                event.preventDefault();
                var formData = JSON.stringify($(this).serializeObject());
                $.ajax({
                    url: "${pageContext.request.contextPath}/rest/users/"+login,
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: formData,
                    success: function () {
                        alert("Пользователь обновлен");
                    },
                    error: function () {
                        alert("что-то пошло не так ");
                    },
                    complete: function () {
                        alert("выполненно ");
                    }
                });
                return false;
            });

            $.fn.serializeObject = function () {
                var o = {};
                var a = this.serializeArray();
                $.each(a, function () {
                    if (o[this.name] !== undefined) {
                        if (!o[this.name].push) {
                            o[this.name] = [o[this.name]];
                        }
                        o[this.name].push(this.value || '');
                    } else {
                        o[this.name] = this.value || '';
                    }
                });
                return o;
            };

        });




    </script>
</head>
<body>
<div class="row">
    <form id="addUserForm" class="col s12">
        <div class="row">
            <div class="input-field col s6">
                <input id="firstName" name="firstName" type="text" class="validate">
                <label for="firstName">First Name</label>
            </div>
            <div class="input-field col s6">
                <input id="lastName" name="lastName" type="text" class="validate">
                <label for="lastName">Last Name</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input id="login" name="login" type="text" class="validate">
                <label for="login">Login</label>
            </div>
            <div class="input-field col s6">
                <input id="password" name="password" type="password" class="validate">
                <label for="password">Password</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s2">
                <input id="birthDay" name="birthDay" type="date" class="datepicker">
            </div>
            <div class="input-field col s4">
                <input id="address" name="address" type="text" class="validate">
                <label for="address">address</label>
            </div>
            <div class="input-field col s6">
                <textarea id="aBout" name="aBout" class="materialize-textarea" length="120"></textarea>
                <label for="aBout">about</label>
            </div>
        </div>


        <button class="btn waves-effect waves-light" type="submit">Добавить
            <i class="material-icons right">send</i>
        </button>
    </form>
</div>


</body>
</html>