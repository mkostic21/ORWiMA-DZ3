package hr.ferit.orwimadz3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class ModularFragment extends Fragment {

    private static final String BUNDLE_TYPE = "fragment type";
    private static final String TEXT_FRAGMENT_TYPE = "text";

    private TextView tvModular;
    private ImageView imgModular;

    public static ModularFragment newInstance(String type) {
        Bundle args = new Bundle();
        ModularFragment fragment = new ModularFragment();
        args.putString(BUNDLE_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_modular, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvModular = view.findViewById(R.id.tvModular);
        imgModular = view.findViewById(R.id.imgModular);
        toggleState();
    }

    private void toggleState() {
        if (getArguments() != null) {
            String argMessage = getArguments().getString(BUNDLE_TYPE);
            if (argMessage.equals(TEXT_FRAGMENT_TYPE)) {
                tvModular.setVisibility(View.VISIBLE);
                imgModular.setVisibility(View.GONE);
            } else {
                tvModular.setVisibility(View.GONE);
                imgModular.setVisibility(View.VISIBLE);
            }
        }
    }
}