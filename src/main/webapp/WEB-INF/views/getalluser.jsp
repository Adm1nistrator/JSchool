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
        var path= "${pageContext.request.contextPath}";
        $.ajax({
            type: "GET",
            dataType: "json",
            url: path+"/rest/users/",
            success: function (data) {
                var $resultList = $('.collection');
                for (var i = 0; i < data.length; i++) {
                    var item = data[i];
                    var userUrl = path+"/getuser?login="+item.login;
                    var link = $("<a href='"+userUrl+"' class='collection-item' >" + item.firstName+ " "+item.lastName + "</а>");
                    $resultList.append(link);
                }
            },
            error: function () {

            },
            complete: function () {
                $(".progress").hide();
            }
        });



    </script>
</head>
<body>

<div class="progress">
    <div class="indeterminate"></div>
</div>
<div class="container">
    <h4>Список пользователей</h4>
    <div class="collection">

    </div>

    <!-- Modal Structure -->
    <div id="modal1" class="modal modal-fixed-footer">
        <div class="modal-content">
            <div class="row">
                <form id="addUserForm" class="col s12">
                    <div class="row">
                        <div class="input-field col s6">
                            <input id="firstName"  type="text" class="validate">
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
                            <label for="login"></label>
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

                    <button id="updateButton" class="btn waves-effect waves-light" type="submit">Обновить
                        <i class="material-icons right">send</i>
                    </button>
                </form>
            </div>


        </div>
    </div>

</div>




</body>
</html>