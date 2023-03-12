package org.example.boleto.strategy.leituraretornostraegies;

import lombok.SneakyThrows;
import org.example.boleto.Boleto;
import org.example.boleto.strategy.LeituraRetorno;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBradesco implements LeituraRetorno {
    @Override
    @SneakyThrows
    public List<Boleto> lerArquivo(URI caminhoArquivo) {
        var reader = Files.newBufferedReader(Paths.get(caminhoArquivo));
        String line;
        final List<Boleto> listaBoletos = new ArrayList<>();
        while((line=reader.readLine())!=null){
            final String[] atributos = line.split(";");
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
            listaBoletos.add(boleto);
        }
        return listaBoletos;
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
