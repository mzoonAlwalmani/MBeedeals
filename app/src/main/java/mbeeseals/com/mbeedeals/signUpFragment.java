package mbeeseals.com.mbeedeals;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.common.SignInButton;

import retrofit2.Call;
import retrofit2.Retrofit;


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
        Button signUp =(Button) getView().findViewById(R.id.register);
     final   EditText name =(EditText) getView().findViewById(R.id.Name);
        final EditText email =(EditText) getView().findViewById(R.id.Email);
        final EditText phone =(EditText) getView().findViewById(R.id.PhoneNumber);
        final EditText password =(EditText) getView().findViewById(R.id.Password);

        TextView title = (TextView) getView().findViewById(R.id.mytext) ;
        title.setText(R.string.Register);

      SignInButton Signup = (SignInButton) getView().findViewById(R.id.google);
        setGooglePlusButtonText(Signup , getString(R.string.google));

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://localhost/webservice/")
                        .build();

                Service service = retrofit.create(Service.class);
                user user= new user();
                user.setName(name.getText().toString());
                user.setEmail(email.getText().toString());
                user.setPhone(phone.getText().toString());
                user.setPassword(password.getText().toString());
                user.setGoogle("0");
                Call<user> call = service.register(user.getName(),user.getPhone(),user.getEmail(),user.getPassword(),user.getGoogle());
            }
        });


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
