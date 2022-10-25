package br.com.mrc.pizzariafuturodev.model.service;

import br.com.mrc.pizzariafuturodev.model.entity.Mesa;
import br.com.mrc.pizzariafuturodev.model.entity.Prato;
import br.com.mrc.pizzariafuturodev.model.repository.PratoRepository;
import br.com.mrc.pizzariafuturodev.model.service.interfaces.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PratoServiceImpl implements PratoService {

    @Autowired
    private PratoRepository pratoRepository;

    @Override
    public Prato salvar(Prato prato) {
        return this.pratoRepository.save(prato);
    }

    @Override
    public Prato atualizar(Prato prato) {
        return null;
    }

    @Override
    public Prato buscar(Long id) {
        Optional<Prato> pratoPesquisado = this.pratoRepository.findById(id);

        if(pratoPesquisado.isEmpty()){
            throw new EntityNotFoundException("Não foi possivel encontrar um prato com o id " + id);
        }
        return pratoPesquisado.get();
    }

    @Override
    public List<Prato> listar() {
        return this.pratoRepository.findAll();
    }

    @Override
    public void excluir(Long id) {
        this.pratoRepository.deleteById(id);
    }

    @Override
    public Prato buscarPorNome(String nome) {
        return this.pratoRepository.findByNome(nome).orElseThrow(() -> {
            throw new EntityNotFoundException("Não foi possivel encontar um prato como o nome " + nome);
        });
    }
}
