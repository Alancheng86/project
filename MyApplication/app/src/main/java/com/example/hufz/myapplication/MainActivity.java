package com.example.hufz.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.example.hufz.myapplication.TempControlView;



public class MainActivity extends AppCompatActivity {

    private TempControlView tempControl;
    private String[] areas = new String[]{"1H","2H", "3H", "4H", "5H", "6H", "7H","8H","9H","10H","11H","12H" };
    private boolean[] areaState=new boolean[]{true, false, false, false, false, false,false,false,false,false,false,false };
    private ListView areaCheckListView;
    private Button Button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempControl = (TempControlView) findViewById(R.id.temp_control);
        tempControl.setTemp(25, 85, 25);

        tempControl.setOnTempChangeListener(new TempControlView.OnTempChangeListener() {
            @Override
            public void change(int temp) {
/*这里是显示温度数字的代码，屏蔽之*/
             /*   Toast.makeText(MainActivity.this, temp + "°C"+"C", Toast.LENGTH_SHORT).show();
            */

            }
        });
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        Button=(Button)findViewById(R.id.Button);

        Button.setOnClickListener(new CheckBoxClickListener());

    }



    class CheckBoxClickListener implements OnClickListener{
        @Override
        public void onClick(View v) {
            AlertDialog ad = new AlertDialog.Builder(MainActivity.this)
                    .setTitle("定时设定")
                    .setMultiChoiceItems(areas,areaState,new DialogInterface.OnMultiChoiceClickListener(){
                        public void onClick(DialogInterface dialog,int whichButton, boolean isChecked){
                            //点击某个区域
                        }
                    }).setPositiveButton("确定",new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog,int whichButton){
                            /*这里是显示弹出字符的代码，屏蔽之*/
                        /*    String s = "您选择了:";*/
                          /*  for (int i = 0; i < areas.length; i++){
                                if (areaCheckListView.getCheckedItemPositions().get(i)){
                                    s += i + ":"+ areaCheckListView.getAdapter().getItem(i)+ "  ";
                                }else{
                                    areaCheckListView.getCheckedItemPositions().get(i,false);
                                }
                            }*/
                            /*if (areaCheckListView.getCheckedItemPositions().size() > 0){
                                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                            }else{
                                //没有选择
                            }*/
                            dialog.dismiss();
                        }
                    }).setNegativeButton("取消", null).create();
            areaCheckListView = ad.getListView();
            ad.show();
        }
    }



}

