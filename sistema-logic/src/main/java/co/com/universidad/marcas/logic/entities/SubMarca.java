package co.com.universidad.marcas.logic.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sub_marca database table.
 * 
 */
@Entity
@Table(name="sub_marca")
@NamedQuery(name="SubMarca.findAll", query="SELECT s FROM SubMarca s")
public class SubMarca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String descripcion;

	private String nombre;

	private Double ranking;

	@Column(name="ruta_logo")
	private String rutaLogo;

	@Column(name="ruta_portada")
	private String rutaPortada;

	@Column(name="valor_decimal")
	private Integer valorDecimal;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;

	//bi-directional many-to-one association to Marca
	@ManyToOne
	@JoinColumn(name="id_marca")
	private Marca marca;

	public SubMarca() {
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

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return this.marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}