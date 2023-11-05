package com.tienda_v2.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="categoria")
public class Categoria implements Serializable{
    
    private static final Long serialVersionUID= 1L;
    /*Se quita el private categoria y se hace un objeto*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_categoria")
    private Long idCategoria;
    
    private String descripcion;
    private String rutaImagen;
    private Boolean activo;

    @OneToMany
    @JoinColumn(name="id_categoria", updatable = false)
private List<Producto> productos;
    
    }
