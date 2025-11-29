package br.com.etecia.sustainapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import br.com.etecia.sustainapp.R;
import br.com.etecia.sustainapp.data.SmartItem;
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
        adapter = new SmartItemAdapter(new ArrayList<>(), new SmartItemAdapter.OnItemClickListener() {
            @Override
            public void onEdit(int position) {
                SmartItem item = viewModel.getSmartItems().getValue().get(position);
                Bundle bundle = new Bundle();
                bundle.putString("name", item.getName());
                bundle.putString("category", item.getCategory());
                bundle.putString("description", item.getDescription());
                bundle.putInt("position", position);
                Navigation.findNavController(view).navigate(R.id.nav_cadastro, bundle);
            }

            @Override
            public void onDelete(int position) {
                viewModel.removeItem(position);
            }
        });

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