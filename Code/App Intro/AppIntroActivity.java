package in.topux.tripzo.appintro;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ramotion.paperonboarding.PaperOnboardingEngine;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnChangeListener;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnLeftOutListener;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;

import java.util.ArrayList;

import in.topux.tripzo.MainActivity;
import in.topux.tripzo.R;

/**
 * Created by abhijit on 1/28/2018.
 */

public class AppIntroActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appintro);

        // Define the engine for PaperOnBoarding
        PaperOnboardingEngine engine = new PaperOnboardingEngine(findViewById(R.id.onboardingRootView), getDataForOnboarding(), getApplicationContext());
        engine.setOnChangeListener(new PaperOnboardingOnChangeListener() {
            @Override
            public void onPageChanged(int i, int i1) {
//                Toast.makeText(getApplicationContext(), "swiped from " + i + "to " + i1, Toast.LENGTH_SHORT).show();

            }
        });

        // Swipe Left listener from the last screen
        engine.setOnLeftOutListener(new PaperOnboardingOnLeftOutListener() {
            @Override
            public void onLeftOut() {
//                Toast.makeText(getApplicationContext(), "Swiped Left", Toast.LENGTH_SHORT).show();
            }
        });

        // Swipe right listener from the last screen
        engine.setOnRightOutListener(new PaperOnboardingOnRightOutListener() {
            @Override
            public void onRightOut() {
//                Toast.makeText(getApplicationContext(), "Swiped Right", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AppIntroActivity.this, MainActivity.class));
                finish();
            }
        });




    }

    private ArrayList<PaperOnboardingPage> getDataForOnboarding() {
        // Prepare data
        PaperOnboardingPage scr1 = new PaperOnboardingPage(getString(R.string.introslider_1_title),
                getString(R.string.introslider_1_desc), Color.parseColor("#F7934C"), R.drawable.ic_photo_library_24dp,
                R.drawable.ic_photo_library_24dp);
        PaperOnboardingPage scr2 = new PaperOnboardingPage(getString(R.string.introslider_2_title),
                getString(R.string.introslider_2_desc), Color.parseColor("#0288d1"), R.drawable.ic_people_outline_24dp,
                R.drawable.ic_people_outline_24dp);

        ArrayList<PaperOnboardingPage> screens = new ArrayList<>();
        screens.add(scr1);
        screens.add(scr2);
        return screens;
    }
}
