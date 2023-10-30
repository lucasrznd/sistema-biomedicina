package br.edu.unifio.sistemabiomedicina.utils;

import org.omnifaces.util.Messages;

import java.util.List;

public class ListaUtil<T> {

    public static <T> void verificaTamanhoLista(List<T> lista) {
        if (lista.isEmpty()) {
            Messages.addFlashGlobalWarn("Nenhum registro encontrado.");
        }
    }

}
