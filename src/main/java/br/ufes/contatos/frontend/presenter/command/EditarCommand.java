/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.contatos.frontend.presenter.command;

import br.ufes.contatos.frontend.model.Contato;
import br.ufes.contatos.frontend.presenter.ConsultarContatosPresenter;
import br.ufes.contatos.frontend.presenter.ManterPresenter;


/**
 *
 * @author gabriel
 */
public class EditarCommand implements ICommandPresenter{
    
    private Contato contato;
    private ConsultarContatosPresenter controler;

    public EditarCommand(Contato contato, ConsultarContatosPresenter controler) {
        this.contato = contato;
        this.controler = controler;
    }

    @Override
    public void executar() {
        this.controler.addObservado(new ManterPresenter(this.contato));
    }
    
    
    
}
