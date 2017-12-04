package br.icarwash.util.email;

import br.icarwash.model.Solicitacao;

public class EmailStatusSolicitacaoLavador extends Email {

    private final Solicitacao solicitacao;

    public EmailStatusSolicitacaoLavador(Solicitacao solicitacao) {
        super(solicitacao.getLavador().getNome(),
                solicitacao.getLavador().getUsuario().getEmail());
        this.solicitacao = solicitacao;
        super.setAssunto(defineAssunto(solicitacao.getEstado().toString()));
        super.setMensagem(defineMensagem(solicitacao.getEstado().toString()));
    }

    private String defineAssunto(String status) {
        String assunto = "";
        switch (status) {
            case "Agendado":
                assunto = "Nova Solicitação Agendada!";
                break;
            case "Finalizado":
                assunto = "Solicitação #" + solicitacao.getId() + " finalizada!";
                break;
            case "Avaliado":
                assunto = "Solicitação Avaliada!";
                break;
            case "Concluido":
                assunto = "Solicitação Concluído!";
                break;
            case "Cancelado":
                assunto = "Solicitação Cancelada!!";
                break;
            default:
                throw new UnsupportedOperationException("Solicitação sem Status");
        }
        return assunto;
    }

    private String defineMensagem(String status) {
        String mensagem = "";
        switch (status) {
            case "Agendado":
                mensagem = "Olá " + solicitacao.getLavador().getNome() + ",\n\n"
                        + "Foi Atribuido uma solicitação á você, #" + solicitacao.getId() + ".\n\n"
                        + "Fique esperto com a data do seu serviço!\n\n"
                        + "Data: " + solicitacao.getDataSolicitacao().getTime() + ",\n"
                        + "Lavador: " + solicitacao.getLavador().getNome() + ",\n"
                        + "Endereco: " + solicitacao.getEndereco().getEndereco() + " nº " + solicitacao.getEndereco().getNumero() + ",\n"
                        + "Valor: " + solicitacao.getValorTotal();
                break;
            case "Finalizado":
                mensagem = "Olá " + solicitacao.getLavador().getNome() + ",\n\n"
                        + "Parabéns, pelo ótimo trabalho #" + solicitacao.getId() + " foi finalizada com sucesso!\n\n";
                break;
            case "Avaliado":
                mensagem = "Olá " + solicitacao.getLavador().getNome() + ",\n\n"
                        + "Sua Solicitação #" + solicitacao.getId() + ", foi avaliada!\n\n"
                        + "Sua média foi de: " + solicitacao.getAvaliacao().getNotaMedia();
                break;
            case "Concluido":
                mensagem = "Olá " + solicitacao.getLavador().getNome() + ",\n\n"
                        + "A Solicitação #" + solicitacao.getId() + " foi concluído com sucesso!\n\n";
                break;
            case "Cancelado":
                mensagem = "Olá " + solicitacao.getLavador().getNome() + ",\n\n"
                        + "A Solicitação #" + solicitacao.getId() + " foi cancelada.\n\n"
                        + "Data: " + solicitacao.getDataSolicitacao().getTime() + ",\n"
                        + "Endereco: " + solicitacao.getEndereco().getEndereco()
                        + " nº " + solicitacao.getEndereco().getNumero() + ",\n"
                        + "Valor: " + solicitacao.getValorTotal();
                break;
            default:
                throw new UnsupportedOperationException("Solicitação sem Status");
        }
        return mensagem;
    }

}
