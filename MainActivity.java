package com.tlians.ttt;

import android.app.AlertDialog;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {




    TextView turn;
    EditText p1;
    EditText p2;
    Button start;
    Button about;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Boolean player1;
    Boolean player2;
    Boolean game;
    int p1wins;
    int p2wins;
    int winner=0;
    int[] B=new int[10];

    public void check(){
        final AlertDialog win1=new AlertDialog.Builder(this).create();
        win1.setTitle("P1 Won");
        win1.setMessage("Player 1 Won The Game\nReturn & Restart to play again");

        final AlertDialog win2=new AlertDialog.Builder(this).create();
        win2.setTitle("P2 Won");
        win2.setMessage("Player 2 Won The Game\nReturn & Restart to play again");

        if((B[1]==1&&B[2]==1&&B[3]==1)||(B[4]==1&&B[5]==1&&B[6]==1)||(B[7]==1&&B[8]==1&&B[9]==1)||(B[1]==1&&B[5]==1&&B[9]==1)||(B[3]==1&&B[5]==1&&B[7]==1)||(B[1]==1&&B[4]==1&&B[7]==1)||(B[2]==1&&B[5]==1&&B[8]==1)||(B[3]==1&&B[6]==1&&B[9]==1)){
            game=false;
            p1wins++;
            winner=1;
            turn.setText("P1 Won");
            turn.setTextColor(Color.RED);
            win1.show();
        }
        if((B[1]==2&&B[2]==2&&B[3]==2)||(B[4]==2&&B[5]==2&&B[6]==2)||(B[7]==2&&B[8]==2&&B[9]==2)||(B[1]==2&&B[5]==2&&B[9]==2)||(B[3]==2&&B[5]==2&&B[7]==2)||(B[1]==2&&B[4]==2&&B[7]==2)||(B[2]==2&&B[5]==2&&B[8]==2)||(B[3]==2&&B[6]==2&&B[9]==2)){
            game=false;
            p2wins++;
            winner=2;
            turn.setText("P2 Won");
            turn.setTextColor(Color.BLUE);
            win2.show();
        }

        p1.setText(""+p1wins);
        p2.setText(""+p2wins);

    }

    public void Start() {
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
        game=true;

        if (winner == 0) {
            player1 = true;
            player2 = false;
            game = true;
            turn.setText("P1 Turn");
            turn.setTextColor(Color.RED);

        }
        else if(winner==1){
            player1=true;
            player2=false;
            turn.setText("P1 Turn");
            turn.setTextColor(Color.RED);

        }
        else if(winner==2){
            player1=false;
            player2=true;
            turn.setText("P2 Turn");
            turn.setTextColor(Color.BLUE);

        }
        for(int i=1;i<=9;i++)
            B[i]=0;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final AlertDialog ta=new AlertDialog.Builder(this).create();
        ta.setTitle("About Tic Tac Toe");
        ta.setMessage("Written by Tanweer Ahmad\n14TL02@Student.Muet.Edu.Pk\nPress Back Key to Return");




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turn=(TextView) findViewById(R.id.turn);
        p1=(EditText) findViewById(R.id.p1);
        p2=(EditText) findViewById(R.id.p2);
        start=(Button) findViewById(R.id.start);
        about=(Button) findViewById(R.id.about);
        b1=(Button) findViewById(R.id.b1);
        b2=(Button) findViewById(R.id.b2);
        b3=(Button) findViewById(R.id.b3);
        b4=(Button) findViewById(R.id.b4);
        b5=(Button) findViewById(R.id.b5);
        b6=(Button) findViewById(R.id.b6);
        b7=(Button) findViewById(R.id.b7);
        b8=(Button) findViewById(R.id.b8);
        b9=(Button) findViewById(R.id.b9);


        p1wins=0;
        p2wins=0;
        game=false;


        start.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Start();
            }
        });

        about.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                ta.show();
            }
        });


        b1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(game==true){
                    if(player1==true){
                        b1.setText("X");
                        b1.setTextColor(Color.RED);
                        B[1]=1;
                        player1=false;
                        player2=true;
                        turn.setText("P2 Turn");
                        turn.setTextColor(Color.BLUE);
                        b1.setEnabled(false);
                    }
                    else{
                        b1.setText("O");
                        b1.setTextColor(Color.BLUE);
                        B[1]=2;
                        player1=true;
                        player2=false;
                        turn.setText("P1 Turn");
                        turn.setTextColor(Color.RED);
                        b1.setEnabled(false);
                    }
                    check();
                }
            }
        });
        b2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(game==true){
                    if(player1==true){
                        b2.setText("X");
                        b2.setTextColor(Color.RED);
                        B[2]=1;
                        player1=false;
                        player2=true;
                        turn.setText("P2 Turn");
                        turn.setTextColor(Color.BLUE);
                        b2.setEnabled(false);
                    }
                    else{
                        b2.setText("O");
                        b2.setTextColor(Color.BLUE);
                        B[2]=2;
                        player1=true;
                        player2=false;
                        turn.setText("P1 Turn");
                        turn.setTextColor(Color.RED);
                        b2.setEnabled(false);
                    }
                    check();
                }
            }
        });
        b3.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(game==true){
                    if(player1==true){
                        b3.setText("X");
                        b3.setTextColor(Color.RED);
                        B[3]=1;
                        player1=false;
                        player2=true;
                        turn.setText("P2 Turn");
                        turn.setTextColor(Color.BLUE);
                        b3.setEnabled(false);
                    }
                    else{
                        b3.setText("O");
                        b3.setTextColor(Color.BLUE);
                        B[3]=2;
                        player1=true;
                        player2=false;
                        turn.setText("P1 Turn");
                        turn.setTextColor(Color.RED);
                        b3.setEnabled(false);
                    }
                    check();
                }
            }
        });
        b4.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(game==true){
                    if(player1==true){
                        b4.setText("X");
                        b4.setTextColor(Color.RED);
                        B[4]=1;
                        player1=false;
                        player2=true;
                        turn.setText("P2 Turn");
                        turn.setTextColor(Color.BLUE);
                        b4.setEnabled(false);
                    }
                    else{
                        b4.setText("O");
                        b4.setTextColor(Color.BLUE);
                        B[4]=2;
                        player1=true;
                        player2=false;
                        turn.setText("P1 Turn");
                        turn.setTextColor(Color.RED);
                        b4.setEnabled(false);
                    }
                    check();
                }
            }
        });
        b5.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(game==true){
                    if(player1==true){
                        b5.setText("X");
                        b5.setTextColor(Color.RED);
                        B[5]=1;
                        player1=false;
                        player2=true;
                        turn.setText("P2 Turn");
                        turn.setTextColor(Color.BLUE);
                        b5.setEnabled(false);
                    }
                    else{
                        b5.setText("O");
                        b5.setTextColor(Color.BLUE);
                        B[5]=2;
                        player1=true;
                        player2=false;
                        turn.setText("P1 Turn");
                        turn.setTextColor(Color.RED);
                        b5.setEnabled(false);
                    }
                    check();
                }
            }
        });
        b6.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (game == true) {
                    if (player1 == true) {
                        b6.setText("X");
                        b6.setTextColor(Color.RED);
                        B[6] = 1;
                        player1 = false;
                        player2 = true;
                        turn.setText("P2 Turn");
                        turn.setTextColor(Color.BLUE);
                        b6.setEnabled(false);
                    } else {
                        b6.setText("O");
                        b6.setTextColor(Color.BLUE);
                        B[6] = 2;
                        player1 = true;
                        player2 = false;
                        turn.setText("P1 Turn");
                        turn.setTextColor(Color.RED);
                        b6.setEnabled(false);
                    }
                    check();
                }
            }
        });
        b7.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (game == true) {
                    if (player1 == true) {
                        b7.setText("X");
                        b7.setTextColor(Color.RED);
                        B[7] = 1;
                        player1 = false;
                        player2 = true;
                        turn.setText("P2 Turn");
                        turn.setTextColor(Color.BLUE);
                        b7.setEnabled(false);
                    } else {
                        b7.setText("O");
                        b7.setTextColor(Color.BLUE);
                        B[7] = 2;
                        player1 = true;
                        player2 = false;
                        turn.setText("P1 Turn");
                        turn.setTextColor(Color.RED);
                        b7.setEnabled(false);
                    }
                    check();
                }
            }
        });
        b8.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (game == true) {
                    if (player1 == true) {
                        b8.setText("X");
                        b8.setTextColor(Color.RED);
                        B[8] = 1;
                        player1 = false;
                        player2 = true;
                        turn.setText("P2 Turn");
                        turn.setTextColor(Color.BLUE);
                        b8.setEnabled(false);
                    } else {
                        b8.setText("O");
                        b8.setTextColor(Color.BLUE);
                        B[8] = 2;
                        player1 = true;
                        player2 = false;
                        turn.setText("P1 Turn");
                        turn.setTextColor(Color.RED);
                        b8.setEnabled(false);
                    }
                    check();
                }
            }
        });
        b9.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (game == true) {
                    if (player1 == true) {
                        b9.setText("X");
                        b9.setTextColor(Color.RED);
                        B[9] = 1;
                        player1 = false;
                        player2 = true;
                        turn.setText("P2 Turn");
                        turn.setTextColor(Color.BLUE);
                        b9.setEnabled(false);
                    } else {
                        b9.setText("O");
                        b9.setTextColor(Color.BLUE);
                        B[9] = 2;
                        player1 = true;
                        player2 = false;
                        turn.setText("P1 Turn");
                        turn.setTextColor(Color.RED);
                        b9.setEnabled(false);
                    }
                    check();
                }
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
