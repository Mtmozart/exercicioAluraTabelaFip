package br.tabelafip.demo.service;

import br.tabelafip.demo.models.DadosMarca;

import java.util.Collections;
import java.util.List;

public class PesquisarTipoVeiculo {

    private ConsumerApi consumerApi = new ConsumerApi();

    private Conversor conversor = new Conversor();


    public List<DadosMarca> tipoVeiculo( String URL, String tipoVeiculo) {
        if (tipoVeiculo != null) {
            var json = consumerApi.conectarApi(URL + tipoVeiculo + "/marcas");
            // System.out.println(URL + tipoVeiculo + "/marcas");
            var listaMarcas = conversor.obterlista(json, DadosMarca.class);
            listaMarcas.forEach(System.out::println);
            return listaMarcas;
        }
        return Collections.emptyList();
    }
}
