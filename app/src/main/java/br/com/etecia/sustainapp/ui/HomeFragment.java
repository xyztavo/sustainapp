package br.com.etecia.sustainapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import br.com.etecia.sustainapp.R;
import br.com.etecia.sustainapp.databinding.FragmentHomeBinding;
import br.com.etecia.sustainapp.ui.tabs.Tab1Fragment;
import br.com.etecia.sustainapp.ui.tabs.Tab2Fragment;

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

        // Configurar TabLayout com listener
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Mobilidade"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Sustentabilidade"));

        binding.tabLayout.addOnTabSelectedListener(new com.google.android.material.tabs.TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(com.google.android.material.tabs.TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    binding.tabContent.setText("Mobilidade Inteligente: Sistemas de transporte público eficientes, compartilhamento de veículos e otimização de tráfego.");
                } else {
                    binding.tabContent.setText("Sustentabilidade: Gestão de energia renovável, redução de emissões e preservação ambiental.");
                }
            }

            @Override
            public void onTabUnselected(com.google.android.material.tabs.TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(com.google.android.material.tabs.TabLayout.Tab tab) {}
        });

        // Configurar cards
        binding.card1.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.nav_cadastro);
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