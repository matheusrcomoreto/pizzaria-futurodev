package br.com.mrc.pizzariafuturodev.api.controller;

import br.com.mrc.pizzariafuturodev.model.entity.Mesa;
import br.com.mrc.pizzariafuturodev.model.entity.Pedido;
import br.com.mrc.pizzariafuturodev.model.service.interfaces.MesaService;
import br.com.mrc.pizzariafuturodev.model.service.interfaces.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private MesaService mesaService;

    @PostMapping
    public ResponseEntity<Pedido> criarPedido (@RequestBody Pedido pedido){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.pedidoService.salvar(pedido));
    }

    @GetMapping("/mesas-livres")
    public ResponseEntity<List<Mesa>> listarMesasLivres(){
        return ResponseEntity.ok(this.mesaService.listarAtivas());
    }

}