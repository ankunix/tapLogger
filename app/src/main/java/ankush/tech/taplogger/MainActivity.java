package ankush.tech.taplogger;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private int clicks[] = new int[144];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


        View.OnClickListener btnClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = v.getId() - bt001.getId();
                buttonClicked(i);
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

            private void buttonClicked(int i) {
                Log.d("bt\t", Integer.toString(i));
                clicks[i]++;
                Log.d("clicks:\t", Integer.toString(clicks[i]));
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
    }
}