package com.example.weswing.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.example.weswing.R;

public class AvisFragment extends DialogFragment {
    TextView message;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.avis, null);

        builder.setPositiveButton(R.string.avis_ok, (DialogInterface.OnClickListener) (dialog, id) -> {})
                .setNegativeButton(R.string.avis_nook, (DialogInterface.OnClickListener) (dialog, id) -> {});

        builder.setView(v);

        message = v.findViewById(R.id.avis_msg);
        message.setText(R.string.avis_msg);

        return builder.create();
    }
}