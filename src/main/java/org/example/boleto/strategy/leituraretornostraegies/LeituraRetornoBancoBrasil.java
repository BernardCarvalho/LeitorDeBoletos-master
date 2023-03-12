package org.example.boleto.strategy.leituraretornostraegies;

import lombok.SneakyThrows;
import org.example.boleto.Boleto;
import org.example.boleto.strategy.LeituraRetorno;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBancoBrasil implements LeituraRetorno {
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
            boleto.setDataVencimento(LocalDate.parse(atributos[2],FORMATO_DATA));
            boleto.setDataPagamento(LocalDate.parse(atributos[3],FORMATO_DATA).atStartOfDay());
            boleto.setCpfCliente(atributos[4]);
            boleto.setValor(Double.parseDouble(atributos[5]));
            boleto.setMulta(Double.parseDouble(atributos[6]));
            boleto.setJuros(Double.parseDouble(atributos[7]));
            listaBoletos.add(boleto);
        }
        return listaBoletos;
    }
}
