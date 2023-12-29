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

    public String urlModelosAnos(String tipoVeiculo, String marca, String codigoDoVeiculo) {
        //  System.out.println(URL + tipoVeiculo + "/marcas/" + marca + "/modelos/" + ano);
        return consumerApi.conectarApi(URL + tipoVeiculo + "/marcas/" + marca + "/modelos/" + codigoDoVeiculo
                + "/anos");
    }

    public String urlModelosPorAno(String tipoVeiculo, String marca, String codigoDoVeiculo, String ano) {
        //  System.out.println(URL + tipoVeiculo + "/marcas/" + marca + "/modelos/" + ano);
        return consumerApi.conectarApi(URL + tipoVeiculo + "/marcas/" + marca + "/modelos/" + codigoDoVeiculo
                + "/anos/" + ano);
    }
}
