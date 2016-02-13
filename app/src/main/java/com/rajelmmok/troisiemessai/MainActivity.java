package com.rajelmmok.troisiemessai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements View.OnClickListener {

    Button bLogin, bRegister;
    EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bLogin = (Button) findViewById(R.id.bLogin);
        bLogin.setOnClickListener(this);
        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(this);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.bLogin:
                this.login(v);
            default:
                break;
        }
    }

    public void login(View v){
        if (etEmail.getText().toString().compareTo("a")==0 && etPassword.getText().toString().compareTo("a")==0){
            startActivity(new Intent(this, OurWebsites.class));
        }
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
