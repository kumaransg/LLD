/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.cricscore.model;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.Instant;
import java.util.Objects;

/**
 * @author paras.chawla
 * @version $Id: Over.java, v 0.1 2020-11-06 23:49 paras.chawla Exp $$
 * A set of (normally) 6 balls bowled in an innings.
 */
public class Over {

    private final int     overNumber;
    private final Player  striker;
    private final Player  nonStriker;
    private final Player  bowler;
    private final int     ballsInOver;
    private final Balls   balls;
    private final Instant startTime;

    private Over(@Nonnegative int inningsNumber, @Nonnegative int overNumber, Player striker, Player nonStriker, Balls balls, Player bowler,
                 @Nonnegative int ballsInOver, @Nullable
                         Instant startTime) {
        this.overNumber = overNumber;
        this.striker = Objects.requireNonNull(striker);
        this.nonStriker = Objects.requireNonNull(nonStriker);
        this.balls = Objects.requireNonNull(balls);
        this.bowler = Objects.requireNonNull(bowler);
        this.ballsInOver = ballsInOver;
        this.startTime = startTime;
    }

    /**
     * @return The current batter that is going to face the next ball
     */
    public @Nonnull
    Player striker() {
        return striker;
    }

    /**
     * @return The batter that is currently at the non-facing end
     */
    public @Nonnull Player nonStriker() {
        return nonStriker;
    }

    /**
     * @return The current bowler of this over.
     */
    public @Nonnull Player bowler() {
        return bowler;
    }

    /**
     * @return The zero-indexed number of this over (e.g. the first over in an innings returns 0)
     */
    public @Nonnegative int overNumber() {
        return overNumber;
    }

    /**
     * @return The max number of valid deliveries allowed in the over
     */
    public @Nonnegative int ballsInOver() {
        return ballsInOver;
    }

    /**
     * @return The balls bowled in this over
     */
    public @Nonnull Balls balls() {
        return balls;
    }

    /**
     * @return The runs scored in this over
     */
    public @Nonnull Score score() {
        return balls.score();
    }

    /**
     * @return The number of runs gained by the team in this over (including extras).
     */
    public @Nonnegative int teamRuns() {
        return balls.score().teamRuns();
    }

    /**
     * @return True if no runs have been scored from the bat or as bowling extras in this over.
     * If not {@link #isComplete()} then returns false even if there are no runs so far.
     */
    public boolean isMaiden() {
        return isComplete() && (score().batterRuns() + score().bowlingExtras()) == 0;
    }

    /**
     * @return The number of valid balls remaining to be bowled in this over.
     */
    public @Nonnegative int remainingBalls() {
        return ballsInOver - validDeliveries();
    }

    /**
     * @return The number of valid (or legal) balls bowled so far in this over.
     */
    public @Nonnegative int validDeliveries() {
        return (int) balls.list().stream().filter(BallCompletedEvent::isValid).count();
    }

    /**
     * @return True if there shouldn't be any more balls bowled in this over. Note that it is still possible to have
     * more balls in this over even if it is complete if there is an umpiring error.
     */
    public boolean isComplete() {
        return validDeliveries() >= ballsInOver;
    }

    @Override
    public String toString() {
        return "Over{" +
                ", overNumber=" + overNumber +
                ", striker=" + striker +
                ", nonStriker=" + nonStriker +
                ", bowler=" + bowler +
                ", ballsInOver=" + ballsInOver +
                ", startTime=" + startTime +
                '}';
    }

}