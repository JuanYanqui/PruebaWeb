package com.pruebadeweb.JuanYanqui.controller;


import com.pruebadeweb.JuanYanqui.model.Cliente;
import com.pruebadeweb.JuanYanqui.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")

public class ControllerCliente {
    @Autowired
    ClienteService clienteService;
    @PostMapping("/cre")
    public ResponseEntity<Cliente> crearcli(@RequestBody Cliente persona){
        return new ResponseEntity<>(clienteService.save(persona), HttpStatus.CREATED);
    }
    @GetMapping("/li")
    public ResponseEntity<List<Cliente>>getList(){
        return new ResponseEntity<>(clienteService.findByAll(), HttpStatus.OK);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<Cliente> UpdateUser(@RequestBody Cliente u, @PathVariable Long id){
        Cliente ub = clienteService.findById(id);
        ub.setNombre(u.getNombre());
        ub.setApellido(u.getApellido());
        ub.setCelular(u.getCelular());
        ub.setDireccion(u.getDireccion());
        return new ResponseEntity<>(clienteService.save(ub),HttpStatus.CREATED);

    }

    @DeleteMapping("/eli/{id}")
    public ResponseEntity <?> eliminarli(@PathVariable Long id) {
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
