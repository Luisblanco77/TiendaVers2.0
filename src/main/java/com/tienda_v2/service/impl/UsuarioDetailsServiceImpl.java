/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda_v2.service.impl;

import com.tienda_v2.dao.UsuarioDao;
import com.tienda_v2.domain.Rol;
import com.tienda_v2.domain.Usuario;
import com.tienda_v2.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl
        implements UsuarioDetailsService, UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private HttpSession session;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        //Se busca el usuario en la tabla de la BD
        Usuario usuario = usuarioDao.findByUsername(username);

        //Se valida si el usuario se encuentra
        if (usuario == null) {
            //No encontro el usuario
            throw new UsernameNotFoundException(username);
        }
        session.setAttribute("usuarioImagen",
                usuario.getRutaImagen());

        var roles = new ArrayList<GrantedAuthority>();

        for (Rol rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }

        return new User(usuario.getUsername(),
                usuario.getPassword(),
                roles);
    }

}
