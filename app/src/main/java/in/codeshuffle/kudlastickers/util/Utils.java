package in.codeshuffle.kudlastickers.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utils {

    public static class URL{
        public static final String CONTRIBUTE_URL ="https://goo.gl/forms/vCAETXdjoitSFZmm1";
        public static final String FEEDBACK_URL ="https://goo.gl/forms/j7s044gUkp9H1f8k1";
        public static final String LICENSE_URL ="https://github.com/skymansandy/nammaKudlaStickerPack/blob/master/LICENSE";
        public static final String ABOUT_DEV_URL ="http://skymansandy.github.io";
        public static final String OPEN_SOURCE_LICENSE_URL = "https://github.com/skymansandy/nammaKudlaStickerPack/blob/master/LICENSE" ;
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
