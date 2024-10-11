package edu.badpals;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Prestable mitosGriegos = new Libro("978-0-14-044913-6","Mitos Griegos","2005");
        mitosGriegos.presta();
        Prestable cuantica = new Libro("978-0-201-03801-0","Física Cuántica: Una Introducción","2019");
        Prestable viaje = new Libro("978-0-7432-7356-5","Viaje al Centro de la Tierra","1989");
        viaje.presta();

        biblioteca.addLibro((Publicacion) mitosGriegos).addLibro((Publicacion) cuantica).addLibro((Publicacion) viaje);
        biblioteca.guardarPublicaciones();

        /*List<Publicacion> publicaciones = biblioteca.getPublicaciones();
        System.out.println(publicaciones.toString());*/

        Publicacion revistaTecnologia = new Revista("978-3-16-148410-0","Revista de Tecnología y Ciencia","2023","52");
        Publicacion revistaArqueologia = new Revista("978-3-16-148411-7", "Arqueología y Culturas Antiguas","2022","28");
        Publicacion revistaPsicologia = new Revista("978-3-16-148412-4", "Psicología Hoy","2021","15");

        biblioteca.addPublicacion(revistaTecnologia).addPublicacion(revistaArqueologia).addRevista(revistaPsicologia);
        biblioteca.guardarPublicaciones();
        System.out.println(biblioteca.getPublicaciones().toString());

    }
}
