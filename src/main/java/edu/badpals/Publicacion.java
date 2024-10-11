package edu.badpals;

import java.io.Serializable;

public class Publicacion implements Serializable {
    private static final long serialVersionUID = 1L;
    private String ISBN;
    private String titulo;
    private String anoPublicacion;

    public Publicacion() {
    }

    public Publicacion(String ISBN, String titulo, String anoPublicacion) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.anoPublicacion = anoPublicacion;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(String anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Publicación:\n")
                .append("\tISBN: ").append(getISBN()).append("\n")
                .append("\ttítulo: ").append(getTitulo()).append("\n")
                .append("\taño: ").append(getAnoPublicacion()).append("\n");
        return sb.toString();
    }
}
