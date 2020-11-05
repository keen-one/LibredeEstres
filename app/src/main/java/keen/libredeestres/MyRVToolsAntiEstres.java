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
import keen.libredeestres.pojo.ToolsAntiEstres;

public class MyRVToolsAntiEstres extends RecyclerView.Adapter<MyRVToolsAntiEstres.ViewHolder> {

  private List<ToolsAntiEstres> myItems;
  private ItemListener myListener;

  public MyRVToolsAntiEstres(List<ToolsAntiEstres> items, ItemListener listener) {
    myItems = items;
    myListener = listener;
  }

  @Override
  public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.row_tools_anti_estres, parent, false)); // TODO
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

    void onItemClick(ToolsAntiEstres item);
  }

  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    // TODO - Your view members
    ToolsAntiEstres item;
    private TextView tv;
    private ImageView iv;

    ViewHolder(View itemView) {
      super(itemView);
      CardView cv = itemView.findViewById(R.id.cv_tools_anti_estres);
      tv = itemView.findViewById(R.id.tv_titulo_tools_anti_estres);
      iv = itemView.findViewById(R.id.iv_tools_anti_estres);
      itemView.setOnClickListener(this);
      // TODO instantiate/assign view members
    }

    void setData(ToolsAntiEstres item) {
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
                                