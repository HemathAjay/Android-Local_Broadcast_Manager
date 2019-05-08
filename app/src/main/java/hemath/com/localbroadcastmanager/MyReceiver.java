package hemath.com.localbroadcastmanager;

import android.content.*;
import android.widget.*;

public class MyReceiver extends BroadcastReceiver
{
    public static final String ACTION_LOCAL_BROADCAST = "hemath.com.LOCAL";

    @Override
    public void onReceive(Context context,Intent intent) {
        if (intent.getAction().equals(ACTION_LOCAL_BROADCAST))
        {
            String data = intent.getExtras().getString("some_data");
            Toast.makeText(context, data + " received", Toast.LENGTH_SHORT).show();
        }

    }
}
