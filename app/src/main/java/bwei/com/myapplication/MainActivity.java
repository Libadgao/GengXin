package bwei.com.myapplication;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tbl_tablayout;
    private ViewPager viewPager;
    private List<String> title = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        tbl_tablayout = findViewById(R.id.tbl_tablayout);
        viewPager = findViewById(R.id.vp_viewpager);
    }

    private void initData() {
        title.add("你的");
        title.add("他的");
        title.add("我的");
        for (int i = 0; i < title.size(); i++) {
            fragments.add(new BlankFragment());
        }

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return title.get(position);
            }
        });
        tbl_tablayout.setupWithViewPager(viewPager);
    }
}
