/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.contatos.frontend.presenter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public abstract class Observado {
    
    private List<Observador> observadores;

    public Observado() {
        this.observadores = new ArrayList<>();
    }
    
    public void addObservador(Observador o){
        this.observadores.add(o);
    }
    
    public void removerObservador(Observador o){
        this.observadores.remove(o);
    }
    
    public void notificarObservadores(){
        for(Observador o : observadores){
            o.update();
        }
    }
    
}
