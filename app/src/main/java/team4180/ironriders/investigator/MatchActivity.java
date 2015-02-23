package team4180.ironriders.investigator;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

public class MatchActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_match, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.to_home_activity) {
            startActivity(new Intent(MatchActivity.this, HomeActivity.class));
            return true;
        } else if (id == R.id.to_team_activity){
            startActivity(new Intent(MatchActivity.this, TeamActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onCheckedAutonomousTeleop(View v){
        int id = v.getId();
        CheckBox autoCheckBox = (CheckBox) findViewById(R.id.matchActivityCheckedTextViewAutonomus);
        CheckBox teleopCheckBox = (CheckBox) findViewById(R.id.matchActivityCheckedTextViewTeleop);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(id == R.id.matchActivityCheckedTextViewAutonomus && autoCheckBox.isChecked()){
            teleopCheckBox.setChecked(false);
            ft.replace(R.id.fragment, new AutonomousFragment());
        } else if (id == R.id.matchActivityCheckedTextViewTeleop && teleopCheckBox.isChecked()){
            autoCheckBox.setChecked(false);
            ft.replace(R.id.fragment, new TeleopFragment());
        }
        ft.commit();

    }
}
