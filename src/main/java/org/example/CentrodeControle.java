package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CentrodeControle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<Foguete> foguetes = new ArrayList<>();
        List<Satelite> satelites = new ArrayList<>();

        System.out.println("Sistema de Cadastro Aeroespacial ");

        System.out.print("Quantos foguetes deseja registrar: ");
        int quantFoguetes = scanner.nextInt();

        for (int i = 0; i < quantFoguetes; i++) {
            System.out.println("\nDados do Foguete " + (i + 1) + ":");
            System.out.print("Nome: ");
            String nome = scanner.next();
            System.out.print("Combustível Inicial (t): ");
            double combustivel = scanner.nextDouble();
            System.out.print("Carga Máxima (kg): ");
            float carga = scanner.nextFloat();

            foguetes.add(new Foguete(nome, combustivel, carga));
        }

        Satelite sat1 = new Satelite("Starlink-V2", 500, "Baixa");
        satelites.add(sat1);

        if (!foguetes.isEmpty()) {
            System.out.println("\nIniciando Missão de Teste");
            Foguete f = foguetes.get(0);
            f.setSatelitecarregado(sat1);
            f.lancar();
        }


        try {
            File arquivo = new File("missao_espacial.json");

            mapper.writeValue(arquivo, foguetes);
            System.out.println("\nArquivo 'missao_espacial.json' criado com sucesso!");

            Foguete[] foguetesLidos = mapper.readValue(arquivo, Foguete[].class);

            System.out.println("\nDados Lidos do JSON");
            for (Foguete f : foguetesLidos) {
                System.out.println(f);
            }

        } catch (IOException e) {
            System.out.println("[ERRO] Falha ao manipular JSON: " + e.getMessage());
            e.printStackTrace();
        }

        scanner.close();
    }

    public void adicionarFoguete(Foguete atlas) {
    }

    public void adicionarSatelite(Satelite sentinel) {
    }

    public void statusMissao() {
    }

    public void iniciarMissao(String falconCascavel, String s) {
    }
}