package com.pc.cricscore.data;

import com.pc.cricscore.model.ImmutableList;
import com.pc.cricscore.model.Player;
import com.pc.cricscore.model.SimpleLineUp;
import com.pc.cricscore.model.SimplePlayer;

public class Australia {

    public static Player player(String name) {
        return new SimplePlayer(name);
    }

    public static final Player SEAN_ABBOT        = player("Sean Abbot");
    public static final Player JASON_BEHRENDORFF = player("Jason Behrendorff");
    public static final Player PAT_CUMMINS       = player("Pat Cummins");
    public static final Player MARCUS_HARRIS     = player("Marcus Harris");
    public static final Player USMAN_KHAWAJA     = player("Usman Khawaja");
    public static final Player BEN_MC_DERMOTT    = player("Ben McDermott");
    public static final Player TIM_PAINE         = player("Tim Paine");
    public static final Player PETER_SIDDLE      = player("Peter Siddle");
    public static final Player MITCHELL_STARC = player("Mitchell Starc");
    public static final Player MATTHEW_WADE = player("Matthew Wade");
    public static final Player ASHTON_AGAR = player("Ashton Agar");
    public static final Player JOE_BURNS = player("Joe Burns");
    public static final Player AARON_FINCH = player("Aaron Finch");
    public static final Player JOSH_HAZLEWOOD = player("Josh Hazlewood");
    public static final Player MARNUS_LABUSCHAGNE = player("Marnus Labuschagne");
    public static final Player MITCHELL_MARSH = player("Mitchell Marsh");
    public static final Player JAMES_PATTINSON = player("James Pattinson");
    public static final Player STEVEN_SMITH = player("Steven Smith");
    public static final Player MARCUS_STOINIS = player("Marcus Stoinis");
    public static final Player DAVID_WARNER = player("David Warner");
    public static final Player CAMERON_BANCROFT = player("Cameron Bancroft");
    public static final Player ALEX_CAREY = player("Alex Carey");
    public static final Player PETER_HANDSCOMB = player("Peter Handscomb");
    public static final Player TRAVIS_HEAD = player("Travis Head");
    public static final Player NATHON_LYON = player("Nathon Lyon");
    public static final Player GLENN_MAXWELL = player("Glenn Maxwell");
    public static final Player KANE_RICHARDSON = player("Kane Richardson");
    public static final Player BILLY_STANLAKE = player("Billy Stanlake");
    public static final Player ASHTON_TURNER = player("Ashton Turner");
    public static final Player ADAM_ZAMPA = player("Adam Zampa");

    public static SimpleLineUp.Builder t20LineUp() {
        return new SimpleLineUp.Builder()
            .withCaptain(AARON_FINCH)
            .withWicketKeeper(ALEX_CAREY)
            .withTeamName("Australia")
            .withBattingOrder(ImmutableList.of(
                DAVID_WARNER, AARON_FINCH, STEVEN_SMITH, BEN_MC_DERMOTT, ASHTON_TURNER, ALEX_CAREY, ASHTON_AGAR,
                SEAN_ABBOT, MITCHELL_STARC, KANE_RICHARDSON, BILLY_STANLAKE
            ));
    }

    public static SimpleLineUp.Builder oneDayLineUp() {
        return SimpleLineUp.lineUp()
            .withCaptain(AARON_FINCH)
            .withWicketKeeper(ALEX_CAREY)
            .withTeamName("Australia")
            .withBattingOrder(ImmutableList.of(
                DAVID_WARNER, AARON_FINCH, STEVEN_SMITH, PETER_HANDSCOMB, ALEX_CAREY, MARCUS_STOINIS, GLENN_MAXWELL,
                PAT_CUMMINS, MITCHELL_STARC, JASON_BEHRENDORFF, NATHON_LYON
            ));
    }

    public static SimpleLineUp.Builder testLineUp() {
        return SimpleLineUp.lineUp()
            .withCaptain(TIM_PAINE)
            .withWicketKeeper(TIM_PAINE)
            .withTeamName("Australia")
            .withBattingOrder(ImmutableList.of(
                DAVID_WARNER, JOE_BURNS, MARNUS_LABUSCHAGNE, STEVEN_SMITH, MATTHEW_WADE, TRAVIS_HEAD, TIM_PAINE,
                PAT_CUMMINS, MITCHELL_STARC, NATHON_LYON, JOSH_HAZLEWOOD
            ));
    }

}
