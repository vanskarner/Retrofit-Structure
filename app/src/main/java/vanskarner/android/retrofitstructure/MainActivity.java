package vanskarner.android.retrofitstructure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import vanskarner.android.retrofitstructure.api_service.OnCompleteListener;
import vanskarner.android.retrofitstructure.api_service.request.UserReq;
import vanskarner.android.retrofitstructure.api_service.response.UserRes;
import vanskarner.android.retrofitstructure.api_service.services.UserService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGet = findViewById(R.id.btnGet);
        Button btnPost = findViewById(R.id.btnPost);
        Button btnPut = findViewById(R.id.btnPut);
        Button btnDelete = findViewById(R.id.btnDelete);

        btnGet.setOnClickListener(this);
        btnPost.setOnClickListener(this);
        btnPut.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

    }

    public void setInfo(UserRes userRes) {
        TextView tvId = findViewById(R.id.tvId);
        TextView tvUserId = findViewById(R.id.tvUserId);
        TextView tvBody = findViewById(R.id.tvBody);
        TextView tvTitle = findViewById(R.id.tvTitle);

        String id = String.format(getString(R.string.api_id), String.valueOf(userRes.getId()));
        String userId = String.format(getString(R.string.api_user_id), String.valueOf(userRes.getUserId()));
        String body = String.format(getString(R.string.api_body), String.valueOf(userRes.getBody()));
        String title = String.format(getString(R.string.api_title), String.valueOf(userRes.getTitle()));

        tvId.setText(id);
        tvUserId.setText(userId);
        tvBody.setText(body);
        tvTitle.setText(title);
    }

    public void setInfoDelete() {
        TextView tvId = findViewById(R.id.tvId);
        TextView tvUserId = findViewById(R.id.tvUserId);
        TextView tvBody = findViewById(R.id.tvBody);
        TextView tvTitle = findViewById(R.id.tvTitle);

        String id = String.format(getString(R.string.api_id), "");
        String userId = String.format(getString(R.string.api_user_id), "");
        String body = String.format(getString(R.string.api_body), "");
        String title = String.format(getString(R.string.api_title), "");

        tvId.setText(id);
        tvUserId.setText(userId);
        tvBody.setText(body);
        tvTitle.setText(title);
    }

    public void showProgressBar(){
        ProgressBar progressBar=findViewById(R.id.progressBar);
        progressBar.setIndeterminate(true);
    }
    public void hideProgressBar(){
        ProgressBar progressBar=findViewById(R.id.progressBar);
        progressBar.setIndeterminate(false);
    }

    @Override
    public void onClick(View v) {
        showProgressBar();
        setInfoDelete();
        switch (v.getId()) {
            case R.id.btnGet:
                UserService.posts_GET(new OnCompleteListener<UserRes>() {
                    @Override
                    public void onSuccess(UserRes object) {
                        setInfo(object);
                        hideProgressBar();
                    }

                    @Override
                    public void onFail(String message) {
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        hideProgressBar();
                    }
                });
                break;
            case R.id.btnPost:
                UserReq userReq=new UserReq();
                userReq.setUserId(1);
                userReq.setBody("bar");
                userReq.setTitle("foo");
                UserService.posts_POST(userReq, new OnCompleteListener<UserRes>() {
                    @Override
                    public void onSuccess(UserRes object) {
                        setInfo(object);
                        hideProgressBar();
                    }

                    @Override
                    public void onFail(String message) {
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        hideProgressBar();
                    }
                });
                break;
            case R.id.btnPut:
                UserReq userReq2=new UserReq();
                userReq2.setId(1);
                userReq2.setUserId(1);
                userReq2.setBody("bar");
                userReq2.setTitle("foo");
                UserService.posts_PUT(userReq2, new OnCompleteListener<UserRes>() {
                    @Override
                    public void onSuccess(UserRes object) {
                        setInfo(object);
                        hideProgressBar();
                    }

                    @Override
                    public void onFail(String message) {
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        hideProgressBar();
                    }
                });
                break;
            case R.id.btnDelete:
                UserService.posts_DELETE(new OnCompleteListener<UserRes>() {
                    @Override
                    public void onSuccess(UserRes object) {
                        Toast.makeText(MainActivity.this, "DELETE", Toast.LENGTH_SHORT).show();
                        hideProgressBar();
                    }

                    @Override
                    public void onFail(String message) {
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        hideProgressBar();
                    }
                });
                break;
        }
    }
}
