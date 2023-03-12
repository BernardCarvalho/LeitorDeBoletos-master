package org.example.boleto.template_method_plus_strategy;

import lombok.SneakyThrows;
import org.example.boleto.Boleto;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProcessarBoletos {

    private LeituraRetorno leituraRetorno;

    public ProcessarBoletos(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public final void processar(URI caminhoArquivo){
        System.out.println("Boletos");
        System.out.println("------------------------------------------");
        final List<Boleto> boletos = lerArquivo(caminhoArquivo);
        for(Boleto boleto: boletos){
            System.out.println(boleto);
        }
    }
    @SneakyThrows
    public final List<Boleto> lerArquivo(URI caminhoArquivo) {
        var reader = Files.newBufferedReader(Paths.get(caminhoArquivo));
        String line;
        final List<Boleto> listaBoletos = new ArrayList<>();
        while((line=reader.readLine())!=null){
            final String[] atributos = line.split(";");
            //final Boleto boleto = new Boleto();

            final Boleto boleto = leituraRetorno.processarLinhaArquivo(atributos);
            listaBoletos.add(boleto);
        }
        return listaBoletos;
    }

//    protected abstract Boleto processarLinhaArquivo(String[] atributos);

    public void setLeituraRetorno(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
}
