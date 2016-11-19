package co.com.universidad.marcas.logic.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;


/**
 * The persistent class for the marca database table.
 * 
 */
@Entity
@NamedQuery(name="Marca.findAll", query="SELECT m FROM Marca m")
public class Marca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String descripcion;

	private String estado;

	private String nombre;

	private Double ranking;

	@Column(name="ruta_logo")
	private String rutaLogo;

	@Column(name="ruta_portada")
	private String rutaPortada;

	@Column(name="valor_decimal")
	private Integer valorDecimal;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="marca", fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Comentario> comentarios;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to SubMarca
	@OneToMany(mappedBy="marca", fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<SubMarca> subMarcas;

	public Marca() {
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

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getRanking() {
		return this.ranking;
	}

	public void setRanking(Double ranking) {
		this.ranking = ranking;
	}

	public String getRutaLogo() {
		return this.rutaLogo;
	}

	public void setRutaLogo(String rutaLogo) {
		this.rutaLogo = rutaLogo;
	}

	public String getRutaPortada() {
		return this.rutaPortada;
	}

	public void setRutaPortada(String rutaPortada) {
		this.rutaPortada = rutaPortada;
	}

	public Integer getValorDecimal() {
		return this.valorDecimal;
	}

	public void setValorDecimal(Integer valorDecimal) {
		this.valorDecimal = valorDecimal;
	}

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario addComentario(Comentario comentario) {
		getComentarios().add(comentario);
		comentario.setMarca(this);

		return comentario;
	}

	public Comentario removeComentario(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setMarca(null);

		return comentario;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<SubMarca> getSubMarcas() {
		return this.subMarcas;
	}

	public void setSubMarcas(List<SubMarca> subMarcas) {
		this.subMarcas = subMarcas;
	}

	public SubMarca addSubMarca(SubMarca subMarca) {
		getSubMarcas().add(subMarca);
		subMarca.setMarca(this);

		return subMarca;
	}

	public SubMarca removeSubMarca(SubMarca subMarca) {
		getSubMarcas().remove(subMarca);
		subMarca.setMarca(null);

		return subMarca;
	}

}