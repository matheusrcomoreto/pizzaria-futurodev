package br.com.mrc.pizzariafuturodev.model.service;

import br.com.mrc.pizzariafuturodev.model.entity.Categoria;
import br.com.mrc.pizzariafuturodev.model.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria salvar(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    @Override
    public Categoria atualizar(Categoria categoria) {
        return null;
    }

    @Override
    public Categoria buscar(Long id) {
        return null;
    }

    @Override
    public List<Categoria> listar() {
        return null;
    }

    @Override
    public void deletar(long id) {

    }
}
