public class Libro {
    private int isbn;
    private String titulo;
    private String autor;
    private String categoria;
    private int anioPublicacion;

    public Libro(int isbn, String titulo, String autor, String categoria, int anioPublicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.anioPublicacion = anioPublicacion;

    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public String toString() {
        return "Libro" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", categoria='" + categoria + '\'' +
                ", anioPublicacion=" + anioPublicacion;

    }
}
