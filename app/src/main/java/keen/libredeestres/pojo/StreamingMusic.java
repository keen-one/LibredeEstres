package keen.libredeestres.pojo;


import androidx.annotation.NonNull;

public final class StreamingMusic {

  private String titulo = "";
  private String uri = "";

  public StreamingMusic(String titulo, String uri) {
    this.titulo = titulo;
    this.uri = uri;
  }

  public final String getTitulo() {
    return titulo;
  }


  public final String getUri() {
    return uri;
  }

  @NonNull
  @Override
  public String toString() {
    return "StreamingMusic{" +
        "titulo='" + titulo + '\'' +
        ", uri='" + uri + '\'' +
        '}';
  }
}
