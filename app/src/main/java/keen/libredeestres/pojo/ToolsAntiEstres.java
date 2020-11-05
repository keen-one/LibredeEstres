package keen.libredeestres.pojo;


import androidx.annotation.NonNull;

public final class ToolsAntiEstres {

  private String titulo = "";
  private int imagen = 0;

  public final String getTitulo() {
    return titulo;
  }

  public final void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public final int getImagen() {
    return imagen;
  }

  public final void setImagen(int imagen) {
    this.imagen = imagen;
  }

  @NonNull
  @Override
  public String toString() {
    return "ToolsAntiEstres{" +
        "titulo='" + titulo + '\'' +
        ", imagen=" + imagen +
        '}';
  }
}
