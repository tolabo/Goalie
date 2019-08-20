package com.tolulopealuko.goaliertm.network;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import com.tolulopealuko.goaliertm.models.FixtureDetail;
import com.tolulopealuko.goaliertm.models.Fixtures;
import com.tolulopealuko.goaliertm.models.LeagueTable;
import com.tolulopealuko.goaliertm.models.Players;
import com.tolulopealuko.goaliertm.models.SoccerSeason;
import com.tolulopealuko.goaliertm.models.Team;

public interface FootballDataService {
    @GET("/v2/competitions/2000")
    void getFixtures(@Query("timeFrameStart") String timeFrameStart, @Query("timeFrameEnd") String timeFrameEnd, Callback<Fixtures> cb);

    @GET("/v2/competitions/{id}/teams")
    void getFixtureDetail(@Path("id") int fixtureId, Callback<FixtureDetail> cb);

    @GET("/v2/competitions/{id}/matches")
    void getSoccerSeasons(Callback<ArrayList<SoccerSeason>> cb);

    @GET("/v2/competitions/{id}/matches")
    void getSoccerSeason(@Path("id") int soccerSeasonId, Callback<SoccerSeason> cb);

    @GET("/v2/competitions/{id}/standings")
    void getSoccerSeasonLeagueTable(@Path("id") int soccerSeasonId, Callback<LeagueTable> cb);

    @GET("/v2/competitions/{id}/teams")
    void getTeam(@Path("id") int teamId, Callback<Team> cb);

    @GET("/v2/players/{id}/matches")
    void getTeamPlayers(@Path("id") int teamId, Callback<Players> cb);
}
