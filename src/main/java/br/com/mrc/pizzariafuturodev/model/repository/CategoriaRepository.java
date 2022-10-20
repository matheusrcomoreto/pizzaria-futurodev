package br.com.mrc.pizzariafuturodev.model.repository;

import br.com.mrc.pizzariafuturodev.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
