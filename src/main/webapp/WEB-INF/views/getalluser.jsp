<%@page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="/resources/js/jquery-3.0.0.min.js"></script>
    <script type="text/javascript">

            $.ajax({
                type: "GET",
                dataType: "json",
                url: "${pageContext.request.contextPath}/rest/users/",
                success: function (data) {
                    var $resultList =  $('.list-placeholder');
                    for(var i=0; i< data.length; i++){
                        var item = data[i];
                        $resultList.append("<div>"+item.login+"</div>");
                    }
                },
                error: function(){

                },
                complete: function(){
                   $(".progress").hide();
                }
            });


    </script>
</head>
<body>
    <h1>Список пользователей</h1>

    <div class="progress">
        <div class="indeterminate"></div>
    </div>
    <div class="list-placeholder"></div>

</body>
</html>