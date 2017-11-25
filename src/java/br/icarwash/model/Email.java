package br.icarwash.model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

    // Recipient's email ID needs to be mentioned.
    // Sender's email ID needs to be mentioned
    String from = "icarwash.br@gmail.com";
    final String username = "icarwash.br";//change accordingly
    final String password = "qwerty111232";//change accordingly

    // Assuming you are sending email through relay.jangosmtp.net
    String host = "relay.jangosmtp.net";

    public void enviarEmailAgendado(Solicitacao solicitacao) {
        Properties props = new Properties();

        props.put(
                "mail.smtp.auth", "true");
        props.put(
                "mail.smtp.starttls.enable", "true");
        props.put(
                "mail.smtp.host", host);
        props.put(
                "mail.smtp.port", "25");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(solicitacao.getCliente().getUsuario().getEmail()));

            // Set Subject: header field
            message.setSubject("Testing Subject");

            // Now set the actual message
            message.setText("Olá " + solicitacao.getCliente().getNome() + ",\n\n"
                    + "Sua solicitação #" + solicitacao.getId() + " foi agendada com sucesso.\n\n"
                    + "Fique esperto com a data do seu serviço!\n\n"
                    + "Data: " + solicitacao.getDataSolicitacao() + ",\n"
                    + "Lavador: " + solicitacao.getLavador() + ",\n"
                    + "Endereco: " + solicitacao.getEndereco().getEndereco() + " nº " + solicitacao.getEndereco().getNumero() + ",\n"
                    + "Valor: " + solicitacao.getValorTotal());

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
