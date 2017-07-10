package im.akari.gittracer.view.activity.common;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import im.akari.gittracer.R;
import im.akari.gittracer.model.entity.User;
import im.akari.gittracer.presenter.contract.LoginContract;
import im.akari.gittracer.presenter.impl.LoginPresenterImpl;
import im.akari.gittracer.view.activity.student.StudentMainActivity;
import im.akari.gittracer.view.activity.teacher.TeacherMainActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    public static final String EXTRA_MESSAGE = "USER_INFO";

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.bt_go)
    Button btGo;
    @BindView(R.id.cv)
    CardView cv;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    LoginContract.Presenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImpl(this);
    }

    @OnClick({R.id.bt_go, R.id.fab})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                getWindow().setExitTransition(null);
                getWindow().setEnterTransition(null);

                ActivityOptions options =
                        ActivityOptions.makeSceneTransitionAnimation(this, fab, fab.getTransitionName());
                startActivity(new Intent(this, RegisterActivity.class), options.toBundle());
                break;
            case R.id.bt_go:
                login();
                break;
        }
    }

    public void login() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        Log.d("username", username);
        Log.d("pw", password);

        loginPresenter.getUserInfo(username, password);
    }


    @Override
    public void enterMain(User user) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        sharedPreferences.edit().putString("username", user.getUsername()).apply();
        sharedPreferences.edit().putString("password", user.getPassword()).apply();
        sharedPreferences.edit().putString("type", user.getType()).apply();
        sharedPreferences.edit().putInt("userId", user.getId()).apply();

        Intent intent;
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_MESSAGE, user);

        if (user.getType().equals("student")) {
            intent = new Intent(this, StudentMainActivity.class);
        } else {
            intent = new Intent(this, TeacherMainActivity.class);
        }
        intent.putExtras(bundle);

        startActivity(intent);
    }

    @Override
    public void showError() {
        CharSequence text = "登陆失败，请重试";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
    }
}
