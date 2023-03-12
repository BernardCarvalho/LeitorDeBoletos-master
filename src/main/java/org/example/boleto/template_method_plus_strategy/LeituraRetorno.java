package org.example.boleto.template_method_plus_strategy;

import org.example.boleto.Boleto;

import java.time.format.DateTimeFormatter;

public interface LeituraRetorno {
    DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    Boleto processarLinhaArquivo(String[] vetor);
}
