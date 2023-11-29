import java.io.*;

public class persistencia {

    public static void crearArchivos() throws IOException {
        File candidatos_dat = new File("candidatos.dat");
        if (!candidatos_dat.exists()) {
            candidatos_dat.createNewFile();
        }
        File votantess_dat = new File("votantes.dat");
        if (!votantess_dat.exists()) {
            votantess_dat.createNewFile();
        }
    }

    public static Boolean verificar_candidatos(){
        File archivo = new File("candidatos.dat");
        System.out.println(archivo.length());
        if (archivo.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static Boolean verificar_votantes(){
        File archivo = new File("votantes.dat");
        System.out.println(archivo.length());
        if (archivo.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void guardarMapCandidatos(map_candidato candidatos, String archivo) throws Exception {

        // Creamos un objeto FileOutputStream para crear el archivo
        FileOutputStream fos = new FileOutputStream(archivo);

        // Creamos un objeto ObjectOutputStream para escribir objetos en el archivo
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // Escribimos los datos nuevos en el archivo
        oos.writeObject(candidatos);

        // Cerramos el flujo de bytes
        oos.close();
    }

    public static map_candidato leerMapCandidatos(String archivo) throws Exception {
        // Creamos un objeto FileInputStream para leer el archivo
        FileInputStream fis = new FileInputStream(archivo);

        // Creamos un objeto ObjectInputStream para leer objetos del archivo
        ObjectInputStream ois = new ObjectInputStream(fis);

        // Leemos el objeto map_candidato del archivo
        map_candidato candidatos = (map_candidato) ois.readObject();

        // Cerramos el flujo de bytes
        ois.close();

        return candidatos;
    }

    public static void guardarMapVotantes(map_votante votantes, String archivo) throws Exception {
        // Creamos un objeto FileOutputStream para crear el archivo
        FileOutputStream fos = new FileOutputStream(archivo);

        // Creamos un objeto ObjectOutputStream para escribir objetos en el archivo
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // Escribimos el objeto map_votantes en el archivo
        oos.writeObject(votantes);

        // Cerramos el flujo de bytes
        oos.close();
    }

    public static map_votante leerMapVotantes(String archivo) throws Exception {
        // Creamos un objeto FileInputStream para leer el archivo
        FileInputStream fis = new FileInputStream(archivo);

        // Creamos un objeto ObjectInputStream para leer objetos del archivo
        ObjectInputStream ois = new ObjectInputStream(fis);

        // Leemos el objeto map_votantes del archivo
        map_votante votantes = (map_votante) ois.readObject();

        // Cerramos el flujo de bytes
        ois.close();

        return votantes;
    }
}