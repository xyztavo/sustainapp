package br.com.etecia.sustainapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.lifecycle.ViewModelProvider;
import androidx.fragment.app.Fragment;

import br.com.etecia.sustainapp.R;
import br.com.etecia.sustainapp.data.SmartItem;
import br.com.etecia.sustainapp.data.SmartViewModel;
import br.com.etecia.sustainapp.databinding.FragmentCadastroBinding;

/**
 * Fragment para cadastro de itens inteligentes.
 */
public class CadastroFragment extends Fragment {

    private FragmentCadastroBinding binding;
    private SmartViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCadastroBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(SmartViewModel.class);

        binding.btnSave.setOnClickListener(v -> {
            String name = binding.etName.getText().toString().trim();
            String category = binding.etCategory.getText().toString().trim();
            String description = binding.etDescription.getText().toString().trim();

            if (!name.isEmpty() && !category.isEmpty() && !description.isEmpty()) {
                SmartItem item = new SmartItem(name, category, description);
                viewModel.addSmartItem(item);
                Toast.makeText(getContext(), "Item salvo!", Toast.LENGTH_SHORT).show();
                // Limpar campos
                binding.etName.setText("");
                binding.etCategory.setText("");
                binding.etDescription.setText("");
                // Navegar para lista
                Navigation.findNavController(view).navigate(R.id.action_cadastro_to_lista);
            } else {
                Toast.makeText(getContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}