package team4180.ironriders.investigator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void toTeamActivity(View v){
        startActivity(new Intent(HomeActivity.this, TeamActivity.class));
    }

    public void toMatchActivity(View v){
        startActivity(new Intent(HomeActivity.this, MatchActivity.class));
    }
}
