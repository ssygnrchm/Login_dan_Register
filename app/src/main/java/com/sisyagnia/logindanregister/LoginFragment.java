package com.sisyagnia.logindanregister;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends Fragment {

//    private FragmentLoginBinding binding;
    private Button btnFragmentRegister;
    private FloatingActionButton btnLogin;
    public TextInputLayout etUsername, etPassword;

    public LoginFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        etUsername = view.findViewById(R.id.username);
        etPassword = view.findViewById(R.id.password);

        btnFragmentRegister = view.findViewById(R.id.button_register);
        btnFragmentRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment);
            }
        });

        btnLogin = view.findViewById(R.id.button_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getEditText().getText().toString();
                String password = etPassword.getEditText().getText().toString();

                if (username.equals("")||password.equals("")){
                    Toast.makeText(getActivity(),"Silahkan isi field yang masih kosong", Toast.LENGTH_SHORT).show();
                }else{
                    ((MainActivity) getActivity()).LoginUser(username, password);
                }
            }
        });

        return view;
    }

        @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}