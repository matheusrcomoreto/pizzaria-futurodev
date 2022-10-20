package br.com.mrc.pizzariafuturodev.model.service;

import br.com.mrc.pizzariafuturodev.model.entity.Mesa;
import br.com.mrc.pizzariafuturodev.model.repository.MesaRepositiry;
import br.com.mrc.pizzariafuturodev.model.service.interfaces.MesaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MesaServiceImpl implements MesaService {

    @Autowired
    private MesaRepositiry mesaRepositiry;

    @Override
    public Mesa salvar(Mesa mesa) {
        Mesa mesaSalvar = this.mesaRepositiry.save(mesa);
        return mesaSalvar;
    }

    @Override
    public Mesa atualizar(Mesa mesa) {
        Optional<Mesa> mesaPesquisada = this.mesaRepositiry.findById(mesa.getId());

        if (mesaPesquisada.isPresent()){
            mesaPesquisada.get().setStatus(mesa.getStatus());
//            BeanUtils.copyProperties(mesa,mesaPesquisada.get(),"id");
            return this.mesaRepositiry.save(mesaPesquisada.get());
        }
        return null;
    }

    @Override
    public Mesa buscar(Long id) {
        Optional<Mesa> mesa = this.mesaRepositiry.findById(id);

        if (mesa.isPresent()){
            return mesa.get();
        }
        return null;
    }

    @Override
    public List<Mesa> listar() {
        return this.mesaRepositiry.findAll();
    }

    @Override
    public List<Mesa> listarAtivas() {
        List<Mesa> mesas = this.mesaRepositiry.findAll().stream().filter(mesa -> mesa.getStatus() == true).collect(Collectors.toList());

        return mesas;
    }

    @Override
    public void excluir(Long id) {

    }
}
