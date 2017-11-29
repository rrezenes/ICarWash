package br.icarwash.util.email;

public class EmailNovoCliente extends Email{
    
    public EmailNovoCliente(String nomeDestinatario, String emailDestinatario) {        
        super(  nomeDestinatario,
                emailDestinatario, 
                "Assunto novo cliente",
                "Mensagem de Boas Vindas,\n\n"
              + "novo cliente");        
    }
}
