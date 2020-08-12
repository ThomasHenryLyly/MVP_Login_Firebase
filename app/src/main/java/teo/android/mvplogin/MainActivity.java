package teo.android.mvplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import teo.android.mvplogin.presenter.PresenterLogin;
import teo.android.mvplogin.view.Main2Activity;
import teo.android.mvplogin.view.ViewListener;

public class MainActivity extends AppCompatActivity implements ViewListener {
    private EditText edtUser, edtPass;
    private Button btnOk;

    private PresenterLogin presenterLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();

    }

    private void addEvents() {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String password = edtPass.getText().toString();
                presenterLogin.presenter(user, password);
            }
        });
    }

    private void addControls() {
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnOk = findViewById(R.id.btnOk);

        presenterLogin = new PresenterLogin(this);
    }

    @Override
    public void viewSuccess() {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);

        startActivity(intent);
    }

    @Override
    public void viewFailed() {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
    }
}
