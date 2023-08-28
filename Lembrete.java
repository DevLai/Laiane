/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Registro;

public class Lembrete {
    private String data;
    private String lembrete;

    public Lembrete(String data, String lembrete) {
        this.data = data;
        this.lembrete = lembrete;
    }

    public String getData() {
        return data;
    }

    public String getLembrete() {
        return lembrete;
    }

    @Override
    public String toString() {
        return "Data: " + data + ", Lembrete: " + lembrete;
    }
}
