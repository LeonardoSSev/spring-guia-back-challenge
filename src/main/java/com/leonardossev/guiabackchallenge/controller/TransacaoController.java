package com.leonardossev.guiabackchallenge.controller;

import com.leonardossev.guiabackchallenge.model.Transacao;
import com.leonardossev.guiabackchallenge.model.TransacaoFiltro;
import com.leonardossev.guiabackchallenge.service.impl.TransacaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Representa o controller principal que contém o endpoint para listagem das transações.
 *
 * @author leonardossev
 * @author https://github.com/leonardossev
 * @version 25/12/2020
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class TransacaoController {

    @Autowired
    private TransacaoServiceImpl transacaoService;

    @GetMapping(value = "/{id}/transacoes/{ano}/{mes}")
    public ResponseEntity<List<Transacao>> listarTransacao(final TransacaoFiltro transacaoFiltro) {
        return new ResponseEntity<List<Transacao>>(
            this.transacaoService.listarTransacao(transacaoFiltro),
            HttpStatus.OK
        );
    }

}
