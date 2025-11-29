package br.com.etecia.sustainapp.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import br.com.etecia.sustainapp.R;
import br.com.etecia.sustainapp.databinding.ActivityMainBinding;

/**
 * MainActivity que hospeda o NavHostFragment para navegação entre fragments.
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "onCreate started");
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Log.d("MainActivity", "setContentView done");

        setSupportActionBar(binding.appBarMain.toolbar);
        Log.d("MainActivity", "toolbar set");

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment_content_main);
        Log.d("MainActivity", "navHostFragment: " + navHostFragment);
        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();
            Log.d("MainActivity", "navController: " + navController);

            appBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.nav_home, R.id.nav_cadastro, R.id.nav_lista, R.id.nav_sobre)
                    .setOpenableLayout(binding.drawerLayout)
                    .build();
            Log.d("MainActivity", "appBarConfiguration created");

            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
            Log.d("MainActivity", "setupActionBarWithNavController done");
            NavigationUI.setupWithNavController(binding.navView, navController);
            Log.d("MainActivity", "setupWithNavController navView done");
            NavigationUI.setupWithNavController(binding.appBarMain.bottomNavigation, navController);
            Log.d("MainActivity", "setupWithNavController bottomNavigation done");
        } else {
            Log.e("MainActivity", "navHostFragment is null");
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.d("MainActivity", "onCreate finished");
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment_content_main);
        NavController navController = navHostFragment.getNavController();
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}