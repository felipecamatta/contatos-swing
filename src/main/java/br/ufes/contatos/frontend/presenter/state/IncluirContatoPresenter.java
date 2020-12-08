package br.ufes.contatos.frontend.presenter.state;

import br.ufes.contatos.frontend.presenter.ManterPresenter;
import br.ufes.contatos.frontend.model.Contato;
import br.ufes.contatos.frontend.view.ManterContatoView;
import javax.swing.JOptionPane;


public class IncluirContatoPresenter extends ManterContatosState {

    public IncluirContatoPresenter(ManterPresenter presenter) {
        super(presenter);
    }

    @Override
    public void salvar() {
        ManterContatoView view = this.presenter.getView();

        Contato contato = this.presenter.getContatoView();
        this.contatoService.saveContato(contato);

        JOptionPane.showMessageDialog(view,
                "Contato " + contato.getNome() + " salvo com sucesso!",
                "Salvo com sucesso",
                JOptionPane.INFORMATION_MESSAGE);
    }
    

}
