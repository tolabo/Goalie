package com.tolulopealuko.goaliertm;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGBuilder;

import org.parceler.Parcels;

import java.net.HttpURLConnection;
import java.net.URL;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import com.tolulopealuko.goaliertm.models.LeagueTable;
import com.tolulopealuko.goaliertm.models.Player;
import com.tolulopealuko.goaliertm.models.Players;
import com.tolulopealuko.goaliertm.models.StandingTeam;
import com.tolulopealuko.goaliertm.models.Team;
import com.tolulopealuko.goaliertm.network.RestClient;
import com.tolulopealuko.goaliertm.views.adapters.PlayerListItemView;
import com.tolulopealuko.goaliertm.views.adapters.PlayersAdapter;

public class TeamActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
    }
}
