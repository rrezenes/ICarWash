package br.icarwash.model;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

public class Email {

    public Email(String to) throws AddressException, MessagingException {

    }

//    public void enviarEmAnalise(Solicitacao solicitacao) {
//        try {
//
//            // Set Subject: header field
//            msg.setSubject("Sua Solicitação está em analise!");
//
//            // Now set the actual message
//            msg.setText("Olá " + solicitacao.getCliente().getNome() + ",\n\n"
//                    + "Sua solicitação #"
//                    + solicitacao.getId() + " está em processo de analise.\n\n"
//                    + "Acompanhe os proximos emails!\n\n"
//                    + "Data: " + solicitacao.getDataSolicitacao() + ",\n"
//                    + "Lavador: " + solicitacao.getLavador() + ",\n"
//                    + "Endereco: " + solicitacao.getEndereco().getEndereco() + " nº " + solicitacao.getEndereco().getNumero() + ",\n"
//                    + "Valor: " + solicitacao.getValorTotal());
//
//            try (Transport transport = mailSession.getTransport("smtp")) {
//                transport.connect(host, user, pass);
//                transport.sendMessage(msg, msg.getAllRecipients());
//            }
//            System.out.println("message send successfully");
//        } catch (Exception ex) {
//
//            throw new RuntimeException(ex);
//        }
//    }
    public void enviarEmailAgendado(Solicitacao solicitacao) {

            try {
                String host = "smtp.gmail.com";
                String user = "icarwash.br@gmail.com";
                String pass = "qwerty111232";
                String to = solicitacao.getCliente().getUsuario().getEmail();
                String from = "icarwash.br@gmail.com";
                String subject = "Serviço Agendado!";
                String messageText = "Olá " + solicitacao.getCliente().getNome() + ",\n\n"
                        + "Sua solicitação #" + solicitacao.getId() + " foi agendada com sucesso.\n\n"
                        + "Fique esperto com a data do seu serviço!\n\n"
                        + "Data: " + solicitacao.getDataSolicitacao() + ",\n"
                        + "Lavador: " + solicitacao.getLavador() + ",\n"
                        + "Endereco: " + solicitacao.getEndereco().getEndereco() + " nº " + solicitacao.getEndereco().getNumero() + ",\n"
                        + "Valor: " + solicitacao.getValorTotal();
                boolean sessionDebug = false;

                Properties props = System.getProperties();

                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.port", "25");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.required", "true");
                props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

                java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                Session mailSession = Session.getDefaultInstance(props, null);
                mailSession.setDebug(sessionDebug);
                Message msg = new MimeMessage(mailSession);
                msg.setFrom(new InternetAddress(from));
                InternetAddress[] address = {new InternetAddress(to)};
                msg.setRecipients(Message.RecipientType.TO, address);
                msg.setSubject(subject);
                msg.setSentDate(new Date());
                msg.setText(messageText);

                Transport transport = mailSession.getTransport("smtp");
                transport.connect(host, user, pass);
                transport.sendMessage(msg, msg.getAllRecipients());
                transport.close();
                System.out.println("message send successfully");

            } catch (Exception ex) {

                throw new RuntimeException(ex);
            }

//            String host = "smtp.gmail.com";
//            String user = "icarwash.br@gmail.com";
//            String pass = "qwerty111232";
//            String from = "icarwash.br@gmail.com";
//            boolean sessionDebug = false;
//            Properties props = System.getProperties();
//            props.put("mail.smtp.starttls.enable", "true");
//            props.put("mail.smtp.host", host);
//            props.put("mail.smtp.port", "587");
//            props.put("mail.smtp.auth", "true");
//            props.put("mail.smtp.starttls.required", "true");
//            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//
//            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//
//            Session mailSession = Session.getDefaultInstance(props, null);
//            mailSession.setDebug(sessionDebug);
//
//            Message msg = new MimeMessage(mailSession);
//            msg.setFrom(new InternetAddress(from));
//            InternetAddress[] address = {new InternetAddress()};
//            msg.setRecipients(Message.RecipientType.TO, address);
//            msg.setSentDate(new Date());
//
//            // Set Subject: header field
//            msg.setSubject();
//
//            Transport transport = mailSession.getTransport("smtp");
//            transport.connect(host, user, pass);
//            transport.sendMessage(msg, msg.getAllRecipients());
//            transport.close();
//            System.out.println("message send successfully");
//        } catch (Exception ex) {
//
//            throw new RuntimeException(ex);
//        }
    }

//    public void enviarEmailEmProcesso(Solicitacao solicitacao) {
//        try {
//
//            Transport transport = mailSession.getTransport("smtp");
//            transport.connect(host, user, pass);
//            transport.sendMessage(msg, msg.getAllRecipients());
//            transport.close();
//            System.out.println("message send successfully");
//        } catch (Exception ex) {
//
//            throw new RuntimeException(ex);
//        }
//    }
//
//    public void enviarEmailAvaliado(Solicitacao solicitacao) {
//        try {
//
//            Transport transport = mailSession.getTransport("smtp");
//            transport.connect(host, user, pass);
//            transport.sendMessage(msg, msg.getAllRecipients());
//            transport.close();
//            System.out.println("message send successfully");
//        } catch (Exception ex) {
//
//            throw new RuntimeException(ex);
//        }
//    }
//
//    public void enviarEmailFinalizado(Solicitacao solicitacao) {
//        try {
//
//            Transport transport = mailSession.getTransport("smtp");
//            transport.connect(host, user, pass);
//            transport.sendMessage(msg, msg.getAllRecipients());
//            transport.close();
//            System.out.println("message send successfully");
//        } catch (Exception ex) {
//
//            throw new RuntimeException(ex);
//        }
//    }
}
