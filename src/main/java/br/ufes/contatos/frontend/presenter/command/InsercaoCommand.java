package br.ufes.contatos.frontend.presenter.command;

import br.ufes.contatos.frontend.presenter.state.ManterContatosState;

public class InsercaoCommand implements ICommandPresenter {

    private ManterContatosState estado;

    public InsercaoCommand(ManterContatosState estado) {
        this.estado = estado;
    }

    @Override
    public void executar() {
        this.estado.salvar();
    }

}
