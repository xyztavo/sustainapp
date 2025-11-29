package br.com.etecia.sustainapp.ui;

import android.os.Bundle;
import android.util.Log;
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
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Fragment Home que exibe cards explicando o conceito de Cidades Inteligentes.
 */
public class HomeFragment extends Fragment {

    private SmartViewModel viewModel;
    private SmartItemAdapter adapter;
    private RecyclerView recyclerView;
    private Button btnAddItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("HomeFragment", "onCreateView");
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        btnAddItem = view.findViewById(R.id.btn_add_item);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("HomeFragment", "onViewCreated");

        viewModel = new ViewModelProvider(requireActivity()).get(SmartViewModel.class);
        adapter = new SmartItemAdapter(new ArrayList<>(), new SmartItemAdapter.OnItemClickListener() {
            @Override
            public void onEdit(int position) {
                Log.d("HomeFragment", "Edit clicked for position: " + position);
                SmartItem item = viewModel.getSmartItems().getValue().get(position);
                Bundle bundle = new Bundle();
                bundle.putString("name", item.getName());
                bundle.putString("category", item.getCategory());
                bundle.putString("description", item.getDescription());
                bundle.putInt("position", position);
                Navigation.findNavController(view).navigate(R.id.action_home_to_cadastro, bundle);
            }

            @Override
            public void onDelete(int position) {
                Log.d("HomeFragment", "Delete clicked for position: " + position);
                viewModel.removeItem(position);
            }
        });

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);
        Log.d("HomeFragment", "RecyclerView set up");

        viewModel.getSmartItems().observe(getViewLifecycleOwner(), smartItems -> {
            Log.d("HomeFragment", "Items updated, size: " + smartItems.size());
            adapter.updateItems(smartItems);
        });

        binding.card1.setOnClickListener(v -> {
            Log.d("HomeFragment", "Card1 clicked, navigating to cadastro");
            Navigation.findNavController(view).navigate(R.id.action_home_to_cadastro);
        });

        binding.card2.setOnClickListener(v -> {
            Log.d("HomeFragment", "Card2 clicked");
            // Optional
        });

        binding.btnAddItem.setOnClickListener(v -> {
            Log.d("HomeFragment", "Add item clicked");
            Navigation.findNavController(view).navigate(R.id.action_home_to_cadastro);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}