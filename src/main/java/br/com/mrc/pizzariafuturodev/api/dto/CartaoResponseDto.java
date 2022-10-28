package br.com.mrc.pizzariafuturodev.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartaoResponseDto {

    private Long id;

    private String numero;
}
