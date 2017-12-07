package br.icarwash.model;

import java.math.BigDecimal;

public class Avaliacao {

    private int id;
    private BigDecimal notaPontualidade;
    private BigDecimal notaServico;
    private BigDecimal notaAtendimento;
    private BigDecimal notaAgilidade;
    private BigDecimal notaMedia;

    public Avaliacao() {
    }

    public Avaliacao(AvaliacaoBuilder builder) {
        this.id = builder.id;
        this.notaPontualidade = builder.notaPontualidade;
        this.notaServico = builder.notaServico;
        this.notaAtendimento = builder.notaAtendimento;
        this.notaAgilidade = builder.notaAgilidade;
        this.notaMedia = builder.notaMedia;
    }

    public static class AvaliacaoBuilder {

        private int id;
        private BigDecimal notaPontualidade;
        private BigDecimal notaServico;
        private BigDecimal notaAtendimento;
        private BigDecimal notaAgilidade;
        private BigDecimal notaMedia;

        public AvaliacaoBuilder from(Avaliacao avaliacao) {
            this.id = avaliacao.id;
            this.notaPontualidade = avaliacao.notaPontualidade;
            this.notaServico = avaliacao.notaServico;
            this.notaAtendimento = avaliacao.notaAtendimento;
            this.notaAgilidade = avaliacao.notaAgilidade;
            this.notaMedia = avaliacao.notaMedia;

            return this;
        }

        public AvaliacaoBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public AvaliacaoBuilder withNotaPontualidade(BigDecimal notaPontualidade) {
            this.notaPontualidade = notaPontualidade;
            return this;
        }

        public AvaliacaoBuilder withNotaServico(BigDecimal notaServico) {
            this.notaServico = notaServico;
            return this;
        }

        public AvaliacaoBuilder withNotaAtendimento(BigDecimal notaAtendimento) {
            this.notaAtendimento = notaAtendimento;
            return this;
        }

        public AvaliacaoBuilder withNotaAgilidade(BigDecimal notaAgilidade) {
            this.notaAgilidade = notaAgilidade;
            return this;
        }

        public AvaliacaoBuilder withNotaMedia(BigDecimal notaMedia) {
            this.notaMedia = notaMedia;
            return this;
        }

        public Avaliacao build() {
            return new Avaliacao(this);
        }

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getNotaPontualidade() {
        return notaPontualidade;
    }

    public BigDecimal getNotaServico() {
        return notaServico;
    }

    public BigDecimal getNotaAtendimento() {
        return notaAtendimento;
    }

    public BigDecimal getNotaAgilidade() {
        return notaAgilidade;
    }

    public BigDecimal getNotaMedia() {
        return notaMedia;
    }

    public void calcularMedia() {
        notaMedia = notaPontualidade.add(notaServico.add(notaAtendimento.add(notaAgilidade)));
        this.notaMedia = this.notaMedia.divide(BigDecimal.valueOf(4));
    }

}
