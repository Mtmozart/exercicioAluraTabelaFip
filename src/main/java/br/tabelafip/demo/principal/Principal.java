package br.tabelafip.demo.principal;

import br.tabelafip.demo.models.DadosMarca;
import br.tabelafip.demo.service.*;

import java.util.List;
import java.util.Scanner;

public class Principal {

    private ConsumerApi consumerApi = new ConsumerApi();

    private Conversor conversor = new Conversor();


    private String tipoVeiculo;

    private MenuOptions menu = new MenuOptions();

    private PesquisarTipoVeiculo pesquisarTipoVeiculo = new PesquisarTipoVeiculo();

    private PesquisaPorModelo pesquisaPorModelo = new PesquisaPorModelo();


    Scanner sc = new Scanner(System.in);

    public void exibiMenu() {

        List<DadosMarca> marcas = this.pesquisarTipoVeiculo.tipoVeiculo(this.tipoVeiculo = menu.exibiTiposVeiculos());

        if (!marcas.isEmpty()) {
            BuscaMarca buscaVeiculoPorMarcas = new BuscaMarca();
            var marca = buscaVeiculoPorMarcas.buscaVeiculoPorMarcas(marcas);
            this.pesquisaPorModelo.pesquisaPorModelo(this.tipoVeiculo, marca);
        }
    }
}



