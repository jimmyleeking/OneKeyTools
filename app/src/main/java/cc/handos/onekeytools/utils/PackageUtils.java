package cc.handos.onekeytools.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;


public class PackageUtils {


    public static String getSignature(Context context) {
        Signature[] sigs = new Signature[1];
        try {
            sigs = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES).signatures;

            if (sigs != null) {
                return sigs[0].toCharsString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
