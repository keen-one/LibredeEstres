package keen.libredeestres;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Player.EventListener;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import java.util.Objects;
import keen.libredeestres.util.Validacion;

public class MusicActivity extends AppCompatActivity {

  private SimpleExoPlayer player;

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      finish();
      getSupportFragmentManager().popBackStack();
      return true;
    }
    return super.onOptionsItemSelected(item);

  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.music);

    ActionBar bar = this.getSupportActionBar();
    if (bar != null) {
      bar.setDisplayHomeAsUpEnabled(true);
    }

    Intent in = getIntent();
    Bundle bundle = in.getExtras();
    String uriSelected = Objects.requireNonNull(bundle)
        .getString(MainActivity.URI_SELECTED, "http://66.225.205.8:8030");
    String generoSelected = bundle.getString(MainActivity.GENERO_SELECTED, "CLASICA");
    PlayerView playerView = findViewById(R.id.player_view);
    LinearLayout linearLayout = findViewById(R.id.layout_playback);
    if (generoSelected.equalsIgnoreCase("ROCK")) {
      linearLayout.setBackgroundResource(R.drawable.papel_tapiz_rock);
      //playerView.setBackgroundResource(R.drawable.papel_tapiz_rock);
    } else if (generoSelected.equalsIgnoreCase("CLASICA")) {
      linearLayout.setBackgroundResource(R.drawable.papel_tapiz_clasica);
      //playerView.setBackgroundResource(R.drawable.papel_tapiz_clasica);
    } else if (generoSelected.equalsIgnoreCase("JAZZ")) {
      linearLayout.setBackgroundResource(R.drawable.papel_tapiz_jazz);
      //playerView.setBackgroundResource(R.drawable.papel_tapiz_jazz);
    }

    ExtractorMediaSource ems = getSourceByGenero(uriSelected);
    DefaultRenderersFactory drf = new DefaultRenderersFactory(this);
    //drf.setExtensionRendererMode(DefaultRenderersFactory.EXTENSION_RENDERER_MODE_PREFER);
    player = ExoPlayerFactory.newSimpleInstance(this, drf,
        new DefaultTrackSelector(), new DefaultLoadControl());

    playerView.requestFocus();
    playerView.setPlayer(player);
    Validacion validacion = new Validacion();
    if (validacion.tieneInternet(this)) {
      player.prepare(ems);
      player.setPlayWhenReady(true);
    }
    player.addListener(new EventListener() {
      @Override
      public void onPlayerError(ExoPlaybackException error) {
        player.stop();
      }

    });
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    if (player != null) {
      player.stop();
      player.release();
      player = null;
    }
  }

  private ExtractorMediaSource getSourceByGenero(String uriSelected) {
    Uri uri = Uri.parse(uriSelected);
    return new ExtractorMediaSource.Factory(new DefaultHttpDataSourceFactory("exoplayer-codelab"))
        .createMediaSource(uri);
  }
}
