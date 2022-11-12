package com.ceep.peliculas.negocio;

import com.ceep.peliculas.datos.AccesoDatosImpl;
import com.ceep.peliculas.datos.IAccesoDatos;
import com.ceep.peliculas.domain.Pelicula;
import com.ceep.peliculas.excepciones.EscrituraDatosEx;
import com.ceep.peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas{
    private final IAccesoDatos accesoDatos = new AccesoDatosImpl();
    @Override
    public void agregarPelicula(String nombrePeli, String archivo) throws EscrituraDatosEx {
        if (accesoDatos.existe(archivo)){
            accesoDatos.escribir(new Pelicula(nombrePeli),archivo,true);
        }else {
            System.out.println("El catalogo introducido no existe");
        }
    }

    @Override
    public void listarPeliculas(String archivo) throws LecturaDatosEx {
        if (accesoDatos.existe(archivo)){
            for(Pelicula p: accesoDatos.listar(archivo)){
                System.out.println(p.getNombre());
            }
        }else {
            System.out.println("El catalogo introducido no existe");
        }
    }

    @Override
    public void buscarPelicula(String archivo, String buscar) throws LecturaDatosEx {
        if (accesoDatos.existe(archivo)){
            System.out.println(accesoDatos.buscar(archivo, buscar));
        }else {
            System.out.println("El catalogo introducido no existe");
        }
    }

    @Override
    public void iniciarArchivo(String archivo) {
        accesoDatos.crear(archivo);
    }

    @Override
    public void borrarArchivo(String archivo) {
        accesoDatos.borrar(archivo);
    }
}
