package br.com.mrc.pizzariafuturodev.model.entity;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
=======
>>>>>>> fa5f0bfebf5fb8845de9aff6f6a8983d4c3c4965
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> fa5f0bfebf5fb8845de9aff6f6a8983d4c3c4965

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
<<<<<<< HEAD

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonBackReference
    @ManyToMany(mappedBy = "pedidoPrato")
    private List<Pedido> pedido;
=======
>>>>>>> fa5f0bfebf5fb8845de9aff6f6a8983d4c3c4965
}
