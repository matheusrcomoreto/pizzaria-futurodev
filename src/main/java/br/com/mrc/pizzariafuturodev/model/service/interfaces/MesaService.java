package br.com.mrc.pizzariafuturodev.model.service.interfaces;

import br.com.mrc.pizzariafuturodev.model.entity.Mesa;

import java.util.List;

public interface MesaService {

    Mesa salvar (Mesa mesa);

    Mesa atualizar (Mesa mesa);

    Mesa buscar (Long id);

    List<Mesa> listar();

    List<Mesa> listarAtivas();

    void excluir (Long id);

}
