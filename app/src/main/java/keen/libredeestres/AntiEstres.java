package keen.libredeestres;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AntiEstres extends Fragment {


  public AntiEstres() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AppCompatActivity activity = (AppCompatActivity) getActivity();
    if (activity != null) {
      ActionBar bar = activity.getSupportActionBar();
      if (bar != null) {
        bar.setDisplayHomeAsUpEnabled(false);
      }

    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_anti_estres, container, false);
    TextView tvMessage = view.findViewById(R.id.message_anti_estres);
    tvMessage.setText(getResources().getString(R.string.title_habitos_anti_estres));
    RecyclerView rv = view.findViewById(R.id.rv_factor_anti_estres);
    List<keen.libredeestres.pojo.AntiEstres> lista = new ArrayList<>();
    keen.libredeestres.pojo.AntiEstres antiEstres1 = new keen.libredeestres.pojo.AntiEstres();
    keen.libredeestres.pojo.AntiEstres antiEstres2 = new keen.libredeestres.pojo.AntiEstres();
    keen.libredeestres.pojo.AntiEstres antiEstres3 = new keen.libredeestres.pojo.AntiEstres();
    keen.libredeestres.pojo.AntiEstres antiEstres4 = new keen.libredeestres.pojo.AntiEstres();
    keen.libredeestres.pojo.AntiEstres antiEstres5 = new keen.libredeestres.pojo.AntiEstres();
    keen.libredeestres.pojo.AntiEstres antiEstres6 = new keen.libredeestres.pojo.AntiEstres();
    keen.libredeestres.pojo.AntiEstres antiEstres7 = new keen.libredeestres.pojo.AntiEstres();
    keen.libredeestres.pojo.AntiEstres antiEstres8 = new keen.libredeestres.pojo.AntiEstres();
    keen.libredeestres.pojo.AntiEstres antiEstres9 = new keen.libredeestres.pojo.AntiEstres();
    keen.libredeestres.pojo.AntiEstres antiEstres10 = new keen.libredeestres.pojo.AntiEstres();
    keen.libredeestres.pojo.AntiEstres antiEstres11 = new keen.libredeestres.pojo.AntiEstres();
    keen.libredeestres.pojo.AntiEstres antiEstres12 = new keen.libredeestres.pojo.AntiEstres();

    antiEstres1.setTitulo(getResources().getString(R.string.factor_anti_estres1));
    antiEstres1.setImagen(R.drawable.ic_almohada_golpeada3);
    antiEstres2.setTitulo(getResources().getString(R.string.factor_anti_estres2));
    antiEstres2.setImagen(R.drawable.ic_lanzar_objetos);
    antiEstres3.setTitulo(getResources().getString(R.string.factor_anti_estres3));
    antiEstres3.setImagen(R.drawable.ic_frustracion);
    antiEstres4.setTitulo(getResources().getString(R.string.factor_anti_estres4));
    antiEstres4.setImagen(R.drawable.ic_preocupacion2);
    antiEstres5.setTitulo(getResources().getString(R.string.factor_anti_estres5));
    antiEstres5.setImagen(R.drawable.ic_rock);
    antiEstres6.setTitulo(getResources().getString(R.string.factor_anti_estres6));
    antiEstres6.setImagen(R.drawable.ic_clasica);
    antiEstres7.setTitulo(getResources().getString(R.string.factor_anti_estres7));
    antiEstres7.setImagen(R.drawable.ic_rompecabezas);
    antiEstres8.setTitulo(getResources().getString(R.string.factor_anti_estres8));
    antiEstres8.setImagen(R.drawable.ic_respirar);
    antiEstres9.setTitulo(getResources().getString(R.string.factor_anti_estres9));
    antiEstres9.setImagen(R.drawable.ic_gritar);
    antiEstres10.setTitulo(getResources().getString(R.string.factor_anti_estres10));
    antiEstres10.setImagen(R.drawable.ic_meditar);
    antiEstres11.setTitulo(getResources().getString(R.string.factor_anti_estres11));
    antiEstres11.setImagen(R.drawable.ic_ejercicio_fisico2);
    antiEstres12.setTitulo(getResources().getString(R.string.factor_anti_estres12));
    antiEstres12.setImagen(R.drawable.ic_mover_cuerpo);
    lista.add(antiEstres1);
    lista.add(antiEstres2);
    lista.add(antiEstres3);
    lista.add(antiEstres4);
    lista.add(antiEstres5);
    lista.add(antiEstres6);
    lista.add(antiEstres7);
    lista.add(antiEstres8);
    lista.add(antiEstres9);
    lista.add(antiEstres10);
    lista.add(antiEstres11);
    lista.add(antiEstres12);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    if (lista.size() > 0) {

      Collections.sort(lista, new Comparator<keen.libredeestres.pojo.AntiEstres>() {
        @Override
        public int compare(keen.libredeestres.pojo.AntiEstres o1,
            keen.libredeestres.pojo.AntiEstres o2) {
          return o1.getTitulo().compareTo(o2.getTitulo());
        }
      });

    }

    MyRecyclerViewAntiEstres adapter = new MyRecyclerViewAntiEstres(lista, null);
    rv.setAdapter(adapter);
    rv.setLayoutManager(linearLayoutManager);
    rv.setHasFixedSize(true);
    return view;
  }

}
