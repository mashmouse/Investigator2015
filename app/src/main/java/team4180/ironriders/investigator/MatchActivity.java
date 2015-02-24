package team4180.ironriders.investigator;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

public class MatchActivity extends ActionBarActivity {
    private AutonomousFragment autoFrag;
    private TeleopFragment teleopFrag;
    private CheckBox autoCheckBox;
    private CheckBox teleopCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        autoFrag = new AutonomousFragment();
        teleopFrag = new TeleopFragment();
        teleopCheckBox = (CheckBox) findViewById(R.id.matchActivityCheckedTextViewTeleop);
        autoCheckBox = (CheckBox) findViewById(R.id.matchActivityCheckedTextViewAutonomus);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, autoFrag);
        ft.commit();
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

    public void onCheckedAutonomous(View v){
        int id = v.getId();
        if(autoCheckBox.getId() == id && autoCheckBox.isChecked()) {
            teleopCheckBox.setChecked(false);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, autoFrag).commit();
        }
    }

    public void onCheckedTeleop(View v){
        int id = v.getId();
        if(teleopCheckBox.getId() == id && teleopCheckBox.isChecked()) {
            autoCheckBox.setChecked(false);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, teleopFrag).commit();
        }
    }

}
