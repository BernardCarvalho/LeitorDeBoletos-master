package org.example.boleto.template_method_plus_strategy;

import org.example.boleto.Boleto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LeituraRetornoBradesco implements LeituraRetorno {
    @Override
    public Boleto processarLinhaArquivo(String[] atributos) {

        final Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(atributos[0]));
        boleto.setCodBanco(atributos[1]);
        boleto.setAgencia(atributos[2]);
        boleto.setContaBancaria(atributos[3]);
        boleto.setDataVencimento(LocalDate.parse(atributos[4],FORMATO_DATA));
        boleto.setDataPagamento(LocalDateTime.parse(atributos[5],FORMATO_DATA_HORA));
        boleto.setCpfCliente(preparaCPF(atributos[6]));
        boleto.setValor(Double.parseDouble(atributos[7]));
        boleto.setMulta(Double.parseDouble(atributos[8]));
        boleto.setJuros(Double.parseDouble(atributos[9]));

        return boleto;
    }

    private String preparaCPF(String cpfNaoFormatado){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<cpfNaoFormatado.length();i++) {
            char c =cpfNaoFormatado.charAt(i);
            switch (c) {
                case '.':
                    break;
                case '-':
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}
