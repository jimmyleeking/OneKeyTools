package cc.handos.onekeytools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnAdb, btnSignature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdb = (Button) findViewById(R.id.btn_adb);
        btnSignature = (Button) findViewById(R.id.btn_signature);

    }


    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()) {
            case R.id.btn_adb: {

                intent.setClass(this,OneKeyAdbActivity.class);

            }
            ;
            break;
            case R.id.btn_signature: {

                intent.setClass(this,null);
            }
            ;
            break;
        }
        startActivity(intent);
    }
}
