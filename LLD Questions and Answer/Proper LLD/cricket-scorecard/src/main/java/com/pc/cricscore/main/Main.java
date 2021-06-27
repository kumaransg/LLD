/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.cricscore.main;

import com.pc.cricscore.data.England;
import com.pc.cricscore.data.NewZealand;
import com.pc.cricscore.model.ImmutableList;
import com.pc.cricscore.model.SimpleLineUp;
/**
 * @author paras.chawla
 * @version $Id: Main.java, v 0.1 2020-11-07 00:42 paras.chawla Exp $$
 */
public class Main {

    public static void main(String[] args) {

        SimpleLineUp nz = SimpleLineUp.lineUp()
                .withTeamName("New Zealand")
                .withBattingOrder(ImmutableList.of(NewZealand.COLIN_MUNRO, NewZealand.MARTIN_GUPTILL, NewZealand.TIM_SEIFERT, NewZealand.COLIN_DE_GRANDHOMME, NewZealand.ROSS_TAYLOR,
                        NewZealand.JAMES_NEESHAM, NewZealand.MITCHELL_SANTNER, NewZealand.TIM_SOUTHEE, NewZealand.ISH_SODHI, NewZealand.LOCKIE_FERGUSON, NewZealand.BLAIR_TICKNER))
                .withCaptain(NewZealand.TIM_SOUTHEE)
                .withWicketKeeper(NewZealand.TIM_SEIFERT)
                .build();

        SimpleLineUp eng = SimpleLineUp.lineUp()
                .withTeamName("England")
                .withBattingOrder(ImmutableList.of(
                        England.BURNS, England.SIBLEY, England.DENLY, England.ROOT, England.STOKES, England.BAIRSTOW, England.BUTTLER, England.SAM_CURRAN, England.ARCHER, England.BROAD, England.ANDERSON
                ))
                .withCaptain(England.ROOT)
                .withWicketKeeper(England.BUTTLER)
                .build();


    }
}