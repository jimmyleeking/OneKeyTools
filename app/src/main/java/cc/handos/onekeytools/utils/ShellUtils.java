package cc.handos.onekeytools.utils;

import java.io.DataOutputStream;

/**
 * Created by jimmylee on 7/3/15.
 */
public class ShellUtils {

    /**
     * 执行shell指令
     * @param strings 指令集
     * @return 指令集是否执行成功
     */
    public static boolean exeCmdByRoot(String... strings) {
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
