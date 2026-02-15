package com.mi_tec.tiendaBackEnd.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mi_tec.tiendaBackEnd.Security.Entity.Rol;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
public class EUsuario {

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public List<EProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<EProducto> productos) {
        this.productos = productos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ECarrito getCarrito() {
        return carrito;
    }

    public void setCarrito(ECarrito carrito) {
        this.carrito = carrito;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<EProducto> productos;
    @NotNull
    @Column(unique = true)
    private String nombreUsuario;
    private String nombreApellido;
    private String password;
    private String email;
    private String telefono;
    private String ubicacion;

    // Nueva relación uno a uno con la entidad ECarrito
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private ECarrito carrito;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    // Constructor
    public EUsuario() {
    }

    public EUsuario(String nombre, String nombre_User, String pass, String email, String telefono, String ubi) {
        this.nombreApellido = nombre;
        this.nombreUsuario = nombre_User;
        this.password = pass;
        this.email = email;
        this.telefono = telefono;
        this.ubicacion = ubi;
    }
}
