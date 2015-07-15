package cc.handos.onekeytools;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cc.handos.onekeytools.utils.PackageUtils;

/**
 * Created by jimmylee on 7/15/15.
 */
public class SignatureActivity extends Activity {

    Button btnGet;
    EditText etPackageName;
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btnGet = (Button) findViewById(R.id.btn_get);
        etPackageName = (EditText) findViewById(R.id.et_package);
        tvContent =
                (TextView) findViewById(R.id.tv_content);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String name=etPackageName.getText().toString();
                tvContent.setText(PackageUtils.getSignature(SignatureActivity.this));
            }
        });

    }


}
