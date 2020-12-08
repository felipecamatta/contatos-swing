package br.ufes.contatos.frontend.presenter.command;

import br.ufes.contatos.frontend.model.Contato;
import br.ufes.contatos.frontend.presenter.ConsultarContatosPresenter;
import br.ufes.contatos.frontend.presenter.ManterPresenter;

public class EditarCommand implements ICommandPresenter {

    private Contato contato;
    private ConsultarContatosPresenter controler;

    public EditarCommand(Contato contato, ConsultarContatosPresenter controler) {
        this.contato = contato;
        this.controler = controler;
    }

    @Override
    public void executar() {
        new ManterPresenter(this.contato).addObservador(controler);
    }

}
