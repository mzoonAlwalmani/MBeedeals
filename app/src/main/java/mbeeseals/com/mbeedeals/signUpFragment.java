package mbeeseals.com.mbeedeals;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.common.SignInButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class signUpFragment extends Fragment {

    public static signUpFragment newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt("argsInstance", instance);
        signUpFragment firstFragment = new signUpFragment();
        firstFragment.setArguments(args);
        return firstFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      TextView title = (TextView) getView().findViewById(R.id.mytext) ;
        title.setText(R.string.Register);

      SignInButton Signup = (SignInButton) getView().findViewById(R.id.google);
        setGooglePlusButtonText(Signup , getString(R.string.google));
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }
    protected void setGooglePlusButtonText(SignInButton signInButton, String buttonText) {
        // Find the TextView that is inside of the SignInButton and set its text
        for (int i = 0; i < signInButton.getChildCount(); i++) {
            View v = signInButton.getChildAt(i);

            if (v instanceof TextView) {
                TextView tv = (TextView) v;
                tv.setText(buttonText);
                return;
            }
        }
    }
 }
