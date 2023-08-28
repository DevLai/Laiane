/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registro;

/**
 *
 * @author laiane
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BlocoDeLembretes {
    private List<Lembrete> lembretes;

    public BlocoDeLembretes() {
        lembretes = new ArrayList<>();
    }

    public void adicionarLembrete(Lembrete lembrete) {
        lembretes.add(lembrete);
    }

    public void removerLembrete(int indice) {
        if (indice >= 0 && indice < lembretes.size()) {
            lembretes.remove(indice);
        }
    }

    public List<Lembrete> buscarSubstring(String substring) {
        List<Lembrete> retornos = new ArrayList<>();
        for (Lembrete lembrete : lembretes) {
            if (lembrete.getLembrete().contains(substring)) {
                retornos.add(lembrete);
            }
        }
        return retornos;
    }

    public List<Lembrete> buscarMes(int mes) {
        List<Lembrete> retornos = new ArrayList<>();
        for (Lembrete lembrete : lembretes) {
            String[] dataParts = lembrete.getData().split("/");
            int lembreteMes = Integer.parseInt(dataParts[1]);
            if (lembreteMes == mes) {
                retornos.add(lembrete);
            }
        }
        return retornos;
    }

    public List<Lembrete> buscarPorDia(int dia) {
        List<Lembrete> retornos = new ArrayList<>();
        for (Lembrete lembrete : lembretes) {
            String[] dataParts = lembrete.getData().split("/");
            int lembreteDia = Integer.parseInt(dataParts[0]);
            if (lembreteDia == dia) {
                retornos.add(lembrete);
            }
        }
        return retornos;
    }

    public void ordenarPorData() {
        Collections.sort(lembretes, Comparator.comparing(Lembrete::getData));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lembrete lembrete : lembretes) {
            sb.append(lembrete).append("\n");
        }
        return sb.toString();
    }
}
