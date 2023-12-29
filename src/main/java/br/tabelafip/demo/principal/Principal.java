package br.tabelafip.demo.principal;

import br.tabelafip.demo.models.DadosMarca;
import br.tabelafip.demo.service.BuscaVeiculoPorMarcas;
import br.tabelafip.demo.service.ConsumerApi;
import br.tabelafip.demo.service.Conversor;
import br.tabelafip.demo.service.PesquisarTipoVeiculo;

import java.util.List;
import java.util.Scanner;

public class Principal {

    private ConsumerApi consumerApi = new ConsumerApi();

    private Conversor conversor = new Conversor();

    private final String URL = "https://parallelum.com.br/fipe/api/v1/";
    private String tipoVeiculo;

    private MenuOptions menu = new MenuOptions();

    private PesquisarTipoVeiculo pesquisarTipoVeiculo = new PesquisarTipoVeiculo();


    Scanner sc = new Scanner(System.in);

    public void exibiMenu() {

        List<DadosMarca> marcas = this.pesquisarTipoVeiculo.tipoVeiculo(URL, this.tipoVeiculo = menu.exibiTiposVeiculos());

        if (!marcas.isEmpty()){
            BuscaVeiculoPorMarcas buscaVeiculoPorMarcas= new BuscaVeiculoPorMarcas();
            buscaVeiculoPorMarcas.buscaVeiculoPorMarcas(marcas);
        }
    }
}



