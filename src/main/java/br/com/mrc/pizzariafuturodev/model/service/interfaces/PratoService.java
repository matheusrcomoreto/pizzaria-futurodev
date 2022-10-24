package br.com.mrc.pizzariafuturodev.model.service.interfaces;

import br.com.mrc.pizzariafuturodev.model.entity.Prato;

public interface PratoService extends DefaultCrud<Prato> {

    Prato buscarPorNome(String nome);


}
