package com.example.weswing.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.weswing.MainActivity;
import com.example.weswing.R;
import com.example.weswing.adapters.AdapterProfessors;
import com.example.weswing.listener.SelectListenerProfessors;
import com.example.weswing.objects.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class AssistentsFragment extends Fragment implements SelectListenerProfessors {
    List<User> userList;
    RecyclerView novetatsRecycler;
    AdapterProfessors adapterProfessors;
    User selectProfessor;
    TextView titol,tipus,data,descripcio;
    Switch asistencia;
    CardView cardView;

    public AssistentsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AssistentsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AssistentsFragment newInstance(String param1, String param2) {
        AssistentsFragment fragment = new AssistentsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")

    public void initRecyclerReview() {
        userList = new ArrayList<>();
        userList.add(new User("Antonio Martinez", R.drawable.user1));
        userList.add(new User("Juan Antonio", R.drawable.user2));
        userList.add(new User("Maria Hernandez", R.drawable.user3));
        userList.add(new User("Teresa Pons", R.drawable.user3));
        userList.add(new User("Teresa Pons", R.drawable.user3));

        adapterProfessors = new AdapterProfessors(userList, this);
        novetatsRecycler.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        novetatsRecycler.setHasFixedSize(true);
        novetatsRecycler.setAdapter(adapterProfessors);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).changeTitle("Assistents");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_assistents, container, false);
        novetatsRecycler = view.findViewById(R.id.recyclerProfessors);
        initRecyclerReview();
        return view;
    }

    @Override
    public void onItemClicked(User user) {
        shareProfessorToProfileFragment(user);

        ((MainActivity) getActivity()).replaceFragment(new ProfileFragment());
    }

    private void shareProfessorToProfileFragment(User user) {
        Gson gson = new Gson();
        String json = gson.toJson(user);


        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("userData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userJson", json);
        editor.apply();
    }
}