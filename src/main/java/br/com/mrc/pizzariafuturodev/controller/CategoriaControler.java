package br.com.mrc.pizzariafuturodev.controller;

import br.com.mrc.pizzariafuturodev.model.entity.Categoria;
import br.com.mrc.pizzariafuturodev.model.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaControler {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> salvar (@RequestBody @Valid Categoria categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.categoriaService.salvar(categoria));
    }
}
