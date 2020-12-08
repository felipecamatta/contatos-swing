package br.ufes.contatos.frontend.presenter;

import br.ufes.contatos.frontend.presenter.state.IncluirContatoPresenter;
import br.ufes.contatos.frontend.view.PrincipalView;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class PrincipalPresenter {
    
    private PrincipalView view;
    private ManterPresenter manter;
    private ConsultarContatosPresenter consultar;

    public PrincipalPresenter() {
        this.view = new PrincipalView();
        this.manter = null;
        this.consultar = null;
        
        this.view.setState(JFrame.ICONIFIED);

        this.view.setLocationRelativeTo(this.view.getParent());
        this.view.setExtendedState(MAXIMIZED_BOTH);
        
        this.view.setVisible(true);
        
        this.view.getItemIncluir().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(manter != null){
                    manter.fechar(); 
                }
                incluir();
                
            }
        });
        
        this.view.getItemConsultar().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(consultar != null){
                    consultar.fechar(); 
                }
                consultar();
            }
        });
    }

    
    private void consultar(){
        this.consultar = new ConsultarContatosPresenter(this);
    }
    
    private void incluir(){
        this.manter = new ManterPresenter();
        new IncluirContatoPresenter(this.manter);
    }
    
    
}
