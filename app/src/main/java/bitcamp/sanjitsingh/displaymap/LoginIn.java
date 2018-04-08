package bitcamp.sanjitsingh.displaymap;

/**
 * Created by sanjit singh and Micheal Zhou on 4/7/18.
 */

import android.app.Activity;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;
import com.facebook.*;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import java.util.Arrays;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginIn extends AppCompatActivity {
    TextView txtStatus;
    LoginButton login_button;
    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.log);
      //initializeControls();
        // loginWithFB();
        Button button1 = (Button) findViewById(R.id.login_button);

        button1.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                Intent i = new Intent(LoginIn.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
