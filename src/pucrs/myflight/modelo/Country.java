package pucrs.myflight.modelo;

public class Country implements Comparable<Country> {
    private String cod;
    private String name;

    public Country(String cod) {
        this.cod = cod;
    }

    public Country(String cod, String name) {
        this.cod = cod;
        this.name = name;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "cod='" + cod + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Country outro) {
        return this.name.compareTo(outro.name);
    }
}
