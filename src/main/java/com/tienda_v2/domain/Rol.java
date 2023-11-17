package com.tienda_v2.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "rol")
public class Rol implements Serializable {

    private static final Long serialVersionUID = 1L;
    /*Se quita el private rol y se hace un objeto*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;
    private String nombre;
    
    @Column(name = "id_usuario")
    private Long idUsuario;

}
