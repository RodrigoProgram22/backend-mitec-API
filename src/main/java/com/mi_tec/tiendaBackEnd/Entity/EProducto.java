package com.mi_tec.tiendaBackEnd.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class EProducto {

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public EUsuario getProveedor() {
        return proveedor;
    }

    public void setProveedor(EUsuario proveedor) {
        this.proveedor = proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    // Constructor vacío (obligatorio para JPA/Hibernate)
    public EProducto() {
    }

// Constructor con parámetros (opcional, pero muy útil)
    public EProducto(Long id_producto, EUsuario proveedor, String nombre, String etiquetas, String descripcion, Long precio, String imagen, Long cantidad) {
        this.id_producto = id_producto;
        this.proveedor = proveedor;
        this.nombre = nombre;
        this.etiquetas = etiquetas;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.cantidad = cantidad;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;

    @JsonIgnoreProperties({"productos", "password"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proveedor")
    private EUsuario proveedor;

    private String nombre;
    private String etiquetas;
    private String descripcion;
    private Long precio;
    private String imagen;
    private Long cantidad;
}
