package br.com.mrc.pizzariafuturodev.model.service.interfaces;

import br.com.mrc.pizzariafuturodev.model.entity.Pedido;

public interface PedidoService extends DefaultCrud<Pedido>{

    Pedido fecharConta (Long idPedido);
}
