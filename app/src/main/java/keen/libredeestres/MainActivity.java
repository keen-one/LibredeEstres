package keen.libredeestres;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

  public static final String GENERO_SELECTED = "GENERO_SELECTED";
  public static final String URI_SELECTED = "URI_SELECTED";
  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
      = new BottomNavigationView.OnNavigationItemSelectedListener() {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      switch (item.getItemId()) {
        case R.id.factores_estres:
          FactorEstres factorEstres = new FactorEstres();
          getSupportFragmentManager().beginTransaction()
              .replace(R.id.container_fragment, factorEstres).addToBackStack(null).commit();

          return true;
        case R.id.navigation_home:
          Home home = new Home();
          getSupportFragmentManager().beginTransaction()
              .replace(R.id.container_fragment, home)
              .addToBackStack(null).commit();

          return true;
        case R.id.navigation_dashboard:
          AntiEstres antiEstres = new AntiEstres();
          getSupportFragmentManager().beginTransaction()
              .replace(R.id.container_fragment, antiEstres).addToBackStack(null).commit();

          return true;
        case R.id.tools_antiestres:
          ToolsAntiEstres tools = new ToolsAntiEstres();
          getSupportFragmentManager().beginTransaction()
              .replace(R.id.container_fragment, tools, ToolsAntiEstres.TAG)
              .addToBackStack(null).commit();
          return true;

      }
      return false;
    }
  };


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    StrictMode.setThreadPolicy(policy);
    BottomNavigationView navView = findViewById(R.id.nav_view);
    navView.setSelectedItemId(R.id.navigation_home);
    navView.getMenu().performIdentifierAction(R.id.navigation_home, 0);
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.container_fragment, new Home()).addToBackStack(null).commit();
    navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

  }


}
