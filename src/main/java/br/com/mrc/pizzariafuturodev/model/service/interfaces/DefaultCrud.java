package br.com.mrc.pizzariafuturodev.model.service.interfaces;
import java.util.List;

public interface DefaultCrud <T>{

    T salvar (T Object);

    T atualizar (T Object);

    T buscar (Long id);

    List<T> listar();

    void excluir (Long id);
}
