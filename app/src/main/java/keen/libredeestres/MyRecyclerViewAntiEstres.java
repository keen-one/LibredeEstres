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
import keen.libredeestres.pojo.AntiEstres;


public class MyRecyclerViewAntiEstres extends
    RecyclerView.Adapter<MyRecyclerViewAntiEstres.ViewHolder> {

  private List<AntiEstres> myItems;
  private ItemListener myListener;

  public MyRecyclerViewAntiEstres(List<AntiEstres> items, ItemListener listener) {
    myItems = items;
    myListener = listener;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.rv_row_anti_estres, parent, false)); // TODO
  }

  @Override
  public int getItemCount() {
    return myItems.size();
  }

  @Override
  public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.tv_factor.setText(myItems.get(position).getTitulo());
    holder.ivAntiEstres.setImageResource(myItems.get(position).getImagen());
    //myItems.add(holder.item);
    holder.setData(myItems.get(position));
  }

  interface ItemListener {

    void onItemClick(AntiEstres item);
  }

  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    // TODO - Your view members
    AntiEstres item;
    private ImageView ivAntiEstres;
    private TextView tv_factor;

    ViewHolder(View itemView) {
      super(itemView);
      //myItems.add(item);
      ivAntiEstres = itemView.findViewById(R.id.iv_anti_estres);
      tv_factor = itemView.findViewById(R.id.tv_titulo_anti_estres);
      CardView cvAntiEstresItem = itemView.findViewById(R.id.cv_anti_estres);
      itemView.setOnClickListener(this);
      // TODO instantiate/assign view members
    }

    void setData(AntiEstres item) {
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
                                