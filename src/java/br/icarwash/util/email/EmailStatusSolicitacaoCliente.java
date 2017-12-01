package br.icarwash.util.email;

import br.icarwash.model.Solicitacao;

public class EmailStatusSolicitacaoCliente extends Email {

    private final Solicitacao solicitacao;

    public EmailStatusSolicitacaoCliente(Solicitacao solicitacao) {
        super(solicitacao.getCliente().getNome(),
                solicitacao.getCliente().getUsuario().getEmail());
        this.solicitacao = solicitacao;
        super.setAssunto(defineAssunto(solicitacao.getEstado().toString()));
        super.setMensagem(defineMensagem(solicitacao.getEstado().toString()));
    }

    private String defineAssunto(String status) {
        String assunto = "";
        switch (status) {
            case "Em Analise":
                assunto = "Solicitação Em Análise!";
                break;
            case "Agendado":
                assunto = "Solicitação Agendada!";
                break;
            case "Em Processo":
                assunto = "Solicitação já está em processo!";
                break;
            case "Finalizado":
                assunto = "Solicitação foi finalizada com sucesso!";
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
            case "Em Analise":
                mensagem = "Olá " + solicitacao.getCliente().getNome() + ",\n\n"
                        + "Sua solicitação #" + solicitacao.getId() + " está em análise.\n\n"
                        + "Aguarde a próxima notificação refernte a sua solictitação!\n\n"
                        + "Data: " + solicitacao.getDataSolicitacao().getTime() + ",\n"
                        + "Endereco: " + solicitacao.getEndereco().getEndereco() + " nº " + solicitacao.getEndereco().getNumero() + ",\n"
                        + "Valor: " + solicitacao.getValorTotal();
                break;
            case "Agendado":
                mensagem = "Olá " + solicitacao.getCliente().getNome() + ",\n\n"
                        + "Sua solicitação #" + solicitacao.getId() + " foi agendada com sucesso.\n\n"
                        + "Fique esperto com a data do seu serviço!\n\n"
                        + "Data: " + solicitacao.getDataSolicitacao().getTime() + ",\n"
                        + "Lavador: " + solicitacao.getLavador().getNome() + ",\n"
                        + "Endereco: " + solicitacao.getEndereco().getEndereco() + " nº " + solicitacao.getEndereco().getNumero() + ",\n"
                        + "Valor: " + solicitacao.getValorTotal();
                break;
            case "Em Processo":
                mensagem = "Olá " + solicitacao.getCliente().getNome() + ",\n\n"
                        + "Sua solicitação #" + solicitacao.getId() + " já está em processo.\n\n"
                        + "Aguarde o término do serviço para nos dizer o que achou do serviço do Lavador " + solicitacao.getLavador().getNome()
                        + "Valor: " + solicitacao.getValorTotal();
                break;
            case "Finalizado":
                mensagem = "Olá " + solicitacao.getCliente().getNome() + ",\n\n"
                        + "Parabéns, sua solicitação #" + solicitacao.getId() + " foi finalizada com sucesso!\n\n"
                        + "Aguardamos sua avaliação do serviço para que possamos sempre melhorar nosso atendimento! \n";
                break;
            case "Avaliado":
                mensagem = "Olá " + solicitacao.getCliente().getNome() + ",\n\n"
                        + "Muito obrigado por avaliar a solicitação #" + solicitacao.getId() + "!\n\n"
                        + "Para nós essas informações são muito importantes, esperamos você na próxima solicitação! \n";
                break;
            case "Concluido":
                mensagem = "Olá " + solicitacao.getCliente().getNome() + ",\n\n"
                        + "A Solicitação #" + solicitacao.getId() + " foi concluído com sucesso!\n\n";
                break;
            case "Cancelado":
                mensagem = "Olá " + solicitacao.getCliente().getNome() + ",\n\n"
                        + "Sua solicitação #" + solicitacao.getId() + " foi cancelada.\n\n"
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
