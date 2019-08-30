package com.example.Model;

import java.util.Date;

public class Vacantes {
private Integer id;

private String nombre;
private String descripcion;
private Double salario;
private Date fecha;
private Integer destacado;
private String image="No_picture_available.png";


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
@Override
public String toString() {
	return "Vacantes [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", salario=" + salario
			+ ", fecha=" + fecha + ", destacado=" + destacado + "]";
}



}