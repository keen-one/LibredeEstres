package keen.libredeestres;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import keen.libredeestres.pojo.CategoriaMusical;


public class MyRVCategoriaMusical extends RecyclerView.Adapter<MyRVCategoriaMusical.ViewHolder> {

  private List<CategoriaMusical> myItems;
  private ItemListener myListener;

  public MyRVCategoriaMusical(List<keen.libredeestres.pojo.CategoriaMusical> items,
      ItemListener listener) {
    myItems = items;
    myListener = listener;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.row_categoria_musical, parent, false)); // TODO
  }

  @Override
  public int getItemCount() {
    return myItems.size();
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.tv.setText(myItems.get(position).getTitulo());
    holder.iv.setImageResource(myItems.get(position).getImagen());
    holder.setData(myItems.get(position));
  }

  public interface ItemListener {

    void onItemClick(keen.libredeestres.pojo.CategoriaMusical item);
  }

  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    // TODO - Your view members
    keen.libredeestres.pojo.CategoriaMusical item;
    private TextView tv;
    private ImageView iv;

    ViewHolder(View itemView) {
      super(itemView);
      CardView cv = itemView.findViewById(R.id.cv_categoria_musical);
      tv = itemView.findViewById(R.id.tv_titulo_categoria_musical);
      iv = itemView.findViewById(R.id.iv_categoria_musical);
      itemView.setOnClickListener(this);
      // TODO instantiate/assign view members
    }

    void setData(CategoriaMusical item) {
      this.item = item;
      // TODO set data to view
    }

    @Override
    public void onClick(View v) {
      if (myListener != null) {
        myListener.onItemClick(item);
      }
    }
  }


}
