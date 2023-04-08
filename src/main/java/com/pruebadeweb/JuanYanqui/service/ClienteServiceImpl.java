package com.pruebadeweb.JuanYanqui.service;

import com.pruebadeweb.JuanYanqui.model.Cliente;
import com.pruebadeweb.JuanYanqui.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Long> implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public CrudRepository<Cliente, Long> getDao() {
        return clienteRepository;
    }
}
