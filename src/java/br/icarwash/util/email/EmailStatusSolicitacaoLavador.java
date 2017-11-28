package br.icarwash.util.email;

import br.icarwash.model.Solicitacao;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailStatusSolicitacaoLavador {

    private String nomeDestinatario;
    private String emailDestinatario;
    private String assunto;
    private String mensagem;

    public EmailStatusSolicitacaoLavador(Solicitacao solicitacao) {
        this.nomeDestinatario = solicitacao.getLavador().getNome();
        this.emailDestinatario = solicitacao.getLavador().getUsuario().getEmail();
        switch (solicitacao.getEstado().toString()) {
            case "Em Analise":
                this.assunto = "Falta implementar assunto";
                this.mensagem = "falta implementar msg";
                break;
            case "Agendado":
                this.assunto = "Solicitação Agendada!!";
                this.mensagem = "Olá " + solicitacao.getCliente().getNome() + ",\n\n"
                        + "Sua solicitação #" + solicitacao.getId() + " foi agendada com sucesso.\n\n"
                        + "Fique esperto com a data do seu serviço!\n\n"
                        + "Data: " + solicitacao.getDataSolicitacao().getTime() + ",\n"
                        + "Lavador: " + solicitacao.getLavador().getNome() + ",\n"
                        + "Endereco: " + solicitacao.getEndereco().getEndereco() + " nº " + solicitacao.getEndereco().getNumero() + ",\n"
                        + "Valor: " + solicitacao.getValorTotal();
                break;
            case "Em Processo":
                this.assunto = "Falta implementar assunto";
                this.mensagem = "falta implementar msg";
                break;
            case "Finalizado":
                this.assunto = "Falta implementar assunto";
                this.mensagem = "falta implementar msg";
                break;
            case "Avaliado":
                this.assunto = "Falta implementar assunto";
                this.mensagem = "falta implementar msg";
                break;
            case "Concluido":
                this.assunto = "Falta implementar assunto";
                this.mensagem = "falta implementar msg";
                break;
            case "Cancelado":
                this.assunto = "Falta implementar assunto";
                this.mensagem = "falta implementar msg";
                break;
            default:
                break;
        }
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

        // email.setSslSmtpPort("456");
        //email.setSSLOnConnect(true);
        try {
            email.addTo(emailDestinatario, nomeDestinatario);
            email.setFrom(EmailAutenticacao.email, EmailAutenticacao.nome);
            email.setSubject(assunto);
            email.setMsg(mensagem);

            //System.out.println("autenticando...");
            email.setAuthentication(EmailAutenticacao.email, EmailAutenticacao.senha);
            //System.out.println("enviando...");
            System.out.println(assunto);
            System.out.println(mensagem);
            System.out.println(email.send());
            //System.out.println("Email enviado!");

            return true;
        } catch (EmailException e) {
            e.printStackTrace();
            return false;
        }
    }
}
