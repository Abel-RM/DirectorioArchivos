import javax.swing.*;
import java.io.File;

public class Main {
    static Line rutas = new Line();

    public static void main(String[] args) {
        System.out.println("Escribe la palabra a buscar:");
        String palabra= Keyboard.readString();
        String rutaInicial = escogerArchivo("Escoge la ruta");
        buscarArchivos(rutaInicial, palabra);

        for (String linea: rutas.getAll()){
            System.out.println(linea);
        }
    }
    private static void buscarArchivos(String path, String palabra){

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        Line pull = new Line();
        Directorio directorio = new Directorio(pull, palabra);

        pull.addObserver(directorio);
        if (listOfFiles != null)
            for (File f : listOfFiles){
                pull.insert(f.toString());
            }

        System.out.println(directorio);

    }

    private static String escogerArchivo(String titulo){
        String ruta = null;
        int opc = 1;
        do{
            try {
                JFileChooser fileChooser = new JFileChooser("C:\\Users\\abely\\Desktop\\Maestria\\semestre 2\\Arquitectura\\Proyectos\\Proyecto-Archivo\\src");
                fileChooser.setDialogTitle(titulo);
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.showOpenDialog(null);
                ruta = fileChooser.getSelectedFile().getAbsolutePath();
                opc = 1;
            }catch (Exception e){
                opc = JOptionPane.showConfirmDialog(null, "¿quieres terminar el programa?", "Salir", JOptionPane.OK_CANCEL_OPTION);
            }

        }while(opc == 2);

        return ruta;
    }
}


/*
for (File listOfFile : listOfFiles) {

            if (listOfFile.isFile()) {
                files = listOfFile.getName();
                if (files.toLowerCase().contains(palabra))
                    rutas.insert(files+"\t\t\t\t\t\t\t\t\t\t\t\t\t"+listOfFile.getPath());

            }else
                buscarArchivos(listOfFile.getPath(), palabra);
        }
*/