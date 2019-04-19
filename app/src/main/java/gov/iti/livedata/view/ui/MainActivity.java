package gov.iti.livedata.view.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import gov.iti.livedata.viewmodel.MyViewModel;
import gov.iti.livedata.R;

public class MainActivity extends AppCompatActivity {

    MyViewModel viewModel;
    Button incrementBtn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incrementBtn = findViewById(R.id.button);
        incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.incrementCount();
            }
        });
        textView = findViewById(R.id.textView);
        viewModel =ViewModelProviders.of(this).get(MyViewModel.class);
        viewModel.getCount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                //update the textView
                setMyText(integer);
                Toast.makeText(MainActivity.this,"on changed",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void setMyText(Integer count){
        textView.setText(Integer.toString(count));
    }
}
