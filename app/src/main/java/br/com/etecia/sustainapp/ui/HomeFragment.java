package br.com.etecia.sustainapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Configurar TabLayout com ViewPager2
        // Para simplificar, vamos usar um TabLayout com fragments
        // Mas como é MD3, usar TabLayoutMediator

        // Aqui, vamos adicionar conteúdo estático nos cards
        binding.card1.setOnClickListener(v -> {
            // Ação opcional
        });

        binding.card2.setOnClickListener(v -> {
            // Ação opcional
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}