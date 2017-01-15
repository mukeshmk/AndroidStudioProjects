package com.example.mk.endsem;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Async extends AppCompatActivity {
    private Button button;
    private EditText time;
    private TextView finalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async);
        time = (EditText) findViewById(R.id.in_time);
        button = (Button) findViewById(R.id.btn_run);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTaskRunner runner = new AsyncTaskRunner();
                runner.execute();
            }
        });
        finalResult = (TextView) findViewById(R.id.tv_result);
    }

    class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp;
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... params) {
            publishProgress("DB Process..."); // Calls onProgressUpdate()
            try {
                //DB Process
                resp = "DB Process Complete";
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }


        @Override
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
            progressDialog.dismiss();
            Toast.makeText(Async.this, "DB Process Done", Toast.LENGTH_SHORT).show();
        }


        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(Async.this,
                    "ProgressDialog",
                    "Wait for DB Process");
        }


        @Override
        protected void onProgressUpdate(String... text) {
            Toast.makeText(Async.this, text[0], Toast.LENGTH_SHORT).show();
        }
    }
}