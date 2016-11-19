/**
 * GeneralService.java
 * Copyright (c) SoftOne
 * 27/04/2016
 * 1.0
 */
package co.com.universidad.marcas.logic.services;

import java.util.List;

import co.com.universidad.marcas.logic.entities.Cargo;
import co.com.universidad.marcas.logic.entities.Categoria;
import co.com.universidad.marcas.logic.entities.Marca;
import co.com.universidad.marcas.logic.entities.TiposSuscripcion;
import co.com.universidad.marcas.logic.entities.Usuario;


/**
 * 
 * <p>
 * Servicios generales del sistema.
 * </p>
 * 
 * @author <a <href="cgonzalez@softone.com.co">Christian Ferney Gonzalez</a>
 * @version 1.0
 */
public interface GeneralService {

	/**
	 * <p>
	 * Permite consultar un usuario por su id
	 * </p> 
	 * @param id
	 * @return Usuario
	 */
	Usuario findUsuarioById(Integer id);
	
	/**
	 * <p>
	 * Permite consultar una lista de usuarios
	 * </p> 
	 * @return List<Usuario>
	 */
	List<Usuario> findUsuarios();
	
	/**
	 * <p>
	 * Guardar usuario en la base de datos
	 * </p> 
	 */

	Usuario saveUser(Usuario usuario);
	
	/**
	 * <p>
	 * Permite consultar un cargo por su id
	 * </p> 
	 * @param id
	 * @return Cargo
	 */
	Cargo findCargoById(Integer id);
	
	/**
	 * <p>
	 * Permite consultar una lista de cargos
	 * </p> 
	 * @return List<Cargo>
	 */
	List<Cargo> findCargos();
	
	/**
	 * <p>
	 * Guardar cargo en la base de datos
	 * </p> 
	 */

	Cargo saveCargo(String nombre, String descripcion);
	
	
	/**
	 * <p>
	 * Permite consultar una lista de marcas
	 * </p> 
	 * @return List<Marca>
	 */
	List<Marca> findMarcas();	
	
	/**
	 * <p>
	 * Guardar Marca en la base de datos
	 * </p> 
	 */

	Marca saveMarca(String nombre, String descripcion, Double ranking, Integer valorDecimal, String rutaLogo, Integer idCategoria, Integer idUsuario);
	
	/**
	 * <p>
	 * Permite consultar un tiposuscripcion por su id
	 * </p> 
	 * @param id
	 * @return TipoSuscripcion
	 */
	TiposSuscripcion findTipoSuscripcionById(Integer id);
	
	
	/**
	 * <p>
	 * Guardar tiposuscripcion en la base de datos
	 * </p> 
	 */

	TiposSuscripcion saveTiposSuscripcion(String nombre, String descripcion);
	
	/**
	 * <p>
	 * Guardar categoria en la base de datos
	 * </p> 
	 */

	Categoria saveCategoria(String nombre, String descripcion);
}
