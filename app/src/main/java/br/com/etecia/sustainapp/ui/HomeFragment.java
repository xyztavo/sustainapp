package br.com.etecia.sustainapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayoutMediator;

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

        // Configurar ViewPager2 com TabLayout
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        adapter.addFragment(new Tab1Fragment(), "Mobilidade");
        adapter.addFragment(new Tab2Fragment(), "Sustentabilidade");
        binding.viewPager.setAdapter(adapter);

        new TabLayoutMediator(binding.tabLayout, binding.viewPager,
                (tab, position) -> tab.setText(adapter.getPageTitle(position))
        ).attach();

        // Configurar cards
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