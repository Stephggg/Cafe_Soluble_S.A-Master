package com.servweb.prueba2026.controller;

import com.servweb.prueba2026.model.Producto;
import com.servweb.prueba2026.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> consultarTodos() {
        return productoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> consultarPorId(@PathVariable Long id) {
        return productoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Producto> registrar(@RequestBody Producto producto) {
        Producto guardado = productoService.registrar(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }
}
