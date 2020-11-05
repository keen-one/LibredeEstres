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


public class MyRecyclerViewEstres extends RecyclerView.Adapter<MyRecyclerViewEstres.ViewHolder> {

  private List<keen.libredeestres.pojo.FactorEstres> myItems;
  private ItemListener myListener;

  public MyRecyclerViewEstres(List<keen.libredeestres.pojo.FactorEstres> items,
      ItemListener listener) {
    myItems = items;
    myListener = listener;
  }


  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.rv_row_factor_estres, parent, false)); // TODO
  }

  @Override
  public long getItemId(int position) {
    return super.getItemId(position);
  }

  @Override
  public int getItemCount() {
    return myItems.size();
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.tv.setText(myItems.get(position).getTitulo());
    holder.iv.setImageResource(myItems.get(position).getImagen());
    holder.setData(myItems.get(position));
  }


  @Override
  public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
  }

  interface ItemListener {

    void onItemClick(keen.libredeestres.pojo.FactorEstres item);
  }

  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    // TODO - Your view members
    keen.libredeestres.pojo.FactorEstres item;
    private TextView tv;
    private ImageView iv;

    ViewHolder(View itemView) {
      super(itemView);
      //myItems.add(item);
      iv = itemView.findViewById(R.id.iv_factor_estres);
      tv = itemView.findViewById(R.id.tv_titulo_estres);
      CardView cv = itemView.findViewById(R.id.cv_factor_estres);
      itemView.setOnClickListener(this);
      // TODO instantiate/assign view members
    }

    void setData(keen.libredeestres.pojo.FactorEstres item) {
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
                                