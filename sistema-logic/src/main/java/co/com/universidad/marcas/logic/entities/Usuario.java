package co.com.universidad.marcas.logic.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq-gen",sequenceName="MY_SEQ_GEN", initialValue=205, allocationSize=12)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen")
	private Integer id;

	@Column(name="codigo_registro")
	private String codigoRegistro;

	private String contrasena;

	@Column(name="email_delegado")
	private String emailDelegado;

	@Column(name="fecha_registro")
	private Timestamp fechaRegistro;

	private String nombre;

	@Column(name="nombre_delegado")
	private String nombreDelegado;

	@Column(name="ruta_logo")
	private String rutaLogo;

	private String usuario;

	//bi-directional many-to-one association to Marca
	@OneToMany(mappedBy="usuario", fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JsonIgnore
	private List<Marca> marcas;

	//bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name="id_cargo")
	private Cargo cargo;

	//bi-directional many-to-one association to TiposSuscripcion
	@ManyToOne
	@JoinColumn(name="id_tipo_suscripcion")
	private TiposSuscripcion tiposSuscripcion;

	public Usuario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoRegistro() {
		return this.codigoRegistro;
	}

	public void setCodigoRegistro(String codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmailDelegado() {
		return this.emailDelegado;
	}

	public void setEmailDelegado(String emailDelegado) {
		this.emailDelegado = emailDelegado;
	}

	public Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreDelegado() {
		return this.nombreDelegado;
	}

	public void setNombreDelegado(String nombreDelegado) {
		this.nombreDelegado = nombreDelegado;
	}

	public String getRutaLogo() {
		return this.rutaLogo;
	}

	public void setRutaLogo(String rutaLogo) {
		this.rutaLogo = rutaLogo;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Marca> getMarcas() {
		return this.marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	public Marca addMarca(Marca marca) {
		getMarcas().add(marca);
		marca.setUsuario(this);

		return marca;
	}

	public Marca removeMarca(Marca marca) {
		getMarcas().remove(marca);
		marca.setUsuario(null);

		return marca;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public TiposSuscripcion getTiposSuscripcion() {
		return this.tiposSuscripcion;
	}

	public void setTiposSuscripcion(TiposSuscripcion tiposSuscripcion) {
		this.tiposSuscripcion = tiposSuscripcion;
	}

}