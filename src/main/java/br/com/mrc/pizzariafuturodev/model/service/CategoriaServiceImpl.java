package br.com.mrc.pizzariafuturodev.model.service;

import br.com.mrc.pizzariafuturodev.model.entity.Categoria;
import br.com.mrc.pizzariafuturodev.model.repository.CategoriaRepository;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria salvar(Categoria categoria) {
        String nome = categoria.getNome().toLowerCase();

        validarNome(nome);
        categoria.setNome(nome);
        return this.categoriaRepository.save(categoria);
    }

    @Override
    public Categoria atualizar(Categoria categoria) {
       Categoria categoriaPesquisada = buscar (categoria.getId());

        if (Objects.nonNull(categoria)){
            categoria.setNome(categoria.getNome().toLowerCase());
            BeanUtils.copyProperties(categoria,categoriaPesquisada,"id");
            validarNome(categoriaPesquisada.getNome().toLowerCase());
            this.categoriaRepository.save(categoriaPesquisada);
        }
        return null;
    }

    private void validarNome (String nome){
        if (this.categoriaRepository.existsByNome(nome)){
            throw new EntityExistsException("Já existe uma categoria com o nome: " + nome);
        }
    }

    @Override
    public Categoria buscar(Long id) {
        Optional<Categoria> categoriaPesquisada = this.categoriaRepository.findById(id);

        if (categoriaPesquisada.isEmpty()){
            throw new EntityExistsException("Não foi possível encontar uma categoria com o id " + id);
        }
        return categoriaPesquisada.get();

    }

    @Override
    public Categoria buscarPorNome(String nome) {
        Optional<Categoria> categoriaPesquisada = this.categoriaRepository.findByNome(nome);

        if (categoriaPesquisada.isEmpty()){
            throw new EntityNotFoundException("Não foi possivel encontar uma categoria com o nome :" + nome);
        }
        return categoriaPesquisada.get();
    }

    @Override
    public List<Categoria> listar() {
        return this.categoriaRepository.findAll();
    }

    @Override
    public void deletar(long id) {
        this.categoriaRepository.deleteById(id);

    }
}
