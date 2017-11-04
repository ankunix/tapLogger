package ankush.tech.taplogger;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private StorageReference mStorageRef;
    private int clicks[] = new int[144];
    private String uid = "EXP001";
    DatabaseReference uidRef = myRef.child(uid);
    private int btnID = 0;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private String filename;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private SensorManager mSensorManager;
    private SensorEventListener mSensorListener;
    private File file;
    private FileOutputStream fOut;
    private OutputStreamWriter writer;
    private String label = "stop";
    private RadioGroup radioGroup;
    private long timestamp;
    private double lastLatitude = 0;
    private double lastLongitude = 0;
    private float[] lastGyroscopeValues = {0, 0, 0};
    private float[] lastAccelerometerValues = {0, 0, 0};
    private float[] lastMagnetometerValues = {0, 0, 0};

    public void snapshot() {
        try {
            writer.append(timestamp + ", " + lastLatitude + ", " + lastLongitude + ", " + lastAccelerometerValues[0] + ", " + lastAccelerometerValues[1] + ", " + lastAccelerometerValues[2] + ", " + lastGyroscopeValues[0] + ", " + lastGyroscopeValues[1] + ", " + lastGyroscopeValues[2] + ", " + lastMagnetometerValues[0] + ", " + lastMagnetometerValues[1] + ", " + lastMagnetometerValues[2] + ", " + btnID + "\n");
            Log.d("a", Long.toString(timestamp));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }


    public void sensorSetup() {
        mSensorManager = (SensorManager) this
                .getSystemService(Context.SENSOR_SERVICE);
        mSensorListener = new SensorEventListener() {
            @Override
            public void onAccuracyChanged(Sensor arg0, int arg1) {
            }

            @Override
            public void onSensorChanged(SensorEvent event) {
                Sensor sensor = event.sensor;
                if (sensor.getType() == Sensor.TYPE_GYROSCOPE) {
                    lastGyroscopeValues = event.values;
                } else if (sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                    lastAccelerometerValues = event.values;
                } else if (sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
                    lastMagnetometerValues = event.values;
                }
                timestamp = event.timestamp;
                snapshot();
            }
        };

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                lastLatitude = location.getLatitude();
                lastLongitude = location.getLongitude();
                snapshot();
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInAnonymously()
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInAnonymously:success");
                            user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInAnonymously:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });


        sensorSetup();

        final Button bt001 = (Button) findViewById(R.id.button1);
        Button bt002 = (Button) findViewById(R.id.button2);
        Button bt003 = (Button) findViewById(R.id.button3);
        Button bt004 = (Button) findViewById(R.id.button4);
        Button bt005 = (Button) findViewById(R.id.button5);
        Button bt006 = (Button) findViewById(R.id.button6);
        Button bt007 = (Button) findViewById(R.id.button7);
        Button bt008 = (Button) findViewById(R.id.button8);
        Button bt009 = (Button) findViewById(R.id.button9);
        Button bt010 = (Button) findViewById(R.id.button10);
        Button bt011 = (Button) findViewById(R.id.button11);
        Button bt012 = (Button) findViewById(R.id.button12);
        Button bt013 = (Button) findViewById(R.id.button13);
        Button bt014 = (Button) findViewById(R.id.button14);
        Button bt015 = (Button) findViewById(R.id.button15);
        Button bt016 = (Button) findViewById(R.id.button16);
        Button bt017 = (Button) findViewById(R.id.button17);
        Button bt018 = (Button) findViewById(R.id.button18);
        Button bt019 = (Button) findViewById(R.id.button19);
        Button bt020 = (Button) findViewById(R.id.button20);
        Button bt021 = (Button) findViewById(R.id.button21);
        Button bt022 = (Button) findViewById(R.id.button22);
        Button bt023 = (Button) findViewById(R.id.button23);
        Button bt024 = (Button) findViewById(R.id.button24);
        Button bt025 = (Button) findViewById(R.id.button25);
        Button bt026 = (Button) findViewById(R.id.button26);
        Button bt027 = (Button) findViewById(R.id.button27);
        Button bt028 = (Button) findViewById(R.id.button28);
        Button bt029 = (Button) findViewById(R.id.button29);
        Button bt030 = (Button) findViewById(R.id.button30);
        Button bt031 = (Button) findViewById(R.id.button31);
        Button bt032 = (Button) findViewById(R.id.button32);
        Button bt033 = (Button) findViewById(R.id.button33);
        Button bt034 = (Button) findViewById(R.id.button34);
        Button bt035 = (Button) findViewById(R.id.button35);
        Button bt036 = (Button) findViewById(R.id.button36);
        Button bt037 = (Button) findViewById(R.id.button37);
        Button bt038 = (Button) findViewById(R.id.button38);
        Button bt039 = (Button) findViewById(R.id.button39);
        Button bt040 = (Button) findViewById(R.id.button40);
        Button bt041 = (Button) findViewById(R.id.button41);
        Button bt042 = (Button) findViewById(R.id.button42);
        Button bt043 = (Button) findViewById(R.id.button43);
        Button bt044 = (Button) findViewById(R.id.button44);
        Button bt045 = (Button) findViewById(R.id.button45);
        Button bt046 = (Button) findViewById(R.id.button46);
        Button bt047 = (Button) findViewById(R.id.button47);
        Button bt048 = (Button) findViewById(R.id.button48);
        Button bt049 = (Button) findViewById(R.id.button49);
        Button bt050 = (Button) findViewById(R.id.button50);
        Button bt051 = (Button) findViewById(R.id.button51);
        Button bt052 = (Button) findViewById(R.id.button52);
        Button bt053 = (Button) findViewById(R.id.button53);
        Button bt054 = (Button) findViewById(R.id.button54);
        Button bt055 = (Button) findViewById(R.id.button55);
        Button bt056 = (Button) findViewById(R.id.button56);
        Button bt057 = (Button) findViewById(R.id.button57);
        Button bt058 = (Button) findViewById(R.id.button58);
        Button bt059 = (Button) findViewById(R.id.button59);
        Button bt060 = (Button) findViewById(R.id.button60);
        Button bt061 = (Button) findViewById(R.id.button61);
        Button bt062 = (Button) findViewById(R.id.button62);
        Button bt063 = (Button) findViewById(R.id.button63);
        Button bt064 = (Button) findViewById(R.id.button64);
        Button bt065 = (Button) findViewById(R.id.button65);
        Button bt066 = (Button) findViewById(R.id.button66);
        Button bt067 = (Button) findViewById(R.id.button67);
        Button bt068 = (Button) findViewById(R.id.button68);
        Button bt069 = (Button) findViewById(R.id.button69);
        Button bt070 = (Button) findViewById(R.id.button70);
        Button bt071 = (Button) findViewById(R.id.button71);
        Button bt072 = (Button) findViewById(R.id.button72);
        Button bt073 = (Button) findViewById(R.id.button73);
        Button bt074 = (Button) findViewById(R.id.button74);
        Button bt075 = (Button) findViewById(R.id.button75);
        Button bt076 = (Button) findViewById(R.id.button76);
        Button bt077 = (Button) findViewById(R.id.button77);
        Button bt078 = (Button) findViewById(R.id.button78);
        Button bt079 = (Button) findViewById(R.id.button79);
        Button bt080 = (Button) findViewById(R.id.button80);
        Button bt081 = (Button) findViewById(R.id.button81);
        Button bt082 = (Button) findViewById(R.id.button82);
        Button bt083 = (Button) findViewById(R.id.button83);
        Button bt084 = (Button) findViewById(R.id.button84);
        Button bt085 = (Button) findViewById(R.id.button85);
        Button bt086 = (Button) findViewById(R.id.button86);
        Button bt087 = (Button) findViewById(R.id.button87);
        Button bt088 = (Button) findViewById(R.id.button88);
        Button bt089 = (Button) findViewById(R.id.button89);
        Button bt090 = (Button) findViewById(R.id.button90);
        Button bt091 = (Button) findViewById(R.id.button91);
        Button bt092 = (Button) findViewById(R.id.button92);
        Button bt093 = (Button) findViewById(R.id.button93);
        Button bt094 = (Button) findViewById(R.id.button94);
        Button bt095 = (Button) findViewById(R.id.button95);
        Button bt096 = (Button) findViewById(R.id.button96);
        Button bt097 = (Button) findViewById(R.id.button97);
        Button bt098 = (Button) findViewById(R.id.button98);
        Button bt099 = (Button) findViewById(R.id.button99);
        Button bt100 = (Button) findViewById(R.id.button100);
        Button bt101 = (Button) findViewById(R.id.button101);
        Button bt102 = (Button) findViewById(R.id.button102);
        Button bt103 = (Button) findViewById(R.id.button103);
        Button bt104 = (Button) findViewById(R.id.button104);
        Button bt105 = (Button) findViewById(R.id.button105);
        Button bt106 = (Button) findViewById(R.id.button106);
        Button bt107 = (Button) findViewById(R.id.button107);
        Button bt108 = (Button) findViewById(R.id.button108);
        Button bt109 = (Button) findViewById(R.id.button109);
        Button bt110 = (Button) findViewById(R.id.button110);
        Button bt111 = (Button) findViewById(R.id.button111);
        Button bt112 = (Button) findViewById(R.id.button112);
        Button bt113 = (Button) findViewById(R.id.button113);
        Button bt114 = (Button) findViewById(R.id.button114);
        Button bt115 = (Button) findViewById(R.id.button115);
        Button bt116 = (Button) findViewById(R.id.button116);
        Button bt117 = (Button) findViewById(R.id.button117);
        Button bt118 = (Button) findViewById(R.id.button118);
        Button bt119 = (Button) findViewById(R.id.button119);
        Button bt120 = (Button) findViewById(R.id.button120);
        Button bt121 = (Button) findViewById(R.id.button121);
        Button bt122 = (Button) findViewById(R.id.button122);
        Button bt123 = (Button) findViewById(R.id.button123);
        Button bt124 = (Button) findViewById(R.id.button124);
        Button bt125 = (Button) findViewById(R.id.button125);
        Button bt126 = (Button) findViewById(R.id.button126);
        Button bt127 = (Button) findViewById(R.id.button127);
        Button bt128 = (Button) findViewById(R.id.button128);
        Button bt129 = (Button) findViewById(R.id.button129);
        Button bt130 = (Button) findViewById(R.id.button130);
        Button bt131 = (Button) findViewById(R.id.button131);
        Button bt132 = (Button) findViewById(R.id.button132);
        Button bt133 = (Button) findViewById(R.id.button133);
        Button bt134 = (Button) findViewById(R.id.button134);
        Button bt135 = (Button) findViewById(R.id.button135);
        Button bt136 = (Button) findViewById(R.id.button136);
        Button bt137 = (Button) findViewById(R.id.button137);
        Button bt138 = (Button) findViewById(R.id.button138);
        Button bt139 = (Button) findViewById(R.id.button139);
        Button bt140 = (Button) findViewById(R.id.button140);
        Button bt141 = (Button) findViewById(R.id.button141);
        Button bt142 = (Button) findViewById(R.id.button142);
        Button bt143 = (Button) findViewById(R.id.button143);
        Button bt144 = (Button) findViewById(R.id.button144);

        View.OnTouchListener btnTouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int i = v.getId() - bt001.getId();
                Log.d("touch:", event.toString());
                uidRef.child("Uid").child(user.getUid()).child("btnID").child(Integer.toString(i)).child("clickID").child(Integer.toString(clicks[i])).setValue(event.toString());

                return false;
            }

            public void screenTouched() {
            }
        };


        View.OnClickListener btnClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = v.getId() - bt001.getId();
                buttonClicked(i);
                updateButton(v, i);
            }

            private void buttonClicked(int i) {
                btnID = i;
                clicks[i]++;
                Log.d("bt\t", Integer.toString(i));
                Log.d("clicks:\t", Integer.toString(clicks[i]));
                uidRef.child("btn").child(Integer.toString(i));
                uidRef.child("clicks").child(Integer.toString(clicks[i]));

            }

            private void updateButton(View v, int i) {
                switch (clicks[i]) {
                    case 1:
                        v.setBackgroundColor(Color.parseColor("#00c0c0"));
                        break;
                    case 2:
                        v.setBackgroundColor(Color.parseColor("#ff040f"));
                        break;
                    case 3:
                        v.setBackgroundColor(Color.parseColor("#00f40f"));
                        break;
                    case 4:
                        v.setBackgroundColor(Color.parseColor("#40f42f"));
                        break;
                    case 5:
                        v.setBackgroundColor(Color.parseColor("#00f40f"));
                        break;
                    case 6:
                        v.setBackgroundColor(Color.parseColor("#60b40c"));
                        break;
                    case 7:
                        v.setBackgroundColor(Color.parseColor("#f0000d"));
                        break;
                    case 8:
                        v.setBackgroundColor(Color.parseColor("#0f4cf1"));
                        break;
                    case 9:
                        v.setBackgroundColor(Color.parseColor("#63f40f"));
                        break;
                    case 10:
                        v.setVisibility(View.INVISIBLE);
                }
            }
        };

        bt001.setOnClickListener(btnClickListener);
        bt002.setOnClickListener(btnClickListener);
        bt003.setOnClickListener(btnClickListener);
        bt004.setOnClickListener(btnClickListener);
        bt005.setOnClickListener(btnClickListener);
        bt006.setOnClickListener(btnClickListener);
        bt007.setOnClickListener(btnClickListener);
        bt008.setOnClickListener(btnClickListener);
        bt009.setOnClickListener(btnClickListener);
        bt010.setOnClickListener(btnClickListener);
        bt011.setOnClickListener(btnClickListener);
        bt012.setOnClickListener(btnClickListener);
        bt013.setOnClickListener(btnClickListener);
        bt014.setOnClickListener(btnClickListener);
        bt015.setOnClickListener(btnClickListener);
        bt016.setOnClickListener(btnClickListener);
        bt017.setOnClickListener(btnClickListener);
        bt018.setOnClickListener(btnClickListener);
        bt019.setOnClickListener(btnClickListener);
        bt020.setOnClickListener(btnClickListener);
        bt021.setOnClickListener(btnClickListener);
        bt022.setOnClickListener(btnClickListener);
        bt023.setOnClickListener(btnClickListener);
        bt024.setOnClickListener(btnClickListener);
        bt025.setOnClickListener(btnClickListener);
        bt026.setOnClickListener(btnClickListener);
        bt027.setOnClickListener(btnClickListener);
        bt028.setOnClickListener(btnClickListener);
        bt029.setOnClickListener(btnClickListener);
        bt030.setOnClickListener(btnClickListener);
        bt031.setOnClickListener(btnClickListener);
        bt032.setOnClickListener(btnClickListener);
        bt033.setOnClickListener(btnClickListener);
        bt034.setOnClickListener(btnClickListener);
        bt035.setOnClickListener(btnClickListener);
        bt036.setOnClickListener(btnClickListener);
        bt037.setOnClickListener(btnClickListener);
        bt038.setOnClickListener(btnClickListener);
        bt039.setOnClickListener(btnClickListener);
        bt040.setOnClickListener(btnClickListener);
        bt041.setOnClickListener(btnClickListener);
        bt042.setOnClickListener(btnClickListener);
        bt043.setOnClickListener(btnClickListener);
        bt044.setOnClickListener(btnClickListener);
        bt045.setOnClickListener(btnClickListener);
        bt046.setOnClickListener(btnClickListener);
        bt047.setOnClickListener(btnClickListener);
        bt048.setOnClickListener(btnClickListener);
        bt049.setOnClickListener(btnClickListener);
        bt050.setOnClickListener(btnClickListener);
        bt051.setOnClickListener(btnClickListener);
        bt052.setOnClickListener(btnClickListener);
        bt053.setOnClickListener(btnClickListener);
        bt054.setOnClickListener(btnClickListener);
        bt055.setOnClickListener(btnClickListener);
        bt056.setOnClickListener(btnClickListener);
        bt057.setOnClickListener(btnClickListener);
        bt058.setOnClickListener(btnClickListener);
        bt059.setOnClickListener(btnClickListener);
        bt060.setOnClickListener(btnClickListener);
        bt061.setOnClickListener(btnClickListener);
        bt062.setOnClickListener(btnClickListener);
        bt063.setOnClickListener(btnClickListener);
        bt064.setOnClickListener(btnClickListener);
        bt065.setOnClickListener(btnClickListener);
        bt066.setOnClickListener(btnClickListener);
        bt067.setOnClickListener(btnClickListener);
        bt068.setOnClickListener(btnClickListener);
        bt069.setOnClickListener(btnClickListener);
        bt070.setOnClickListener(btnClickListener);
        bt071.setOnClickListener(btnClickListener);
        bt072.setOnClickListener(btnClickListener);
        bt073.setOnClickListener(btnClickListener);
        bt074.setOnClickListener(btnClickListener);
        bt075.setOnClickListener(btnClickListener);
        bt076.setOnClickListener(btnClickListener);
        bt077.setOnClickListener(btnClickListener);
        bt078.setOnClickListener(btnClickListener);
        bt079.setOnClickListener(btnClickListener);
        bt080.setOnClickListener(btnClickListener);
        bt081.setOnClickListener(btnClickListener);
        bt082.setOnClickListener(btnClickListener);
        bt083.setOnClickListener(btnClickListener);
        bt084.setOnClickListener(btnClickListener);
        bt085.setOnClickListener(btnClickListener);
        bt086.setOnClickListener(btnClickListener);
        bt087.setOnClickListener(btnClickListener);
        bt088.setOnClickListener(btnClickListener);
        bt089.setOnClickListener(btnClickListener);
        bt090.setOnClickListener(btnClickListener);
        bt091.setOnClickListener(btnClickListener);
        bt092.setOnClickListener(btnClickListener);
        bt093.setOnClickListener(btnClickListener);
        bt094.setOnClickListener(btnClickListener);
        bt095.setOnClickListener(btnClickListener);
        bt096.setOnClickListener(btnClickListener);
        bt097.setOnClickListener(btnClickListener);
        bt098.setOnClickListener(btnClickListener);
        bt099.setOnClickListener(btnClickListener);
        bt100.setOnClickListener(btnClickListener);
        bt101.setOnClickListener(btnClickListener);
        bt102.setOnClickListener(btnClickListener);
        bt103.setOnClickListener(btnClickListener);
        bt104.setOnClickListener(btnClickListener);
        bt105.setOnClickListener(btnClickListener);
        bt106.setOnClickListener(btnClickListener);
        bt107.setOnClickListener(btnClickListener);
        bt108.setOnClickListener(btnClickListener);
        bt109.setOnClickListener(btnClickListener);
        bt110.setOnClickListener(btnClickListener);
        bt111.setOnClickListener(btnClickListener);
        bt112.setOnClickListener(btnClickListener);
        bt113.setOnClickListener(btnClickListener);
        bt114.setOnClickListener(btnClickListener);
        bt115.setOnClickListener(btnClickListener);
        bt116.setOnClickListener(btnClickListener);
        bt117.setOnClickListener(btnClickListener);
        bt118.setOnClickListener(btnClickListener);
        bt119.setOnClickListener(btnClickListener);
        bt120.setOnClickListener(btnClickListener);
        bt121.setOnClickListener(btnClickListener);
        bt122.setOnClickListener(btnClickListener);
        bt123.setOnClickListener(btnClickListener);
        bt124.setOnClickListener(btnClickListener);
        bt125.setOnClickListener(btnClickListener);
        bt126.setOnClickListener(btnClickListener);
        bt127.setOnClickListener(btnClickListener);
        bt128.setOnClickListener(btnClickListener);
        bt129.setOnClickListener(btnClickListener);
        bt130.setOnClickListener(btnClickListener);
        bt131.setOnClickListener(btnClickListener);
        bt132.setOnClickListener(btnClickListener);
        bt133.setOnClickListener(btnClickListener);
        bt134.setOnClickListener(btnClickListener);
        bt135.setOnClickListener(btnClickListener);
        bt136.setOnClickListener(btnClickListener);
        bt137.setOnClickListener(btnClickListener);
        bt138.setOnClickListener(btnClickListener);
        bt139.setOnClickListener(btnClickListener);
        bt140.setOnClickListener(btnClickListener);
        bt141.setOnClickListener(btnClickListener);
        bt142.setOnClickListener(btnClickListener);
        bt143.setOnClickListener(btnClickListener);
        bt144.setOnClickListener(btnClickListener);

        bt001.setOnTouchListener(btnTouchListener);
        bt002.setOnTouchListener(btnTouchListener);
        bt003.setOnTouchListener(btnTouchListener);
        bt004.setOnTouchListener(btnTouchListener);
        bt005.setOnTouchListener(btnTouchListener);
        bt006.setOnTouchListener(btnTouchListener);
        bt007.setOnTouchListener(btnTouchListener);
        bt008.setOnTouchListener(btnTouchListener);
        bt009.setOnTouchListener(btnTouchListener);
        bt010.setOnTouchListener(btnTouchListener);
        bt011.setOnTouchListener(btnTouchListener);
        bt012.setOnTouchListener(btnTouchListener);
        bt013.setOnTouchListener(btnTouchListener);
        bt014.setOnTouchListener(btnTouchListener);
        bt015.setOnTouchListener(btnTouchListener);
        bt016.setOnTouchListener(btnTouchListener);
        bt017.setOnTouchListener(btnTouchListener);
        bt018.setOnTouchListener(btnTouchListener);
        bt019.setOnTouchListener(btnTouchListener);
        bt020.setOnTouchListener(btnTouchListener);
        bt021.setOnTouchListener(btnTouchListener);
        bt022.setOnTouchListener(btnTouchListener);
        bt023.setOnTouchListener(btnTouchListener);
        bt024.setOnTouchListener(btnTouchListener);
        bt025.setOnTouchListener(btnTouchListener);
        bt026.setOnTouchListener(btnTouchListener);
        bt027.setOnTouchListener(btnTouchListener);
        bt028.setOnTouchListener(btnTouchListener);
        bt029.setOnTouchListener(btnTouchListener);
        bt030.setOnTouchListener(btnTouchListener);
        bt031.setOnTouchListener(btnTouchListener);
        bt032.setOnTouchListener(btnTouchListener);
        bt033.setOnTouchListener(btnTouchListener);
        bt034.setOnTouchListener(btnTouchListener);
        bt035.setOnTouchListener(btnTouchListener);
        bt036.setOnTouchListener(btnTouchListener);
        bt037.setOnTouchListener(btnTouchListener);
        bt038.setOnTouchListener(btnTouchListener);
        bt039.setOnTouchListener(btnTouchListener);
        bt040.setOnTouchListener(btnTouchListener);
        bt041.setOnTouchListener(btnTouchListener);
        bt042.setOnTouchListener(btnTouchListener);
        bt043.setOnTouchListener(btnTouchListener);
        bt044.setOnTouchListener(btnTouchListener);
        bt045.setOnTouchListener(btnTouchListener);
        bt046.setOnTouchListener(btnTouchListener);
        bt047.setOnTouchListener(btnTouchListener);
        bt048.setOnTouchListener(btnTouchListener);
        bt049.setOnTouchListener(btnTouchListener);
        bt050.setOnTouchListener(btnTouchListener);
        bt051.setOnTouchListener(btnTouchListener);
        bt052.setOnTouchListener(btnTouchListener);
        bt053.setOnTouchListener(btnTouchListener);
        bt054.setOnTouchListener(btnTouchListener);
        bt055.setOnTouchListener(btnTouchListener);
        bt056.setOnTouchListener(btnTouchListener);
        bt057.setOnTouchListener(btnTouchListener);
        bt058.setOnTouchListener(btnTouchListener);
        bt059.setOnTouchListener(btnTouchListener);
        bt060.setOnTouchListener(btnTouchListener);
        bt061.setOnTouchListener(btnTouchListener);
        bt062.setOnTouchListener(btnTouchListener);
        bt063.setOnTouchListener(btnTouchListener);
        bt064.setOnTouchListener(btnTouchListener);
        bt065.setOnTouchListener(btnTouchListener);
        bt066.setOnTouchListener(btnTouchListener);
        bt067.setOnTouchListener(btnTouchListener);
        bt068.setOnTouchListener(btnTouchListener);
        bt069.setOnTouchListener(btnTouchListener);
        bt070.setOnTouchListener(btnTouchListener);
        bt071.setOnTouchListener(btnTouchListener);
        bt072.setOnTouchListener(btnTouchListener);
        bt073.setOnTouchListener(btnTouchListener);
        bt074.setOnTouchListener(btnTouchListener);
        bt075.setOnTouchListener(btnTouchListener);
        bt076.setOnTouchListener(btnTouchListener);
        bt077.setOnTouchListener(btnTouchListener);
        bt078.setOnTouchListener(btnTouchListener);
        bt079.setOnTouchListener(btnTouchListener);
        bt080.setOnTouchListener(btnTouchListener);
        bt081.setOnTouchListener(btnTouchListener);
        bt082.setOnTouchListener(btnTouchListener);
        bt083.setOnTouchListener(btnTouchListener);
        bt084.setOnTouchListener(btnTouchListener);
        bt085.setOnTouchListener(btnTouchListener);
        bt086.setOnTouchListener(btnTouchListener);
        bt087.setOnTouchListener(btnTouchListener);
        bt088.setOnTouchListener(btnTouchListener);
        bt089.setOnTouchListener(btnTouchListener);
        bt090.setOnTouchListener(btnTouchListener);
        bt091.setOnTouchListener(btnTouchListener);
        bt092.setOnTouchListener(btnTouchListener);
        bt093.setOnTouchListener(btnTouchListener);
        bt094.setOnTouchListener(btnTouchListener);
        bt095.setOnTouchListener(btnTouchListener);
        bt096.setOnTouchListener(btnTouchListener);
        bt097.setOnTouchListener(btnTouchListener);
        bt098.setOnTouchListener(btnTouchListener);
        bt099.setOnTouchListener(btnTouchListener);
        bt100.setOnTouchListener(btnTouchListener);
        bt101.setOnTouchListener(btnTouchListener);
        bt102.setOnTouchListener(btnTouchListener);
        bt103.setOnTouchListener(btnTouchListener);
        bt104.setOnTouchListener(btnTouchListener);
        bt105.setOnTouchListener(btnTouchListener);
        bt106.setOnTouchListener(btnTouchListener);
        bt107.setOnTouchListener(btnTouchListener);
        bt108.setOnTouchListener(btnTouchListener);
        bt109.setOnTouchListener(btnTouchListener);
        bt110.setOnTouchListener(btnTouchListener);
        bt111.setOnTouchListener(btnTouchListener);
        bt112.setOnTouchListener(btnTouchListener);
        bt113.setOnTouchListener(btnTouchListener);
        bt114.setOnTouchListener(btnTouchListener);
        bt115.setOnTouchListener(btnTouchListener);
        bt116.setOnTouchListener(btnTouchListener);
        bt117.setOnTouchListener(btnTouchListener);
        bt118.setOnTouchListener(btnTouchListener);
        bt119.setOnTouchListener(btnTouchListener);
        bt120.setOnTouchListener(btnTouchListener);
        bt121.setOnTouchListener(btnTouchListener);
        bt122.setOnTouchListener(btnTouchListener);
        bt123.setOnTouchListener(btnTouchListener);
        bt124.setOnTouchListener(btnTouchListener);
        bt125.setOnTouchListener(btnTouchListener);
        bt126.setOnTouchListener(btnTouchListener);
        bt127.setOnTouchListener(btnTouchListener);
        bt128.setOnTouchListener(btnTouchListener);
        bt129.setOnTouchListener(btnTouchListener);
        bt130.setOnTouchListener(btnTouchListener);
        bt131.setOnTouchListener(btnTouchListener);
        bt132.setOnTouchListener(btnTouchListener);
        bt133.setOnTouchListener(btnTouchListener);
        bt134.setOnTouchListener(btnTouchListener);
        bt135.setOnTouchListener(btnTouchListener);
        bt136.setOnTouchListener(btnTouchListener);
        bt137.setOnTouchListener(btnTouchListener);
        bt138.setOnTouchListener(btnTouchListener);
        bt139.setOnTouchListener(btnTouchListener);
        bt140.setOnTouchListener(btnTouchListener);
        bt141.setOnTouchListener(btnTouchListener);
        bt142.setOnTouchListener(btnTouchListener);
        bt143.setOnTouchListener(btnTouchListener);
        bt144.setOnTouchListener(btnTouchListener);


        filename = new SimpleDateFormat("yyyyMMddHHmm'_recording.csv'").format(new Date());
        Log.d("r", filename);
        try {
            file = new File(getApplicationContext().getApplicationInfo().dataDir, user.getUid() + filename);
            fOut = new FileOutputStream(file);
            writer = new OutputStreamWriter(fOut);
            writer.append("timestamp, lastLatitude, lastLongitude, lastAccelerometerValues[0], lastAccelerometerValues[1], lastAccelerometerValues[2], lastGyroscopeValues[0], lastGyroscopeValues[1], lastGyroscopeValues[2], lastMagnetometerValues[0], lastMagnetometerValues[1], lastMagnetometerValues[2], label\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        onResume();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME);
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE), SensorManager.SENSOR_DELAY_GAME);
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), SensorManager.SENSOR_DELAY_GAME);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (fOut != null && writer != null) {
            try {
                writer.close();
                fOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        mSensorManager.unregisterListener(mSensorListener);
        locationManager.removeUpdates(locationListener);
        Uri fileURI = Uri.fromFile(file);
        StorageReference childRef = mStorageRef.child(user.getUid());

        childRef.putFile(fileURI);

    }
}