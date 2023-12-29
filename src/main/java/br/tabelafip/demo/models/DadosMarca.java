package br.tabelafip.demo.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public record DadosMarca(String codigo, String nome) {

}
