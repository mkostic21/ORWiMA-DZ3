package hr.ferit.orwimadz3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements ButtonClickListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setUpPager();
    }

    private void setUpPager() {
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

    }

    private void initViews() {
        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onButtonClick(String message) {
        pagerAdapter.setString(message);
        viewPager.setCurrentItem(1);
    }
}