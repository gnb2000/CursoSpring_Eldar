package com.controlClientes.ControlClientes.service;

import com.controlClientes.ControlClientes.modelo.Rol;
import com.controlClientes.ControlClientes.modelo.Usuario;
import com.controlClientes.ControlClientes.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
@Slf4j
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = usuarioRepository.findByUsername(username);

        if (u == null){
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();

        for (Rol rol : u.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }

        return new User(u.getUsername(),u.getPassword(),roles);
    }



}
