package com.pruebadeweb.JuanYanqui.controller;

import com.pruebadeweb.JuanYanqui.model.Cliente;
import com.pruebadeweb.JuanYanqui.model.Menu;
import com.pruebadeweb.JuanYanqui.model.Ventas;
import com.pruebadeweb.JuanYanqui.service.ClienteService;
import com.pruebadeweb.JuanYanqui.service.MenuService;
import com.pruebadeweb.JuanYanqui.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller
public class Controllerhome {
    @Autowired
    ClienteService clienteService;

    @Autowired
    MenuService menuService;

    @Autowired
    VentasService ventasService;

    @Value("${texto.cedula}")
    private String cedula;
    @Value("${texto.nombres}")
    private String nombre_apellido;
    @Value("${texto.direccion}")
    private String direccion;
    @Value("${texto.cedular}")
    private String celular;
    @Value("${texto.edad}")
    private String edad;

    @GetMapping({"/index","/","/home"})
    public String index(Model model){
        model.addAttribute("nombre", "Hola");
        return "index";
    }

    @GetMapping({"/index/datos"})
    public String datos(Model model){
        model.addAttribute("cedula", cedula);
        model.addAttribute("nombres", nombre_apellido);
        model.addAttribute("direccion", direccion);
        model.addAttribute("celular", celular);
        model.addAttribute("edad", edad);
        return "datos";
    }

    @GetMapping({"/index/git"})
    public String git(Model model){
        return "redirect:";
    }

//    @GetMapping("/")
//    public String pa(){
//        return "param/index";
//    }

//    @GetMapping("/index/ver/string")
//    public String param(@RequestParam(name="texto", required = false, defaultValue = "Cualquier valor")String texto,Model model){
//        model.addAttribute("resultado", "El texto enviado es"+texto);
//        return "ver";
//    }

    @GetMapping("/index/ver/string/{texto}")
    public String variables(@PathVariable String texto ,Model model) {
        model.addAttribute("titulo", "Recibir parametros de la ruta @(PathVariable)");
        model.addAttribute("resultado", "El texto enviado es"+texto);

        return "ver";
    }


    @GetMapping("/index/cliente")
    public String usuario(ModelMap model){
        Cliente cliente = new Cliente();
        model.addAttribute("clientes", cliente);
        model.addAttribute("listcliente", clienteService.findByAll());

        return "cliente";
    }

    @GetMapping("/index/menu")
    public String menu(ModelMap model){
        Menu menu = new Menu();
        model.addAttribute("menus", menu);
        model.addAttribute("listmenu", menuService.findByAll());

        return "menu";
    }

//    @PostMapping("/menus")
//    public String saveMenu(@ModelAttribute("menu") Menu menu){
//        menuService.save(menu);
//        return "redirect:/index/menu";
//    }

//    @PostMapping("/clientes")
//    public String saveMenu(@ModelAttribute("cliente") Cliente cliente){
//        clienteService.save(cliente);
//        return "redirect:/index/cliente";
//    }

    @PostMapping("/clientecre")
    public String updateClient(@ModelAttribute("cliente") Cliente cliente) {
        if(cliente.getIdCliente() == null){
            clienteService.save(cliente);
        }else {
            Cliente clienteUpdate = clienteService.findById(cliente.getIdCliente());
            if (clienteUpdate != null) {
                clienteUpdate.setCedula(cliente.getCedula());
                clienteUpdate.setNombre(cliente.getNombre());
                clienteUpdate.setApellido(cliente.getApellido());
                clienteUpdate.setCelular(cliente.getCelular());
                clienteUpdate.setDireccion(cliente.getDireccion());
                clienteService.save(clienteUpdate);
            } else {
                clienteService.save(cliente);
            }
        }
        return "redirect:/index/cliente";
    }

    @PostMapping("/menucre")
    public String updatemenu(@ModelAttribute("menu") Menu menu) {
        if(menu.getIdMenu() == null){
            menuService.save(menu);
        }else {
            Menu menuUpdate = menuService.findById(menu.getIdMenu());
            if (menuUpdate != null) {
                menuUpdate.setCodigoMenu(menu.getCodigoMenu());
                menuUpdate.setDescripcion(menu.getDescripcion());
                menuUpdate.setCosto(menu.getCosto());
                menuService.save(menuUpdate);
            } else {
                menuService.save(menu);
            }
        }
        return "redirect:/index/menu";
    }
    @GetMapping("/index/edit")
    public String menuds( ModelMap model){
        Menu menu = new Menu();
        model.addAttribute("menus", menu);
        return "menuvalida";
    }
    @PostMapping("/m")
    public String saveMenu(@Validated Menu menus, BindingResult result, Model model){

        model.addAttribute("title", "Result form");
        if(result.hasErrors()){
            Map<String, String> e = new HashMap<>();
            result.getFieldErrors().forEach(er ->{
                e.put(er.getField(),
                        "El campo ".concat(er.getField()).concat(" ").concat(er.getDefaultMessage()));
            });
            model.addAttribute("error", e);
            return "menuvalida";
        }
        //menuService.save(menu);

        return "redirect:/index/menu";
        //return "redirect:/app/index/menus";
    }

    @GetMapping("/index/cliente/{id}")
    public String clienteEdit(@PathVariable Long id, ModelMap model){
        Cliente cliente = clienteService.findById(id);
        model.addAttribute("clientes", cliente);
        model.addAttribute("listcliente", clienteService.findByAll());
        return "clienteedit";
    }

    @GetMapping("/index/menu/{id}")
    public String menuEdit(@PathVariable Long id, ModelMap model){
        Menu menu = menuService.findById(id);
        model.addAttribute("menus", menu);
        model.addAttribute("listmenu", menuService.findByAll());
        return "menuedit";
    }



//    @PostMapping("/index/delete/cliente/{id}")
//    public String deleteClient(@PathVariable Long id){
//        clienteService.delete(id);
//        return "redirect:/index/cliente";
//    }
    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarDatos(@PathVariable Long idCliente){
        clienteService.delete(idCliente);
        return "redirect:/index/cliente";
    }

    @GetMapping("/menu/eliminar/{idMenu}")
    public String eliminarMenu(@PathVariable Long idMenu){
        menuService.delete(idMenu);
        return "redirect:/index/menu";
    }



    @GetMapping("/index/ventas")
    public String ventas(ModelMap model){
        Ventas ventas = new Ventas();
        model.addAttribute("venta", ventas);
        model.addAttribute("listventas", ventasService.findByAll());
        model.addAttribute("listcliente", clienteService.findByAll());
        model.addAttribute("listmenu", menuService.findByAll());
        return "ventas";
    }

//    @PostMapping("/ventas")
//    public String saveVentas(@ModelAttribute("venta") Ventas ventas){
//        Menu menu = menuService.findById(ventas.getMenu().getIdMenu());
//        Cliente cliente = clienteService.findById(ventas.getCliente().getIdCliente());
//        ventas.setCliente(cliente);
//        ventas.setMenu(menu);
//        ventas.setFecha(LocalDate.now());
//        ventasService.save(ventas);
//        return "redirect:/index/ventas";
//    }

    @PostMapping("/ventas")
    public String updateventa(@ModelAttribute("venta") Ventas ventas) {
        if(ventas.getIdVenta() == null){
            Menu menu = menuService.findById(ventas.getMenu().getIdMenu());
            Cliente cliente = clienteService.findById(ventas.getCliente().getIdCliente());
            ventas.setCliente(cliente);
            ventas.setMenu(menu);
            ventas.setFecha(LocalDate.now());
            ventasService.save(ventas);
        }else {
            Ventas ventaUpdate = ventasService.findById(ventas.getIdVenta());
            if (ventaUpdate != null) {
                ventaUpdate.setCantidad(ventas.getCantidad());
                ventaUpdate.setMenu(ventas.getMenu());
                ventaUpdate.setCliente(ventas.getCliente());
                ventaUpdate.setCosto_menu(ventas.getCosto_menu());
                ventaUpdate.setTotal(ventas.getTotal());
                ventasService.save(ventaUpdate);
            } else {
                ventasService.save(ventas);
            }
        }
        return "redirect:/index/ventas";
    }


    @GetMapping("/index/ventas/{id}")
    public String ventaedit(@PathVariable Long id, ModelMap model){
        Ventas ventas = ventasService.findById(id);
        model.addAttribute("venta", ventas);
        model.addAttribute("listventas", ventasService.findByAll());
        model.addAttribute("listcliente", clienteService.findByAll());
        model.addAttribute("listmenu", menuService.findByAll());
        return "ventasedit";
    }

    @PostMapping("/index/delete/venta/{id}")
    public String deleteMenu(@PathVariable Long id){
        ventasService.delete(id);
        return "redirect:/index/ventas";
    }

    @GetMapping("/venta/eliminar/{idVenta}")
    public String eliminarventa(@PathVariable Long idVenta){
        ventasService.delete(idVenta);
        return "redirect:/index/ventas";
    }



}
