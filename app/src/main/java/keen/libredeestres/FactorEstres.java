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
public class FactorEstres extends Fragment {


  public FactorEstres() {
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
    View view = inflater.inflate(R.layout.fragment_factor_estres, container, false);
    TextView tvMessage = view.findViewById(R.id.message_estres);
    tvMessage.setText(getResources().getString(R.string.title_habitos_factor_estres));
    RecyclerView rv = view.findViewById(R.id.rv_factor_estres);
    List<keen.libredeestres.pojo.FactorEstres> lista = new ArrayList<>();

    keen.libredeestres.pojo.FactorEstres factorEstres1 = new keen.libredeestres.pojo.FactorEstres();
    keen.libredeestres.pojo.FactorEstres factorEstres2 = new keen.libredeestres.pojo.FactorEstres();
    keen.libredeestres.pojo.FactorEstres factorEstres3 = new keen.libredeestres.pojo.FactorEstres();
    keen.libredeestres.pojo.FactorEstres factorEstres4 = new keen.libredeestres.pojo.FactorEstres();
    keen.libredeestres.pojo.FactorEstres factorEstres5 = new keen.libredeestres.pojo.FactorEstres();
    keen.libredeestres.pojo.FactorEstres factorEstres6 = new keen.libredeestres.pojo.FactorEstres();
    keen.libredeestres.pojo.FactorEstres factorEstres7 = new keen.libredeestres.pojo.FactorEstres();
    keen.libredeestres.pojo.FactorEstres factorEstres8 = new keen.libredeestres.pojo.FactorEstres();
    keen.libredeestres.pojo.FactorEstres factorEstres9 = new keen.libredeestres.pojo.FactorEstres();
    keen.libredeestres.pojo.FactorEstres factorEstres10 = new keen.libredeestres.pojo.FactorEstres();
    keen.libredeestres.pojo.FactorEstres factorEstres11 = new keen.libredeestres.pojo.FactorEstres();
    keen.libredeestres.pojo.FactorEstres factorEstres12 = new keen.libredeestres.pojo.FactorEstres();
    keen.libredeestres.pojo.FactorEstres factorEstres13 = new keen.libredeestres.pojo.FactorEstres();
    keen.libredeestres.pojo.FactorEstres factorEstres14 = new keen.libredeestres.pojo.FactorEstres();
    keen.libredeestres.pojo.FactorEstres factorEstres15 = new keen.libredeestres.pojo.FactorEstres();
    keen.libredeestres.pojo.FactorEstres factorEstres16 = new keen.libredeestres.pojo.FactorEstres();
    keen.libredeestres.pojo.FactorEstres factorEstres17 = new keen.libredeestres.pojo.FactorEstres();
    keen.libredeestres.pojo.FactorEstres factorEstres18 = new keen.libredeestres.pojo.FactorEstres();
    keen.libredeestres.pojo.FactorEstres factorEstres19 = new keen.libredeestres.pojo.FactorEstres();
    keen.libredeestres.pojo.FactorEstres factorEstres20 = new keen.libredeestres.pojo.FactorEstres();

    factorEstres1.setTitulo(getResources().getString(R.string.factor_estres1));
    factorEstres1.setImagen(R.drawable.ic_cafe);
    factorEstres2.setTitulo(getResources().getString(R.string.factor_estres2));
    factorEstres2.setImagen(R.drawable.ic_azucar3);
    factorEstres3.setTitulo(getResources().getString(R.string.factor_estres3));
    factorEstres3.setImagen(R.drawable.ic_mantequilla);
    factorEstres4.setTitulo(getResources().getString(R.string.factor_estres4));
    factorEstres4.setImagen(R.drawable.ic_grasas_trans);
    factorEstres5.setTitulo(getResources().getString(R.string.factor_estres5));
    factorEstres5.setImagen(R.drawable.ic_ruido2);
    factorEstres6.setTitulo(getResources().getString(R.string.factor_estres6));
    factorEstres6.setImagen(R.drawable.ic_sobresfuerzo);
    factorEstres7.setTitulo(getResources().getString(R.string.factor_estres7));
    factorEstres7.setImagen(R.drawable.ic_mala_postura);
    factorEstres8.setTitulo(getResources().getString(R.string.factor_estres8));
    factorEstres8.setImagen(R.drawable.ic_temperatura_alta);
    factorEstres9.setTitulo(getResources().getString(R.string.factor_estres9));
    factorEstres9.setImagen(R.drawable.ic_hambre);
    factorEstres10.setTitulo(getResources().getString(R.string.factor_estres10));
    factorEstres10.setImagen(R.drawable.ic_insomnio);
    factorEstres11.setTitulo(getResources().getString(R.string.factor_estres11));
    factorEstres11.setImagen(R.drawable.ic_mudanza);
    factorEstres12.setTitulo(getResources().getString(R.string.factor_estres12));
    factorEstres12.setImagen(R.drawable.ic_examen);
    factorEstres13.setTitulo(getResources().getString(R.string.factor_estres13));
    factorEstres13.setImagen(R.drawable.ic_problema_pareja);
    factorEstres14.setTitulo(getResources().getString(R.string.factor_estres14));
    factorEstres14.setImagen(R.drawable.ic_desempleo);
    factorEstres15.setTitulo(getResources().getString(R.string.factor_estres15));
    factorEstres15.setImagen(R.drawable.ic_muerte3);
    factorEstres16.setTitulo(getResources().getString(R.string.factor_estres16));
    factorEstres16.setImagen(R.drawable.ic_reto2);
    factorEstres17.setTitulo(getResources().getString(R.string.factor_estres17));
    factorEstres17.setImagen(R.drawable.ic_discusion_laboral);
    factorEstres18.setTitulo(getResources().getString(R.string.factor_estres18));
    factorEstres18.setImagen(R.drawable.ic_competitivo);
    factorEstres19.setTitulo(getResources().getString(R.string.factor_estres19));
    factorEstres19.setImagen(R.drawable.ic_atasco_vehicular);
    factorEstres20.setTitulo(getResources().getString(R.string.factor_estres20));
    factorEstres20.setImagen(R.drawable.ic_falta_tiempo);

    lista.add(factorEstres1);
    lista.add(factorEstres2);
    lista.add(factorEstres3);
    lista.add(factorEstres4);
    lista.add(factorEstres5);
    lista.add(factorEstres6);
    lista.add(factorEstres7);
    lista.add(factorEstres8);
    lista.add(factorEstres9);
    lista.add(factorEstres10);
    lista.add(factorEstres11);
    lista.add(factorEstres12);
    lista.add(factorEstres13);
    lista.add(factorEstres14);
    lista.add(factorEstres15);
    lista.add(factorEstres16);
    lista.add(factorEstres17);
    lista.add(factorEstres18);
    lista.add(factorEstres19);
    lista.add(factorEstres20);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    if (lista.size() > 0) {
      Collections.sort(lista, new Comparator<keen.libredeestres.pojo.FactorEstres>() {
        @Override
        public int compare(keen.libredeestres.pojo.FactorEstres o1,
            keen.libredeestres.pojo.FactorEstres o2) {
          return o1.getTitulo().compareTo(o2.getTitulo());
        }
      });
    }

    MyRecyclerViewEstres adapter = new MyRecyclerViewEstres(lista, null);
    rv.setAdapter(adapter);
    rv.setLayoutManager(linearLayoutManager);
    rv.setHasFixedSize(true);
    return view;
  }

}
