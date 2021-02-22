package kg.geektech.android3.lesson_3_1.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kg.geektech.android3.lesson_3_1.R;

public class PageRecyclerAdapter extends RecyclerView.Adapter<PageRecyclerAdapter.PagerVH> {

    private List<String> list;

    public PageRecyclerAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public PagerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page, parent, false);
        return new PagerVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PagerVH holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class PagerVH extends RecyclerView.ViewHolder {

        private final TextView name = itemView.findViewById(R.id.tv_fragment_name);

        public PagerVH(@NonNull View itemView) {
            super(itemView);
        }

        public void onBind(String value) {
            name.setText(value);
        }
    }
}
