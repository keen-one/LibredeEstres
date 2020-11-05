package keen.libredeestres;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import keen.libredeestres.pojo.StreamingMusic;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListStreaming extends Fragment {

  public static final String TAG = ListStreaming.class.getSimpleName();
  private String generoSelected = "clasica";

  public ListStreaming() {
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
    if (getArguments() != null) {
      generoSelected = getArguments().getString(MainActivity.GENERO_SELECTED, "CLASICA");
    }
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
    View view = inflater.inflate(R.layout.fragment_list_streaming, container, false);

    ListView listaView = view.findViewById(R.id.list_uri);
    List<StreamingMusic> lista = new ArrayList<>();
    if (lista.size() > 0) {
      lista.clear();
    }

    if (generoSelected.equalsIgnoreCase("JAZZ")) {

      lista.add(
          new StreamingMusic("KKJZ - KJazz 88.1", "http://1.ice1.firststreaming.com/kkjz_fm.mp3"));

      lista.add(new StreamingMusic("SmoothJazz.com Global Radio #1", "http://sj128.hnux.com"));
      lista.add(new StreamingMusic("SmoothJazz.com Global Radio #2", "http://sj64.hnux.com"));
      lista.add(new StreamingMusic("The Breeze 181.FM",
          "http://181fm-edge1.cdnstream.com/181-breeze_128k.mp3"));

      lista.add(new StreamingMusic("The 1920s Radio Network", "http://tess.fast-serv.com:8570/"));
      lista.add(new StreamingMusic("Radio Dismuke #1", "http://74.208.197.50:8087/"));
      lista.add(new StreamingMusic("Radio Dismuke #2", "http://74.208.197.50:8078/"));
      lista.add(new StreamingMusic("Radio Dismuke #3", "http://74.208.197.50:8000/"));
      lista.add(new StreamingMusic("Radio Dismuke #4", "http://74.208.71.58:8000/"));
      lista.add(new StreamingMusic("Radio Dismuke #5", "http://72.249.45.203:8000/"));
      lista.add(new StreamingMusic("Radio Dismuke #6", "http://74.208.71.58:8087/"));
      lista.add(new StreamingMusic("Radio Dismuke #7", "http://74.208.71.58:8078/"));

      lista.add(new StreamingMusic("Chroma Classic Jazz", "http://chromaradio.com:8028"));

    } else if (generoSelected.equalsIgnoreCase("CLASICA")) {

      lista.add(new StreamingMusic("WKSU Classical Channel", "http://66.225.205.8:8030"));

      lista.add(new StreamingMusic("WKSU Classical Channel", "http://66.225.205.8:8030"));

      lista.add(
          new StreamingMusic("Classical Minnesota", "http://cms.stream.publicradio.org/cms.mp3"));
      lista.add(new StreamingMusic("All Ottos Baroque Musick", "http://sc-baroque.1.fm:8045"));
      lista.add(new StreamingMusic("WQXR Q2", "http://q2stream.wqxr.org/q2"));


    } else if (generoSelected.equalsIgnoreCase("ROCK")) {

      lista.add(new StreamingMusic("sorradio.org SoR Radio", "http://sorradio.org:5005/live"));
      lista.add(new StreamingMusic("Ohana Rock Club", "http://ohana.digistream.info:10288"));
      lista.add(new StreamingMusic("Megarock Radio #1", "http://stream1.megarockradio.net:8240"));

      lista.add(new StreamingMusic("Megarock Radio #3", "http://stream3.megarockradio.net:80"));
      lista.add(new StreamingMusic("Hard Rockin' 80s", "http://stream-licensing.com:8128/"));
      lista.add(new StreamingMusic("Aural Moon", "http://64.202.98.133:2010"));

      lista.add(new StreamingMusic("T1 Radio", "http://t1radio.serverroom.us:8242"));
    }
    if (lista.size() > 0) {

      Collections.sort(lista, new Comparator<StreamingMusic>() {
        @Override
        public int compare(StreamingMusic o1, StreamingMusic o2) {
          return o1.getTitulo().compareTo(o2.getTitulo());
        }
      });
    }

    MyAdapterListURI adapter = new MyAdapterListURI(getContext(), R.layout.row_list_streaming,
        lista);
    listaView.setAdapter(adapter);
    listaView.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        StreamingMusic streamingMusic = lista.get(position);
        String uriDireccion = streamingMusic.getUri();
        Bundle bundle = new Bundle();
        bundle.putString(MainActivity.URI_SELECTED, uriDireccion);
        bundle.putString(MainActivity.GENERO_SELECTED, generoSelected);
        Intent miIntent = new Intent(getActivity(), MusicActivity.class);
        miIntent.putExtras(bundle);
        startActivity(miIntent);
      }
    });

    return view;
  }

}
