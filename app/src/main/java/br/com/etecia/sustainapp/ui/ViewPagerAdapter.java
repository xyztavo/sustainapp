package br.com.etecia.sustainapp.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import br.com.etecia.sustainapp.ui.tabs.Tab1Fragment;
import br.com.etecia.sustainapp.ui.tabs.Tab2Fragment;

/**
 * Adapter para ViewPager2 com fragments.
 */
public class ViewPagerAdapter extends androidx.viewpager2.adapter.FragmentStateAdapter {

    private final String[] titles = {"Mobilidade", "Sustentabilidade"};

    public ViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Tab1Fragment();
            case 1:
                return new Tab2Fragment();
            default:
                return new Tab1Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}