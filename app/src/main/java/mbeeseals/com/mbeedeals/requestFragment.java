package mbeeseals.com.mbeedeals;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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

        final TabLayout tabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("مؤكدة"));
        tabLayout.addTab(tabLayout.newTab().setText("غير مؤكده"));

        final TextView text = (TextView) view.findViewById(R.id.textView) ;
        text.setText("مؤكدة جدا");

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tabLayout.getSelectedTabPosition() == 0){
                  text.setText("مؤكدة");
                }else if(tabLayout.getSelectedTabPosition() == 1) {
                    text.setText("غير مؤكدة");
                }}

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }}

        );
        return view;
    }

}
