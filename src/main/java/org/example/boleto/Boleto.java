package org.example.boleto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Boleto {
    private int id;
    private double valor, multa, juros;
    private String codBanco, cpfCliente, agencia, contaBancaria;
    private LocalDate dataVencimento;
    private LocalDateTime dataPagamento;
}
