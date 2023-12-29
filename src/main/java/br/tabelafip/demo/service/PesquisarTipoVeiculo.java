package br.tabelafip.demo.service;

import br.tabelafip.demo.models.DadosMarca;

import java.net.URL;
import java.util.Collections;
import java.util.List;

public class PesquisarTipoVeiculo {

    private ConsumerApi consumerApi = new ConsumerApi();

    private Conversor conversor = new Conversor();


    public List<DadosMarca> tipoVeiculo( String tipoVeiculo) {
        if (tipoVeiculo != null) {
          //  var json = consumerApi.conectarApi(URL + tipoVeiculo + "/marcas");
            // System.out.println(URL + tipoVeiculo + "/marcas");
            ApisURls apisURls = new ApisURls();
            var json = apisURls.urlMarcasPorTipoVeiculos(tipoVeiculo);
            var listaMarcas = conversor.obterlista(json, DadosMarca.class);
            listaMarcas.forEach(System.out::println);
            return listaMarcas;
        }
        return Collections.emptyList();
    }
}
