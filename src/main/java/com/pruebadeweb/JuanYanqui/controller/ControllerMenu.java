package com.pruebadeweb.JuanYanqui.controller;


import com.pruebadeweb.JuanYanqui.model.Menu;
import com.pruebadeweb.JuanYanqui.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@CrossOrigin("*")

public class ControllerMenu {
    @Autowired
    MenuService menuService;
    @PostMapping("/cre")
    public ResponseEntity<Menu> crearcli(@RequestBody Menu correo){
        return new ResponseEntity<>(menuService.save(correo), HttpStatus.CREATED);
    }
    @GetMapping("/li")
    public ResponseEntity<List<Menu>>getList(){
        return new ResponseEntity<>(menuService.findByAll(), HttpStatus.OK);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<Menu> UpdateUser(@RequestBody Menu u, @PathVariable Long id){
        Menu ub = menuService.findById(id);
        ub.setCodigoMenu(u.getCodigoMenu());
        ub.setCosto(u.getCosto());
        ub.setDescripcion(u.getDescripcion());
        return new ResponseEntity<>(menuService.save(ub),HttpStatus.CREATED);

    }

    @DeleteMapping("/eli/{id}")
    public ResponseEntity <?> eliminarli(@PathVariable Long id) {
        menuService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
