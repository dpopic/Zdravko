package zdravko.tvz.hr.zdravko;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;


public class SendEmailActivity extends ActionBarActivity {
    private String to ="";
    private String message="Molim Vas naručite me na pregled kao što je napisano na uputnici u privitku.";
    private String subject="Narudžba za pregled";

    // Za attachment
    //TODO potrebna dorada za attachment, treba ubaciti path slike
    String pathname= Environment.getExternalStorageDirectory().getAbsolutePath();
    String filename="/MyFiles/mysdfile.txt";
    File file=new File(pathname, filename);

    public SendEmailActivity(String to) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);



        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
        //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);
        //za attachment
        email.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
        //need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));

    }


}
