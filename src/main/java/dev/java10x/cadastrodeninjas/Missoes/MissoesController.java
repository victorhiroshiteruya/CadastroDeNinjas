package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    // GET -- Manda requisição para listar as missões
    @GetMapping("/listar")
    public String listarMissao() {
        return "Lista de missoes";
    }

    // POST -- Manda requisição para criar uma nova missão
    @PostMapping("/criar")
    public String criarMissao() {
        return "Missao criada com sucesso";
    }

    // PUT -- Manda requisição para alterar uma missão
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missao alterada com sucesso";
    }

    // DELETE -- Manda requisição para deletar uma missão
    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missao deletada com sucesso";
    }

}
