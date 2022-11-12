package com.ceep.peliculas.main;

import com.ceep.peliculas.excepciones.EscrituraDatosEx;
import com.ceep.peliculas.excepciones.LecturaDatosEx;
import com.ceep.peliculas.negocio.CatalogoPeliculasImpl;
import com.ceep.peliculas.negocio.ICatalogoPeliculas;

import java.util.Scanner;

public class VideoClub {
    public static void main(String[] args) throws EscrituraDatosEx, LecturaDatosEx {
        ICatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (!salir){
            System.out.println("Elige opción: \n" +
                    "1.- Iniciar catalogo de peliculas\n" +
                    "2.- Agregar pelicula\n" +
                    "3.- Listar películas\n" +
                    "4.- Buscar película\n" +
                    "5.- Borrar catalogo\n" +
                    "0.- Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            String nombreArchivo;
            String nombrePeli;
            switch (opcion){
                case 1:
                    System.out.println("Indica el nombre del catalogo");
                    nombreArchivo = scanner.nextLine();
                    catalogoPeliculas.iniciarArchivo(nombreArchivo);
                    break;
                case 2:
                    System.out.println("Introduzca el nombre del catalogo");
                    nombreArchivo = scanner.nextLine();
                    System.out.println("Introduzca el nombre de una película a agregar: ");
                    nombrePeli = scanner.nextLine();
                    catalogoPeliculas.agregarPelicula(nombrePeli, nombreArchivo);
                    break;
                case 3:
                    System.out.println("Introduzca el nombre del catalogo");
                    nombreArchivo = scanner.nextLine();
                    catalogoPeliculas.listarPeliculas(nombreArchivo);
                    break;
                case 4:
                    System.out.println("Introduzca el nombre del catalogo");
                    nombreArchivo = scanner.nextLine();
                    System.out.println("Introduzca el nombre de la película a buscar: ");
                    nombrePeli = scanner.nextLine();
                    catalogoPeliculas.buscarPelicula(nombreArchivo, nombrePeli);
                    break;
                case 5:
                    System.out.println("Introduzca el nombre del catalogo");
                    nombreArchivo = scanner.nextLine();
                    catalogoPeliculas.borrarArchivo(nombreArchivo);
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Elija una opcion correcta");
                    break;
            }
        }
    }
}
