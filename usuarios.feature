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
        Y        el elemento en la posición <posicion>, debe tener por id: "<posicion>"
        Y        el elemento en la posición <posicion>, debe tener por nombre: "<nombre>"
        Y        el elemento en la posición <posicion>, debe tener por apellidos: "<apellidos>"
        Y        el elemento en la posición <posicion>, debe tener por edad: <edad>
        Y        el elemento en la posición <posicion>, debe tener por email: "<email>"

        Ejemplos:
            | posicion  | nombre        | apellidos     | edad  | email                         |
            | 1         | Ivan          | Osuna         | 44    | ivan@osuna.com                |
            | 2         | Menchu        | García        | 33    | menchu@garcia.com             |

    Esquema del escenario: Recuperación de un usuario
        Cuando invoco al servicio "/api/v1/users" para el id "<id>" con método "GET"
        Entonces se recibe una respuesta con código "200"
        Y        la respuesta contiene un JSON
        Y        debe tener por id: "<id>"
        Y        debe tener por nombre: "<nombre>"
        Y        debe tener por apellidos: "<apellidos>"
        Y        debe tener por edad: <edad>
        Y        debe tener por email: "<email>"

        Ejemplos:
            | id        | nombre        | apellidos     | edad  | email                         |
            | 1         | Ivan          | Osuna         | 44    | ivan@osuna.com                |
            | 2         | Menchu        | García        | 33    | menchu@garcia.com             |

    Escenario: Borrar un usuario
        Cuando invoco al servicio "/api/v1/users/1" con método "DELETE"
        Entonces se recibe una respuesta con código "200"
        Y        la respuesta contiene un JSON
        Y        debe tener por id: "1"
        Y        debe tener por nombre: "Ivan"
        Y        debe tener por apellidos: "Osuna"
        Y        debe tener por edad: 44
        Y        debe tener por email: "ivan@osuna.com"

        Cuando invoco al servicio "/api/v1/users/1" con método "HEAD"
        Entonces se recibe una respuesta con código "404"
        
        Cuando invoco al servicio "/api/v1/users" con método "GET"
        Entonces se recibe una respuesta con código "200"
        Y        la respuesta contiene un JSON
        Y        el JSON es una lista de longitud 1
        Y        el elemento en la posición 1 debe tener por id: "2"
        Y        el elemento en la posición 1, debe tener por nombre: "Menchu"

    Escenario: Crear un usuario
        Cuando invoco al servicio "/api/v1/users" con método "POST" y el JSON:
        """
        {
            "nombre": "Ivan",
            "apellidos": "Osuna",
            "edad": 44,
            "email": "ivan@osuna.com"
        }
        """
        Entonces se recibe una respuesta con código "201"
        Y        la respuesta contiene un JSON
        Y        debe tener por id: "3"
        Y        debe tener por nombre: "Ivan"
        Y        debe tener por apellidos: "Osuna"
        Y        debe tener por edad: 44
        Y        debe tener por email: "ivan@osuna.com"
    
        Cuando invoco al servicio "/api/v1/users" con método "GET"
        Entonces se recibe una respuesta con código "200"
        Y        la respuesta contiene un JSON
        Y        el JSON es una lista de longitud 2
        Y        el elemento en la posición 1 debe tener por id: "2"
        Y        el elemento en la posición 1, debe tener por nombre: "Menchu"
        Y        el elemento en la posición 2 debe tener por id: "3"
        Y        el elemento en la posición 2, debe tener por nombre: "Ivan"
    
    Escenario: Modificar un usuario
        Cuando invoco al servicio "/api/v1/users/2" con método "PUT" y el JSON:
        """
        {
            "nombre": "Menchicta",
            "apellidos": "Garcíita",
            "edad": 34,
            "email": "menchuita@garciita.com"
        }
        """
        Entonces se recibe una respuesta con código "200"
        Y        la respuesta contiene un JSON
        Y        debe tener por id: "2"
        Y        debe tener por nombre: "Menchicta" 
        Y        debe tener por apellidos: "Garcíita"
        Y        debe tener por edad: 34
        Y        debe tener por email: "menchuita@garciita.com"

        Cuando invoco al servicio "/api/v1/users/2" con método "GET"
        Entonces se recibe una respuesta con código "200"
        Y        la respuesta contiene un JSON
        Y        debe tener por id: "2"
        Y        debe tener por nombre: "Menchicta"
        Y        debe tener por apellidos: "Garcíita"
        Y        debe tener por edad: 34
        Y        debe tener por email: "menchuita@garciita.com"
