### Práctica de clase en el módulo DWS, del CFGS DAW


### How to Work with the Code

    $ git clone https://github.com/paulinohuerta/saludando.git
    
The git clone command installs the source code from GitHub into a saludando folder.    

To build the two java projects, from the root of each one, you must execute   

    $ mvn clean install tomee:run

and then, you can access through a borwser   

    $ http://localhost:8080/JSFMaven


### What does the project get?
-----
The three versions manage to greet a client, indicating the number of times that greeting has been repeated.   

### PersistenciaRedis 
-----
_**Description**_: JSF project solving with persistence into Redis server.    
_**Dependenccies**_: init a Redis server.   

### SinPersistencia 
-----
_**Description**_: JSF project solving with the use of "set" and "map" structures.   

### saludando.php 
-----
_**Description**_: PHP script, to deploy into the DocumentRoot folder of Apache server.       
_**Dependenccies**_: init a Redis server, and `php-redis` library client.        



