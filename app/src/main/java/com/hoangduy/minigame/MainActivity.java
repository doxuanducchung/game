package com.hoangduy.minigame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtScore, txtThongbao;
    ImageView imgAnimal;
    CheckBox cbPikachu, cbSquirtle, cbMeowth;
    ImageButton btnPlay, btnMoney;
    SeekBar sbPikachu, sbMeowth, sbSquirtle;
    int Score= 100 ;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        txtScore.setText(""+ Score);
        final CountDownTimer countDownTimer = new CountDownTimer(60000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                int so = 2;
                Random random = new Random();
                int meowth = random.nextInt(so);
                int pikachu = random.nextInt(so);
                int squirtle = random.nextInt(so);
                if (sbMeowth.getProgress() >= sbMeowth.getMax()){
                    this.cancel();
                    btnPlay.setVisibility(View.VISIBLE);
                    if(cbMeowth.isChecked()==true){
                        Score += 10;
                        txtThongbao.setText(cbMeowth.getText() + " WIN - Bạn đã chọn đúng");
                        Toast.makeText(MainActivity.this,"+10 điểm",Toast.LENGTH_SHORT).show();
                    }else{
                        Score -=5;
                        if (sbPikachu.getProgress()>= sbPikachu.getMax()){
                            txtThongbao.setText(cbPikachu.getText() + " WIN - Rất tiếc! Bạn đã chọn sai");
                        }
                        if (sbSquirtle.getProgress()>= sbSquirtle.getMax()){
                            txtThongbao.setText(cbSquirtle.getText() + " WIN - Rất tiếc! Bạn đã chọn sai");
                        }else {
                            txtThongbao.setText(cbMeowth.getText() + " WIN - Rất tiếc! Bạn đã chọn sai");
                        }
                        Toast.makeText(MainActivity.this,"-5 điểm",Toast.LENGTH_SHORT).show();
                    }
                    txtScore.setText(Score +"");
                    EnableCheckBox();
                }
                if (sbPikachu.getProgress() >= sbPikachu.getMax()){
                    this.cancel();
                    btnPlay.setVisibility(View.VISIBLE);
                    if(cbPikachu.isChecked()==true){
                        Score += 10;
                        txtThongbao.setText(cbPikachu.getText() + " WIN - Bạn đã chọn đúng");
                        Toast.makeText(MainActivity.this,"+10 điểm",Toast.LENGTH_SHORT).show();
                    }else{
                        Score -=5;
                        if (sbMeowth.getProgress()>= sbMeowth.getMax()){
                            txtThongbao.setText(cbMeowth.getText() + " WIN - Rất tiếc! Bạn đã chọn sai");
                        }
                        if (sbSquirtle.getProgress()>= sbSquirtle.getMax()){
                            txtThongbao.setText(cbSquirtle.getText() + " WIN - Rất tiếc! Bạn đã chọn sai");
                        }else {
                            txtThongbao.setText(cbPikachu.getText() + " WIN - Rất tiếc! Bạn đã chọn sai");
                        }
                        Toast.makeText(MainActivity.this,"-5 điểm",Toast.LENGTH_SHORT).show();
                    }
                    txtScore.setText(Score +"");
                    EnableCheckBox();
                }
                if (sbSquirtle.getProgress() >= sbSquirtle.getMax()){
                    this.cancel();
                    btnPlay.setVisibility(View.VISIBLE);
                    if(cbSquirtle.isChecked()==true){
                        Score += 10;
                        txtThongbao.setText(cbSquirtle.getText() + " WIN - Bạn đã chọn đúng");
                        Toast.makeText(MainActivity.this,"+10 điểm",Toast.LENGTH_SHORT).show();
                    }else{
                        Score -=5;
                        if (sbMeowth.getProgress()>= sbMeowth.getMax()){
                            txtThongbao.setText(cbMeowth.getText() + " WIN - Rất tiếc! Bạn đã chọn sai");
                        }
                        if (sbPikachu.getProgress()>= sbPikachu.getMax()){
                            txtThongbao.setText(cbPikachu.getText() + " WIN - Rất tiếc! Bạn đã chọn sai");
                        }else {
                            txtThongbao.setText(cbSquirtle.getText() + " WIN - Rất tiếc! Bạn đã chọn sai");
                        }
                        Toast.makeText(MainActivity.this,"-5 điểm",Toast.LENGTH_SHORT).show();
                    }
                    txtScore.setText(Score +"");
                    EnableCheckBox();
                }
                sbMeowth.setProgress(sbMeowth.getProgress() + meowth);
                sbPikachu.setProgress(sbPikachu.getProgress() + pikachu);
                sbSquirtle.setProgress(sbSquirtle.getProgress() + squirtle);
            }

            @Override
            public void onFinish() {

            }
        };
            btnPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Score ==0){
                        txtThongbao.setText("Bạn vui lòng mua thêm điểm");
                    }else{
                        if (cbMeowth.isChecked() || cbPikachu.isChecked() || cbSquirtle.isChecked()){
                            sbMeowth.setProgress(0);
                            sbPikachu.setProgress(0);
                            sbSquirtle.setProgress(0);
                            txtThongbao.setText("Cuộc đua bắt đầu ....");
                            btnPlay.setVisibility(View.INVISIBLE);
                            countDownTimer.start();
                            DisableCheckBox();
                            DisableSeekBar();
                        }else {
                            txtThongbao.setText("Vui lòng chọn một Pokemon để bắt đầu");
                        }
                    }
                }
            });
            btnMoney.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i<3){
                        Score = Score + 20;
                        txtScore.setText(Score+"");
                        int a = 2- i;
                        Toast.makeText(MainActivity.this, "Bạn được cộng thêm 20 điểm. Bạn còn " + a + " lượt", Toast.LENGTH_SHORT).show();
                        i++;
                    }else {
                        Toast.makeText(MainActivity.this, "Bạn đã sử dụng hết số lần miễn phí", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            cbMeowth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean a) {
                    if (a){
                        txtThongbao.setText("Bạn đã chọn: " + cbMeowth.getText());
                        cbPikachu.setChecked(false);
                        cbSquirtle.setChecked(false);
                    }
                }
            });
            cbPikachu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean a) {
                    if (a){
                        txtThongbao.setText("Bạn đã chọn: " + cbPikachu.getText());
                        cbSquirtle.setChecked(false);
                        cbMeowth.setChecked(false);
                    }
                }
            });
            cbSquirtle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean a) {
                    if( a){
                        txtThongbao.setText("Bạn đã chọn: " + cbSquirtle.getText());
                        cbMeowth.setChecked(false);
                        cbPikachu.setChecked(false);
                    }
                }
            });
    }
    private void DisableCheckBox () {
        cbMeowth.setEnabled(false);
        cbPikachu.setEnabled(false);
        cbSquirtle.setEnabled(false);
    }
    private void DisableSeekBar (){
        sbMeowth.setEnabled(false);
        sbPikachu.setEnabled(false);
        sbSquirtle.setEnabled(false);
    }
    private void EnableCheckBox (){
        cbMeowth.setEnabled(true);
        cbPikachu.setEnabled(true);
        cbSquirtle.setEnabled(true);
    }
    private void Anhxa(){
        txtScore = (TextView) findViewById(R.id.textViewMoney);
        txtThongbao = (TextView) findViewById(R.id.textViewThongbao);
        btnPlay = (ImageButton) findViewById(R.id.buttonPlay);
        imgAnimal = (ImageView) findViewById(R.id.imageViewLogo);
        btnMoney = (ImageButton) findViewById(R.id.imageButtonMoney);
        cbMeowth = (CheckBox) findViewById(R.id.checkBoxMeowth);
        cbPikachu = (CheckBox) findViewById(R.id.checkBoxPikachu);
        cbSquirtle = (CheckBox) findViewById(R.id.checkBoxSquirtle);
        sbMeowth = (SeekBar) findViewById(R.id.seekBarMeowth);
        sbPikachu = (SeekBar) findViewById(R.id.seekBarPikachu);
        sbSquirtle = (SeekBar) findViewById(R.id.seekBarSquirtle);
    }
}
