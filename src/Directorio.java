import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("ALL")
public class Directorio implements Observer {
    ArrayList<String> nombres = new ArrayList<>();
    ArrayList<String> nombre_rutas = new ArrayList<>();
    Line pull;
    String palabra;

    public Directorio(Line pull, String p ) {
        palabra = p;
        this.pull = pull;
    }

    @Override
    public void update(Observable o, Object arg) {
        File file = new File(arg.toString());
        String files;
        File[] listOfFiles = file.listFiles();
        if (file.isFile()) {
            files = file.getName();
            if (files.toLowerCase().contains(palabra)){
                nombres.add(files);
                nombre_rutas.add(file.getPath());
            }


        }else{
            for (File f : listOfFiles){
                pull.insert(f.toString());
            }
        }


    }

    @Override
    public String toString(){
        String temp = "";
        int mayor  = 0;
        for (String g: nombres){
            if (g.length() > mayor)
                mayor = g.length();
        }

        String n_nombre = "";
        ArrayList<String> lista_nombres = new ArrayList<>();
        for (String g: nombres){
            n_nombre = g;
            for(int i=0; i < (mayor-g.length()); i++){
                n_nombre += " ";
            }
            lista_nombres.add(n_nombre);
        }
        for(int i=0; i < lista_nombres.size(); i++){
            temp += lista_nombres.get(i)+"\t"+nombre_rutas.get(i)+"\n";
        }

        return temp;
    }
}
