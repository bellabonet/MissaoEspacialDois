package org.example;

public class Foguete {
    private String nome;
    private double combustivelRestante;
    private float cargaMaxima;
    private String status;
    private Satelite sateliteCarregado; // CamelCase para seguir o padrão Java

    public Foguete(){

    }

    public Foguete(String nome, double combustivelInicial, float cargaMaxima) {
        this.nome = nome;
        this.combustivelRestante = combustivelInicial;
        this.cargaMaxima = cargaMaxima;
        this.status = "Pronto";
        this.sateliteCarregado = null;
    }

    public void abastecer(double quantidade) {
        if (quantidade > 0) {
            this.combustivelRestante += quantidade;
            System.out.printf("%s abastecido. Combustível atual: %.1f t%n", nome, combustivelRestante);
        }
    }

    public boolean lancar() {
        if (combustivelRestante < 50) {
            System.out.printf("Falha no lançamento de %s: Combustível insuficiente!%n", nome);
            status = "Falha";
            return false;
        }
        if (sateliteCarregado == null) {
            System.out.printf("Falha: %s não tem satélite carregado!%n", nome);
            return false;
        }

        combustivelRestante -= 60;
        status = "Em orbita";

        sateliteCarregado.setStatus("Em orbita");

        System.out.printf("Lançamento bem sucedido! %s levou %s à órbita.%n", nome, sateliteCarregado.getNome());
        return true;
    }

    public void relatorio() {
        String nomeSatelite = (sateliteCarregado != null) ? sateliteCarregado.getNome() : "Nenhum";
        System.out.printf("Foguete: %s | Combustível: %.1f t | Status: %s | Carga Máx: %.0f kg | Satélite: %s%n",
                nome, combustivelRestante, status, cargaMaxima, nomeSatelite);
    }

    public void setSatelitecarregado(Satelite satelite) {
        this.sateliteCarregado = satelite;
    }
    public Satelite getSateliteCarregado() {
        return sateliteCarregado;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public void setcargaMaxima(float cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }
    public float getCargaMaxima() {
        return cargaMaxima;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setCombustivelRestante(float combustivelRestante) {
        this.combustivelRestante = combustivelRestante;
    }
    public float getCombustivelRestante() {
        return (float) combustivelRestante;
    }

    @Override
    public String toString() {
        return "Foguete{" +
                "nome='" + nome + '\'' +
                ", combustivelRestante=" + combustivelRestante + "t" +
                ", cargaMaxima=" + cargaMaxima + "kg" +
                ", status='" + status + '\'' +
                ", sateliteCarregado=" + (sateliteCarregado != null ? sateliteCarregado.getNome() : "vazio") +
                '}';
    }}