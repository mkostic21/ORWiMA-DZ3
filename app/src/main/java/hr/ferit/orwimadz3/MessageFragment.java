package hr.ferit.orwimadz3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MessageFragment extends Fragment {

    private final static String BUNDLE_MESSAGE = "input";
    private TextView tvMessage;

    public static MessageFragment newInstance(String message) {
        Bundle args = new Bundle();
        MessageFragment fragment = new MessageFragment();
        args.putString(BUNDLE_MESSAGE, message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvMessage = view.findViewById(R.id.tvMessage);
        displayMessage();
    }

    public void displayMessage(){
        if(getArguments() != null){
            String argMessage = getArguments().getString(BUNDLE_MESSAGE);
            if(argMessage != null && !argMessage.isEmpty()){
                tvMessage.setText(argMessage);
            }
        }
    }

}