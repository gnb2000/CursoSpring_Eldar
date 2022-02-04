package com.controlClientes.ControlClientes.repository;

import com.controlClientes.ControlClientes.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Usuario findByUsername(String username);
}
