package br.com.etecia.sustainapp.ui;

import android.os.Bundle;
import android.util.Log;
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
    private boolean isEditMode = false;
    private int editPosition = -1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("CadastroFragment", "onCreateView");
        binding = FragmentCadastroBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("CadastroFragment", "onViewCreated");

        viewModel = new ViewModelProvider(requireActivity()).get(SmartViewModel.class);

        Bundle args = getArguments();
        if (args != null) {
            String name = args.getString("name");
            String category = args.getString("category");
            String description = args.getString("description");
            editPosition = args.getInt("position", -1);
            if (name != null && category != null && description != null) {
                isEditMode = true;
                binding.etName.setText(name);
                binding.etCategory.setText(category);
                binding.etDescription.setText(description);
                binding.btnSave.setText("Atualizar");
                Log.d("CadastroFragment", "Edit mode, position: " + editPosition);
            }
        }

        binding.btnSave.setOnClickListener(v -> {
            Log.d("CadastroFragment", "Save button clicked");
            String name = binding.etName.getText().toString().trim();
            String category = binding.etCategory.getText().toString().trim();
            String description = binding.etDescription.getText().toString().trim();

            if (!name.isEmpty() && !category.isEmpty() && !description.isEmpty()) {
                SmartItem item = new SmartItem(name, category, description);
                if (isEditMode) {
                    viewModel.updateItem(editPosition, item);
                    Toast.makeText(getContext(), "Item atualizado!", Toast.LENGTH_SHORT).show();
                    Log.d("CadastroFragment", "Item updated");
                } else {
                    viewModel.addSmartItem(item);
                    Toast.makeText(getContext(), "Item salvo!", Toast.LENGTH_SHORT).show();
                    Log.d("CadastroFragment", "Item saved");
                }
                // Limpar campos
                binding.etName.setText("");
                binding.etCategory.setText("");
                binding.etDescription.setText("");
                // Navegar para lista
                Navigation.findNavController(view).navigate(R.id.action_cadastro_to_lista);
                Log.d("CadastroFragment", "Navigated to lista");
            } else {
                Toast.makeText(getContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                Log.d("CadastroFragment", "Fields not filled");
            }
        });

        binding.btnGoLista.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_cadastro_to_lista);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}