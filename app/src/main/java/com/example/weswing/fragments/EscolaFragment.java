package com.example.weswing.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.weswing.MainActivity;
import com.example.weswing.R;

public class EscolaFragment extends Fragment {
    View view;
    Button socProfessor, profes;
    TextView nom, detalls, descripcio;

    public EscolaFragment(){}

    public static EscolaFragment newInstance() {

        Bundle args = new Bundle();

        EscolaFragment fragment = new EscolaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_escola, container, false);

        socProfessor = view.findViewById(R.id.escola_socprofe);
        socProfessor.setOnClickListener(v -> {
            DialogFragment avis = new AvisFragment();
            avis.show(getChildFragmentManager(), "AVIS");
        });

        profes = view.findViewById(R.id.escola_btn_profes);
        profes.setOnClickListener(v -> {
            ((MainActivity) getActivity()).replaceFragment(new ProfessorFragment());
        });

        nom = view.findViewById(R.id.escola_nom);
        detalls = view.findViewById(R.id.escola_detalls);
        descripcio = view.findViewById(R.id.escola_descripcio);
        ((MainActivity) getActivity()).changeTitle("Escola");
        return view;
    }


    public void mostraEscola() {

        nom.setText("Escola.getNom()");
        detalls.setText(String.format("%s | Alumnes: %d", "Barcelona(Espanya)", 72));
        descripcio.setText("Escola.descripcio()");
    }

}