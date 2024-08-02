package baseDatos;
import java.io.*;
import java.util.ArrayList;

import gestorAplicacion.adminVuelos.Aerolinea;
import gestorAplicacion.alojamiento.Alojamiento;


//PARA CARGAR ARCHIVOS DESDE TEMP Y VER EL ESTADO DE LOS OBJETOS DEL SISTEMA
public class Deserializador {
    
    //LA CLASE File SE USA PARA EL MANEJO DE ARCHIVOS
    //File.separator SE USA PARA DIVIDIR LA RUTA A UN ARCHIVO ESPECIFICO DADO UN SISTEMA OPERATIVO
    private static File rutaArchivosTemp = new File("src"+File.separator+"baseDatos"+File.separator+"temp");

    //SE DESERIALIZA LA LISTA DE ALOJAMIENTOS Y AEROLINEAS
    public static void deserializar(){

        //CREAMOS UNA LISTA QUE GUARDE LOS .txt QUE ESTAN EN  rutaArchiosTemp
        File[] ficheros = rutaArchivosTemp.listFiles();

        //PARA DESERIALIZAR DECLARAMOS LOS PUNTEROS FileinputStream y ObjectInputStream
        FileInputStream archivo;
        ObjectInputStream guardado;

        //CICLO QUE RECORRE LOS ARCHIVOS DE LA LISTA ficheros
        for (File file : ficheros){

            //VERIFICA SI LA RUTA DEL ARCHIVO CONTIENE LA PALABRA Aerolineas(DE DONDE SACAMOS LAS AEROLINEAS JUNTO CON SU INFO)
            if (file.getAbsolutePath().contains("Aerolineas")){
                try{
                    //LEEMOS EL ARCHIVO Aerolineas.txt DE LA LISTA ficheros
                    archivo = new FileInputStream(file);
                    //SE PROCESAN LOS DATOS EN EL OBJETO archivo Y SE VINCULAN
                    guardado = new ObjectInputStream(archivo);
    
                    //SE LEEN LOS OBJETOS EN EL ORDEN DE ESCRITURA Y SE CASTEA
                    //EL APUNTADOR OBJECT A ArrayList<Aerolinea>
                    //ESTE ArrayList DE AEROLINEAS ES ASIGNADO AL ATRIBUTO DE CLASE DE Aerolinea
                    Aerolinea.setAerolineas((ArrayList<Aerolinea>) guardado.readObject());
    
                }catch(FileNotFoundException e){
                    e.printStackTrace();
                }catch(IOException e){
                    e.printStackTrace();
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
    
                //PARA EXTRAER LA LISTA DE ALOJAMIENTOS Y SU INFO VERIFICAMOS QUE LA RUTA TENGA LA PALABRA Alojamientos
                //DESERIALIZAMOS UNA LISTA DE ALOJAMIENTOS
            }else if (file.getAbsolutePath().contains("Alojamientos")){
                try {
                    archivo = new FileInputStream(file);
                    guardado = new ObjectInputStream(archivo);
                    Alojamiento.setAlojamientos((ArrayList<Alojamiento>) guardado.readObject());

                }catch(FileNotFoundException e){
                    e.printStackTrace();
                }catch(IOException e){
                    e.printStackTrace();
                }catch(ClassNotFoundException e){
                    e.printStackTrace();
                }
            }

        }
    }
}
