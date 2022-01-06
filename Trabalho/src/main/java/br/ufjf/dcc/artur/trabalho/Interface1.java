/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Artur Welerson Sott Meyer - 202065552C
 */
public class Interface1 {

    public static void main(String[] args) {
        Administrador adm = new Administrador("Artur", "123", 1000f);
        adm.adicionarFinanciamento("Peguei Empréstimo", 24000, 50, 7, 2, true);
        adm.adicionarFinanciamento("Empréstimo", 10000, 10, 2, 2, false);
        adm.adicionarGasto("Plano de Saúde", 500, 5);
        adm.adicionarGasto("Cartão", 500, 5);
        adm.adicionarFuncionario("Pedreiro", 300, 5);
        adm.adicionarRenda("Salário", 1000, 860);
        List<GastoRendaMensal> gastosDependente = new ArrayList<>();
        GastoRendaMensal planoDeSaude = new GastoRendaMensal("Plano de Saúde do José", 100, 854);
        gastosDependente.add(planoDeSaude);
        adm.adicionarDependente("José", 50, gastosDependente);
        adm.calcularSaldoFuturo(5);
        adm.calcularTempoParaMeta(50000);
    }

}
