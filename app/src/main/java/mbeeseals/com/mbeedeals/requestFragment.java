package mbeeseals.com.mbeedeals;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.

 */
public class requestFragment  extends Fragment {

    ViewPager viewPager;
    SampleFragmentPagerAdapter ft;

    public static requestFragment newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt("argsInstance", instance);
        requestFragment firstFragment = new requestFragment();
        firstFragment.setArguments(args);
        return firstFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_request, container, false);


        viewPager= (ViewPager) view.findViewById(R.id.viewpager);
        ft = new SampleFragmentPagerAdapter(getChildFragmentManager() , view.getContext());
        viewPager.setAdapter(ft);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

}
