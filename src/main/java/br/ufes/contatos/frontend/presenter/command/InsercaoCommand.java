/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.contatos.frontend.presenter.command;

import br.ufes.contatos.frontend.presenter.state.ManterContatosState;

/**
 *
 * @author gabriel
 */
public class InsercaoCommand implements ICommandPresenter{

    private ManterContatosState estado;

    public InsercaoCommand(ManterContatosState estado) {
        this.estado = estado;
    }
    
    @Override
    public void executar() {
        this.estado.salvar();
    }
    
}
