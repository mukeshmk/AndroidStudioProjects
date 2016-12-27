package com.example.mk.labex12;
import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText n,i;
    Button ad,dis,dele,modi;
    private SQLiteDatabase db;
    //   private static final String DB_NAME = "emp";
    //  private static final int DB_VERSION = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n=(EditText)findViewById(R.id.name);
        i=(EditText)findViewById(R.id.rno);
        ad=(Button)findViewById(R.id.add);
        dis=(Button)findViewById(R.id.disp);
        dele=(Button)findViewById(R.id.del);
        modi=(Button)findViewById(R.id.mod);
        ad.setOnClickListener(this);
        dis.setOnClickListener(this);
        dele.setOnClickListener(this);
        modi.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.add:
                db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
                Toast.makeText(this,"add button",Toast.LENGTH_SHORT).show();
                //   String DB_TABLE = "create table login (name varchar,id varchar);";

                db.execSQL("CREATE TABLE IF NOT EXISTS student1(name VARCHAR,rollno VARCHAR);");

                //    String qur="insert into login values ("hello","hai")";

                //   db.execSQL(DB_TABLE);
                db.execSQL("INSERT INTO student1 VALUES('"+n.getText()+"','"+i.getText()+"');");
                break;

            case R.id.disp:
                db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
                Toast.makeText(this,"display button",Toast.LENGTH_SHORT).show();
                Cursor c=db.rawQuery("SELECT * FROM student1", null);
                if(c.getCount()==0)
                {
                    showMessage("Error", "No records found");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(c.moveToNext())
                {

                    buffer.append("Name: "+c.getString(0)+"\n");
                    buffer.append("Rollno: "+c.getString(1)+"\n");
                }
                showMessage("Student Details", buffer.toString());

                break;

            case R.id.del:
                db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
                Toast.makeText(this,"delete button",Toast.LENGTH_SHORT).show();
                // db.execSQL("DROP TABLE student1");
                // Checking empty roll number
                if(n.getText().toString().trim().length()==0)
                {
                    showMessage("Error", "Please enter Rollno");
                    return;
                }
                // Searching roll number
                Cursor c1=db.rawQuery("SELECT * FROM student1 WHERE name='"+n.getText()+"'", null);
                if(c1.moveToFirst())
                {
                    // Deleting record if found
                    db.execSQL("DELETE FROM student1 WHERE name='"+n.getText()+"'");
                    showMessage("Success", "Record Deleted");
                }
                else
                {
                    showMessage("Error", "Invalid Rollno");
                }
                clearText();
                break;

            case R.id.mod:
                Toast.makeText(this,"modify button",Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void showMessage(String title, String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText()
    {
        n.setText("");
        i.setText("");

    }
}
/*
public class MainActivity extends Activity {
    //ListView listView1;
    RelativeLayout r1;
    String contacts[]={"Ajay","Sachin","Sumit","Tarun","Yogesh"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        r1=(RelativeLayout)findViewById(R.id.activity_main);
        registerForContextMenu(r1);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Hello");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "Hi");
        menu.add(0, v.getId(), 0, "Good day");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Hello"){
            Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle()=="Hi"){
            Toast.makeText(getApplicationContext(),"Hi",Toast.LENGTH_LONG).show();
        }else if(item.getTitle()=="Good day"){
            Toast.makeText(getApplicationContext(),"Good day",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }

*/