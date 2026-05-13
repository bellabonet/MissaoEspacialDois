package org.example;
public class MissaoEspacial {
    public MissaoEspacial() {}
    public static void main(String[] args) {

            MissaoEspacial missao = new MissaoEspacial();
            CentrodeControle controle = new CentrodeControle();

            //criando foguetes
            Foguete falcon = new Foguete("Falcon Cascavel", 80.0, 20000);
            Foguete atlas = new Foguete("Atlas-PR", 120.0, 150000);

            //criando satelites
            Satelite sentinel = new Satelite("Satelite-1", 850, "LEO");
            Satelite comms = new Satelite("Comms-BR", 1200, "GEO");
            Satelite lunar = new Satelite("Lunar_Probe", 450, "Orbita Lunar");

            //adicionado ao centro de controle
            controle.adicionarFoguete(falcon);
            controle.adicionarFoguete(atlas);
            controle.adicionarSatelite(sentinel);
            controle.adicionarSatelite(comms);
            controle.adicionarSatelite(lunar);

            //status inicial
            controle.statusMissao();

            System.out.println();

            falcon.abastecer(50);
            controle.iniciarMissao("Falcon Cascavel", "Satelite-1");

            sentinel.ativarPaineis();
            sentinel.enviarDados("Dados de temperatura da Amazonia: 28.5 C ");

            controle.statusMissao();
        }
    }
