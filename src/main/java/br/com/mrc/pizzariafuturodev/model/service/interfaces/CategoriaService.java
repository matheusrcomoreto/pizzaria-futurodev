package br.com.mrc.pizzariafuturodev.model.service.interfaces;

import br.com.mrc.pizzariafuturodev.model.entity.Categoria;

import java.util.Calendar;
import java.util.List;

public interface CategoriaService {

    Categoria salvar (Categoria categoria);
    Categoria atualizar (Categoria categoria);
    Categoria buscar (Long id);
    Categoria buscarPorNome (String nome);
    List<Categoria> listar ();
    void deletar (long id);

}
