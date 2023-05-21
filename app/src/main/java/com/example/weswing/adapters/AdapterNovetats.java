package com.example.weswing.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weswing.R;
import com.example.weswing.listener.SelectListenerNovetats;
import com.example.weswing.objects.Novetats;

import java.util.List;

public class AdapterNovetats extends RecyclerView.Adapter<AdapterNovetats.MyViewHolder> {

    private List<Novetats> novetatsList;
    private SelectListenerNovetats listenerMoguda;

    public AdapterNovetats(List<Novetats> novetatsList, SelectListenerNovetats listenerMoguda){
        this.novetatsList = novetatsList;
        this.listenerMoguda = listenerMoguda;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_moguda,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bindData(novetatsList.get(position));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerMoguda.onItemClicked(novetatsList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return novetatsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView pfp;
        TextView desc;
        TextView hores;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            pfp = itemView.findViewById(R.id.pfp_escola);
            desc = itemView.findViewById(R.id.title_escola);
            hores = itemView.findViewById(R.id.desc_escola);
            cardView = itemView.findViewById(R.id.cardView);

        }

        void bindData(final Novetats novetats){
            pfp.setImageResource(novetats.getPfp());
            desc.setText(novetats.getDesc());
            hores.setText(novetats.getHores());
        }
    }
}
