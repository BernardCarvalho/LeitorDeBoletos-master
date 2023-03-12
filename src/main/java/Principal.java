import org.example.boleto.ProcessarBoletos;
import org.example.boleto.strategy.leituraretornostraegies.LeituraRetornoBancoBrasil;
import org.example.boleto.strategy.leituraretornostraegies.LeituraRetornoBradesco;

import java.net.URISyntaxException;

public class Principal {
    public static void main(String[] args) throws URISyntaxException {
        final ProcessarBoletos processador = new ProcessarBoletos(new LeituraRetornoBancoBrasil());
        var caminhoArquivo = Principal.class.getResource("banco-brasil-1.csv").toURI();
        System.out.println("\n\n### lendo arquivo:"+caminhoArquivo+"\n");
        processador.processar(caminhoArquivo);

        processador.setLeituraRetorno(new LeituraRetornoBradesco());
        caminhoArquivo = Principal.class.getResource("bradesco-1.csv").toURI();
        System.out.println("\n\n### lendo arquivo:"+caminhoArquivo+"\n");
        processador.processar(caminhoArquivo);

        final org.example.boleto.template_method.ProcessarBoletos a = new org.example.boleto.template_method.LeituraRetornoBradesco();
        var caminhoArquivo2 = Principal.class.getResource("bradesco-1.csv").toURI();
        var aa = a.lerArquivo(caminhoArquivo2);
        System.out.println("Mostrando arquivo com padrao template: ");
        System.out.println(aa.toString());

        final org.example.boleto.template_method.ProcessarBoletos b = new org.example.boleto.template_method.LeituraRetornoBancoBrasil();
        var caminhoArquivo3 = Principal.class.getResource("banco-brasil-1.csv").toURI();
        var bb = b.lerArquivo(caminhoArquivo3);
        System.out.println("Mostrando arquivo com padrao template: ");
        System.out.println(bb.toString());

        final org.example.boleto.template_method_plus_strategy.ProcessarBoletos d = new org.example.boleto.template_method_plus_strategy.ProcessarBoletos(
                new org.example.boleto.template_method_plus_strategy.LeituraRetornoBancoBrasil()
        );
        var aaa = d.lerArquivo(caminhoArquivo3);
        System.out.println("Lendo arquivo com template method + strategy");
        System.out.println(aaa.toString());

        final org.example.boleto.template_method_plus_strategy.ProcessarBoletos e = new org.example.boleto.template_method_plus_strategy.ProcessarBoletos(
                new org.example.boleto.template_method_plus_strategy.LeituraRetornoBradesco()
        );
        var bbb = e.lerArquivo(caminhoArquivo2);
        System.out.println("Lendo arquivo com template method + strategy");
        System.out.println(bbb.toString());



    }
}
