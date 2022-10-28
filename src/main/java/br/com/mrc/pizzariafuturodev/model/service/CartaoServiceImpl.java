package br.com.mrc.pizzariafuturodev.model.service;

import br.com.mrc.pizzariafuturodev.model.entity.Cartao;
import br.com.mrc.pizzariafuturodev.model.repository.CartaoRepository;
import br.com.mrc.pizzariafuturodev.model.service.interfaces.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoServiceImpl implements CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Override
    public Cartao salvar(Cartao cartao) {
        return this.cartaoRepository.save(cartao);
    }

    @Override
    public Cartao atualizar(Cartao cartao) {
        return null;
    }

    @Override
    public Cartao buscar(Long id) {
        return null;
    }

    @Override
    public List<Cartao> listar() {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
