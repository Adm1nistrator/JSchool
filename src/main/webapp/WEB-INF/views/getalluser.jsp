<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script type="text/javascript" src="/resources/js/materialize.min.js"></script>

    <script type="text/javascript">
        var path = "${pageContext.request.contextPath}";
        $.ajax({
            type: "GET",
            dataType: "json",
            url: path + "/rest/users/",
            success: function (data) {
                var $resultList = $('.collection');
                for (var i = 0; i < data.length; i++) {
                    var item = data[i];
                    var userUrl = path + "/getuser?login=" + item.login;
                    var deleteLink = path + "/rest/users/" + item.login;
                    var link = $("<a href='" + userUrl + "'>" + item.firstName + " " + item.lastName + "</а>");
                    var row = $("<li class='collection-item'></li>");
                    var button = $("<a href='" + deleteLink + "' class='secondary-content'><i class='small material-icons'>delete</i></a>");

                    button.click(function (event) {
                        event.preventDefault();
                        deleteuser(item.login,row);
                    });
                    $resultList.append(row.append(link).append(button));
                }
            },
            error: function () {

            },
            complete: function () {
                $(".progress").hide();
            }
        });

        function deleteuser(login, row) {
            $.ajax({
                type: "DELETE",
                url: path + "/rest/users/" + login,
                success: function () {
                    row.remove();
                    alert("Пользователь удален ");

                },
                error: function () {
                    alert("что-то пошло не так ");
                },
                complete: function () {
                    alert("выполенно");
                }

            })

        }


    </script>
</head>
<body>

<div class="progress">
    <div class="indeterminate"></div>
</div>
<div class="container">
    <h4>Список пользователей</h4>
    <ul class="collection">

    </ul>
</div>


</body>
</html>