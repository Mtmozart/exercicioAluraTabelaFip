package br.tabelafip.demo.service;

import br.tabelafip.demo.models.DadosMarca;

import java.util.List;

public class ApisURls {
    private final String URL = "https://parallelum.com.br/fipe/api/v1/";

    private ConsumerApi consumerApi = new ConsumerApi();


    public String urlMarcasPorTipoVeiculos(String tipoVeiculo) {
        return consumerApi.conectarApi(URL + tipoVeiculo + "/marcas");
    }

    public String urlModelosPorMarcas(String tipoVeiculo, String marca) {
      //  System.out.println(URL + tipoVeiculo + "/marcas/" + marca + "/modelos");
        return consumerApi.conectarApi(URL + tipoVeiculo + "/marcas/" + marca + "/modelos");
    }
}
