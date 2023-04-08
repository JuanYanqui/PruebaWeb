package com.pruebadeweb.JuanYanqui.repository;

import com.pruebadeweb.JuanYanqui.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
