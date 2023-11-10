package br.edu.unifio.sistemabiomedicina.utils;

import br.edu.unifio.sistemabiomedicina.models.entities.Anticorpo;
import org.omnifaces.util.Messages;

import java.util.List;

public class ListaUtil<T> {

    public static <T> void verificaTamanhoLista(List<T> lista) {
        if (lista.isEmpty()) {
            Messages.addFlashGlobalWarn("Nenhum registro encontrado.");
        }
    }

    public static <T> String listaString(List<T> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (T item : list) {
            sb.append(item).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

}
