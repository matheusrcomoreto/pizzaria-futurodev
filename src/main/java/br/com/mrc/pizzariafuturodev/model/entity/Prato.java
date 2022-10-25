package br.com.mrc.pizzariafuturodev.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String nome;

    @PositiveOrZero
    private Double valor;

    @ManyToOne
    private Categoria categoria;

    @ManyToMany(mappedBy = "pedidoPrato")
    private List<Pedido> pedido;
}
