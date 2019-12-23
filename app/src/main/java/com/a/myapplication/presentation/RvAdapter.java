package com.a.myapplication.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.a.myapplication.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvViewHolder> {

    private List<String> stringList = new ArrayList<>();
    private ClickListener clickListener;

    public RvAdapter(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lv, parent, false);
        return new RvViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RvViewHolder holder, int position) {
        holder.bind(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public void updateData(List<String> strings) {
        stringList.clear();
        stringList.addAll(strings);
        notifyDataSetChanged();
    }

    static class RvViewHolder extends RecyclerView.ViewHolder {

        private final WeakReference<ClickListener> clickListener;
        private TextView textView;
        private Button button;

        public RvViewHolder(@NonNull View itemView, ClickListener clickListener) {
            super(itemView);
            this.clickListener = new WeakReference<>(clickListener);
            textView = itemView.findViewById(R.id.tv);
            button = itemView.findViewById(R.id.btn);
        }

        public void bind(final String s) {
            textView.setText(s);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickListener.get() != null) {
                        clickListener.get().onClick(getAdapterPosition(), s);
                    }
                }
            });


        }
    }

    public interface ClickListener {
        void onClick(int position, String s);
    }

}
