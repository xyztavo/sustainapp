package br.com.etecia.sustainapp.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import br.com.etecia.sustainapp.R;
import br.com.etecia.sustainapp.databinding.FragmentSobreBinding;

/**
 * Fragment Sobre com informações sobre o tema e links.
 */
public class SobreFragment extends Fragment {

    private FragmentSobreBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSobreBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.tvDescription.setText("Uma cidade inteligente é um modelo urbano que utiliza tecnologias avançadas para aprimorar a qualidade de vida e promover a eficiência em diversos setores. Essas cidades empregam infraestrutura inteligente, conectividade e análise de dados para melhorar mobilidade, segurança, sustentabilidade e gestão pública. O objetivo é criar ambientes urbanos mais eficientes, seguros e inclusivos.");

        binding.btnWriBrasil.setOnClickListener(v -> openUrl("https://wribrasil.org.br/"));
        binding.btnMaterialDesign.setOnClickListener(v -> openUrl("https://material.io/design"));
        binding.btnPixabay.setOnClickListener(v -> openUrl("https://pixabay.com/"));
        binding.btnFlaticon.setOnClickListener(v -> openUrl("https://flaticon.com/"));
        binding.btnGoogleFonts.setOnClickListener(v -> openUrl("https://fonts.google.com/"));
        binding.btnGoogleIcons.setOnClickListener(v -> openUrl("https://fonts.google.com/icons"));
    }

    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}