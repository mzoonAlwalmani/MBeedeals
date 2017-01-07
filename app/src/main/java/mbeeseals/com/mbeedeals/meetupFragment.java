package mbeeseals.com.mbeedeals;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class meetupFragment extends Fragment {


    public static meetupFragment newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt("argsInstance", instance);
        meetupFragment firstFragment = new meetupFragment();
        firstFragment.setArguments(args);
        return firstFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_meetup, container, false);

        final TabLayout tabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("مؤكدة"));
        tabLayout.addTab(tabLayout.newTab().setText("غير مؤكده"));

        final TabLayout tabLayout2 = (TabLayout) view.findViewById(R.id.sliding_tabs2);
        tabLayout2.addTab(tabLayout2.newTab().setText("شحن"));
        tabLayout2.addTab(tabLayout2.newTab().setText("لقاء"));

        final TextView text = (TextView) view.findViewById(R.id.textView) ;
        text.setText("مؤكدة");

    tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            if(tabLayout.getSelectedTabPosition() == 0){
                text.setText("مؤكده");
            }else if(tabLayout.getSelectedTabPosition() == 1) {
                text.setText("غير مؤكده");
            }}

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }}

    );








    return view;

}}
