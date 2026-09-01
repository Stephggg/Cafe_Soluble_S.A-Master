package com.servweb.prueba2026;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioController {

    @GetMapping("/")
    public String inicio() {
        return "¡Hola! Cafe Soluble S.A. está funcionando";
    }
}