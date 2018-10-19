package interviewd;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements Tab1.OnFragmentInteractionListener,Tab2.OnFragmentInteractionListener,Tab3.OnFragmentInteractionListener,Tab4.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupAll();
        UpdateAll();
    }


    //============================================================================================== Methods




    //============================================================================================== Setup

    private void setupAll(){
        setupTabs();
        setupActionButtons();
    }

    private void setupTabs(){

        int[] tabImageIds = {
                R.drawable.home,
                R.drawable.script,
                R.drawable.info,
                R.drawable.settings
        };

        String[] tabNames = getResources().getStringArray(R.array.tabs_text_array);

//        String[] tabNames = {
//                getResources().getString(R.string.tab1_name),
//                getResources().getString(R.string.tab2_name),
//                getResources().getString(R.string.tab3_name),
//                getResources().getString(R.string.tab4_name)
//        };


        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);

        for(int i = 0; i < tabNames.length; i++){
            tabLayout.addTab(tabLayout.newTab().setText(tabNames[i]));
            tabLayout.getTabAt(i).setIcon(tabImageIds[i]);
        }

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setupActionButtons(){

    }



    //============================================================================================== Update

    private void UpdateAll(){

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
