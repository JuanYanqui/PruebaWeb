package com.pruebadeweb.JuanYanqui.controller;

import com.pruebadeweb.JuanYanqui.model.Ventas;
import com.pruebadeweb.JuanYanqui.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
@CrossOrigin("*")
public class ControllerVentas {

    @Autowired
    VentasService ventasService;
    @PostMapping("/cre")
    public ResponseEntity<Ventas> crearcli(@RequestBody Ventas tipoCorreo){
        return new ResponseEntity<>(ventasService.save(tipoCorreo), HttpStatus.CREATED);
    }
    @GetMapping("/li")
    public ResponseEntity<List<Ventas>>getList(){
        return new ResponseEntity<>(ventasService.findByAll(), HttpStatus.OK);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<Ventas> UpdateUser(@RequestBody Ventas u, @PathVariable Long id){
        Ventas ub = ventasService.findById(id);
        ub.setFecha(u.getFecha());
        ub.setTotal(u.getTotal());
        ub.setCosto_menu(u.getCosto_menu());
        ub.setCantidad(u.getCantidad());

        return new ResponseEntity<>(ventasService.save(ub),HttpStatus.CREATED);

    }

    @DeleteMapping("/eli/{id}")
    public ResponseEntity <?> eliminarli(@PathVariable Long id) {
        ventasService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
