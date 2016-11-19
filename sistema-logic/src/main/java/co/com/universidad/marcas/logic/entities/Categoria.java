package co.com.universidad.marcas.logic.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Marca
	@OneToMany(mappedBy="categoria", fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JsonIgnore
	private List<Marca> marcas;

	//bi-directional many-to-one association to SubMarca
	@OneToMany(mappedBy="categoria", fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JsonIgnore
	private List<SubMarca> subMarcas;

	public Categoria() {
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

	public List<Marca> getMarcas() {
		return this.marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	public Marca addMarca(Marca marca) {
		getMarcas().add(marca);
		marca.setCategoria(this);

		return marca;
	}

	public Marca removeMarca(Marca marca) {
		getMarcas().remove(marca);
		marca.setCategoria(null);

		return marca;
	}

	public List<SubMarca> getSubMarcas() {
		return this.subMarcas;
	}

	public void setSubMarcas(List<SubMarca> subMarcas) {
		this.subMarcas = subMarcas;
	}

	public SubMarca addSubMarca(SubMarca subMarca) {
		getSubMarcas().add(subMarca);
		subMarca.setCategoria(this);

		return subMarca;
	}

	public SubMarca removeSubMarca(SubMarca subMarca) {
		getSubMarcas().remove(subMarca);
		subMarca.setCategoria(null);

		return subMarca;
	}

}