<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="<c:url value="/resources/jquery-2.2.0.min.js" />"></script>
   <%-- <script type="text/javascript" src="/resources/jquery-2.2.0.min.js"></script>--%>
</head>

<body>

<button id="ajax">ajax call</button>
<button id="json">json</button>

<script type="text/javascript">
    $('#json').click(function(){
        alert('json');
        $.getJSON("http://localhost:8888/rest/users/",
                function(data) {
                    alert(data);
                });
    });

    $('#ajax').click(function(){
        alert('ajax');
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "http://localhost:8888/rest/users/",
            success: function(data){
                alert(data);
            }
        });
    });

</script>



</body>

</html>