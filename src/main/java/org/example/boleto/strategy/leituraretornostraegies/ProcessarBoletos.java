package org.example.boleto;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.example.boleto.strategy.LeituraRetorno;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
public class ProcessarBoletos {
    @Setter
    private LeituraRetorno leituraRetorno;

    public final void processar(URI caminhoArquivo){
        System.out.println("Boletos");
        System.out.println("------------------------------------------");
        final List<Boleto> boletos = leituraRetorno.lerArquivo(caminhoArquivo);
        for(Boleto boleto: boletos){
            System.out.println(boleto);
        }
    }
}
