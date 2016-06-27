# JSchool

Приложение для создания, редактирования, обновления и удаления пользователя через REST Api.


### API
##1 .Создание нового пользователя: 
Http Method: POST
URL: /rest/users/
 
 В теле запроса в формате JSON передаются данные пользователя:
 Ключевым идентификатором пользователя будет его логин {login}, при создании пользователя указывается обязательно. 

 ```html
 {
    "login": "vano",
    "firstName": "Иван",
    "lastName": "Иванов",
    "birthDay": "1979-09-09",
    "password": "password!1",
    "aBout": "тестовый пользователь",
    "address": "где то в центре"
 }
 ```

##2. Получить нформацию о пользователе
Http Method: GET
URL: /rest/users/{login}
В запросе необходимо указать {login}, в ответе в формате JSON будут полученны данные по пользователю с логином {login}
##3. получение списка пользователей
Http Method: GET
URL: /rest/users/
В ответе в ответе в формате JSON будут полученны данные по всем имеющимся пользователям
##4. Обновлении информации о пользователе.
Http Method: PUT
URL: /rest/users/{login}
В теле запроса в формате JSON передаются данные пользователя:
Ключевым идентификатором пользователя будет его логин {login}, данное поля изменять нельзя! 

 ```html
 {
    "login": "{login}",
    "firstName": "Иван",
    "lastName": "Иванов",
    "birthDay": "1979-09-09",
    "password": "password!2",
    "aBout": "тестовый пользователь",
    "address": "где то в центре"
 }
 ```
##5. Удаление пользователя
Http Method: DELETE
URL: /rest/users/{login}
В запросе необходимо указать {login}
