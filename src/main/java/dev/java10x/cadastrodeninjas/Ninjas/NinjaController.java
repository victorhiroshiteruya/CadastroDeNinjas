package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public String boasVindas() {
        return "Boas vindas nessa rota";
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + ninjaDTO.getNome() + "(ID) : " + ninjaDTO.getId());

    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return  ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorID(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.buscarNinjaPorID(id);
        if (ninjaService.buscarNinjaPorID(id) != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não encontrado de ID " + id);
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        if (ninjaService.buscarNinjaPorID(id) != null) {
            ninjaService.atualizarNinja(id, ninja);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Ninja de ID " + id + " alterado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID: " + id + " Não encontrado!");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorID(@PathVariable Long id) {
        if (ninjaService.buscarNinjaPorID(id) != null) {
            ninjaService.deleteNinja(id);
            return ResponseEntity.ok("iD: " + id + " Ninja atualizada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID: " + id + " Não encontrado!");
        }
    }
}