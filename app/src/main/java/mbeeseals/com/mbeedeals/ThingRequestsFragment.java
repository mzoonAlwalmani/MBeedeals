package mbeeseals.com.mbeedeals;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThingRequestsFragment extends Fragment {


    public static ThingRequestsFragment newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt("argsInstance", instance);
        ThingRequestsFragment firstFragment = new ThingRequestsFragment();
        firstFragment.setArguments(args);
        return firstFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_thing_requests, container, false);

        RelativeLayout Thingview = (RelativeLayout)view.findViewById(R.id.thing);
        View child = getLayoutInflater(savedInstanceState).inflate(R.layout.thing_c_l,container,false);
        Thingview.addView(child);

        return view;
    }

}
