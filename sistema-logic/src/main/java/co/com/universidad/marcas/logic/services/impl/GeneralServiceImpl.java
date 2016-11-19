/**
 * GeneralServiceImpl.java
 * Copyright (c) SoftOne
 * 27/04/2016
 * 1.0
 */
package co.com.universidad.marcas.logic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;








import co.com.universidad.marcas.logic.entities.Cargo;
import co.com.universidad.marcas.logic.entities.Categoria;
import co.com.universidad.marcas.logic.entities.Marca;
import co.com.universidad.marcas.logic.entities.TiposSuscripcion;
import co.com.universidad.marcas.logic.entities.Usuario;
import co.com.universidad.marcas.logic.repositories.CargoRepository;
import co.com.universidad.marcas.logic.repositories.CategoriaRepository;
import co.com.universidad.marcas.logic.repositories.MarcaRepository;
import co.com.universidad.marcas.logic.repositories.TipoSuscripcionRepository;
import co.com.universidad.marcas.logic.repositories.UsuarioRepository;
import co.com.universidad.marcas.logic.services.GeneralService;

/**
 * <p>
 * Servicios generales del sistema.
 * </p>
 * 
 * @author <a <href="cgonzalez@softone.com.co">Christian Ferney Gonzalez</a>
 * @version 1.0
 */
@Service("generalService")
@Transactional
public class GeneralServiceImpl implements GeneralService {

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private TipoSuscripcionRepository tipoSuscripcionRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.universidad.marcas.logic.services.GeneralService#findUsuarioById(id)
	 */
	@Override
	public Usuario findUsuarioById(Integer id){
		Usuario usuario = usuarioRepository.findById(id); 
		return usuario;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.universidad.marcas.logic.services.GeneralService#findCargoById(id)
	 */
	@Override
	public Cargo findCargoById(Integer id){
		Cargo cargo = cargoRepository.findOne(id); 
		return cargo;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.universidad.marcas.logic.services.GeneralService#findTipoSuscripcionById(id)
	 */
	@Override
	public TiposSuscripcion findTipoSuscripcionById(Integer id){
		TiposSuscripcion tipo = tipoSuscripcionRepository.findOne(id); 
		return tipo;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.universidad.marcas.logic.services.GeneralService#findUsuarios()
	 */
	@Override
	public List<Usuario> findUsuarios(){
		return usuarioRepository.findAll();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.universidad.marcas.logic.services.GeneralService#findMarcas()
	 */
	@Override
	public List<Marca> findMarcas(){
		return marcaRepository.findAll();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.universidad.marcas.logic.services.GeneralService#saveUser()
	 */
	@Override
	public Usuario saveUser(Usuario usuario){
		Usuario usu = usuarioRepository.save(usuario);			
		return usu;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.universidad.marcas.logic.services.GeneralService#saveCargo()
	 */
	@Override
	public Cargo saveCargo(String nombre, String descripcion){		
		
		Cargo cargo = new Cargo();
		cargo.setNombre(nombre);
		cargo.setDescripcion(descripcion);
		
		cargo = cargoRepository.save(cargo);
					
		return cargo;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.universidad.marcas.logic.services.GeneralService#saveTiposSuscripcion()
	 */
	@Override
	public TiposSuscripcion saveTiposSuscripcion(String nombre, String descripcion){		
		
		TiposSuscripcion tipo = new TiposSuscripcion();
		tipo.setNombre(nombre);
		tipo.setDescripcion(descripcion);
		
		tipo = tipoSuscripcionRepository.save(tipo);
					
		return tipo;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.universidad.marcas.logic.services.GeneralService#findCargos()
	 */
	@Override
	public List<Cargo> findCargos(){
		return cargoRepository.findAll();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.universidad.marcas.logic.services.GeneralService#saveMarca()
	 */
	@Override
	public Marca saveMarca(String nombre, String descripcion, Double ranking, Integer valorDecimal, 
			String rutaLogo, Integer idCategoria, Integer idUsuario){		
		
		Usuario usuario = usuarioRepository.findOne(idUsuario);
		Categoria categoria = categoriaRepository.findOne(idCategoria);
		
		Marca marca = new Marca();
		marca.setUsuario(usuario);
		marca.setCategoria(categoria);
		marca.setNombre(nombre);
		marca.setDescripcion(descripcion);
		marca.setRanking(ranking);
		marca.setValorDecimal(valorDecimal);
		marca.setRutaLogo(rutaLogo);			
		
		marca = marcaRepository.save(marca);
					
		return marca;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.universidad.marcas.logic.services.GeneralService#saveCategoria()
	 */
	@Override
	public Categoria saveCategoria(String nombre, String descripcion){		
		
		Categoria categoria = new Categoria();
		categoria.setNombre(nombre);
		categoria.setDescripcion(descripcion);
		
		categoria = categoriaRepository.save(categoria);
					
		return categoria;
	}

}
