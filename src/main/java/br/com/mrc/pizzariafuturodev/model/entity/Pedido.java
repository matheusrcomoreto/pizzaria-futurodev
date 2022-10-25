package br.com.mrc.pizzariafuturodev.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Mesa mesa;

    private Double valorTotal;

    private Boolean isPago;

    @ManyToMany
            @JoinTable(
                    name = "pedido_prato",
                    joinColumns = @JoinColumn(name = "pedido_id"),
                    inverseJoinColumns = @JoinColumn(name = "prato_id"))
    private List<Prato> pedidoPrato;



}
