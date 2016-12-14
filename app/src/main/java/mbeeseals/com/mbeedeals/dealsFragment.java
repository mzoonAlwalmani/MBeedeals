package mbeeseals.com.mbeedeals;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class dealsFragment extends Fragment {


    public static dealsFragment newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt("argsInstance", instance);
        dealsFragment firstFragment = new dealsFragment();
        firstFragment.setArguments(args);
        return firstFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_request, container, false);

        final TabLayout tabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("إعارة"));
        tabLayout.addTab(tabLayout.newTab().setText("تبرع"));
        tabLayout.addTab(tabLayout.newTab().setText("اجار"));
        tabLayout.addTab(tabLayout.newTab().setText("بيع"));
        tabLayout.addTab(tabLayout.newTab().setText("كل"));

        return view;

    }}
