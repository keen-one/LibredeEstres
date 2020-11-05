package keen.libredeestres;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
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
import keen.libredeestres.MyRVToolsAntiEstres.ItemListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class ToolsAntiEstres extends Fragment {

  public static final String TAG = ToolsAntiEstres.class.getSimpleName();

  public ToolsAntiEstres() {
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
    View view = inflater.inflate(R.layout.fragment_tools_anti_estres, container, false);
    AppCompatActivity activity = (AppCompatActivity) getActivity();
    if (activity != null) {
      ActionBar bar = activity.getSupportActionBar();
      if (bar != null) {
        bar.setDisplayHomeAsUpEnabled(false);
      }

    }
    TextView tvMessage = view.findViewById(R.id.message_tools_anti_estres);
    tvMessage.setText(getResources().getString(R.string.title_tools_anti_estres));
    RecyclerView rv = view.findViewById(R.id.rv_factor_tools_anti_estres);
    List<keen.libredeestres.pojo.ToolsAntiEstres> lista = new ArrayList<>();
    keen.libredeestres.pojo.ToolsAntiEstres tool1 = new keen.libredeestres.pojo.ToolsAntiEstres();
    keen.libredeestres.pojo.ToolsAntiEstres tool2 = new keen.libredeestres.pojo.ToolsAntiEstres();
    keen.libredeestres.pojo.ToolsAntiEstres tool3 = new keen.libredeestres.pojo.ToolsAntiEstres();

    tool1.setTitulo(getResources().getString(R.string.tool_anti_estres1));
    tool1.setImagen(R.drawable.ic_musicoterapia);
    tool2.setTitulo(getResources().getString(R.string.tool_anti_estres2));
    tool2.setImagen(R.drawable.ic_tool_rompecabezas);
    tool3.setTitulo(getResources().getString(R.string.tool_anti_estres3));
    tool3.setImagen(R.drawable.ic_escribir);
    lista.add(tool1);
    lista.add(tool2);
    lista.add(tool3);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    if (lista.size() > 0) {
      Collections.sort(lista, new Comparator<keen.libredeestres.pojo.ToolsAntiEstres>() {
        @Override
        public int compare(keen.libredeestres.pojo.ToolsAntiEstres o1,
            keen.libredeestres.pojo.ToolsAntiEstres o2) {
          return o1.getTitulo().compareTo(o2.getTitulo());
        }
      });
    }

    MyRVToolsAntiEstres adapter = new MyRVToolsAntiEstres(lista, new ItemListener() {
      @Override
      public void onItemClick(keen.libredeestres.pojo.ToolsAntiEstres item) {
        FragmentManager manager = getFragmentManager();
        switch (item.getImagen()) {
          case R.drawable.ic_musicoterapia:

            CategoriaMusical categoriaMusical = new CategoriaMusical();

            if (manager != null) {
              manager.beginTransaction()
                  .replace(R.id.container_fragment, categoriaMusical, CategoriaMusical.TAG)
                  .addToBackStack(ToolsAntiEstres.TAG).commit();
            }

            break;
          case R.drawable.ic_escribir:

            PlantillaEscritura plantilla = new PlantillaEscritura();

            if (manager != null) {
              manager.beginTransaction()
                  .replace(R.id.container_fragment, plantilla, PlantillaEscritura.TAG)
                  .addToBackStack(ToolsAntiEstres.TAG).commit();
            }

            break;
          case R.drawable.ic_tool_rompecabezas:
            startActivity(new Intent(getActivity(), MainActivityPuzzle.class));
            break;
          default:
            break;
        }
      }
    });
    rv.setAdapter(adapter);
    rv.setLayoutManager(linearLayoutManager);
    rv.setHasFixedSize(true);
    return view;
  }

}
