package br.com.etecia.sustainapp.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.etecia.sustainapp.R;

/**
 * Adapter para o RecyclerView que exibe a lista de SmartItems.
 */
public class SmartItemAdapter extends RecyclerView.Adapter<SmartItemAdapter.SmartItemViewHolder> {

    private List<SmartItem> smartItems;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onEdit(int position);
        void onDelete(int position);
    }

    public SmartItemAdapter(List<SmartItem> smartItems, OnItemClickListener listener) {
        this.smartItems = smartItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SmartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_smart, parent, false);
        return new SmartItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SmartItemViewHolder holder, int position) {
        SmartItem item = smartItems.get(position);
        holder.nameTextView.setText(item.getName());
        holder.categoryTextView.setText(item.getCategory());
        holder.descriptionTextView.setText(item.getDescription());

        holder.btnEdit.setOnClickListener(v -> listener.onEdit(position));
        holder.btnDelete.setOnClickListener(v -> listener.onDelete(position));
    }

    @Override
    public int getItemCount() {
        return smartItems.size();
    }

    public void updateItems(List<SmartItem> newItems) {
        this.smartItems = newItems;
        notifyDataSetChanged();
    }

    static class SmartItemViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView categoryTextView;
        TextView descriptionTextView;
        Button btnEdit;
        Button btnDelete;

        public SmartItemViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.item_name);
            categoryTextView = itemView.findViewById(R.id.item_category);
            descriptionTextView = itemView.findViewById(R.id.item_description);
            btnEdit = itemView.findViewById(R.id.btn_edit);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }
    }
}