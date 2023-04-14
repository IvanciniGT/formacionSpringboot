package com.curso.app.users;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.curso.app.users.models.Usuario;
import com.curso.app.users.repository.UsuariosRepository;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.spring.CucumberContextConfiguration;

@Suite									// Esta clase contiene una suite de pruebas
@IncludeEngines("cucumber")				// Las pruebas van a ser gestionadas a través de la herramienta cucumber
@SelectClasspathResource("features")	// Aquí indicamos a JUNIT, que busque archivos que se necesitan para las
										// pruebas dentro de la carpeta FEATURES, que tenemos creada en resources
@CucumberContextConfiguration			// Me pone en marcha cucumber para hacer pruebas contra una app springboot
@SpringBootTest(
		classes = UsersApiRestAppTest.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
		
		)								// Para esta prueba, necesitamos arancar esta aplicación, en un puerto aleatorio
@TestPropertySource( locations ="classpath:application-test.properties")
										// Establece el fichero de configuración que vamos a usar para el arranque
										// de springboot en modo pruebas
@AutoConfigureMockMvc					// Este nos ofrece un cliente para conectarnos a la app de pruebas
@ExtendWith(SpringExtension.class)		// Decimos a JUNIT que las pruebas se realizan sobre Springboot
public class UsersApiRestTests {

	private Usuario usuario;
	private UsuariosRepository usuariosRepository;
	
	public UsersApiRestTests(UsuariosRepository usuariosRepository) { // Inyección de dependencias de Springboot
		this.usuariosRepository=usuariosRepository;
	}
	
	@Dado("un usuario")
	public void un_usuario() {
	   usuario = new Usuario();
	}
	
	@Dado("el usuario tiene por nombre {string}")
	public void el_usuario_tiene_por_nombre(String nombre) {
	    usuario.setNombre(nombre);
	}
	
	@Dado("el usuario tiene por apellidos {string}")
	public void el_usuario_tiene_por_apellidos(String apellidos) {
	    usuario.setApellidos(apellidos);
	}
	
	@Dado("el usuario tiene por una edad de {int}")
	public void el_usuario_tiene_por_una_edad_de(Integer edad) {
	    usuario.setEdad(edad);
	}
	
	@Dado("el usuario tiene por email {string}")
	public void el_usuario_tiene_por_email(String email) {
	    usuario.setEmail(email);
	}
	
	@Dado("el usuario tiene por telefono {string}")
	public void el_usuario_tiene_por_telefono(String telefono) {
	    usuario.setTelefono(telefono);
	}
	
	@Dado("el usuario está guardado en la BBDD")
	public void el_usuario_está_guardado_en_la_bbdd() {
		usuariosRepository.save(usuario);
	}
	
	@Cuando("invoco al servicio {string} con método {string}")
	public void invoco_al_servicio_con_método(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Entonces("se recibe una respuesta con código {string}")
	public void se_recibe_una_respuesta_con_código(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Entonces("la respuesta contiene un JSON")
	public void la_respuesta_contiene_un_json() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Entonces("el JSON es una lista de longitud {int}")
	public void el_json_es_una_lista_de_longitud(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Entonces("el elemento en la posición {int}, debe tener por {string}: {string}")
	public void el_elemento_en_la_posición_debe_tener_por_id(Integer int1, String campo, String valor) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
		
		
	
	
	
}


