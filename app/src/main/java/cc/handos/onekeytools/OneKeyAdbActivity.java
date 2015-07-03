package cc.handos.onekeytools;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cc.handos.onekeytools.utils.NetworkUtils;
import cc.handos.onekeytools.utils.ShellUtils;

/**
 * 一键ROOT
 * Created by jimmylee on 7/3/15.
 */
public class OneKeyAdbActivity extends Activity {

    Button btnOneKeyAdb;
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_key_adb);
        btnOneKeyAdb = (Button) findViewById(R.id.btn_one_key_adb);
        tvContent = (TextView) findViewById(R.id.tv_content);
        btnOneKeyAdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text;
                if(oneKeyAdb())
                {
                    text=String.format("请在PC终端输入:\nadb connect %s:5555", NetworkUtils.getLocalIpAddress(OneKeyAdbActivity.this));

                }else
                {
                    text="错误，该手机未ROOT";
                }
                tvContent.setText(text);
            }
        });
    }

    /**
     * 一键开启adb调试
     */
    private boolean oneKeyAdb() {
        String[] commandList = new String[]{
                "setprop service.adb.tcp.port 5555",
                "stop adbd",
                "start adbd"
        };
        return ShellUtils.sudo(commandList);
    }

}
