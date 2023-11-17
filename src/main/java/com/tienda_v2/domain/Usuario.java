package com.tienda_v2.domain;

import com.google.cloud.storage.Acl.Role;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
    
    private static final Long serialVersionUID= 1L;
    /*Se quita el private usuario y se hace un objeto*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_usuario")
    private Long idUsuario;
    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String rutaImagen;
    private boolean activo;

    @OneToMany
    @JoinColumn(name="id_usuario")
private List<Rol> roles;
  
    
    }
