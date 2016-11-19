package co.com.universidad.marcas.logic.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the tipos_suscripcion database table.
 * 
 */
@Entity
@Table(name="tipos_suscripcion")
@NamedQuery(name="TiposSuscripcion.findAll", query="SELECT t FROM TiposSuscripcion t")
public class TiposSuscripcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tiposSuscripcion", fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JsonIgnore
	private List<Usuario> usuarios;

	public TiposSuscripcion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setTiposSuscripcion(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setTiposSuscripcion(null);

		return usuario;
	}

}