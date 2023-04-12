# Características de los entornos de producción

## Alta disponibilidad

## Escalabilidad
    Capacidad de ajustar la infra a las necesidades de cada momento (petciones/usuarios)

        App1 
            Dia 1       100 usuarios
            Dia 100     1000 usuarios           En este caso, tendríamos lo que se denomina ESCALABILIDAD VERTICAL: MAS MAQUINA !
            Dia 300     10000 usuarios
            Dia 1000    100000 usuarios

        App2: Esto es lo normal (habitual) a día de hoy: INTERNET
            Hora n       100 usuarios
            Hora n+1     1000000 usuarios          WEB TELEPIZZA
            Hora n+2     1000 usuarios              En este caso, tendríamos lo que se denomina ESCALABILIDAD HORIZONTAL: MAS MAQUINAS !
            Hora n+3     3000000 usuarios           

        Nos sale el concepto de cluster: conjunto de maquinas que trabajan juntas para dar un servicio

        Nuestra aplicación la vamos a tener instalada en multiples servidores... 
        Pero cuidado... mi aplicación tiene muchas partes... hace muchas cosas diferentes

## Soy NETFLIX !
    Funcionalidades:
    - Streaming en tiempo real de peliculas, episodios, documentales
    - Cobrar por los servicios
    - Descarga de peliculas a dispositivos
    - Mostrar peliculas que pueden ser de tu interés....

    En todo momento, todas esas funcionalidades (programas) van a necesitar los mismos recursos? Posiblemente no
    Las necesidades de cada uno de ellos cambian en el tiempo de manera independiente al resto

---

# Arquitecturas orientadas a Microservicios

Son una evolución de las arquitecturas CLIENTE-SERVIDOR.

        COMPUTADORAS 
                                    RED
            Computadora1    --------|
                                    |------     Servidor (computadora más gordita!)
            Computadora2    --------|               Software servidor
                Software cliente                        DATOS

Desgajo la funcionalidad en 2 sistemas que se van a estar comunicando entre si:
- Me permiten CENTRALIZAR LOS DATOS:
  - Congruencia / Acceso compartido en tiempo real a los datos
  - Seguridad
  - Volumen de datos
- Tener computadoras para los clientes más ligeras (poco hardware)

Esta arquitectura implica un aumento en la complejidad del desarrollo.
- Tengo que montar 2 programas
- Y tengo que comunicarlos entre si:
    - Definir un lenguaje 
    - Definir un protocolo de comunicación

# COMUNICACION

Computadora/programas                                  Computadora2/Programa2
Emisor ------------------------ CANAL ---------------> Receptor
                                        mensaje (IDIOMA: lenguaje)
                                RED

Y aquí nos falta algo clave: PROTOCOLO DE COMUNICACION

## Protocolo? 

Conjunto de reglas a seguir

Cuando hablamos por radio / Walkie-talkie : CORTO Y CAMBIO

# Mundo WEB

## La web???

Es un servicio que se ofrece sobre Internet ( otros servicios: correo, tvip, vozip, juegos online)

La web la crea en los 90 Tim Berners-Lee:
- Un lenguaje para transmitir información: HTML             Hypertext Markup Language
- Un protocolo para transmitir esa información: HTTP        Hypertext Transfer Protocol

A partir del momento en que se generan esos ESTANDARES: HTML y HTTP (W3C), se comienzan a montar:
- Programas que instalar en los clientes que hablen esos protocolos (HTTP) y sepan procesar el lenguaje HTML:   Navegadores de internet
- Programas que instalar en los servidores que hablan esos protocolos y sirven la información de esa forma:     Servidores web (Apache, nginx)

La cuestión es que el mundo WEB va orientado a SERES HUMANOS

En un fichero HTML, lo que tenemos dentro es:
- body
- head
- parrafo
- lista ordenada
- negrita
- imagen
- tabla
- resaltado

Y a eso le metemos luego el CSS:
- Negrita
- Letra arial 15 puntos
- Sangrado de 10 pixels
- Borde negro de 1px 

Cuando comienza la web, los HTML se generaban pro programas tipo FRONT PAGE (Office): Los desarrolladores picabamos páginas WEB(HTML)

Eso evoluciona en un momento dado: PAGINAS WEB -> APLICACIONES WEB

Donde el HTML no existe de antemano en un servidor... se genera bajo demanda en cada petición (normalmente personalizando la info en base al usuario)
El HTML comienza a autogenerarse = Montamos programas que generan el HTML

Para esos programas necesitamos un lenguaje de programación:
- PHP
- Java (JSPs, Servlets = J2EE)
    J2EE -> JEE --> JEE : Framework en el mundo JAVA para montar app en empresas
    Java Enterprise Edition
                    Jakarta Enterprise Edition
    Ese framework ofrece un monton de librerias (APIs):
        - Servlets (HttpRequest, HttpSession, HttpResponse, HttpServlet)
        - JDBC
        - JMS
        - JPA
- ASP.net, C#

Pero las app web siguen estando orientadas a SERES HUMANOS (HTML)

En un momento dado, nos preguntamos... Y si al otro lado (cliente) hay otro programa en lugar de un ser humano?

Clientes                                            AMAZON

                                                        Servidor de aplicaciones (Evolución de un servidor web) = HTTP + Sabe hablar con programas escrito en un lenguaje de programación X, para solicitarles la generación de un HTML
                                                            JAVA: Weblogic, JBoss (wildfly), Websphere, Tomcat, glassfish
Felipe ---> Quiero calzoncillos ----------------->      Buscar productos ---> BBDD?
                                HTTP ( HTML )
Menchu ---> Quiero pelota ----------------------->      Comprar producto
                                                        Ver el estado de mis pedidos
                                HTTP ( HTML )

Programa en la sede de SEUR/UPS 
qué pedidos debo repartir hoy ? ----------------->      Listado de pedidos para repartir **
Cuando se ha repartido un pedido ---------------->      Marcar pedido como entregado!    **
^^^^^
Aquí lo que hay es un programa, no un ser humano
                                HTTP(s)
                                Lenguaje? 
                                    Me sirve HTML? NO... HTML va orientado a seres humanos.
                                    Necesitamos lenguajes que no vayan orientados a seres humanos... que me permitan el envío de datos en crudo:
                                        - XML
                                        - JSON

Y entonces empezamos a montar apps en el servidor ** que también hablan HTTP, que se instalan dentro de un servidor de aplicaciones, pero que dejan de generar HTML, y pasan a generar JSON o XML.---> Nacimiento del mundo de los servicios WEB

Inicialmente se opta por el envío de información en XML.
    Y se crea un protocolo (por encima de HTTP) para lidiar con este lenguaje de envío de datos): SOAP
Eso se usa unos cuantos años... Pero vaya follón que es trabajar con eso.... !
Y al final se opta por otro lenguaje mucho más sencillo: JSON
Y simplemente por unas restricciones en el uso de el protocolo HTTP: REST

Pasa otra cosa.... en paralelo....
Hace 20-15 años... cómo accedía a datos en internet? Desde mi pc con un navegador de internet

Y hoy en día?  cómo accedo a los datos?
- Desde mi PC con un navegador de internet???? Esta ya ha dejado de ser la forma preferida...
- Desde mi Telefono/Tablet/TV con un navegador de internet???? Esto se usa mucho... aunque es la misma vaina que lo de arriba. (Pantalla más reducida)
- A través de apps especializadas que corren en teléfonos móviles / TV
    - App banco
    - App aliexpress, amazon
- A través de otro tipo de Apps que corren dentro de un asistente de voz (ALEXA, OK google, SIRI)

NETFLIX                                                                                                                         SERVIDOR
- App web, que corre en un navegador y que permite a la gente ver pelis                                                         programa para 
                                                                                                                                actualizar los datos Tarjeta?
- App netflix?
  - TV
            Android
            Otros SO...                                                                                                         programa de streaming
  - Movil   iOS                                                                                                                 programa para crear
                                                                                                                                cuenta de usuario
  - Movil   Android                                                                                                          ahora admite un avatar?
                                                                                                                                    NuevaCuentaV1
                                                                                                                                    NuevaCuentaV2

Las apps web... antiguamente corrían en un servidor... Y en el servidor se generaba el HTML... Esto ya no se hace... desde hace mucho: JSPs y compañía OBSOLETOS !!!!

Donde generamos hoy en día el HTML? En el navegador del cliente: A través de programas escritos en lenguaje JS: VueJs, AngularJS, ReactJS, Polymer


---

# En paralelo con todo esto.

Llevábamos años montando lo que llamábamos MONOLITOS (apps monolíticas).
Una app gigante que hacía de todo... En JAVA montabamos un WAR o un EAR gigante, que necesitaba correr en un serv. de apps. gigante (e hipercaro: weblogic, websphere, jboss)
ESTO RESULTO SER UNA CAGADA GIGANTESCA !!!!!
- Son escalables... pero... cuando escalo, escalo el sistema en su conjunto. Y quizás solo necesito escalar una parte de la app.
- Muy difíciles de mantener: Todo está entremezclado y entrelazado. 
                                Cualquier cambio implica la necesidad de tocar en muchos sitios del código
- Muy difíciles de evolucionar: Todo está entremezclado y entrelazado. 
                                Cualquier cambio implica la necesidad de tocar en muchos sitios del código
- Me obligan a usar una única tecnología (JAVA, C#... ) y quizás para distintas tareas, quiero usar distintas herramientas!

Hoy en día planteamos una aplicación como un CONJUNTO DE programas DEBILMENTE ACOPLADOS entre si

# Y estas 2 cosas son las que unimos al plantear una ARQUITECTURA ORIENTADA A SERVICIOS / MICROSERVICIOS

En JAVA hay un framework que nos permite montar servicios web de forma muy cómoda (springboot: Que nos ofrece una configuración predefinida sobre Spring)

Cada uno de esos programas es un proyecto en si mismo Y acabará generando un fichero WAR, que corren en servidores de apps diferentes.
Y me quito la necesidad de esos mega-servidores de apps que tenía antes. Me sirve con un serv. de apps más básico Y GRATUITO: Tomcat

---

Springboot < Spring
Maven
BBDD H2 -> MariaDB
A esos servicios les vamos amontar PRUEBAS !
- Pruebas unitarias
- Pruebas de integración
De esos servicios hay que generar documentación. SWAGGER -> OpenAPI
JWT
Stateless

---

# METODOLOGIAS DE GESTION DE PROYECTOS DE SOFTWARE

Antiguamente usábamos metodologías EN CASCADA ! WATERFALL

    HITO 1: Serie de requisitos que había que implementar en una determinada fecha 15 de abril. -> 20 de abril
            *******************
    HITO 2: Serie de requisitos que había que implementar en una determinada fecha 30 de abril
    HITO 3: Serie de requisitos que había que implementar en una determinada fecha 15 de mayo.
    

Hoy en día ha cambiado la forma en la que nos planteamos la gestión de un proyecto de software.
También la forma en la que lo ejecutamos el proyecto.

El proyecto se entrega al cliente de forma INCREMENTAL.

A las 2 semanas de comenzar un proyecto, ya hay una entrega en "producción"
Una entrega 100% funcional. A lo mejor solo con el 5% de la funcionalidad... pero 100% funcional
Y cada 2 semanas otra entrega en producción.

Entrega 1:  Sprint 1: Serie de requisitos que había que implementar en una determinada fecha 15 de abril. 
                      R1, R2, R3, R4                                                   *****************
                      Se entrega el R1, R2, R3... y el 4, se mueve al siguiente sprint
                        5% de la funcionalidad... que pruebo? ese 5%
            Sprint 2: Serie de requisitos que había que implementar en una determinada fecha. 
                        +5% de la funcionalidad... que pruebo? ese 5% nuevo + 5% anterior
            Sprint 3: Serie de requisitos que había que implementar en una determinada fecha. 
Esta forma de trabajar nos ha ayudado de sobremanera con un problema que teníamos con las metodologías en cascada: FEEDBACK y el reajuste de requisitos.

Pero las metodologías ágiles han venido con sus propios problemas nuevos:
- Cada 15 días / mes, tengo un paso a producción! -> PRUEBAS de producción cada 15 días. -> Pruebas se multiplican !!!!
                                                     DESPLIEGUE EN PRODUCCION!

No hay pasta para aguantar ese sobre-esfuerzo!
n instalaciones 
n x Un huevo de pruebas

Esto solo tienen una UNICA SOLUCION ! AUTOMATIZAR las instalaciones y las pruebas !

Esto es un cambio de paradigma importante !

## Pruebas de software

### Para qué sirven?

- Verificar el cumplimiento de un conjunto de requisitos
  - Detectar fallos/defectos
  - Garantizar que el sistema hace lo que debe hacer
  - Detectar cosas que le falten al sistema
  - Verificar que el sistema sigue estable tras cambios.
- Conocer mejor el funcionamiento / comportamiento de mi sistema
- Proveer información en caso de fallo, para identificar el defecto.                FALLO -- depuración / debugging --> DEFECTO
- Identificar la causa de los errores
- Para controlar el grado de avance de un proyecto
    > EXTRAIDO DEL MANIFIESTO AGIL: El software **funcionando** es la medida principal de progreso.
                                                      vv              ****************
                                                    PROBADO !

### Vocabulario que usamos en el mundo de las pruebas (de software)

- Error:    Es cometido por un ser humano (error tipográfico, error de planteamiento, de entendimiento...)
- Defecto   Al cometer un error, introducimos un DEFECTO en un sistema/producto/programa
- Fallo     Es la manifestación de un defecto... No todo defecto provoca un fallo (o al menos con la misma frecuencia)

### Tipos de pruebas:

#### En base al nivel de la pruebas

- Unitarias     Comprueban UNA CARACTERISTICA de un componente AISLADO del sistema
- Integración   Comprueban la COMUNICACION entre componentes
- Sistema       Comprueban el COMPORTAMIENTO del sistema en su conjunto
  - Aceptación    Las que requiere el cliente

#### En base al objeto de prueba

Pruebas estáticas                           Que no requieren poner el sistema en funcionamiento
    Pruebas de calidad de código: Sonarqube
Pruebas dinámicas                           Que SI requieren poner el sistema en funcionamiento
- Funcionales                               Comprueban la funcionalidad
- No funcionales                            Comprueban otras cosas
  - De carga
  - De rendimiento
  - De estres
  - De HA
  - De Experiencia de usuario

Programa en JAVA -> Corriendo dentro de un serv de aplicaciones... trabajando contra una o varias BBDD y además para probarlo me conecto desde un cliente por HTTP

Una característica de las pruebas (a cualquier nivel que la haga) es que deben ser ATOMICAS: Se deben centrar en una UNICA CARACTERISTICA
Si falla la prueba, SE LO QUE ESTÁ FALLANDO

Aquí nos sale el concepto de MOCK. Los mock me permiten INTERCEPTAR las comunicaciones de mi sistema / componente con otros... ofreciendo respuesta CONTROLADAS y predefinidas = AISLANDO EL COMPONENTE QUE QUIERO PROBAR

Hoy en día, la tendencia (TDD, BDD, ATDD) es a realizar PRIMERO las pruebas y luego el código.


El diseño lo vamos a hacer según una ARQUITECTURA LIMPIA (clean arquitecture)

---

# Un servicio para la gestión de unos usuarios en un servidor

CRUD
Creación de usuarios
Modificación de usuarios
Borrado de usuarios
Recuperación de usuarios

## Devuelveme TODOS los usuarios del servidor, según está definido en la versión 1 del API

GET http://servidor:8080/api/v1/users
Envío:

Devuelve:
- Content-Type: application/json
- Return code:  200
[
    {
        "id": 127,
        "nombre": "Ivan",
        "apellidos": "Osuna",
        "email": "ivan@osuna.com",
        "telefono": "938459583"
    },
    {
        "id": 128,
        "nombre": "Menchu",
        "apellidos": "García",
        "email": "menchu@garcia.com",
        "telefono": "1231897123"
    },
    ...
]

## Dar de alta un usuario

POST http://servidor:8080/api/v1/users
Envío:
- Content-Type: application/json
{
    "nombre": "Ivan",
    "apellidos": "Osuna",
    "email": "ivan@osuna.com",
    "telefono": "938459583"
}
Devuelve:
- Content-Type: application/json
- Return code:  201
{
    "id": 127,
    "nombre": "Ivan",
    "apellidos": "Osuna",
    "email": "ivan@osuna.com",
    "telefono": "938459583"
}


GET         Recuperar información del servidor
POST        Dar de alta información en el servidor
PUT         Modificar información en el servidor
HEAD        Comprobar si existe una información en el servidor
DELETE      Eliminar información del servidor

# Versiones de software

1.2.3

                Cuando se incrementa?
1: Major        Cuando hay un cambio que rompe con la compatibilidad
                Si alguien se actualiza a este cambio, está en peligro de que lo que tiene en funcionamiento le deje de funcionar
2: Minor        Cuando se añade funcionalidad
                Cuando una funcionalidad se marca como obsoleta
                    + Puede haber arreglo de errores
3: Patch        Cuando se arreglan errores (bugs)

## Librería del diccionario

1.0.0           Libero la primera versión que hará unas cositas
1.0.1           Arreglo de un bug
1.1.0           Nueva funcionalidad
                    + dameAlternativa(String palabra): String
1.2.0           Cambio en la signatura de una función (nueva función + otra función la marco como deprecated)
                    ~ dameAlternativa(String palabra): String
                    + dameAlternativas(String palabra): List<String>
2.0.0           Quito la función del API
                    - dameAlternativa(String palabra): String

A la hora de montar microservicios.... el CONTROL DEL major es crítico
Habitual es que mantengamos en producción varios major en paralelo de la misma funcionalidad (programa/servicio)

NETFLIX
Frontends                                                   Backend
- app iOS v1                                                    Dame información de un usuario v1
- app Android v1                                                    nombre, email, telefono
- app TV Android v2                                             Dame información de un usuario v2
- app TV XXXXX v2                                                   con muchos mas datos
- app web v2
- ...

                                      ID
GET http://servidor:8080/api/v1/users/127

{
    "nombre": "Ivan",
    "apellidos": "Osuna",
    "email": "ivan@osuna.com",
    "telefono": "938459583"
}

GET http://servidor:8080/api/v2/users/127

{
    "nombre": "Ivan",
    "apellidos": "Osuna",
    "datosContacto": [
        { 
            "tipo": "email",
            "valor": "ivan@osuna.com"
        },
        { 
            "tipo": "telefono",
            "valor": "938459583"
        },
        { 
            "tipo": "email",
            "valor": "osuna@ivan.com"
        }
    ],
    "avatar": {
        "foto": "http://miservidorimagenes/user/127.png",
        "video": "http://miservidorimagenes/user/127.mp4"
    }
}

---

# JSON

JavaScript Object Notation
var usuario = {
                "nombre": "Ivan",
                "apellidos": "Osuna",
                "edad": 44
              }

var numero = 3
var logico = true
var texto = "hola"
var lista = [1,2,3]
var superlista = [
                    {
                        "nombre": "Ivan",
                        "apellidos": "Osuna",
                        "edad": 44
                    },
                    {
                        "nombre": "Menchu",
                        "apellidos": "García",
                        "edad": 33
                    }
                 ]


En JS Muchas veces usamos Objetos como el equivalente en JAVA a un Map<String, Object>

# POJO : Plain Old Java Object

public class Usuario{ // POJO
    public String nombre;
    public String apellidos;
    public int edad;
}

Usuario miUsuario1 = new Usuario();
miUsuario1.nombre="Ivan";
miUsuario1.apellidos="Osuna";
miUsuario1.edad=44;

Map<String,Object> miTablaDeDatos = new HashMap<>(); // JAVA
miTablaDeDatos.put("clave1","valor1");

miTablaDeDatos = {}                                  // JS
miTablaDeDatos["clave1"] = "valor1";

---
## Vamos a explicar el comportamiento del servicio de usuarios mediante ejemplos de uso

#language:es

Requisito: Servicio de usuarios v1

    Antecedentes:
        Dado un usuario
        Y    el usuario tiene por nombre "Ivan"
        Y    el usuario tiene por apellidos "Osuna"
        Y    el usuario tiene por una edad de 44
        Y    el usuario tiene por email "ivan@osuna.com"
        Y    el usuario está guardado en la BBDD
        
        Dado un usuario
        Y    el usuario tiene por nombre "Menchu"
        Y    el usuario tiene por apellidos "García"
        Y    el usuario tiene por una edad de 33
        Y    el usuario tiene por email "menchu@garcia.com"
        Y    el usuario está guardado en la BBDD
    
    Esquema del escenario: Recuperación de usuarios
        Cuando invoco al servicio "/api/v1/users" con método "GET"
        Entonces se recibe una respuesta con código "200"
        Y        la respuesta contiene un JSON
        Y        el JSON es una lista de longitud 2
        Y        el elemento en la posición <posicion>, debe tener por nombre: "<nombre>"
        Y        el elemento en la posición <posicion>, debe tener por apellidos: "<apellidos>"
        Y        el elemento en la posición <posicion>, debe tener por edad: <edad>
        Y        el elemento en la posición <posicion>, debe tener por email: "<email>"

        Ejemplos:
        | posicion  | nombre        | apellidos     | edad  | email                         |
        | 1         | Ivan          | Osuna         | 44    | ivan@osuna.com                |
        | 2         | Menchu        | García        | 33    | menchu@garcia.com             |


---

# Tiempo de implementar nuestro servicio !!!!




            Frontal WEB, Otro servicio, ....
                ^v
            API Rest                                          >      Controlador
                nuevoUsuario ~ /api/v1/users [POST]
                    email? 
                v^
            ServicioDeUsuarios(clase)                        >       Servicio
                v^ + logica
            RepositorioDeUsuarios(clase) < Usuario(clase)    >       Modelo
            ^  v
-----------------------------------------------------------------------------
                            BBDD

Necesitaré la clase Usuario (POJO) para contener los datos de un usuario     >      MODELO

Necesitaré una clase que se encargue de la PERSISTENCIA de los usuarios: RepositorioDeUsuarios

Imaginad que al dar de alta un usuario, le debemos enviar un email?

RepositorioDeUsuarios.java
    guardar
    nuevo

El controlador: API REST: Solo debe ser eso... un API... una forma de exponer un servicio
Qué pasa si mañana decido exponer el servicio de otra forma: SOAP
                                                             API Java
                                                             RPC
                                                             REST v2



Capa                Quién hace el trabajo                                                   Datos
-----------------------------------------------------------------------------------------------------------------
WEB                 ????
---------------vvv----------------------------^^^----------------------------------------------------------------
Controlador         APIRestV1DeUsuarios                                                      DatosEntradaUsuario
(expongo una            getUsuarios()               ~ /api/v1/usuarios[GET]                     nombre, email, telefono
 funcionalidad)         getUsuario(id)              ~ /api/v1/usuarios/<id>[GET]
                            return new DatosSalidaUsuario ()
      ||                nuevoUsuario(DatosEntradaUsuario datos)         ~ /api/v1/usuarios[POST]
    Servicio                DatosUsuario datosUsuario=new DatosUsuario();                    DatosSalidaUsuario
                            nuevoUsuario.setNombre(datos.NOMBRE);                               id, nombre, email, telefono
                            ...
                            nuevoUsuario.setNombre(datos.EDAD);
                            ServicioDeUsuarios.nuevoUsuario(datosUsuario);
                        modificarUsuario(id,datos)  ~ /api/v1/usuarios/<id>[PUT]
                        eliminarUsuario(id)         ~ /api/v1/usuarios/<id>[DELETE]
---------------vvv----------------------------^^^----------------------------------------------------------------
Servicio            ServicioDeUsuarios                                                      DatosUsuario(POJO)
(logica)                getUsuarios()                                                        id, nombre, email, telefono,
                                                                                             edad = -1
                        getUsuario(id)
                        //nuevoUsuario(nuevoUsuario)
                            //RepositorioDeUsuarios.guardarUsuario(nuevoUsuario);   // GRAVE ERROR !!!!! Muy goloso !!!
                                                                                    // Y ese es el problema.. que es muy goloso!!!
                                                                                    // Pero grave ERROR !!!!
                            //mandar un email
                        nuevoUsuario(datosUsuario)
                            Usuario nuevoUsuario=new Usuario();
                            nuevoUsuario.setNombre(datosUsuario.NOMBRE);
                            ...
                            nuevoUsuario.setNombre(datosUsuario.EDAD);
                            RepositorioDeUsuarios.guardarUsuario(nuevoUsuario);
                            //mandar un email
                        modificarUsuario(id,datos)
                        eliminarUsuario(id)
---------------vvv----------------------------^^^----------------------------------------------------------------
Modelo              RepositorioDeUsuarios                                                   Usuario(POJO)
(entidades              guardarUsuario(Usuario)                                              id, nombre, email, telefono, edad
sobre las que           borrarUsuario(Usuario)
trabajo)                eliminarUsuario(Usuario)
                        buscarUsuarios()

... 
Controlador         APIRestV2DeUsuarios                                                      DatosEntradaUsuario
(expongo una            getUsuarios()               ~ /api/v2/usuarios[GET]                  nombre, email, telefono, edad
 funcionalidad)         getUsuario(id)              ~ /api/v2/usuarios/<id>[GET]
                            return new DatosSalidaUsuario ()
      ||                nuevoUsuario(DatosEntradaUsuario datos)         ~ /api/v1/usuarios[POST]
    Servicio                DatosUsuario datosUsuario=new DatosUsuario();                    DatosSalidaUsuario
                            nuevoUsuario.setNombre(datos.NOMBRE);                            id, nombre, email, telefono, edad
                            ...
                            nuevoUsuario.setNombre(datos.EDAD);
                            ServicioDeUsuarios.nuevoUsuario(datosUsuario);
                        modificarUsuario(id,datos)  ~ /api/v2/usuarios/<id>[PUT]
                        eliminarUsuario(id)         ~ /api/v2/usuarios/<id>[DELETE]




# Empieza la magia de Springboot

Springboot en automático va validar el JSON que se reciba contra un ESQUEMA JSON
Y además, va a transformar ese JSON en un Objeto JAVA: POJO

# Ahora si, vamos a empezar a picar JAVA

Y vamos a usar una herramienta para que nos ayude con las compilaciones, empaquetado, dependencias... etc

## MAVEN

Nos ayuda a automatizar muchas tareas de un proyecto.
Todo el trabajo que hace maven, lo hacen realmente añadidos que le ponemos a maven. 
Maven per se, no sabe hacer la O con un canuto!
- Plugin de compilar
- Plugin de empaquetar
- Plugin de mis pruebas
- Plugin de compilacion de las pruebas
- Plugin para mandar mi proyecto a SonarQube
- ...

Maven nos obliga a trabajar (es configurable PERO NUNCA SE CAMBIA) con una determina estructura de carpetas:

    proyecto
        |- src
        |   |- main                     Código principal de mi programa
        |   |   |- java/                 La parte del código escrita en JAVA
        |   |   |- resources/            Otros archivos de mi código, como por ejemplo configuraciones
        |   |- test                     Código de las pruebas de mi programa
        |       |- java/                 La parte del código escrita en JAVA
        |       |- resources/            Otros archivos de mi código, como por ejemplo configuraciones
        |- target
        |   |- classes/                  El resultado de compilar mi programa + lo que hay en src/main/resources/
        |   |- test-classes/             El resultado de compilar mis pruebas + lo que hay en src/test/resources/
        |   |- surefire-reports/         Informes de ejecución de pruebas
        |   |- artefacto                 Distribuible de mi proyecto
        |- pom.xml                      Configuración de maven para mi proyecto

## pom.xml:

### Coordenadas de mi proyecto:

- groupId                               Identificar a mi empresa/proyecto (a alto nivel)
- artifactId                            Dentro de mi empresa/proyecto de alto nivel, modulo
- Version                               Versión de ese artefacto/modulo

### Dependencias

Librerías adicionales que necesita mi programa:
- Compilar
- Producción
- Pruebas

### Plugins con los que quiero trabajar

Maven por defecto ya viene con una serie de plugins preconfigurados... 
Que me puede interesar cambiar (al menos las versiones de esos plugins)
Adicionalmente me puede interesar añadir nuevos plugins

## A maven le pedimos que ejecute tareas sobre nuestro proyecto (les llamamos goals)

Esos goals, al final se traducen en llamadas a los plugins.
con los plugins que vienen por defecto, que GOALS encontramos:
- clean             Borra la carpeta target/ entera
- compile           Compila lo que hay en src/main/java/ y lo deposita (el resultado) en target/classes/
                    También copia lo que hay en la carpeta src/main/resources/ a la carpeta target/classes/
- test-compile      Compila lo que hay en src/test/java/ y lo deposita (el resultado) en target/test-classes/
                    También copia lo que hay en la carpeta src/test/resources/ a la carpeta target/test-classes/
- test              Ejecuta las pruebas que existen en target/test-classes/
                    Y genera un informe resultado de las pruebas en la carpeta target/surefire-reports/
- package           Empaqueta el proyecto, generando el distribuible: .jar .war .ear NADA y lo deposita en target/
- install           Copia mi artefacto en la carpeta .m2, de forma que pueda ser usado por otros PROYECTOS
                    Que otros proyectos puedan añadir este proyecto entre sus dependencias.

La carpeta .m2 de MAVEN: 
Es donde maven buscar todas las dependencias de un proyecto...
Cuando maven no tiene en ese directorio una dependencia que necesito, la descarga de un 
repositorio de artefactos (maven central), y lo deja en esa carpeta

A la hora de trabajar con maven, podemos crear un proyecto desde cero, montando nosotros esa estructura de carpetas, y un fichero pom.xml.

Mucho más habitual es partir de una PLANTILLA (ARQUETIPOS)

En nuestro caso vamos a partir de un arquetipo, que no mete nada de nada de SPRINGBOOT...
Quiero que lo configuremos entero a mano, para que entendamos lo que estamos haciendo.
En la empresa lo habitual es que os den una serie de arquetipos, con pre-configuraciones que se hayan decidido corporativamente.

Nosotros vamos a tomar un arquetipo que lo único que generará es un HELLO WORLD ! punto. Sin dependencias a priori.
