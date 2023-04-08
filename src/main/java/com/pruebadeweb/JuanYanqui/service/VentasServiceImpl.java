package com.pruebadeweb.JuanYanqui.service;


import com.pruebadeweb.JuanYanqui.model.Ventas;
import com.pruebadeweb.JuanYanqui.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class VentasServiceImpl extends GenericServiceImpl<Ventas, Long> implements VentasService{
    @Autowired
    private VentasRepository ventasRepository;

    @Override
    public CrudRepository<Ventas, Long> getDao() {
        return ventasRepository;
    }
}
