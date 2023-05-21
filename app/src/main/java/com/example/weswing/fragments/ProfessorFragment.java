package com.example.weswing.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weswing.MainActivity;
import com.example.weswing.R;
import com.example.weswing.adapters.AdapterProfessors;
import com.example.weswing.listener.SelectListenerProfessors;
import com.example.weswing.objects.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfessorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfessorFragment extends Fragment implements SelectListenerProfessors {
    List<User> userList;
    RecyclerView novetatsRecycler;
    AdapterProfessors adapterProfessors;
    User selectProfessor;

    public ProfessorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfessorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfessorFragment newInstance(String param1, String param2) {
        ProfessorFragment fragment = new ProfessorFragment();
        Bundle args;
        args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_professor, container, false);
        ((MainActivity) getActivity()).changeTitle("Professors");
        novetatsRecycler = view.findViewById(R.id.recyclerProfessors);
        initRecyclerReview();
        return view;
    }

    public void initRecyclerReview() {
        userList = new ArrayList<>();
        userList.add(new User("Alex Medina", R.drawable.user1));
        userList.add(new User("Christian Perona", R.drawable.user2));
        userList.add(new User("Lidia Saez", R.drawable.user3));
        userList.add(new User("Esther Guirao", R.drawable.user4));

        adapterProfessors = new AdapterProfessors(userList, this);
        novetatsRecycler.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        novetatsRecycler.setHasFixedSize(true);
        novetatsRecycler.setAdapter(adapterProfessors);
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