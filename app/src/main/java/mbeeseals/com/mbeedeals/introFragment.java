package mbeeseals.com.mbeedeals;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import mbeeseals.com.mbeedeals.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class introFragment extends Fragment {


    public introFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intro, container, false);
     //   ImageButton arrow = (ImageButton) getView().findViewById(R.id.arrowback) ;
      //  arrow.setVisibility(View.GONE);
    }

}
