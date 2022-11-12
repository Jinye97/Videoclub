package com.ceep.peliculas.datos;

import com.ceep.peliculas.domain.Pelicula;
import com.ceep.peliculas.excepciones.EscrituraDatosEx;
import com.ceep.peliculas.excepciones.LecturaDatosEx;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatosImpl implements IAccesoDatos{
    @Override
    public boolean existe(String nombre) {
        File file = new File(nombre);
        return file.exists();
    }

    @Override
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx {
        File file = new File(nombre);
        List<Pelicula> peliculas = new ArrayList<>();
        String linea;
        try (BufferedReader bf = new BufferedReader(new FileReader(file))){
            while((linea = bf.readLine()) != null){
                peliculas.add(new Pelicula(linea));
            }
        } catch (IOException e){
            throw new LecturaDatosEx();
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula peli, String archivo, boolean anexar) throws EscrituraDatosEx {
        File file = new File(archivo);
        try (FileWriter fileWriter = new FileWriter(file, anexar)){
            fileWriter.write(peli.getNombre() + "\n");
            System.out.println("Película añadida");
        } catch (IOException e){
            throw new EscrituraDatosEx();
        }
    }

    @Override
    public String buscar(String archivo, String buscar) throws LecturaDatosEx{
        File file = new File(archivo);
        String linea = null;
        try (BufferedReader bf = new BufferedReader(new FileReader(file))){
            while((linea = bf.readLine()) != null){
                if (linea.equalsIgnoreCase(buscar)){
                    break;
                }
            }
        } catch (IOException e){
            throw new LecturaDatosEx();
        }
        if (linea != null){
            return linea;
        }else{
            return "No se ha encontrado la película";
        }
    }

    @Override
    public void crear(String archivo) {
        File file = new File(archivo);
        try {
            if (file.createNewFile()){
                System.out.println("Se ha creado el archivo");
            }else{
                System.out.println("Ya existe un archivo con ese nombre");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void borrar(String archivo) {
        File file = new File(archivo);
        if (file.delete()){
            System.out.println("Se ha borrado el archivo");
        }else{
            System.out.println("No se ha encontrado el archivo");
        }
    }
}
