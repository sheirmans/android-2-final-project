package com.ucsdextandroid2.android2final;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainMenuFragment extends Fragment {


    public MainMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.am_button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //navigate to instagram activity
                //Navigation.findNavController(requireView())
                //        .navigate(R.id.action_mainMenuFragment_to_instagramActivity);

                //Navigation.findNavController(requireView())
                //        .navigate(MainMenuFragmentDirections.actionMainMenuFragmentToInstagramActivity());
            }
        });

        view.findViewById(R.id.am_button_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //navigate to twitter activity
                //  Navigation.findNavController(requireView())
                //          .navigate(R.id.action_mainMenuFragment_to_twitterActivity);

                //Navigation.findNavController(requireView())
                //        .navigate(MainMenuFragmentDirections.actionMainMenuFragmentToTwitterActivity());
            }
        });

    }
}
