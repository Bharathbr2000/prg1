package com.example.prg1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout layout = findViewById(R.id.mylay);
        Switch s = findViewById(R.id.switch1);
        ImageButton m = findViewById(R.id.imageButton);

        s.setOnCheckedChangeListener((buttonGroup,isChecked) -> {
            showMessage(isChecked ? "Pressed" : "Not pressed");
        });

        // Initialize CalendarView and set its visibility to GONE


        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarView = new CalendarView(getApplicationContext());
                calendarView.setVisibility(View.GONE);
                layout.addView(calendarView);

                if (calendarView.getVisibility() == View.VISIBLE) {
                    calendarView.setVisibility(View.GONE);
                } else {
                    calendarView.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void showMessage(String m) {
        Toast.makeText(this, m, Toast.LENGTH_SHORT).show();
    }
}