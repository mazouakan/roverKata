package org.example.data;

public class RoverData {

    private String Initialposition;
    private String commandes;

    public RoverData(String initialposition, String commandes) {
        Initialposition = initialposition;
        this.commandes = commandes;
    }

    public String getInitialposition() {
        return Initialposition;
    }

    public String getCommandes() {
        return commandes;
    }

    @Override
    public String toString() {
        return "RoverData{" +
                "Initialposition='" + Initialposition + '\'' +
                ", commandes='" + commandes + '\'' +
                '}';
    }
}
