package com.example.sakshigupta.profile;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
      Button sendbtn ;
      ImageButton linkedbtn;
      ImageButton fb;
      ImageButton git;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendbtn = (Button) findViewById(R.id.button2);
        linkedbtn = (ImageButton) findViewById(R.id.button3);
        fb= (ImageButton) findViewById(R.id.fb);
        git =   (ImageButton) findViewById(R.id.git);
        linkedbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.linkedin.com/in/sakshi-gupta-16a0b5170/"));
                startActivity(intent);
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.facebook.com/profile.php?id=100002306395634"));
                startActivity(intent);
            }
        });
        git.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://github.com/sakshigupta1102"));
                startActivity(intent);
            }
        });
        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }

    public void openNewActivity(){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.menu, m);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.githubsearchapi:
               // Toast.makeText(this, "upload item", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,githubsearch1.class);
                startActivity(intent);
                return true;
            case R.id.copy_item:
                Toast.makeText(this, "copy item", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.print_item:
                Toast.makeText(this, "print item", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.share_item:
                Toast.makeText(this, "share item", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}

