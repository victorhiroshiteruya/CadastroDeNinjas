package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() { return  "Boas vindas nessa rota"; }

    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
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
