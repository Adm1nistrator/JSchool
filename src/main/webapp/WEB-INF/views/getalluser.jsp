<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%--<script src="<c:url value="/resources/jquery-3.0.0.min.js" />"></script>--%>
     <script type="text/javascript" src="/resources/jquery-3.0.0.min.js"></script>
    <script type="text/javascript">

        jQuery('#json').click(function () {

            $.getJSON("${pageContext.request.contextPath}/rest/users/",
                    function (data) {
                        $('#myName').html(data[0].firstName);
                    });
        });




            $.ajax({
                type: "GET",
                dataType: "json",
                url: "${pageContext.request.contextPath}/rest/users/",
                success: function (data) {
                    var $resultList =  $('.list-placeholder');
                    for(var i=0; i< data.length; i++){
                        var item = data[i];
                        $resultList.append("<div class='red'>"+item.firstName+"</div>").append("<div>"+item.lastName+"</div>");
                    }
                },
                error: function(){

                },
                complete: function(){
                   $(".waiting").hide();
                }
            });


    </script>
</head>
<body>
    <h1>Список пользователей</h1>

    <span class="waiting">waiting...</span>
    <div class="list-placeholder"></div>
    <div class="list-placeholder"></div>

    <button id="ajax">ajax call</button>
    <button id="json">json</button>


</body>
</html>