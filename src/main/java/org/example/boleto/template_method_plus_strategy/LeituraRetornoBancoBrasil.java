package org.example.boleto.template_method_plus_strategy;

import org.example.boleto.Boleto;

import java.time.LocalDate;

public class LeituraRetornoBancoBrasil implements LeituraRetorno {


    @Override
    public Boleto processarLinhaArquivo(String[] atributos) {
        final Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(atributos[0]));
        boleto.setCodBanco(atributos[1]);

        boleto.setDataVencimento(LocalDate.parse(atributos[2],FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(atributos[3],FORMATO_DATA).atStartOfDay());
        boleto.setCpfCliente(atributos[4]);
        boleto.setValor(Double.parseDouble(atributos[5]));
        boleto.setMulta(Double.parseDouble(atributos[6]));
        boleto.setJuros(Double.parseDouble(atributos[7]));

        return boleto;
    }
}
