package net.hernandez.model;

import java.util.Date;

public class Vacantes {
private Integer id;

private String nombre;
private String descripcion;
private Double salario;
private Date fecha;
private Integer destacado;
private String image="No_picture_available.png";
private String detalles;
private String estatus;
private String ststus;
private Categoria categoria;

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public Double getSalario() {
	return salario;
}
public void setSalario(Double salario) {
	this.salario = salario;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}

public Integer getDestacado() {
	return destacado;
}
public void setDestacado(Integer destacado) {
	this.destacado = destacado;
}



public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}

public String getDetalles() {
	return detalles;
}
public void setDetalles(String detalles) {
	this.detalles = detalles;
}
public String getStstus() {
	return ststus;
}
public void setStstus(String ststus) {
	this.ststus = ststus;
}
public String getEstatus() {
	return estatus;
}
public void setEstatus(String estatus) {
	this.estatus = estatus;
}

public Categoria getCategoria() {
	return categoria;
}
public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
}
@Override
public String toString() {
	return "Vacantes [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", salario=" + salario
			+ ", fecha=" + fecha + ", destacado=" + destacado + ", image=" + image + ", detalles=" + detalles
			+ ", estatus=" + estatus + ", categoria=" + categoria + ", ststus=" + ststus + "]";
}


}
