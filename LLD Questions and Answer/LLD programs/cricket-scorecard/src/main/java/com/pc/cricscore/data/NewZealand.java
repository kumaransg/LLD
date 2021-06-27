package com.pc.cricscore.data;

import com.pc.cricscore.model.ImmutableList;
import com.pc.cricscore.model.Player;
import com.pc.cricscore.model.SimpleLineUp;
import com.pc.cricscore.model.SimplePlayer;

public class NewZealand {

    public static Player player(String name) {
        return new SimplePlayer(name);
    }

    public static final Player GEORGE_WORKER = player("George Worker");

    public static final Player NEIL_WAGNER = player("Neil Wagner");
    public static final Player TIM_SOUTHEE = player("Tim Southee");
    public static final Player TIM_SEIFERT = player("Tim Seifert");
    public static final Player JEET_RAVAL = player("Jeet Raval");
    public static final Player HENRY_NICHOLLS = player("Henry Nicholls");
    public static final Player DARYL_MITCHELL = player("Daryl Mitchell");
    public static final Player MATT_HENRY = player("Matt Henry");
    public static final Player COLIN_DE_GRANDHOMME = player("Colin de Grandhomme");
    public static final Player DOUG_BRACEWELL = player("Doug Bracewell");
    public static final Player KANE_WILLIAMSON = player("Kane Williamson");
    public static final Player BLAIR_TICKNER = player("Blair Tickner");
    public static final Player WILLIAM_SOMERVILLE = player("William Somerville");
    public static final Player MITCHELL_SANTNER = player("Mitchell Santner");
    public static final Player SETH_RANCE = player("Seth Rance");
    public static final Player JAMES_NEESHAM = player("Jimmy Neesham");
    public static final Player TOM_LATHAM = player("Tom Latham");
    public static final Player MARTIN_GUPTILL = player("Martin Guptill");
    public static final Player MARK_CHAPMAN = player("Mark Chapman");
    public static final Player TRENT_BOULT = player("Trent Boult");
    public static final Player BJ_WATLING = player("BJ Watling");
    public static final Player ROSS_TAYLOR = player("Ross Taylor");
    public static final Player ISH_SODHI = player("Ish Sodhi");
    public static final Player HAMISH_RUTHERFORD = player("Hamish Rutherford");
    public static final Player AJAZ_PATEL = player("Ajaz Patel");
    public static final Player COLIN_MUNRO = player("Colin Munro");
    public static final Player SCOTT_KUGGELEIJN = player("Scott Kuggeleijn");
    public static final Player LOCKIE_FERGUSON = player("Lockie Ferguson");
    public static final Player TOM_BRUCE = player("Tom Bruce");
    public static final Player TODD_ASTLE = player("Todd Astle");


    public static SimpleLineUp.Builder t20LineUp() {
        return SimpleLineUp.lineUp()
            .withCaptain(KANE_WILLIAMSON)
            .withWicketKeeper(TIM_SEIFERT)
            .withTeamName("New Zealand")
            .withBattingOrder(ImmutableList.of(MARTIN_GUPTILL, COLIN_MUNRO, KANE_WILLIAMSON, ROSS_TAYLOR, TIM_SEIFERT,
                COLIN_DE_GRANDHOMME, JAMES_NEESHAM, MITCHELL_SANTNER, TIM_SOUTHEE, ISH_SODHI, LOCKIE_FERGUSON));
    }

    public static SimpleLineUp.Builder oneDayLineUp() {
        return SimpleLineUp.lineUp()
            .withCaptain(KANE_WILLIAMSON)
            .withWicketKeeper(TOM_LATHAM)
            .withTeamName("New Zealand")
            .withBattingOrder(ImmutableList.of(MARTIN_GUPTILL, HENRY_NICHOLLS, KANE_WILLIAMSON, ROSS_TAYLOR, TOM_LATHAM,
                JAMES_NEESHAM, COLIN_DE_GRANDHOMME, MITCHELL_SANTNER, MATT_HENRY, TRENT_BOULT, LOCKIE_FERGUSON));
    }

    public static SimpleLineUp.Builder testLineUp() {
        return SimpleLineUp.lineUp()
            .withCaptain(KANE_WILLIAMSON)
            .withWicketKeeper(BJ_WATLING)
            .withTeamName("New Zealand")
            .withBattingOrder(ImmutableList.of(JEET_RAVAL, TOM_LATHAM, KANE_WILLIAMSON, ROSS_TAYLOR, HENRY_NICHOLLS,
                BJ_WATLING, COLIN_DE_GRANDHOMME, MITCHELL_SANTNER, TIM_SOUTHEE, NEIL_WAGNER, LOCKIE_FERGUSON));
    }

}
