package hr.ferit.orwimadz3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class InputFragment extends Fragment {

    private EditText edInput;
    private Button btnSubmit;
    private ButtonClickListener clickListener;

    public static InputFragment newInstance() {
        return new InputFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edInput = view.findViewById(R.id.edInput);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        setUpListener();
    }

    private void setUpListener() {
        btnSubmit.setOnClickListener(v -> clickListener.onButtonClick(edInput.getText().toString()));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof ButtonClickListener){
            this.clickListener = (ButtonClickListener) context;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.clickListener = null;
    }

}