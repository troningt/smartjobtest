# Como probarlo

### Docker
Deberan instalar y configurar la aplicación de Docker, a continuación verán la [documentación oficial de Docker](https://docs.docker.com/build/cloud/?_gl=1*1b0umwv*_ga*MTU5OTE0ODM1My4xNzExMzQyOTk3*_ga_XJWPQMJYHQ*MTcxMTQwNDM4My4xLjEuMTcxMTQwNDM4NS41OC4wLjA.)

Una vez instalado Docker podemos iniciar con la prueba del API, el back viene con data inicial para esto. En esta data inicial encontraremos el usuario administrador y un usuario de prueba.
Para loguearse debemos acceder a la siguiente URL con las siguientes credenciales:

``` curl
curl --location 'http://localhost:8080/api/v1/auth/login' \
--header 'Content-Type: application/json' \
--data '{
"username": "rtheran",
"password": "ADMIN456"
}'
```

El resultado de esta consulta será un response como el siguiente:
``` json
{
    "userId": null,
    "jwt": "eyJhbGciOiJIUzUxMiJ9.eyJyb2xlIjoiQURNSU5JU1RSQVRPUiIsIm5hbWUiOiJSb25ueSBUaGVyw6FuIiwidHlwIjoiSldUIiwic3ViIjoicnRoZXJhbiIsImlhdCI6MTcxMTM5MzY3NiwiZXhwIjoxNzExMzk3Mjc2fQ.rCw2vNSABpX84X6Y0yZQTgdlbuKY6wUMT2SHAQ112w6FG2D-G9AseMPdfDgHW7tAUQoeYPSnbloMlux0k1WZvA"
}
```

Este token nos servirá para crear o consultar usuarios

``` curl
curl --location 'http://localhost:8080/api/v1/users' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer token-here' \
--data-raw '{
"name": "Danny Theran",
"username": "dtheran1",
"email": "dtheran1@gmail.com",
"password": "ADMIN123",
"phones": [
{
"number": "3006665625",
"citycode": "1",
"contrycode": "2"
}
]
}'
```

Reemplazando el token-here con nuestro token

En este proyecto usé las siguientes tecnologías:

* Spring Actuator
* Spring Security
* Spring Compose
* Spring Web
* Spring Data JPA (Hibernate)
* Spring Devtools
* Spring Validation
* JUnit 5
* Docker
* JWT
* Github Copilot