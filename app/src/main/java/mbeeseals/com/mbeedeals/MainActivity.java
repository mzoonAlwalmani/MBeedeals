package mbeeseals.com.mbeedeals;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ncapdevi.fragnav.FragNavController;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import net.alhazmy13.catcho.library.Catcho;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;


public class MainActivity extends AppCompatActivity {


    private BottomBar mBottomBar;
    private FragNavController fragNavController;

    //indices to fragments
    private final int TAB_FIRST = FragNavController.TAB1;
    private final int TAB_SECOND = FragNavController.TAB2;
    private final int TAB_THIRD = FragNavController.TAB3;
    private final int TAB_FOURTH = FragNavController.TAB4;
    private final int TAB_FIFTH = FragNavController.TAB5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new Catcho.Builder(this).recipients("bushraawwad93@gmail.com").build());
        setContentView(R.layout.activity_main);

        Toolbar title_bar = (Toolbar) findViewById(R.id.title_bar);
        setSupportActionBar(title_bar);

        final TextView title = (TextView) findViewById(R.id.mytext);
        final ImageButton menu = (ImageButton) findViewById(R.id.menu);
        final View m = (View) findViewById(R.id.k);


        //FragNav
        //list of fragments
        List<Fragment> fragments = new ArrayList<>(5);

        //add fragments to list
        fragments.add(SearchFragment.newInstance(0));
        fragments.add(notifacationFragment.newInstance(0));
        fragments.add(ThingFragment.newInstance(0));
        fragments.add(requestFragment.newInstance(0));
        fragments.add(meetupFragment.newInstance(0));


        //link fragments to container
        fragNavController = new FragNavController(getSupportFragmentManager(), R.id.container, fragments);
        //End of FragNav

        //BottomBar menu
        mBottomBar = (BottomBar) findViewById(R.id.bottomBar);

        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                //switch between tabs
                switch (tabId) {
                    case R.id.itemOne:
                        fragNavController.switchTab(TAB_FIRST);
                        title.setText(R.string.search);
                        break;
                    case R.id.itemTow:
                        fragNavController.switchTab(TAB_SECOND);
                        title.setText(R.string.notification);
                        break;
                    case R.id.itemThree:
                        fragNavController.switchTab(TAB_THIRD);
                        title.setText(R.string.ads);
                        break;
                    case R.id.itemFour:
                        fragNavController.switchTab(TAB_FOURTH);
                        title.setText(R.string.requests);
                        break;
                    case R.id.itemFive:
                        fragNavController.switchTab(TAB_FIFTH);
                        title.setText(R.string.meeting);
                        break;
                }
            }
        });
        mBottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                fragNavController.clearStack();
            }
        });

        //End of BottomBar menu
         menu.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 PopupMenu popup = new PopupMenu(MainActivity.this, menu);
                 popup.getMenuInflater().inflate(R.menu.menu_side, popup.getMenu());

                 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                     public boolean onMenuItemClick(MenuItem item) {
                         Toast.makeText(MainActivity.this,
                                 "You Clicked : " + item.getTitle(),
                                 Toast.LENGTH_SHORT).show();
                         return true;
                     }
                 });
                 MenuPopupHelper menuHelper = new MenuPopupHelper(MainActivity.this,(MenuBuilder) popup.getMenu(), menu);
                 menuHelper.setForceShowIcon(true);
                 menuHelper.show();


             }
         });}
    @Override
    public void onBackPressed() {
        if (fragNavController.getCurrentStack().size() > 1) {
            fragNavController.pop();
        } else {
            super.onBackPressed();
        }
    }




}
