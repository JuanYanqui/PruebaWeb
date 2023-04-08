package com.pruebadeweb.JuanYanqui.repository;

import com.pruebadeweb.JuanYanqui.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Long> {
}
