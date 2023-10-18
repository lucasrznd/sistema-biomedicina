package br.edu.unifio.sistemabiomedicina.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatarData {

    public static void formatarData(LocalDate data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dtf.format(data);
    }

}
