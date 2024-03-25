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

A continuación, te proporciono un manual paso a paso para configurar variables de entorno en IntelliJ IDEA y Visual Studio Code para un proyecto que utiliza PostgreSQL y seguridad basada en tokens JWT. Esto es especialmente útil para entornos de desarrollo y pruebas.
## Configuración en IntelliJ IDEA

1. Crear un archivo .env
   Primero, crea un archivo .env en la raíz de tu proyecto con las siguientes variables de entorno:

```
POSTGRES_DB=ms-security
POSTGRES_PASSWORD=passw1234
POSTGRES_USER=root
SECRET_KEY=Cxep9Aq5/Sg8CbeSWPz1/5VwM3aJe+z57BlHlT/1IZ2vWNIbg4W1Sn/bLs8m56nq
```
2. Configurar el plugin EnvFile
   IntelliJ IDEA no tiene soporte incorporado para archivos .env, por lo que necesitas instalar un plugin llamado EnvFile.

* Abre IntelliJ IDEA y ve a File > Settings > Plugins.
* Busca "EnvFile" y haz clic en "Install".
* Reinicia IntelliJ IDEA para activar el plugin. 

3. Configurar el plugin en tu configuración de ejecución
* Ve a Run > Edit Configurations.
* Selecciona la configuración de ejecución de tu aplicación.
* Haz clic en el ícono de más (+) en el área de "Before launch" y selecciona "Run External tool". 
* Haz clic en el ícono de más (+) y selecciona "EnvFile" de la lista de herramientas externas. 
* Habilita "Enable EnvFile" y agrega tu archivo .env haciendo clic en el ícono de más (+) y seleccionando el archivo. 
* Asegúrate de que las casillas estén marcadas para activar el plugin y cargar las variables.

4. Ejecutar tu aplicación 
Ahora, cuando ejecutes tu aplicación desde esta configuración, IntelliJ IDEA cargará las variables de entorno definidas en tu archivo .env.

## Configuración en Visual Studio Code

1. Crear un archivo .env
   Si aún no lo has hecho, crea un archivo .env en la raíz de tu proyecto como se describió anteriormente.

2. Instalar la extensión DotENV
   Aunque no es estrictamente necesario, instalar la extensión DotENV puede proporcionar resaltado de sintaxis para el archivo .env.

Ve a la barra lateral "Extensions".
Busca "DotENV" y haz clic en "Install".
3. Configurar el archivo launch.json
   Para cargar las variables de entorno cuando ejecutes tu aplicación desde VS Code:

Ve a la vista de "Run" y haz clic en "create a launch.json file" bajo "Run and Debug".
Selecciona el entorno que corresponda a tu proyecto (por ejemplo, Node.js).
Añade la siguiente configuración en el archivo launch.json:

```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "name": "Launch Program",
            "program": "${workspaceFolder}/src/app.js",
            "envFile": "${workspaceFolder}/.env",
            "request": "launch",
            "skipFiles": [
                "<node_internals>/**"
            ],
            "type": "node"
        }
    ]
}
```

Asegúrate de ajustar el campo "program" para que apunte al archivo principal de tu aplicación.
4. Ejecutar tu aplicación
   Con esta configuración, cada vez que inicies tu aplicación desde Visual Studio Code usando la configuración de depuración "Launch Program", VS Code leerá las variables de entorno del archivo .env.

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