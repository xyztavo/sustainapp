package br.com.etecia.sustainapp.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import br.com.etecia.sustainapp.R;
import br.com.etecia.sustainapp.databinding.FragmentHomeBinding;

/**
 * Fragment Home que exibe cards explicando o conceito de Cidades Inteligentes.
 */
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("HomeFragment", "onCreateView");
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("HomeFragment", "onViewCreated");

        binding.card1.setOnClickListener(v -> {
            Log.d("HomeFragment", "Card1 clicked, navigating to cadastro");
            Navigation.findNavController(view).navigate(R.id.action_home_to_cadastro);
        });

        binding.card2.setOnClickListener(v -> {
            Log.d("HomeFragment", "Card2 clicked");
            // Ação opcional
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}