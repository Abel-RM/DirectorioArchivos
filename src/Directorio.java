import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("ALL")
public class Directorio implements Observer {
    ArrayList<String> _final = new ArrayList<>();
    Line pull;
    String palabra;

    public Directorio(Line pull, String p ) {
        this._final = _final;
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
            if (files.toLowerCase().contains(palabra))
                _final.add(files+"\t\t\t\t\t\t\t\t\t\t\t\t\t"+file.getPath());

        }else{
            for (File f : listOfFiles){
                pull.insert(f.toString());
            }
        }


    }

    @Override
    public String toString() {
        String temp = "";
        for (String g: _final){
            temp += g+"\n";
        }

        return temp;
    }
}
