package br.com.mrc.pizzariafuturodev.api.controller;

import br.com.mrc.pizzariafuturodev.api.dto.CartaoRequestDto;
import br.com.mrc.pizzariafuturodev.api.dto.CartaoResponseDto;
import br.com.mrc.pizzariafuturodev.model.entity.Cartao;
import br.com.mrc.pizzariafuturodev.model.service.interfaces.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping
    public ResponseEntity<CartaoResponseDto> salvar(@RequestBody @Valid CartaoRequestDto cartaoRequestDto){
        Cartao cartao = instanciarCartao(cartaoRequestDto);

        Cartao cartaoSalvo = this.cartaoService.salvar(cartao);

        CartaoResponseDto cartaoResponse = instanciarCartaoResponse(cartaoSalvo);

        return ResponseEntity.status(HttpStatus.CREATED).body(cartaoResponse);
    }

    private Cartao instanciarCartao(CartaoRequestDto cartaoRequestDto){
        Cartao cartao = new Cartao();
        cartao.setNumero(cartaoRequestDto.getNumero());
        cartao.setValidade(cartaoRequestDto.getValidade());
        cartao.setLimite(cartaoRequestDto.getLimite());

        return cartao;
    }

    private CartaoResponseDto instanciarCartaoResponse(Cartao cartao){
        CartaoResponseDto cartaoResponse = new CartaoResponseDto();
        cartaoResponse.setId(cartao.getId());
        cartaoResponse.setNumero(cartao.getNumero());
        return cartaoResponse;

    }

}
