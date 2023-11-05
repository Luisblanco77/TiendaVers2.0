package com.tienda_v2.service.impl;

import com.tienda_v2.dao.ProductoDao;
import com.tienda_v2.domain.Producto;
import com.tienda_v2.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService{

    
    @Autowired
    private ProductoDao productoDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Producto> getProductos(boolean activo) {  
        var productos = productoDao.findAll();
        //Si son solo activas (activo = true) debo filtrar las inactivas...
        if (activo) {
            productos.removeIf(e -> !e.getActivo());
        }
        return productos;
    }
    
    //Se obtiene una Producto segun el Id pasado por parametro
    @Transactional(readOnly=true)
    @Override
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);  
    }
            
    //Se actualiza una producto o se inserta una nueva... (Si no hay id es un insert)
    @Override
    public void save(Producto producto) {
        productoDao.save(producto);
    }
    
    //Se elimina una producto segun el id pasado
    @Override
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
}
