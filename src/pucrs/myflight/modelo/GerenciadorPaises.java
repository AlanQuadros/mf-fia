package pucrs.myflight.modelo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GerenciadorPaises {
    private ArrayList<Country> countries;

    public GerenciadorPaises() {
        this.countries = new ArrayList<>();
    }

    public void carregaDados(String nomeArq) throws IOException {
        Path path = Paths.get(nomeArq);
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.forName("utf8")))) {
            sc.useDelimiter("[;\n]"); // separadores: ; e nova linha
            String header = sc.nextLine(); // pula cabeçalho
            String cod, nome;
            while (sc.hasNext()) {
                cod = sc.next();
                nome = sc.next();
                Country nova = new Country(cod, nome);
                adicionar(nova);
            }
        }
    }

    public void ordenarNomes() {
        Collections.sort(countries);
    }

    public void adicionar(Country country) {
        countries.add(country);
    }

    public ArrayList<Country> listarTodos() {
        return new ArrayList<>(countries);
    }

    public Country buscarCodigo(String codigo) {
        for(Country a: countries)
            if(a.getCod().equals(codigo))
                return a;
        return null;
    }
}
