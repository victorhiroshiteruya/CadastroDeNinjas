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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorID(@PathVariable Long id) {
        return ninjaService.buscarNinjaPorID(id);
    }

    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaModel ninja) {
        return ninjaService.atualizarNinja(id, ninja);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorID(@PathVariable Long id) {
        ninjaService.deleteNinja(id);
    }

}
