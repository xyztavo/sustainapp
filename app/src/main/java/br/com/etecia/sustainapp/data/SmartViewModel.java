package br.com.etecia.sustainapp.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewModel para gerenciar a lista de itens inteligentes.
 * Usa LiveData para observar mudanças na lista.
 */
public class SmartViewModel extends ViewModel {
    private final MutableLiveData<List<SmartItem>> smartItems = new MutableLiveData<>(new ArrayList<>());

    public LiveData<List<SmartItem>> getSmartItems() {
        return smartItems;
    }

    public void addSmartItem(SmartItem item) {
        List<SmartItem> currentList = smartItems.getValue();
        if (currentList != null) {
            currentList.add(item);
            smartItems.setValue(currentList);
        }
    }
}