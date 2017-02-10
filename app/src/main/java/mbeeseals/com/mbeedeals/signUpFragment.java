package mbeeseals.com.mbeedeals;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.SignInButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


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

        View view =inflater.inflate(R.layout.fragment_sign_up, container, false);

        final Button signUp =(Button) view.findViewById(R.id.register);
        final EditText name =(EditText) view.findViewById(R.id.Name);
        final EditText email =(EditText) view.findViewById(R.id.Email);
        final EditText phone =(EditText) view.findViewById(R.id.PhoneNumber);
        final EditText password =(EditText) view.findViewById(R.id.Password);
        final TextView textView = (TextView) view.findViewById(R.id.msg);

      SignInButton Signup = (SignInButton) view.findViewById(R.id.google);
        setGooglePlusButtonText(Signup , getString(R.string.google));

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.1.40/webservice/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Service service = retrofit.create(Service.class);
                user user= new user();
                user.setName(name.getText().toString());
                user.setEmail(email.getText().toString());
                user.setPhone(phone.getText().toString());
                user.setPassword(password.getText().toString());
                user.setGoogle("0");
                Call<responce> call = service.register(user.getName(),user.getPhone(),user.getEmail(),user.getPassword(),user.getGoogle());
                call.enqueue(new Callback<responce>() {
                    @Override
                    public void onResponse(Call<responce> call, Response<responce> response) {
                        if (response.isSuccessful()) {
                            textView.setText(response.body().getError()+"  "+response.body().getError2());

                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<responce> call, Throwable t) {
                        // something went completely south (like no internet connection)
                        Log.d("Error", t.getMessage());
                    }
                });

            }
        });


        // Inflate the layout for this fragment
        return view;


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
