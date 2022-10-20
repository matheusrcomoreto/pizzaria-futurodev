package br.com.mrc.pizzariafuturodev.controller;

import br.com.mrc.pizzariafuturodev.model.entity.Mesa;
import br.com.mrc.pizzariafuturodev.model.service.interfaces.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @PostMapping
    public ResponseEntity <Mesa> salvar(@RequestBody Mesa mesa){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.mesaService.salvar(mesa));
    }

    @PutMapping
    public ResponseEntity<Mesa> atualizar (@RequestBody Mesa mesa){
        return ResponseEntity.ok(this.mesaService.atualizar(mesa));

    }

    @GetMapping
    public ResponseEntity<List<Mesa>> listar(){
        return ResponseEntity.ok(this.mesaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> buscar(@PathVariable Long id){
        Mesa mesa = this.mesaService.buscar(id);

        if (mesa == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.mesaService.buscar(id));
    }
    @GetMapping("/ativas")
    public ResponseEntity<List<Mesa>> listarAtivas(){
        return ResponseEntity.ok(this.mesaService.listar());
    }
}
