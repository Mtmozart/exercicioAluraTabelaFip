package br.tabelafip.demo.service;

import java.util.List;
import java.util.Map;

public interface IConversor {
    <T> T obterDados(String json, Class<T> classe);

    <T> List<T> obterlista(String json, Class<T> classe);


}
