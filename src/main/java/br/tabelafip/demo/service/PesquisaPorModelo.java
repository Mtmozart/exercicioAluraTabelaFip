package br.tabelafip.demo.service;

import br.tabelafip.demo.models.DadosMarca;
import br.tabelafip.demo.models.Modelo;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PesquisaPorModelo {
    private Conversor conversor = new Conversor();
    Scanner sc = new Scanner(System.in);

    public List<Modelo> pesquisaPorModelo(String tipoVeiculo, String marca) {

        if(marca != null){
            ApisURls apisURl = new ApisURls();
            var json = apisURl.urlModelosPorMarcas(tipoVeiculo, marca);

            var listaModelos = conversor.obterlista(json, Modelo.class);
            //listaModelos.forEach(System.out::println);
            return listaModelos;
        }else {
            return Collections.emptyList();
        }




    }
}
