package br.tabelafip.demo.service;

import br.tabelafip.demo.models.DadosMarca;

import java.util.List;
import java.util.Scanner;

public class BuscaMarca {
    Scanner sc = new Scanner(System.in);

    public String buscaVeiculoPorMarcas(List<DadosMarca> marcas) {
        System.out.println("Digite o nome da marca ?");
        String nomeMarca = sc.nextLine();
        var marcaBuscada = marcas.stream()
                .filter(m -> m.nome().toUpperCase().contains(nomeMarca.toUpperCase()))
                .findFirst();

        if (marcaBuscada.isEmpty()) {
            System.out.println("Desculpe, a marca que você procurou não foi encontrada");
            return null;
        } else {
            System.out.println("Marca encontrada");
            System.out.println("Procurando por: " + marcaBuscada.get().nome() + " " + marcaBuscada.get().codigo());
            return marcaBuscada.get().codigo();
        }

    }
}
