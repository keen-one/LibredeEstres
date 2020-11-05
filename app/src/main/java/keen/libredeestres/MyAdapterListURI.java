package keen.libredeestres;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.List;
import java.util.Objects;
import keen.libredeestres.pojo.StreamingMusic;


class MyAdapterListURI extends ArrayAdapter<StreamingMusic> {

  private LayoutInflater layoutInflater;

  private List<keen.libredeestres.pojo.StreamingMusic> items;

  public MyAdapterListURI(Context context, int resource, List<StreamingMusic> items) {
    super(context, resource);
    layoutInflater = LayoutInflater.from(context);
    this.items = items;
  }

  @NonNull
  @Override
  public View getView(int position, View convertView, @NonNull ViewGroup parent) {
    if (convertView == null) {
      convertView = layoutInflater.inflate(R.layout.row_list_streaming, parent, false); // TODO
      convertView.setTag(new ViewHolder(convertView));
    }
    initializeViews(Objects.requireNonNull(getItem(position)), (ViewHolder) convertView.getTag());
    return convertView;
  }

  private void initializeViews(keen.libredeestres.pojo.StreamingMusic item,
      ViewHolder holder) {
    //TODO
    holder.tv.setText(item.getTitulo());
  }

  @Override
  public keen.libredeestres.pojo.StreamingMusic getItem(int position) {
    return items.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public int getCount() {
    return items.size();
  }

  static class ViewHolder {

    private TextView tv;

    ViewHolder(View view) {
      // TODO ASSIGNEMENTS
      tv = view.findViewById(R.id.tv_uri_item);
    }
  }
}
                                