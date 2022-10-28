package br.com.mrc.pizzariafuturodev.model.repository;

import br.com.mrc.pizzariafuturodev.model.entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao,Long> {

}
