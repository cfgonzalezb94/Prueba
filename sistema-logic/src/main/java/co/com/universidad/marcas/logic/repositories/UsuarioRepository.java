/**
 * UsuarioRepository.java
 * 04/11/2016
 * 1.0
 */
package co.com.universidad.marcas.logic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.universidad.marcas.logic.entities.Usuario;


/**
 * <p>
 * Repositorio para la entidad {@link Usuario}
 * </p>
 * 
 * @author <a <href="cgonzalez@softone.com.co">Christian Ferney Gonzalez</a>
 * @version 1.0
 * 
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
		
	/**
	 * <p>Busca un usuario por Id</p>
	 */
	Usuario findById(Integer id);
	
	/**
	 * <p>Busca un usuario por su usuario</p>
	 */
	Usuario findByUsuario(String usuario);
	
	
}
