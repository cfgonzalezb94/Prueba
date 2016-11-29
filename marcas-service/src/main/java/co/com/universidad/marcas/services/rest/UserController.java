/**
 * UserController.java
 * Copyright (c) SoftOne - Disponible All rights reserved.
 * 4/12/2014
 * ${version}
 */
package co.com.universidad.marcas.services.rest;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.universidad.marcas.logic.entities.Cargo;
import co.com.universidad.marcas.logic.entities.Categoria;
import co.com.universidad.marcas.logic.entities.Marca;
import co.com.universidad.marcas.logic.entities.TiposSuscripcion;
import co.com.universidad.marcas.logic.entities.Usuario;
import co.com.universidad.marcas.logic.services.GeneralService;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class to produce worker user json to android layer.
 * 
 * @author <a href="cgonzalez@softone.com.co">Christian Gonzalez</a>
 *
 */
@Controller
@RequestMapping("/generalService")
public class UserController {
    
	@Autowired
    @Qualifier("generalService")
    private GeneralService generalService;
	
		
    @RequestMapping(value = "buscarUsuarioById", method = RequestMethod.GET)
    public @ResponseBody String findUser(@RequestParam(value="idUsuario") Integer idUsuario) throws JsonGenerationException, JsonMappingException, IOException {
    	
    	Usuario usuario = generalService.findUsuarioById(idUsuario);
    	String response = "";
    	
    	Object usuarioObject = ((Object)usuario);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	response = mapper.writeValueAsString(usuarioObject);    	    	
    	   	   
    	return response;
    }
    
    @RequestMapping(value = "buscarUsuario", method = RequestMethod.GET)
    public @ResponseBody String findUserByUsuario(@RequestParam(value="usuario") String usuario) throws JsonGenerationException, JsonMappingException, IOException {
    	
    	Usuario usuarioEn = generalService.findUsuarioByUsuario(usuario);
    	String response = "";
    	
    	Object usuarioObject = ((Object)usuarioEn);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	response = mapper.writeValueAsString(usuarioObject);    	    	
    	   	   
    	return response;
    }
    
    @RequestMapping(value = "buscarCargo", method = RequestMethod.GET)
    public @ResponseBody String findCargo(@RequestParam(value="idCargo") Integer idCargo) throws JsonGenerationException, JsonMappingException, IOException {
    	
    	Cargo cargo = generalService.findCargoById(idCargo);
    	String response = "";
    	
    	Object usuarioObject = ((Object)cargo);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	response = mapper.writeValueAsString(usuarioObject);    	    	
    	   	   
    	return response;
    }
    
    @RequestMapping(value = "buscarTipoSuscripcion", method = RequestMethod.GET)
    public @ResponseBody String findTipoSuscripcion(@RequestParam(value="idTipoSuscripcion") Integer idTipoSuscripcion) throws JsonGenerationException, JsonMappingException, IOException {
    	
    	TiposSuscripcion tipo = generalService.findTipoSuscripcionById(idTipoSuscripcion);
    	String response = "";
    	
    	Object usuarioObject = ((Object)tipo);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	response = mapper.writeValueAsString(usuarioObject);    	    	
    	   	   
    	return response;
    }
    
    @RequestMapping(value = "buscarMarcaById", method = RequestMethod.GET)
    public @ResponseBody String findMarca(@RequestParam(value="idMarca") Integer idMarca) throws JsonGenerationException, JsonMappingException, IOException {
    	
    	Marca marca = generalService.findMarcaById(idMarca);
    	String response = "";
    	
    	Object object = ((Object)marca);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	response = mapper.writeValueAsString(object);    	    	
    	   	   
    	return response;
    }
    
    @RequestMapping(value = "buscarMarca", method = RequestMethod.GET)
    public @ResponseBody String findMarcaByNombre(@RequestParam(value="nombre") String nombre) throws JsonGenerationException, JsonMappingException, IOException {
    	
    	Marca marca = generalService.findMarcaByNombre(nombre);
    	String response = "";
    	
    	Object object = ((Object)marca);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	response = mapper.writeValueAsString(object);    	    	
    	   	   
    	return response;
    }
    
    @RequestMapping(value = "buscarUsuarios", method = RequestMethod.GET)
    public @ResponseBody String findAllUsers() throws JsonGenerationException, JsonMappingException, IOException {
    	
    	List<Usuario> usuarios = generalService.findUsuarios();
    	String response = "";
    	
    	Object usuarioObject = ((Object)usuarios);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	response = mapper.writeValueAsString(usuarioObject);    	    	
    	   	   
    	return response;
    }
    
    @RequestMapping(value = "buscarCargos", method = RequestMethod.GET)
    public @ResponseBody String findAllCargos() throws JsonGenerationException, JsonMappingException, IOException {
    	
    	List<Cargo> cargos = generalService.findCargos();
    	String response = "";
    	
    	Object object = ((Object)cargos);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	response = mapper.writeValueAsString(object);    	    	
    	   	   
    	return response;
    }
    
    @RequestMapping(value = "guardarUsuario", method = RequestMethod.GET)
    public @ResponseBody String saveUser(@RequestParam(value="nombre") String nombre, @RequestParam(value="idCargo") Integer idCargo, 
    		@RequestParam(value="nombreDelegado") String nombreDelegado, @RequestParam(value="email") String email, 
    		@RequestParam(value="contrasena") String contrasena, @RequestParam(value="rutaLogo") String rutaLogo, 
    		@RequestParam(value="idTipoSuscripcion") Integer idTipoSuscripcion) throws JsonGenerationException, JsonMappingException, IOException {
    	
    	Cargo cargo = generalService.findCargoById(idCargo);
    	TiposSuscripcion tipo =  generalService.findTipoSuscripcionById(idTipoSuscripcion);
    	
    	Usuario usuario = new Usuario();
    	usuario.setCargo(cargo);
    	usuario.setContrasena(contrasena);
    	usuario.setEmailDelegado(email);
    	usuario.setNombre(nombre);
    	usuario.setNombreDelegado(nombreDelegado);
    	usuario.setRutaLogo(rutaLogo);
    	usuario.setTiposSuscripcion(tipo);

    	usuario = generalService.saveUser(usuario);
    	
    	String response = "";
    	
    	Object usuarioObject = ((Object)usuario);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	response = mapper.writeValueAsString(usuarioObject);    	    	
    	   	   
    	return response;
    }
    
    @RequestMapping(value = "guardarMarca", method = RequestMethod.GET)
    public @ResponseBody String saveMarca(@RequestParam(value="nombre") String nombre, @RequestParam(value="descripcion") String descripcion, 
    		@RequestParam(value="ranking") Double ranking, @RequestParam(value="valorDecimal") Integer valorDecimal, 
    		@RequestParam(value="rutaLogo") String rutaLogo, @RequestParam(value="idCategoria") Integer idCategoria, 
    		@RequestParam(value="idUsuario") Integer idUsuario) throws JsonGenerationException, JsonMappingException, IOException {
    	
    	Marca marca = generalService.saveMarca(nombre, descripcion, ranking, valorDecimal, rutaLogo, idCategoria, idUsuario);
    	
    	String response = "";
    	
    	Object usuarioObject = ((Object)marca);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	response = mapper.writeValueAsString(usuarioObject);    	    	
    	   	   
    	return response;
    }
    
    
    @RequestMapping(value = "buscarMarcas", method = RequestMethod.GET)
    public @ResponseBody String findAllMarcas() throws JsonGenerationException, JsonMappingException, IOException {
    	
    	List<Marca> marcas = generalService.findMarcas();
    	String response = "";
    	
    	Object usuarioObject = ((Object)marcas);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	response = mapper.writeValueAsString(usuarioObject);    	    	
    	   	   
    	return response;
    }
    
    @RequestMapping(value = "guardarCargo", method = RequestMethod.GET)
    public @ResponseBody String saveCargo(@RequestParam(value="nombre") String nombre, @RequestParam(value="descripcion") String descripcion) throws JsonGenerationException, JsonMappingException, IOException {
    	
    	Cargo cargo = generalService.saveCargo(nombre, descripcion);
    	
    	String response = "";
    	
    	Object object = ((Object)cargo);    	
    	ObjectMapper mapper = new ObjectMapper();
    	response = mapper.writeValueAsString(object);    	    	
    	   	   
    	return response;
    }
    
    @RequestMapping(value = "guardarTipoSus", method = RequestMethod.GET)
    public @ResponseBody String saveTipoSuscripcion(@RequestParam(value="nombre") String nombre, @RequestParam(value="descripcion") String descripcion) throws JsonGenerationException, JsonMappingException, IOException {
    	
    	TiposSuscripcion tipo = generalService.saveTiposSuscripcion(nombre, descripcion);
    	
    	String response = "";
    	
    	Object object = ((Object)tipo);    	
    	ObjectMapper mapper = new ObjectMapper();
    	response = mapper.writeValueAsString(object);    	    	
    	   	   
    	return response;
    }
    
    @RequestMapping(value = "guardarCategoria", method = RequestMethod.GET)
    public @ResponseBody String saveCategoria(@RequestParam(value="nombre") String nombre, @RequestParam(value="descripcion") String descripcion) throws JsonGenerationException, JsonMappingException, IOException {
    	
    	Categoria categoria = generalService.saveCategoria(nombre, descripcion);
    	
    	String response = "";
    	
    	Object object = ((Object)categoria);    	
    	ObjectMapper mapper = new ObjectMapper();
    	response = mapper.writeValueAsString(object);    	    	
    	   	   
    	return response;
    }
    
    
}
