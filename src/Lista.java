import java.util.ArrayList;
import java.util.List;

public class Lista {
    List<Libro>biblioteca;

    public Lista() {
        biblioteca=new ArrayList<>();
    }
    public void agregar (Libro dato) throws Exception {
        int tam= biblioteca.size();
        if (tam==0) {
            biblioteca.add(dato);
        }else{
            if(dato.getIsbn()>biblioteca.get(tam-1).getIsbn()){
                biblioteca.add(dato);
            }
            throw  new Exception("ISBN no ordenado");
        }
    }
    public ArrayList<Libro> buscar(String texto){
        ArrayList<Libro> resultado=new ArrayList<>();

        for(Libro aux:biblioteca){
            if(aux.getTitulo().contains(texto)){
                resultado.add(aux);
            }
        }
        return resultado;
    }

    public int binario(int isbn){
        int tam=biblioteca.size()-1;
        if(isbn<biblioteca.get(0).getIsbn()||
                isbn>biblioteca.get(tam).getIsbn()){
            return -1;
        }
        int i=0;
        int s=tam;
        int c;
        while (i<=s){
            c=(i+s)/2;
            int valor=biblioteca.get(c).getIsbn();
            if(isbn==valor){
                return c;
            } else if (isbn>valor) {
                i=c+1;
            }else{
                s=c-1;
            }
        }
        return -1;
    }

}
