package mbeeseals.com.mbeedeals;

import android.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Bushra on 26/11/16.
 */

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter  {

    final int PAGE_COUNT = 2;
    private Context context;
    private String tabTitles[] ;


    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tabTitles =  new String[] {context.getResources().getString(R.string.guaranteed) ,
                context.getResources().getString(R.string.unguranteed) };
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
      switch (position) {
          case 0:
              return new guranteed();
          case 1 :
              return  new unguranteed();
          default:
              break;
      }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}

