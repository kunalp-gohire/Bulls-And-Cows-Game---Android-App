package tk.kunalgohire.bulls_and_cows;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText pos1;
    EditText pos2;
    EditText pos3;
    EditText pos4;
    TextView c;
    TextView b;
    TextView trials;
    TextView tvDisplay;
    //TextView ans;
    int check1=0,check2=0,check3=0;
    int min=1,max=9;
    int rand1=0,rand2=0,rand3=0,rand4=0;
    int check4=0,countc=0,countb=0,count=0,trial=7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //random numbers generator
        Random random = new Random();
        rand1=random.nextInt(max - min + 1) + min;
        rand2=random.nextInt(10);
        rand3=random.nextInt(10);
        rand4=random.nextInt(10);

        pos1=(EditText)findViewById(R.id.editText1);
        pos2=(EditText)findViewById(R.id.editText2);
        pos3=(EditText)findViewById(R.id.editText3);
        pos4=(EditText)findViewById(R.id.editText4);
        trials=(TextView)findViewById(R.id.textView_trials);
        c=findViewById(R.id.textView_cows);
        b=findViewById(R.id.textView_Bulls);
        tvDisplay=findViewById(R.id.tvDisplay);
        Button b1=(Button)findViewById(R.id.button1);

        trials.setText("Trails Left : "+trial);
        c.setText("Cows : "+countc+"");
        b.setText("Bulls : "+countb+"");
        tvDisplay.setText("ENTER NUMBER");
//      ans=findViewById(R.id.textViewans);
//      ans.setText(""+rand1+rand2+rand3+rand4);
    }
    public void Clear(){
        pos1.getText().clear();
        pos2.getText().clear();
        pos3.getText().clear();
        pos4.getText().clear();
    }
    public void click(View view) {
        check1=Integer.parseInt(pos1.getText().toString());
        check2=Integer.parseInt(pos2.getText().toString());
        check3=Integer.parseInt(pos3.getText().toString());
        check4=Integer.parseInt(pos4.getText().toString());
        countcow.clear();
        checkwin();
//      to set cursor in first editText
        pos1.requestFocus();
        count++;
        trial=7;
        trial=trial-count;
        trials.setText("Trails Left: "+""+trial);
        if(countb==4)
        {
            Toast.makeText(getApplicationContext(),"You Are have guessed correct number",Toast.LENGTH_LONG).show();
            Clear();
            recreate();
        }
        if(count==7)
        {
            Toast.makeText(getApplicationContext(),"You Are Out of Attempts. The Number Was "+rand1+rand2+rand3+rand4,Toast.LENGTH_LONG).show();
            Clear();
            recreate();
        }
    }
    ArrayList<Integer>countcow=new ArrayList<Integer>();
    public int count_cow(int check)
    {
        int cc=0;
        if((check==rand1)&&(!(countcow.contains(rand1)))){
            cc++;
            countcow.add(rand1);
        }
        else if((check==rand2)&&(!(countcow.contains(rand2)))){
            cc++;
            countcow.add(rand2);
        }
        else if((check==rand3)&&(!(countcow.contains(rand3)))){
            cc++;
            countcow.add(rand3);
        }
        else if((check==rand4)&&(!(countcow.contains(rand4)))){
            cc++;
            countcow.add(rand4);
        }
        return cc;
    }
    public void checkwin(){
        countb=0;
        countc=0;
        // counting bulls
        if(check1==rand1)countb++;
        if(check2==rand2)countb++;
        if(check3==rand3)countb++;
        if(check4==rand4)countb++;
        b.setText("Bulls : "+countb+"");

        //counting cows
        countc=countc+count_cow(check1);
        countc=countc+count_cow(check2);
        countc=countc+count_cow(check3);
        countc=countc+count_cow(check4);
        c.setText("Cows : "+countc+"");
    }
}