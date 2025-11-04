package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() { return  "Boas vindas nessa rota"; }

    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    @GetMapping("/todos")
    public String mostrarTodosNinjas() {
        return "Todos";
    }

    @GetMapping("/todosID")
    public String mostrarTodosNinjaPorID() {
        return "Todos";
    }

    @PutMapping("/alterarID")
    public String alterarNinjaPorID() {
        return "Ninja alterada por ID";
    }

    @DeleteMapping("/deletarID")
    public String deletarNinjaPorID() {
        return "Ninja deletada por ID";
    }

}
