# JSchool

Приложения для создания, редактировани, обновления и удаления пользоватедя, через RESTful Api.


## API
1 .Создание нового пользователя: 
 Http Method: POST
 URL: "/rest/users/"
 
 В теле запроса в формате JSON передаются данные пользователя:

 ```html
 {
    "login": "vano",
    "firstName": "Иван",
    "lastName": "Иванов",
    "birthDay": "1979-09-09",
    "password": "password!1",
    "aBout": "тестовый пользваотель",
    "address": "где то в центре",
 }
 ```

2. RequestMapping(method = RequestMethod.GET, path = "/rest/users/{login}")
3.  @RequestMapping(method = RequestMethod.GET, path = "/rest/users/")
4.   @RequestMapping(method = RequestMethod.PUT, path = "/rest/users/{login}")
4.   @RequestMapping(method = RequestMethod.DELETE, path = "/rest/users/{login}")
