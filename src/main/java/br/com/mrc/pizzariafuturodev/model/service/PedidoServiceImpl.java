package br.com.mrc.pizzariafuturodev.model.service;

import br.com.mrc.pizzariafuturodev.model.entity.Mesa;
import br.com.mrc.pizzariafuturodev.model.entity.Pedido;
import br.com.mrc.pizzariafuturodev.model.repository.PedidoRepository;
import br.com.mrc.pizzariafuturodev.model.service.interfaces.MesaService;
import br.com.mrc.pizzariafuturodev.model.service.interfaces.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private MesaService mesaService;

    @Override
    public Pedido salvar(Pedido pedido) {
        Pedido pedidoSalvo = this.pedidoRepository.save(pedido);

        if(pedidoSalvo.getId() != null){
            Mesa mesaReservada = this.mesaService.buscar(pedidoSalvo.getMesa().getId());
            mesaReservada.setStatus(false);
            this.mesaService.atualizar(mesaReservada);
        }
        return pedidoSalvo;
    }

    @Override
    public Pedido atualizar(Pedido Object) {
        return null;
    }

    @Override
    public Pedido buscar(Long id) {
        return null;
    }

    @Override
    public List<Pedido> listar() {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
