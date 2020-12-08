package br.ufes.contatos.frontend.presenter.state;

import br.ufes.contatos.frontend.presenter.ManterPresenter;
import br.ufes.contatos.frontend.model.Contato;
import br.ufes.contatos.frontend.view.ManterContatoView;
import javax.swing.JOptionPane;

public class EdicaoContatoPresenter extends ManterContatosState {

    
    public EdicaoContatoPresenter(ManterPresenter presenter) {
        super(presenter);
    }
    
    @Override
    public void salvar() {
        ManterContatoView view = this.presenter.getView();

        Contato contato = this.presenter.getContatoView();
        contato.setId(this.presenter.getContato().getId());
        
        this.contatoService.updateContato(contato);

        JOptionPane.showMessageDialog(view,
                "Contato " + contato.getNome() + " atualizado com sucesso!",
                "Atualizado com sucesso",
                JOptionPane.INFORMATION_MESSAGE);
        
        this.fechar();
    }

    
}
