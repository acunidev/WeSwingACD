package com.example.weswing.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;

import com.example.weswing.MainActivity;
import com.example.weswing.R;
import com.example.weswing.objects.User;
import com.google.gson.Gson;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    private TextView nomProfile;
    private ImageView profilePic;
    private Button professors,seguidors,seguint,mogudes;
    private ToggleButton seguir;
    private User user;
    private View view;
    private boolean clickado;

    public ProfileFragment() {
        // Required empty public constructor
    }
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initUserWithSharedPref();

        view = inflater.inflate(R.layout.fragment_profile, container, false);
        ((MainActivity) getActivity()).changeTitle(user.getName());
        initElementsProfile();
        clickListeneres();
        return view;
    }

    private void initUserWithSharedPref() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("userData", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("userJson", "");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        Gson gson = new Gson();
        user = gson.fromJson(json, User.class);
    }

    private void initElementsProfile() {
        nomProfile = view.findViewById(R.id.nom_user);
        profilePic = view.findViewById(R.id.profile_pic);
        seguir = view.findViewById(R.id.seguir_button);
        seguidors = view.findViewById(R.id.seguidorsButton);
        seguint = view.findViewById(R.id.seguintButton);
        professors = view.findViewById(R.id.professorsButton);
        mogudes = view.findViewById(R.id.mogudesButton);

        nomProfile.setText(user.getName());
        profilePic.setImageResource(user.getIdProfilePic());

    }
    
    public void clickListeneres(){
        professors.setOnClickListener(v -> ((MainActivity) getActivity()).replaceFragment(new ProfessorFragment()));
        
        seguidors.setOnClickListener(v -> ((MainActivity) getActivity()).replaceFragment(new AssistentsFragment()));
        seguint.setOnClickListener(v -> ((MainActivity) getActivity()).replaceFragment(new AssistentsFragment()));
        
        mogudes.setOnClickListener(v -> ((MainActivity) getActivity()).replaceFragment(new FeedFragment()));
        
        seguir.setOnClickListener(v -> {
            if (clickado){
                seguir.setText("Seguir");
                clickado = false;
            } else {
                seguir.setText("Seguint");
                clickado = true;
            }
        });
    }
}