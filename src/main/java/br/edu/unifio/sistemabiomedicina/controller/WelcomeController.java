package br.edu.unifio.sistemabiomedicina.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String redirecionarParaPaginaHome() {
            return "redirect:/pages/fenotipagem.xhtml";
    }

}
