package com.febry.kelaslnt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.febry.kelaslnt.data.IsiRecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private IsiRecyclerView[] data;
    private Context context;

    public RecyclerViewAdapter(IsiRecyclerView[] data, Context context){
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTitle().setText(data[position].getTitle());
        holder.getDetail().setText(data[position].getDetails());
        holder.getButton().setOnClickListener(view -> {
            Toast.makeText(context, "Button telah diclick", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title, detail;
        private Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tv_title);
            detail = itemView.findViewById(R.id.tv_detail);
            button = itemView.findViewById(R.id.btn_test);
        }

        public TextView getTitle() {
            return title;
        }

        public TextView getDetail() {
            return detail;
        }

        public Button getButton() {
            return button;
        }
    }
}
