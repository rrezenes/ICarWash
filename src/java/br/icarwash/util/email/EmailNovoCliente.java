package br.icarwash.util.email;

public class EmailNovoCliente extends Email {

    public EmailNovoCliente(String nomeDestinatario, String emailDestinatario) {
        super(nomeDestinatario,emailDestinatario,
                
                "Seja Bem Vindo ao ICarWash",//Assunto
                
                "Muito obrigado por iniciar seu cadastrar,\n\n"//inicio da mensagem
                + "falta pouco para fazer uma solicitação.");
    }
}
