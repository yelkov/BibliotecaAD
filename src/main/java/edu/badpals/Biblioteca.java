package edu.badpals;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private static String RUTA_LIBROS ="src/main/resources/libros.bin";
    private static String RUTA_REVISTAS ="src/main/resources/revistas.bin";

    private List<Publicacion> libros;
    private List<Publicacion> revistas;
    private List<Publicacion> publicaciones;

    public Biblioteca() {
        this.libros = leerPublicaciones(RUTA_LIBROS);
        this.revistas = leerPublicaciones(RUTA_REVISTAS);
        this.publicaciones = new ArrayList<>();

        publicaciones.addAll(libros);
        publicaciones.addAll(revistas);
    }

    public List<Publicacion> getLibros() {
        return libros;
    }

    public void addLibro(Publicacion libro) {
        if(libro instanceof Libro){
            libros.add(libro);
        }
    }

    public List<Publicacion> getRevistas() {
        return revistas;
    }

    public void addRevista(Publicacion revista) {
        if(revista instanceof Revista){
            revistas.add(revista);
        }
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void addPublicacion(Publicacion publicacion) {
        publicaciones.add(publicacion);
    }

    public void guardarPublicacion(Publicacion publicacion){
        String ruta;
        if(publicacion instanceof Revista){
            ruta = RUTA_REVISTAS;
        } else if (publicacion instanceof Libro) {
            ruta = RUTA_LIBROS;
        }else{
            return;
        }

        List<Publicacion> publicaciones = leerPublicaciones(ruta);
        if(publicaciones.contains(publicacion)) {
            publicaciones.remove(publicacion);
        }

        publicaciones.add(publicacion);

        guardar(publicaciones,ruta);

        }

    public void guardarPublicaciones(){
        for(Publicacion publicacion : this.publicaciones){
            guardarPublicacion(publicacion);
        }
    }

    private void guardar(List<Publicacion> publicaciones, String ruta){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(ruta)))){
            for(Publicacion publicacion : publicaciones){
                oos.writeObject(publicacion);
            }

        }catch (IOException e){
            System.out.println("Error al guardar publicaciones.");
            e.printStackTrace();
        }
    }

    public List<Publicacion> leerPublicaciones(String ruta){
        List<Publicacion> publicaciones = new ArrayList<>();

        File archivo = new File(ruta);
        if(!archivo.exists() || archivo.length() == 0 ){
            return publicaciones;
        }

        try(FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            while(fis.available() > 0){
                Publicacion publicacion = (Publicacion) ois.readObject();
                publicaciones.add(publicacion);
            }

        }catch (IOException e){
            System.out.println("Error al leer publicacion en: " + ruta);
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            System.out.println("Error al leer publicacion en: " + ruta);
            e.printStackTrace();
        }
        return publicaciones;
    }

}
