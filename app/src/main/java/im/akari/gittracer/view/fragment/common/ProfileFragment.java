package im.akari.gittracer.view.fragment.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import im.akari.gittracer.R;
import im.akari.gittracer.model.entity.User;
import im.akari.gittracer.view.activity.common.LoginActivity;


public class ProfileFragment extends Fragment {

    @BindView(R.id.name_label)
    TextView nameText;
    @BindView(R.id.type_label)
    TextView typeText;
    @BindView(R.id.mail_label)
    TextView emailText;
    @BindView(R.id.sex_label)
    TextView genderText;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);

        Intent intent = getActivity().getIntent();
        User user = (User) intent.getExtras().get(LoginActivity.EXTRA_MESSAGE);
        if (user != null) {
            nameText.setText(user.getName());
            typeText.setText(getType(user.getType()));
            genderText.setText(getGender(user.getGender()));
            emailText.setText(user.getEmail());
        }


        return view;
    }

    private String getType(String type) {
        if (type.equals("student")) {
            return "学生";
        } else if (type.equals("teacher")) {
            return "老师";
        } else if (type.equals("admin")) {
            return "管理员";
        }
        return "未知";
    }

    private String getGender(String gender) {
        if (gender.equals("male")) {
            return "男";
        } else if (gender.equals("female")) {
            return "女";
        }
        return "未知";
    }


}
