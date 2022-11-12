package com.ceep.peliculas.negocio;

import com.ceep.peliculas.excepciones.EscrituraDatosEx;
import com.ceep.peliculas.excepciones.LecturaDatosEx;

public interface ICatalogoPeliculas {
    void agregarPelicula(String nombrePeli, String archivo) throws EscrituraDatosEx;
    void listarPeliculas(String archivo) throws LecturaDatosEx;
    void buscarPelicula(String archivo, String buscar) throws LecturaDatosEx;
    void iniciarArchivo(String archivo);
    void borrarArchivo(String archivo);
}
