package br.icarwash.util.email;

import br.icarwash.model.Solicitacao;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailNovoCliente {

    private String nomeDestinatario;
    private String emailDestinatario;
    private String assunto;
    private String mensagem;

    public EmailNovoCliente(String nomeDestinatario, String emailDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
        this.emailDestinatario = emailDestinatario;
        this.assunto = assunto;        
        this.mensagem = mensagem;       
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean enviar() {
        SimpleEmail email = new SimpleEmail();

        email.setHostName("smtp.gmail.com");

        email.setSmtpPort(587);
        email.setStartTLSEnabled(true);

        // email.setSslSmtpPort("25");
        // email.setSslSmtpPort("456");
        // email.setSmtpPort(587);
        //email.setSSLOnConnect(true);
        try {
            email.addTo(emailDestinatario, nomeDestinatario);
            email.setFrom(EmailAutenticacao.email, EmailAutenticacao.nome);
            email.setSubject(assunto);
            email.setMsg(mensagem);

            System.out.println("autenticando...");
            email.setAuthentication(EmailAutenticacao.email, EmailAutenticacao.senha);
            System.out.println("enviando...");
            System.out.println(assunto);
            System.out.println(mensagem);
            System.out.println(email.send());
            System.out.println("Email enviado!");

            return true;
        } catch (EmailException e) {
            e.printStackTrace();
            return false;
        }
    }
}
