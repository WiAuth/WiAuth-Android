package com.hackerchai.wiauth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.hackerchai.wiauth.udpService.udpService;
import com.hackerchai.wiauth.tcpService.tcpService;


public class networkExecute extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_execute);
        Button mSendBroadcast =(Button)findViewById(R.id.broadcast);
        mSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendBroadcst= new Intent(networkExecute.this,udpService.class);
                startService(sendBroadcst);


            }
        });
        Button pair =(Button)findViewById(R.id.pair);
        pair.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent createPairkey =new Intent(networkExecute.this,createPairKey.class);
                        startActivity(createPairkey);

                    }
                }
        );
        Button startTcp = (Button)findViewById(R.id.startTcp);
        startTcp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent startTcpService =new Intent(networkExecute.this,tcpService.class);
                        startService(startTcpService);
                    }
                }
        );

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_network_execute, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
