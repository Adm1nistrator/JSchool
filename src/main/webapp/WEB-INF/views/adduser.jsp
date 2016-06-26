<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="head.jsp" />

    <script type="text/javascript">
        $(function () {
            var contextPath = "${pageContext.request.contextPath}";
            $("form").submit(function (event) {
                event.preventDefault();
                var formData = $(this).formToJSON();
                $.ajax({
                    url: contextPath + "/rest/users/",
                    type: 'POST',
                    contentType: "application/json; charset=utf-8",
                    data: formData,
                    success: function () {
                        alert("Пользователь добавлен");
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
        });
    </script>
</head>
<body>
<div class="container">
    <h1>Создание нового пользователя</h1>
    <div class="row">
        <form id="addUserForm" class="col s12">
            <div class="row">
                <div class="input-field col s6">
                    <input id="firstName" name="firstName" type="text" class="validate">
                    <label for="firstName">Имя</label>
                </div>
                <div class="input-field col s6">
                    <input id="lastName" name="lastName" type="text" class="validate">
                    <label for="lastName">Фамилия</label>
                </div>
            </div>

            <div class="row">
                <div class="input-field col s6">
                    <input id="login" name="login" type="text" class="validate">
                    <label for="login">Логин</label>
                </div>
                <div class="input-field col s6">
                    <input id="password" name="password" type="password" class="validate">
                    <label for="password">Пароль</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s2">
                    <input id="birthDay" name="birthDay" type="date" class="datepicker">
                </div>
                <div class="input-field col s4">
                    <input id="address" name="address" type="text" class="validate">
                    <label for="address">Адрес</label>
                </div>
                <div class="input-field col s6">
                    <textarea id="aBout" name="aBout" class="materialize-textarea" length="120"></textarea>
                    <label for="aBout">Дополнительные сведения</label>
                </div>
            </div>


            <button class="btn waves-effect waves-light" type="submit">Добавить
                <i class="material-icons right">send</i>
            </button>
        </form>
    </div>
</div>
</body>
</html>