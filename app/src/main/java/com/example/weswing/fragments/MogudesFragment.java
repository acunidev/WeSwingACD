package com.example.weswing.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.weswing.MainActivity;
import com.example.weswing.R;
import com.example.weswing.adapters.AdapterNovetats;
import com.example.weswing.listener.SelectListenerNovetats;
import com.example.weswing.objects.Moguda;
import com.example.weswing.objects.Novetats;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class MogudesFragment extends Fragment implements View.OnClickListener, SelectListenerNovetats {
    private View view;
    private TextView title;
    private TextView type;
    private TextView data;
    private TextView descripcio;
    private Button asistencia;
    private List<Novetats> novetats;
    private RecyclerView novetatsRecycler;
    private AdapterNovetats adapterNovetats;
    private Moguda moguda;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public void initComponents(){
        novetatsRecycler = view.findViewById(R.id.recyclerView);
        title = view.findViewById(R.id.nomMoguda);
        type = view.findViewById(R.id.tipusMoguda);
        descripcio = view.findViewById(R.id.descriptionText);
        data = view.findViewById(R.id.dataMoguda);
        asistencia = view.findViewById(R.id.asistentsButton);
        initRecyclerEscola();

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mogudes, container, false);
        ((MainActivity) getActivity()).changeTitle("Moguda");
        initComponents();
        initMogudaFromSharedPref();
        displayMoguda();
        asistencia.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {

        ((MainActivity) getActivity()).replaceFragment(new AssistentsFragment());
    }

    @NonNull
    @Override
    public CreationExtras getDefaultViewModelCreationExtras() {
        return super.getDefaultViewModelCreationExtras();
    }

    public void initRecyclerEscola(){
        novetats = new ArrayList<>();
        novetats.add(new Novetats(R.drawable.we_swing_icon,"Jaume Balmes","Barcelona,Spain"));

        adapterNovetats = new AdapterNovetats(novetats,this);
        novetatsRecycler.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        novetatsRecycler.setHasFixedSize(true);
        novetatsRecycler.setAdapter(adapterNovetats);
    }
    @Override
    public void onItemClicked(Novetats novetat) {
        novetat.getPfp();
        ((MainActivity)getActivity()).replaceFragment(new EscolaFragment());

    }


    private void initMogudaFromSharedPref() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("mogudaData", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("mogudaJson", "");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        Gson gson = new Gson();
        moguda = gson.fromJson(json, Moguda.class);
    }

    private void displayMoguda() {
        title.setText(moguda.getTitle());
        descripcio.setText(moguda.getLloc() + " | " + moguda.getLloc());
    }

}