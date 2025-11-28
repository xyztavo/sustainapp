package br.com.etecia.sustainapp.ui.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import br.com.etecia.sustainapp.R;
import br.com.etecia.sustainapp.databinding.FragmentTabBinding;

/**
 * Fragment para a aba Mobilidade.
 */
public class Tab1Fragment extends Fragment {

    private FragmentTabBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTabBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.textView.setText("Mobilidade Inteligente: Sistemas de transporte público eficientes, compartilhamento de veículos e otimização de tráfego.");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}