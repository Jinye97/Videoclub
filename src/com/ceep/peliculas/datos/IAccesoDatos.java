package com.ceep.peliculas.datos;

import com.ceep.peliculas.domain.Pelicula;
import com.ceep.peliculas.excepciones.EscrituraDatosEx;
import com.ceep.peliculas.excepciones.LecturaDatosEx;

import java.util.List;

public interface IAccesoDatos {

    boolean existe(String nombre);
    List<Pelicula> listar(String nombre) throws LecturaDatosEx;
    void escribir(Pelicula peli, String archivo, boolean anexar) throws EscrituraDatosEx;
    String buscar(String archivo, String buscar) throws LecturaDatosEx;
    void crear(String archivo);
    void borrar(String archivo);
}
