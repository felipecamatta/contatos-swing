/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.contatos.frontend.presenter.command;

import br.ufes.contatos.frontend.model.Contato;
import br.ufes.contatos.frontend.presenter.state.ManterPresenter;


/**
 *
 * @author gabriel
 */
public class EditarCommand implements ICommandPresenter{
    
    private Contato contato;

    public EditarCommand(Contato contato) {
        this.contato = contato;
    }

    @Override
    public void executar() {
        new ManterPresenter(this.contato);
    }
    
    
    
}
