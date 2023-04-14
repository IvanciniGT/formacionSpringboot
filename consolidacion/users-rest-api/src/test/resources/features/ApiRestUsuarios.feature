#language:es

Requisito: Servicio de usuarios v1

	Antecedentes:
		Dado un usuario
		Y    el usuario tiene por nombre "Ivan"
		Y    el usuario tiene por apellidos "Osuna"
		Y    el usuario tiene por una edad de 44
		Y    el usuario tiene por email "ivan@osuna.com"
		Y    el usuario tiene por telefono "123456789"
		Y    el usuario está guardado en la BBDD
		
		Dado un usuario
		Y    el usuario tiene por nombre "Menchu"
		Y    el usuario tiene por apellidos "García"
		Y    el usuario tiene por una edad de 33
		Y    el usuario tiene por email "menchu@garcia.com"
		Y    el usuario tiene por telefono "987654321"
		Y    el usuario está guardado en la BBDD
	
	Esquema del escenario: Recuperación de usuarios
    Cuando invoco al servicio "/api/v1/users" con método "GET"
    Entonces se recibe una respuesta con código "200"
    Y        la respuesta contiene un JSON
    Y        el JSON es una lista de longitud 2
    Y        el elemento en la posición <posicion>, debe tener por "id": "<posicion>"
    Y        el elemento en la posición <posicion>, debe tener por "nombre": "<nombre>"
    Y        el elemento en la posición <posicion>, debe tener por "apellidos": "<apellidos>"
    Y        el elemento en la posición <posicion>, debe tener por "edad": <edad>
    Y        el elemento en la posición <posicion>, debe tener por "email": "<email>"
    Y        el elemento en la posición <posicion>, debe tener por "telefono": "<telefono>"

    Ejemplos:
        | posicion  | nombre        | apellidos     | edad  | email                         | telefono  |
        | 1         | Ivan          | Osuna         | 44    | ivan@osuna.com                | 123456789 |
        | 2         | Menchu        | García        | 33    | menchu@garcia.com             | 987654321 |
