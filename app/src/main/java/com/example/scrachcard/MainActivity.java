package com.example.scrachcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.StackView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.anupkumarpanwar.scratchview.ScratchView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    StackView stackView;
    ImageView image;
    ScratchView view;
    Button btn;
    Switch aswitch;
    TextView text, skim;
    ArrayList<Model> arrmodel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);
        view = findViewById(R.id.srachview);
        btn = findViewById(R.id.btn);
        skim = findViewById(R.id.txtdollar);
        aswitch = findViewById(R.id.sswitch);
        text = findViewById(R.id.txtoff);
        stackView = findViewById(R.id.stackview);

        arrmodel.add(new Model(R.drawable.goggles, "50% OFF"));
        arrmodel.add(new Model(R.drawable.pizza, "Delevery Free"));
        arrmodel.add(new Model(R.drawable.carts, "20% Discount"));
        arrmodel.add(new Model(R.drawable.coin, "5000 $"));
        arrmodel.add(new Model(R.drawable.trophy, "You Are Win Tropy"));
        arrmodel.add(new Model(R.drawable.lunchbox, "40% OFF"));


        scrtch();

        Stack_Adapter adapter = new Stack_Adapter(arrmodel,MainActivity.this);

        stackView.setAdapter(adapter);

        aswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    text.setText("ON");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        text.setTextColor(getColor(R.color.GREEN));
                    }
                } else {
                    text.setText("OFF");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        text.setTextColor(getColor(R.color.RED));
                    }
                }
            }
        });

        view.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {

                Toast.makeText(MainActivity.this, "Reveled!", Toast.LENGTH_SHORT).show();
                view.reveal();
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.mask();
                scrtch();

            }
        });
    }

    public void scrtch() {
        int r = new Random().nextInt(arrmodel.size());
        image.setImageResource(arrmodel.get(r).getImage());
        skim.setText(arrmodel.get(r).getSkim());
    }

}