/**
 * CategoriaRepository.java
 * 04/11/2016
 * 1.0
 */
package co.com.universidad.marcas.logic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.universidad.marcas.logic.entities.Categoria;


/**
 * <p>
 * Repositorio para la entidad {@link Categoria}
 * </p>
 * 
 * @author <a <href="cgonzalez@softone.com.co">Christian Ferney Gonzalez</a>
 * @version 1.0
 * 
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
		
	
}
