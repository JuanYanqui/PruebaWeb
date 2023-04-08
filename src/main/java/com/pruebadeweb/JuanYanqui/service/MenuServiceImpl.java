package com.pruebadeweb.JuanYanqui.service;


import com.pruebadeweb.JuanYanqui.model.Menu;
import com.pruebadeweb.JuanYanqui.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends GenericServiceImpl<Menu, Long> implements MenuService{
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public CrudRepository<Menu, Long> getDao() {
        return menuRepository;
    }
}
