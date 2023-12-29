package br.tabelafip.demo.service;

import br.tabelafip.demo.models.Modelo;
import br.tabelafip.demo.models.Dados;
import br.tabelafip.demo.models.Veiculo;

import java.util.*;
import java.util.stream.Collectors;

public class PesquisaPorModeloEAno {
    private Conversor conversor = new Conversor();
    Scanner sc = new Scanner(System.in);

    public List<Modelo> pesquisaPorModelo(String tipoVeiculo, String marca) {

        if (marca != null) {
            ApisURls apisURl = new ApisURls();
            var json = apisURl.urlModelosPorMarcas(tipoVeiculo, marca);
            var modeloLista = conversor.obterDados(json, Modelo.class);
            modeloLista.modelos().stream()
                    .sorted(Comparator.comparing(Dados::codigo))
                    .forEach(System.out::println);

            System.out.println("Digite o código do veículo ?");
            String codigoVeiculo = sc.nextLine();

            List<Dados> modelosFiltrados = modeloLista.modelos().stream()
                    .filter(m -> m.codigo().toLowerCase().contains(codigoVeiculo.toLowerCase()))
                    .collect(Collectors.toList());
            System.out.println("\nModelos filtrados");
            modelosFiltrados.forEach(System.out::println);

            json = apisURl.urlModelosAnos(tipoVeiculo, marca, codigoVeiculo);
            List<Dados> anos = conversor.obterlista(json, Dados.class);
            List<Veiculo> veiculos = new ArrayList<>();

            for (int i = 0; i < anos.size(); i++) {
                var ano = anos.get(i).codigo();
                json = apisURl.urlModelosPorAno(tipoVeiculo, marca, codigoVeiculo, ano);
                Veiculo veiculo = conversor.obterDados(json, Veiculo.class);
                veiculos.add(veiculo);
            }

            System.out.println("\nTodos os veículos filtrados com avaliações por ano: ");
            veiculos.forEach(System.out::println);
            return Collections.singletonList(modeloLista);
        } else {
            return Collections.emptyList();
        }


    }
}
