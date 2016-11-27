package mbeeseals.com.mbeedeals;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Bushra on 27/11/16.
 */

public class MainAdapter extends FragmentPagerAdapter {
    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SearchFragment();
            case 2 :
                return  new signUpFragment();
            case 3 :
                return  new singInFragment();
            case 4 :
                return  new requestFragment();
            case 5 :
                return  new guranteed();


            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
