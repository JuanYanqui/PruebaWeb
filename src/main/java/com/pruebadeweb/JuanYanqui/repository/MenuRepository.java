package com.pruebadeweb.JuanYanqui.repository;

import com.pruebadeweb.JuanYanqui.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
