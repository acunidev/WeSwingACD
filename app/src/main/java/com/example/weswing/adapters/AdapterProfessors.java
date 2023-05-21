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
import com.example.weswing.listener.SelectListenerProfessors;
import com.example.weswing.objects.User;

import java.util.List;

public class AdapterProfessors extends RecyclerView.Adapter<AdapterProfessors.MyViewHolder> {

    private List<User> professors;
    private SelectListenerProfessors selectListenerProfessors;

    public AdapterProfessors(List<User> professors, SelectListenerProfessors selectListenerProfessors) {
        this.professors = professors;
        this.selectListenerProfessors = selectListenerProfessors;
    }

    @NonNull
    @Override
    public AdapterProfessors.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_professor, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProfessors.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bindData(professors.get(position));
        holder.cardView.setOnClickListener(v -> selectListenerProfessors.onItemClicked(professors.get(position)));
    }

    @Override
    public int getItemCount() {
        return professors.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nomProfessor;
        private ImageView pfpProfessor;
        private CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomProfessor = itemView.findViewById(R.id.tvNomProfessor);
            pfpProfessor = itemView.findViewById(R.id.pfpProfessor);
            cardView = itemView.findViewById(R.id.cardviewProfessor);
        }

        void bindData(final User user) {
            nomProfessor.setText(user.getName());
            pfpProfessor.setImageResource(user.getIdProfilePic());
        }
    }
}