package hemath.com.localbroadcastmanager;

import android.content.*;
import android.support.v4.content.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;

public class MainActivity extends AppCompatActivity {

    private LocalBroadcastManager mLocalBroadcastManager;
    private MyReceiver mMyReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MyReceiver.ACTION_LOCAL_BROADCAST);

        mMyReceiver = new MyReceiver();
        mLocalBroadcastManager.registerReceiver(mMyReceiver, intentFilter);

        findViewById(R.id.cast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MyReceiver.ACTION_LOCAL_BROADCAST);
                intent.putExtra("some_data", "My data");
                mLocalBroadcastManager.sendBroadcast(intent);
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mLocalBroadcastManager != null) {
            mLocalBroadcastManager.unregisterReceiver(mMyReceiver);
        }

    }
}
