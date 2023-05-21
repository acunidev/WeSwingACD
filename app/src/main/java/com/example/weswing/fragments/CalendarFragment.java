package com.example.weswing.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weswing.MainActivity;
import com.example.weswing.listener.SelectListenerMoguda;
import com.example.weswing.objects.Moguda;
import com.example.weswing.R;
import com.example.weswing.adapters.AdapterCalendari;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class CalendarFragment extends Fragment implements SelectListenerMoguda {
    View vista;
    TextView amics, assistire, tot;
    TextView filtresTv;
    RecyclerView mogudes;

    List<TextView> tvs = new ArrayList<>();

    public static CalendarFragment newInstance(String param1, String param2) {
        CalendarFragment fragment = new CalendarFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_calendar, container, false);
        ((MainActivity) getActivity()).changeTitle("Mogudes");
        init();
        initRecyclerTots();

        return vista;
    }

    public void init() {
        amics = vista.findViewById(R.id.amicsBTN);
        amics.setOnClickListener(v -> {
            clickTV(amics);
            initRecyclerAmics();
        });

        assistire = vista.findViewById(R.id.asistireBTN);
        assistire.setOnClickListener(v -> {
            clickTV(assistire);
            initRecyclerAssistire();
        });

        tot = vista.findViewById(R.id.totsBTN);
        tot.setOnClickListener(v -> {
            clickTV(tot);
            initRecyclerTots();
        });
        tvs.add(amics);
        tvs.add(assistire);
        tvs.add(tot);

        filtresTv = vista.findViewById(R.id.filtresTV);
        mogudes = vista.findViewById(R.id.recyclerMogudes);
    }

    public void initRecyclerTots() {
        List<Moguda> mogudaList = new ArrayList<>();

        mogudaList.add(new Moguda("27 de agost de 2022", "DAM/ASIX/DAW Challenge", R.drawable.bailando, "Organitzat per: Generalitat de Barcelona", "Barcelona, Spain", "44/06/2017-18/04/2017 | 8horas", "4 assistents | 0 amics"));
        mogudaList.add(new Moguda("18 de gener de 2013", "Olimpiadas DAM", R.drawable.bailando, "Organitzat per: Gobierno de Espanya", "Madrid, Spain", "18/01/2013-10/01/2013 | 2horas", "21 assistents | 0 amics"));
        mogudaList.add(new Moguda("01 de agost de 2023", "WeSwing Festival Verano", R.drawable.bailando, "Organitzat per: Abel", "Barcelona, Spain", "01/08/2023-10/08/2023 | 12horas", "10 assistents | 5 amics"));
        mogudaList.add(new Moguda("12 de juny de 2018", "Jaume Balmes Got Talent", R.drawable.bailando, "Organitzat per: JaumeBalmes", "Barcelona, Spain", "24/04/2017-18/04/2017 | 5horas", "267 assistents | 3 amics"));
        mogudaList.add(new Moguda("25 de decembre de 2023", "WeSwing Festival Invierno", R.drawable.bailando, "Organitzat per: Abel", "Madrid, Spain", "25/12/2023-27/12/2023 | 7horas", "3 assistents | 3 amics"));


        AdapterCalendari adapter = new AdapterCalendari(mogudaList,this);
        mogudes.setLayoutManager(new LinearLayoutManager(vista.getContext(), LinearLayoutManager.VERTICAL, false));
        mogudes.setAdapter(adapter);
    }

    public void initRecyclerAmics() {
        List<Moguda> recAmics = new ArrayList<>();

        recAmics.add(new Moguda("01 de agost de 2023", "WeSwing Festival Verano", R.drawable.bailando, "Organitzat per: Abel", "Barcelona, Spain", "01/08/2023-10/08/2023 | 12horas", "10 assistents | 5 amics"));
        recAmics.add(new Moguda("12 de juny de 2018", "Jaume Balmes Got Talent", R.drawable.bailando, "Organitzat per: JaumeBalmes", "Barcelona, Spain", "24/04/2017-18/04/2017 | 5horas", "267 assistents | 3 amics"));
        recAmics.add(new Moguda("25 de decembre de 2023", "WeSwing Festival Invierno", R.drawable.bailando, "Organitzat per: Abel", "Madrid, Spain", "25/12/2023-27/12/2023 | 7horas", "3 assistents | 3 amics"));
        recAmics.add(new Moguda("03 de novembre de 2020", "DAM Exalumnes Reunion", R.drawable.bailando, "Organitzat per: Jaume Balmes", "Barcelona, Spain", "25/12/2017-8/04/2017 | 2horas", "31 assistents | 18 amics"));

        AdapterCalendari adapter = new AdapterCalendari(recAmics);
        mogudes.setLayoutManager(new LinearLayoutManager(vista.getContext(), LinearLayoutManager.VERTICAL, false));
        mogudes.setAdapter(adapter);
    }

    public void initRecyclerAssistire() {
        List<Moguda> recAssistire = new ArrayList<>();

        recAssistire.add(new Moguda("01 de agost de 2023", "WeSwing Festival Verano", R.drawable.bailando, "Organitzat per: Abel", "Barcelona, Spain", "01/08/2023-10/08/2023 | 12horas", "10 assistents | 5 amics"));
        recAssistire.add(new Moguda("12 de juny de 2018", "Jaume Balmes Got Talent", R.drawable.bailando, "Organitzat per: JaumeBalmes", "Barcelona, Spain", "24/04/2017-18/04/2017 | 5horas", "267 assistents | 3 amics"));
        recAssistire.add(new Moguda("25 de decembre de 2023", "WeSwing Festival Invierno", R.drawable.bailando, "Organitzat per: Abel", "Madrid, Spain", "25/12/2023-27/12/2023 | 7horas", "3 assistents | 3 amics"));

        AdapterCalendari adapter = new AdapterCalendari(recAssistire);
        mogudes.setLayoutManager(new LinearLayoutManager(vista.getContext(), LinearLayoutManager.VERTICAL, false));
        mogudes.setAdapter(adapter);
    }

    public void clickTV(TextView clicked) {
        clicked.setTextColor(getResources().getColor(R.color.white));
        clicked.setBackgroundColor(getResources().getColor(R.color.tematicRed));

        for (TextView tv : tvs) {
            if (tv.equals(clicked)) {
                tv.setTextColor(getResources().getColor(R.color.white));
                tv.setBackgroundColor(getResources().getColor(R.color.tematicRed));
            } else {
                tv.setTextColor(getResources().getColor(R.color.textgrey));
                tv.setBackgroundColor(getResources().getColor(R.color.brown_light));
            }
        }
    }

    @Override
    public void onItemClicked(Moguda moguda) {
        shareMogudaFromCalendar(moguda);
        ((MainActivity) getActivity()).replaceFragment(new MogudesFragment());
    }

    @Override
    public void onItemClick(Moguda moguda) {
        shareMogudaFromCalendar(moguda);
        ((MainActivity) getActivity()).replaceFragment(new MogudesFragment());
    }

    private void shareMogudaFromCalendar(Moguda moguda) {
        Gson gson = new Gson();
        String json = gson.toJson(moguda);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("mogudaData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("mogudaJson", json);
        editor.apply();
    }
}