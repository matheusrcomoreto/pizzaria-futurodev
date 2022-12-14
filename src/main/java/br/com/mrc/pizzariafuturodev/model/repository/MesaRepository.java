package br.com.mrc.pizzariafuturodev.model.repository;

import br.com.mrc.pizzariafuturodev.model.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
}
