package org.example;

public class Satelite {
    private String nome;
    private float massa;
    private String orbitaAlvo;
    private float energia;
    private String status;

        public Satelite(){

    }

    public Satelite(String nome, float massa, String orbitaAlvo) {
        this.nome = nome;
        this.massa = massa;
        this.orbitaAlvo = orbitaAlvo;
        this.status = "Em solo";
        this.energia = 100.0f;
    }

    public void ativarPaineis() {
        energia = Math.min(100.0f, energia + 25);
        System.out.printf("Painéis Solares de %s ativados. Energia: %.1f%%%n", nome, energia);
    }

    public void enviarDados(String mensagem) {
        if (!status.equals("Em orbita") || energia < 10) {
            System.out.printf("%s não pode enviar dados (status: %s, energia: %.1f%%)%n", nome, status, energia);
            return;
        }
        System.out.printf("[%s] Enviando dados: %s%n", nome, mensagem);
    }

    public void relatorio() {
        System.out.printf("Satélite %s | Massa: %.0f kg | Órbita: %s | Energia: %.1f%% | Status: %s%n",
                nome, massa, orbitaAlvo, energia, status);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setMassa(float massa) {
        this.massa = massa;
    }
    public float getMassa() {
        return massa;
    }
    public void setOrbitaAlvo(String orbitaAlvo) {
        this.orbitaAlvo = orbitaAlvo;
    }
    public String getOrbitaAlvo() {
        return orbitaAlvo;
    }
    public void setEnergia(float energia) {
        this.energia = energia;
    }
    public float getEnergia() {
        return energia;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Satelite{" +
                "nome='" + nome + '\'' +
                ", massa=" + massa + "kg" +
                ", orbitaAlvo='" + orbitaAlvo + '\'' +
                ", energia=" + energia + "%" +
                ", status='" + status + '\'' +
                '}';
    }
}