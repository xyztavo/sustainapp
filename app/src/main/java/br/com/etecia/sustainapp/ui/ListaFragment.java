package br.com.etecia.sustainapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import br.com.etecia.sustainapp.R;
import br.com.etecia.sustainapp.data.SmartItemAdapter;
import br.com.etecia.sustainapp.data.SmartViewModel;
import br.com.etecia.sustainapp.databinding.FragmentListaBinding;

/**
 * Fragment para listar os itens inteligentes cadastrados.
 */
public class ListaFragment extends Fragment {

    private FragmentListaBinding binding;
    private SmartViewModel viewModel;
    private SmartItemAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentListaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(SmartViewModel.class);
        adapter = new SmartItemAdapter(new ArrayList<>());

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);

        viewModel.getSmartItems().observe(getViewLifecycleOwner(), smartItems -> {
            adapter.updateItems(smartItems);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}