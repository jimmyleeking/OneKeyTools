package cc.handos.onekeytools.utils;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by jimmylee on 7/3/15.
 */
public class ShellUtils {

    public static boolean sudo(String... strings) {
        try {
            Process su = Runtime.getRuntime().exec("su");
            DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());

            for (String s : strings) {
                outputStream.writeBytes(s + "\n");
                outputStream.flush();
            }
            outputStream.writeBytes("exit\n");
            outputStream.flush();
            su.waitFor();
            outputStream.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
