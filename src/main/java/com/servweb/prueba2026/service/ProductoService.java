package com.servweb.prueba2026.service;

import com.servweb.prueba2026.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final List<Producto> productos = new ArrayList<>();
    private long siguienteId = 9L;

    public ProductoService() {
        productos.add(new Producto(1L, "Cafe Clasico", "50 g", "Instantaneo", true));
        productos.add(new Producto(2L, "Cafe Premium", "100 g", "Instantaneo", true));
        productos.add(new Producto(3L, "Cafe Suave", "200 g", "Instantaneo", true));
        productos.add(new Producto(4L, "Cafe Descafeinado", "100 g", "Especialidad", true));
        productos.add(new Producto(5L, "Cafe Espresso", "50 g", "Especialidad", true));
        productos.add(new Producto(6L, "Cafe Vainilla", "100 g", "Saborizado", false));
        productos.add(new Producto(7L, "Cafe Moka", "200 g", "Saborizado", true));
        productos.add(new Producto(8L, "Cafe Tradicional", "50 g", "Tradicional", true));
    }

    public List<Producto> listarTodos() {
        return productos;
    }

    public Optional<Producto> buscarPorId(Long id) {
        return productos.stream()
                .filter(producto -> producto.getId().equals(id))
                .findFirst();
    }

    public Producto registrar(Producto producto) {
        Producto nuevoProducto = new Producto(
                siguienteId++,
                producto.getNombre(),
                producto.getPresentacion(),
                producto.getCategoria(),
                producto.isDisponible()
        );
        productos.add(nuevoProducto);
        return nuevoProducto;
    }
}