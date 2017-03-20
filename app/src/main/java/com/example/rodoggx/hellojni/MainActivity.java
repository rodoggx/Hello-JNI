package com.example.rodoggx.hellojni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String toastStr;
    private String titleStr;

    // Load the 'main-lib' library on application startup.
    static {
        System.loadLibrary("main-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Call to a native method
        TextView titleTV = (TextView) findViewById(R.id.main_title);
        titleStr = string1FromJNI();
        titleTV.setText(titleStr);

        TextView toastTV = (TextView) findViewById(R.id.toast_text);
        toastStr = string2FromJNI();
        toastTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), toastStr, Toast.LENGTH_SHORT).show();
            }
        });

        TextView triangleTV = (TextView) findViewById(R.id.triangle_text);
        triangleTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TriangleActivity.class);
                startActivity(intent);
            }
        });
    }
    /**
     * Native methods implemented by the 'main-lib' native library,
     * which is packaged with this application.
     */
    public native String string1FromJNI();
    public native String string2FromJNI();
}
