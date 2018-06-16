package pucrs.myflight.modelo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GerenciadorAeroportos {

    private ArrayList<Aeroporto> aeroportos;

    public GerenciadorAeroportos() {
        this.aeroportos = new ArrayList<>();
    }

    public void carregaDados(String nomeArq) throws IOException {
        Path path = Paths.get(nomeArq);
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.forName("utf8")))) {
            sc.useDelimiter("[;\n]"); // separadores: ; e nova linha
            String header = sc.nextLine(); // pula cabeçalho
            String cod, nome, countryCod;
            Geo loc;
            while (sc.hasNext()) {
                cod = sc.next();

                double latitude = sc.nextDouble();
                double longitude = sc.nextDouble();
                loc = new Geo(latitude, longitude);

                nome = sc.next();
                countryCod = sc.next();

                Aeroporto nova = new Aeroporto(cod, nome, loc, countryCod);
                adicionar(nova);
            }
        }
    }

    public void ordenarNomes() {
        Collections.sort(aeroportos);
    }

    public void adicionar(Aeroporto aero) {
        aeroportos.add(aero);
    }

    public ArrayList<Aeroporto> listarTodos() {
        return new ArrayList<>(aeroportos);
    }

    public Aeroporto buscarCodigo(String codigo) {
        for(Aeroporto a: aeroportos)
            if(a.getCodigo().equals(codigo))
                return a;
        return null;
    }
}
