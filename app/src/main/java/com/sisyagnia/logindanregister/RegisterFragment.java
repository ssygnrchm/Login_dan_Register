package com.sisyagnia.logindanregister;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sisyagnia.logindanregister.databinding.FragmentLoginBinding;
import com.sisyagnia.logindanregister.databinding.FragmentRegisterBinding;

/*
*
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
*/
public class RegisterFragment extends Fragment {
    private FloatingActionButton btnRegister;
    private TextView txtLogin;
    public TextInputLayout etUsername, etPassword, etEmail;


    public RegisterFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        etUsername = view.findViewById(R.id.username);
        etPassword = view.findViewById(R.id.password);
        etEmail = view.findViewById(R.id.email);

        txtLogin = view.findViewById(R.id.text_account);
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment);
            }
        });

        btnRegister = view.findViewById(R.id.button_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = etUsername.getEditText().getText().toString();
                String password = etPassword.getEditText().getText().toString();
                String email = etEmail.getEditText().getText().toString();

                if (username.equals("")||password.equals("")||email.equals("")){
                    Toast.makeText(getActivity(),"Silahkan isi field yang masih kosong", Toast.LENGTH_SHORT).show();
                }else{
                    ((MainActivity) getActivity()).CreateUser(email, password);
                }
            }
        });

        return view;
    }


/*    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }*/


}