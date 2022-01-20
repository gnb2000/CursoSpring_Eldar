package com.HolaSpring.HolaSpring.daos;

import com.HolaSpring.HolaSpring.modelo.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaDAO extends CrudRepository<Persona,Long> {
}
