package mbeeseals.com.mbeedeals;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mbeeseals.com.mbeedeals.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    public static SearchFragment newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt("argsInstance", instance);
        SearchFragment firstFragment = new SearchFragment();
        firstFragment.setArguments(args);
        return firstFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }



}
