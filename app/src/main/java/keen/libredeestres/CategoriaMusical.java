package keen.libredeestres;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import keen.libredeestres.MyRVCategoriaMusical.ItemListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriaMusical extends Fragment {

  public static final String TAG = CategoriaMusical.class.getSimpleName();

  public CategoriaMusical() {
    // Required empty public constructor
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    if (item.getItemId() == android.R.id.home) {
      FragmentManager manager = getFragmentManager();
      if (manager != null) {
        manager.popBackStack();
      }
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
    AppCompatActivity activity = (AppCompatActivity) getActivity();
    if (activity != null) {
      ActionBar bar = activity.getSupportActionBar();
      if (bar != null) {
        bar.setDisplayHomeAsUpEnabled(true);
      }

    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_categoria_musical, container, false);
    TextView tvMessage = view.findViewById(R.id.message_categoria_musical);
    tvMessage.setText(getResources().getString(R.string.title_categoria_musical));
    RecyclerView rv = view.findViewById(R.id.rv_categoria_musical);
    List<keen.libredeestres.pojo.CategoriaMusical> lista = new ArrayList<>();
    keen.libredeestres.pojo.CategoriaMusical categoria1 = new keen.libredeestres.pojo.CategoriaMusical();
    keen.libredeestres.pojo.CategoriaMusical categoria2 = new keen.libredeestres.pojo.CategoriaMusical();
    keen.libredeestres.pojo.CategoriaMusical categoria3 = new keen.libredeestres.pojo.CategoriaMusical();
    categoria1.setTitulo(getResources().getString(R.string.categoria_musical1));
    categoria1.setImagen(R.drawable.ic_musica_clasica_genero);
    categoria2.setTitulo(getResources().getString(R.string.categoria_musical2));
    categoria2.setImagen(R.drawable.ic_jazz_genero);
    categoria3.setTitulo(getResources().getString(R.string.categoria_musical3));
    categoria3.setImagen(R.drawable.ic_rock_genero);

    lista.add(categoria1);
    lista.add(categoria2);
    lista.add(categoria3);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

    if (lista.size() > 0) {
      Collections.sort(lista, new Comparator<keen.libredeestres.pojo.CategoriaMusical>() {
        @Override
        public int compare(keen.libredeestres.pojo.CategoriaMusical o1,
            keen.libredeestres.pojo.CategoriaMusical o2) {
          return o1.getTitulo().compareTo(o2.getTitulo());
        }
      });
    }

    MyRVCategoriaMusical adapter = new MyRVCategoriaMusical(lista, new ItemListener() {
      @Override
      public void onItemClick(keen.libredeestres.pojo.CategoriaMusical item) {
        String genero = "CLASICA";
        Bundle bundle = new Bundle();
        if (item.getImagen() == R.drawable.ic_jazz_genero) {
          genero = "JAZZ";
        } else if (item.getImagen() == R.drawable.ic_musica_clasica_genero) {
          genero = "CLASICA";
        } else if (item.getImagen() == R.drawable.ic_rock_genero) {
          genero = "ROCK";
        }
        bundle.putString(MainActivity.GENERO_SELECTED, genero);
        ListStreaming listStreaming = new ListStreaming();
        listStreaming.setArguments(bundle);
        FragmentManager manager = getFragmentManager();
        if (manager != null) {
          manager.beginTransaction()
              .replace(R.id.container_fragment, listStreaming, ListStreaming.TAG)
              .addToBackStack(CategoriaMusical.TAG).commit();
        }

      }
    });
    rv.setAdapter(adapter);
    rv.setLayoutManager(linearLayoutManager);
    rv.setHasFixedSize(true);

    return view;
  }

}
