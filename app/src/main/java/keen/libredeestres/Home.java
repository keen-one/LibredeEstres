package keen.libredeestres;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {


  public Home() {
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

    return inflater.inflate(R.layout.fragment_home, container, false);
  }

}
