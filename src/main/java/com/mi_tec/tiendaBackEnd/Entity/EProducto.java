package com.mi_tec.tiendaBackEnd.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter @Setter
@Table(name = "productos")
public class EProducto {
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
