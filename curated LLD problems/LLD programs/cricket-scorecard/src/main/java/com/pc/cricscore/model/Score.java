package com.pc.cricscore.model;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Runs scored, deliveries bowled, and wickets taken either from a single ball, or 0 or multiple balls.
 * <p>The types of runs (e.g. from the bat, from boundaries, from extras etc) are specified in this class along
 * with the number of valid and invalid deliveries.</p>
 * <p>These objects are immutable and can only be created with the {@link Score#score()} method to create
 * a builder, or by using a predefined score defined as static fields in this class, such as {@link #DOT_BALL}, {@link #SINGLE}, etc</p>
 */
@Immutable
public class Score {

    public Score() {}

    /**
     * No balls delivered, with no wickets or runs scored.
     */
    public static final Score EMPTY    = new Score(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    /**
     * No runs scored from a valid delivery.
     */
    public static final Score DOT_BALL = new Score(0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1);
    /**
     * One run scored from the bat off of a valid delivery.
     */
    public static final Score SINGLE   = new Score(1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
    /**
     * Two runs scored from the bat off of a valid delivery.
     */
    public static final Score TWO      = new Score(2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1);
    /**
     * Three runs scored from the bat off of a valid delivery.
     */
    public static final Score THREE    = new Score(3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1);

    /**
     * Four runs scored by hitting the ball to the boundary from a valid delivery.
     * <p>Note that this is different from 4 runs run by the batters without it going to the boundary (which would have {@link #batterRuns}
     * being 4 but {@link #fours()} being 0).</p>
     */
    public static final Score FOUR = new Score(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1);
    /**
     * Six runs scored by hitting the ball over the boundary on the full from a valid delivery.
     */
    public static final Score SIX  = new Score(6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1);
    /**
     * A wide (with no extra runs or wicket taken).
     */
    public static final Score WIDE = new Score(0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /**
     * A no-ball (with no extra runs or wicket taken).
     */
    public static final Score NO_BALL = new Score(0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /**
     * A single bye of a valid delivery.
     */
    public static final Score BYE     = new Score(0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1);
    /**
     * A single leg bye of a valid delivery.
     */
    public static final Score LEG_BYE = new Score(0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1);

    /**
     * A wicket taken off a valid delivery that is credited to the bowler.
     */
    public static final Score WICKET = new Score(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1);

    int batterRuns;
    int wides;
    int wideDeliveries;
    int noBalls;
    int legByes;
    int byes;
    int penaltyRuns;
    int wickets;
    int dots;
    int singles;
    int twos;
    int threes;
    int fours;
    int sixes;
    int validDeliveries;

    private Score(@Nonnegative int batterRuns, @Nonnegative int wides, @Nonnegative int wideDeliveries, @Nonnegative int noBalls,
                  @Nonnegative int legByes, @Nonnegative int byes, @Nonnegative int penaltyRuns, @Nonnegative int wickets,
                  @Nonnegative int dots, @Nonnegative int singles, @Nonnegative int twos, @Nonnegative int threes, @Nonnegative int fours,
                  @Nonnegative int sixes, @Nonnegative int validDeliveries) {
        this.wideDeliveries = wideDeliveries;
        if ((singles > 0 || twos > 0 || threes > 0 || fours > 0 || sixes > 0 || byes > 0 || legByes > 0) && (
                (validDeliveries + wideDeliveries + noBalls) == 0)) {
            throw new IllegalStateException("Wickets and runs from the bat can only be scored with valid or invalid balls are set too.");
        }
        if (wideDeliveries > wides) {
            throw new IllegalStateException("There cannot be more wide deliveries than wide runs");
        }
        this.batterRuns = batterRuns;
        this.wides = wides;
        this.noBalls = noBalls;
        this.legByes = legByes;
        this.byes = byes;
        this.penaltyRuns = penaltyRuns;
        this.wickets = wickets;
        this.dots = dots;
        this.singles = singles;
        this.twos = twos;
        this.threes = threes;
        this.fours = fours;
        this.sixes = sixes;
        this.validDeliveries = validDeliveries;
    }

    /**
     * Creates a new score builder
     *
     * @return A new builder
     */
    public static @Nonnull
    Builder score() {
        return new Builder();
    }

    /**
     * @return The total runs scored for the team (which is runs off the bat plus extras)
     */
    public @Nonnegative
    int teamRuns() {
        return bowlerRuns() + legByes + byes;
    }

    /**
     * @return The number of runs ascribed to the bowler, which is total runs less byes and leg byes
     */
    public @Nonnegative
    int bowlerRuns() {
        return batterRuns() + wides + noBalls + penaltyRuns;
    }

    /**
     * @return The number of extras, i.e. runs not scored from the bat
     */
    public @Nonnegative
    int extras() {
        return fieldingExtras() + bowlingExtras();
    }

    /**
     * @return The number of runs ascribed by the batter, which is the total runs less extras.
     */
    public @Nonnegative
    int batterRuns() {
        return batterRuns;
    }

    /**
     * @return The number of runs scored from wides (e.g. a single wide delivery that goes to the boundary would have a value of 5).
     * @see #wideDeliveries()
     */
    public @Nonnegative
    int wides() {
        return wides;
    }

    /**
     * @return The number of deliveries which were bowled wide (e.g. a single wide delivery that goes to the boundary would have a value of
     * 5).
     * @see #wides()
     */
    public @Nonnegative
    int wideDeliveries() {
        return wideDeliveries;
    }

    /**
     * @return The number of runs from a no-ball. Note that if a boundary is hit off a no-ball, then this value should return one, and
     * {@link #batterRuns()} would return 4.
     */
    public @Nonnegative
    int noBalls() {
        return noBalls;
    }

    /**
     * @return The number of leg byes scored.
     */
    public @Nonnegative
    int legByes() {
        return legByes;
    }

    /**
     * @return The number of byes scored.
     */
    public @Nonnegative
    int byes() {
        return byes;
    }

    /**
     * @return The number of penalty runs awarded.
     */
    public @Nonnegative
    int penaltyRuns() {
        return penaltyRuns;
    }

    /**
     * @return The number of wickets taken.
     */
    public @Nonnegative
    int wickets() {
        return wickets;
    }

    /**
     * The number of dot balls is considered to be the number of balls where no runs were scored off the bat and no bowling extras were
     * bowled.
     * <p>Note that this means a valid delivery where byes or leg byes were scored is considered a dot ball.</p>
     *
     * @return The number of dot balls
     */
    public @Nonnegative
    int dots() {
        return dots;
    }

    /**
     * @return The number of times a single was scored from the bat
     */
    public @Nonnegative
    int singles() {
        return singles;
    }

    /**
     * @return The number of times a two was scored from the bat
     */
    public @Nonnegative
    int twos() {
        return twos;
    }

    /**
     * @return The number of times a three was scored from the bat
     */
    public @Nonnegative
    int threes() {
        return threes;
    }

    /**
     * @return The number of times the batter hit the ball to the boundary to score 4 runs (excludes cases where the batters run 4 runs)
     */
    public @Nonnegative
    int fours() {
        return fours;
    }

    /**
     * @return The number of times the batter hit the ball over the boundary to score 6 runs (excludes the unlikely cases where the batters
     * run 6 runs)
     */
    public @Nonnegative
    int sixes() {
        return sixes;
    }

    /**
     * @return The number of valid (or legal) deliveries bowled (i.e. the number of balls excluding wides and no-balls).
     */
    public @Nonnegative
    int validDeliveries() {
        return validDeliveries;
    }

    /**
     * @return The number of deliveries bowled that are {@link #wideDeliveries()} or {@link #noBalls()}
     */
    public @Nonnegative
    int invalidDeliveries() {
        return wideDeliveries() + noBalls();
    }

    /**
     * The number of deliveries counting towards the batter's balls faced tally.
     * <p>This is different from {@link #validDeliveries()} in that no-balls (which are invalid deliveries) count
     * towards the number of balls faced by a batter.</p>
     *
     * @return The balls faced by the batter (which excludes wides)
     */
    public @Nonnegative
    int facedByBatter() {
        return validDeliveries() + noBalls();
    }

    /**
     * @return The number of extras that count against the bowler, i.e. wides plus no-balls
     */
    public @Nonnegative
    int bowlingExtras() {
        return wides + noBalls;
    }

    /**
     * @return The number of extras that do not count against the bowler, i.e. byes, leg byes, and penalty runs
     */
    public @Nonnegative
    int fieldingExtras() {
        return byes + legByes + penaltyRuns;
    }

    /**
     * @return The number of runs from the bat (i.e. excluding extras) per one hundred balls (or null if there have been no valid balls).
     */
    public @Nullable
    Double battingStrikeRate() {
        int balls = facedByBatter();
        return balls == 0 ? null : (batterRuns() * 100.0) / balls;
    }

    /**
     * @return The average number of runs scored from the bat (i.e. excluding extras) per wicket, or null if there have been no wickets
     */
    public @Nullable
    Double battingAverage() {
        return wickets == 0 ? null : batterRuns() / (double) wickets;
    }

    /**
     * @return The average number of (valid) balls bowled per wicket, or null if no wickets have been taken.
     */
    public @Nullable
    Double bowlingStrikeRate() {
        return wickets == 0 ? null : validDeliveries / (double) wickets;
    }

    /**
     * Creates a new score by adding each value from another score with this score.
     * <p>Note that as score objects are immutable, the original score will not be changed.</p>
     *
     * @param other The score to add
     * @return A new score which is the addition of the current with the other score.
     */
    public @Nonnull
    Score add(Score other) {
        return score()
                .withBatterRuns(batterRuns + other.batterRuns)
                .withWides(wides + other.wides)
                .withWideDeliveries(wideDeliveries + other.wideDeliveries)
                .withNoBalls(noBalls + other.noBalls)
                .withLegByes(legByes + other.legByes)
                .withByes(byes + other.byes)
                .withPenaltyRuns(penaltyRuns + other.penaltyRuns)
                .withWickets(wickets + other.wickets)
                .withDots(dots + other.dots)
                .withSingles(singles + other.singles)
                .withTwos(twos + other.twos)
                .withThrees(threes + other.threes)
                .withFours(fours + other.fours)
                .withSixes(sixes + other.sixes)
                .withValidDeliveries(validDeliveries + other.validDeliveries)
                .build();
    }

    /**
     * Creates a new score by subtracting each value from another score from each value in this score.
     * <p>Note that as score objects are immutable, the original score will not be changed.</p>
     *
     * @param other The score to subtract
     * @return A new score which is the addition of the current with the other score.
     */
    public @Nonnull
    Score subtract(Score other) {
        return score()
                .withBatterRuns(batterRuns - other.batterRuns)
                .withWides(wides - other.wides)
                .withWideDeliveries(wideDeliveries - other.wideDeliveries)
                .withNoBalls(noBalls - other.noBalls)
                .withLegByes(legByes - other.legByes)
                .withByes(byes - other.byes)
                .withPenaltyRuns(penaltyRuns - other.penaltyRuns)
                .withWickets(wickets - other.wickets)
                .withDots(dots - other.dots)
                .withSingles(singles - other.singles)
                .withTwos(twos - other.twos)
                .withThrees(threes - other.threes)
                .withFours(fours - other.fours)
                .withSixes(sixes - other.sixes)
                .withValidDeliveries(validDeliveries - other.validDeliveries)
                .build();
    }

    @Override
    public @Nonnull
    String toString() {
        return "Score{" +
                "batterRuns=" + batterRuns +
                ", wides=" + wides +
                ", wideDeliveries=" + wideDeliveries +
                ", noBalls=" + noBalls +
                ", legByes=" + legByes +
                ", byes=" + byes +
                ", penaltyRuns=" + penaltyRuns +
                ", wickets=" + wickets +
                ", dots=" + dots +
                ", singles=" + singles +
                ", twos=" + twos +
                ", threes=" + threes +
                ", fours=" + fours +
                ", sixes=" + sixes +
                ", validDeliveries=" + validDeliveries +
                '}';
    }

    /**
     * Parses a scorecard value for a score.
     * <p>Examples of scores:</p>
     * <ul>
     * <li><strong>0</strong> or <strong>.</strong> which returns {@link #DOT_BALL}</li>
     * <li><strong>1</strong> which returns {@link #SINGLE}</li>
     * <li><strong>2</strong> which returns {@link #TWO}</li>
     * <li><strong>3</strong> which returns {@link #THREE}</li>
     * <li><strong>4</strong> which returns {@link #FOUR}</li>
     * <li><strong>5</strong> which returns a score of 5 runs</li>
     * <li><strong>6</strong> which returns {@link #SIX}</li>
     * <li><strong>1lb</strong> which returns {@link #LEG_BYE}</li>
     * <li><strong>2lb</strong> which returns 2 leg byes</li>
     * <li><strong>W</strong> which returns a wicket without a run</li>
     * <li><strong>1w</strong> which returns {@link #WIDE}</li>
     * <li><strong>1nb</strong> which returns {@link #NO_BALL}</li>
     * <li><strong>5nb</strong> which a no-ball with 4 runs off the bat</li>
     * <li>etc</li>
     * </ul>
     *
     * @param text A score, such as &quot;1&quot;, &quot;1lb&quot; &quot;W&quot; etc
     * @return A built score, or null if unknown
     */
    public static Score parse(String text) {
        if (".".equals(text)) { return DOT_BALL; }
        if ("W".equals(text)) { return WICKET; }
        Pattern pattern = Pattern.compile("^(?<num>[0-9]+)(?<modifier>[A-Za-z]+)?$");
        Matcher matcher = pattern.matcher(text);
        if (!matcher.matches()) {
            return null;
        }
        int runs = Integer.parseInt(matcher.group("num"));
        String modifier = matcher.group("modifier");
        Builder score = Score.score();
        int batterRuns = runs;
        boolean dotBallIfNoRuns = true;
        if (modifier == null) {
            score.withValidDeliveries(1);
        } else {
            switch (modifier) {
                case "W":
                    score.withWickets(1).withValidDeliveries(1).withBatterRuns(runs);
                    break;
                case "w":
                    batterRuns = 0;
                    score.withWides(runs).withWideDeliveries(1);
                    dotBallIfNoRuns = false;
                    break;
                case "nb":
                    batterRuns = runs - 1;
                    score.withNoBalls(1).withBatterRuns(batterRuns);
                    dotBallIfNoRuns = false;
                    break;
                case "b":
                    batterRuns = 0;
                    score.withByes(runs).withValidDeliveries(1);
                    break;
                case "lb":
                    batterRuns = 0;
                    score.withLegByes(runs).withValidDeliveries(1).withDots(1);
                    break;
            }
        }
        return score
                .withBatterRuns(batterRuns)
                .withDots(dotBallIfNoRuns && batterRuns == 0 ? 1 : 0)
                .withSingles(batterRuns == 1 ? 1 : 0)
                .withTwos(batterRuns == 2 ? 1 : 0)
                .withThrees(batterRuns == 3 ? 1 : 0)
                .withFours(batterRuns == 4 ? 1 : 0)
                .withSixes(batterRuns == 6 ? 1 : 0)
                .build();
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Score score = (Score) o;
        return batterRuns == score.batterRuns &&
                wides == score.wides &&
                wideDeliveries == score.wideDeliveries &&
                noBalls == score.noBalls &&
                legByes == score.legByes &&
                byes == score.byes &&
                penaltyRuns == score.penaltyRuns &&
                wickets == score.wickets &&
                dots == score.dots &&
                singles == score.singles &&
                twos == score.twos &&
                threes == score.threes &&
                fours == score.fours &&
                sixes == score.sixes &&
                validDeliveries == score.validDeliveries;
    }

    @Override
    public @Nonnegative
    int hashCode() {
        return Objects.hash(batterRuns, wides, wideDeliveries, noBalls, legByes, byes, penaltyRuns, wickets, dots, singles, twos, threes,
                fours, sixes, validDeliveries);
    }

    /**
     * A builder to create a {@link Score} object.
     * <p>The runs scored and the number of valid deliveries needs to be set on almost all scores. For
     * example, if setting {@link #withLegByes(int)} off a fair delivery, then {@link #withValidDeliveries(int)} should be called as well.
     * However, if the ball was a wide, then {@link #withWides(int)} should be called instead.</p>
     */
    public static final class Builder {
        private int batterRuns      = 0;
        private int wides           = 0;
        private int noBalls         = 0;
        private int legByes         = 0;
        private int byes            = 0;
        private int penaltyRuns     = 0;
        private int wickets         = 0;
        private int singles         = 0;
        private int twos            = 0;
        private int threes          = 0;
        private int fours           = 0;
        private int sixes           = 0;
        private int validDeliveries = 0;
        private int dots            = 0;
        private int wideDeliveries  = 0;

        /**
         * @param batterRuns The number of runs scored off the bat. You should also call one of {@link #withSingles(int)}, {@link
         *                   #withTwos(int)}, {@link #withThrees(int)}, {@link #withFours(int)}, {@link #withSixes(int)} if it is one of
         *                   those amounts.
         * @return This builder
         */
        public @Nonnull
        Builder withBatterRuns(@Nonnegative int batterRuns) {
            this.batterRuns = batterRuns;
            return this;
        }

        /**
         * The number of runs scored from wides. Note this is a separate from the number of deliveries that were bowled that were wides,
         * which needs to also be set with both {@link #withWideDeliveries(int)}.
         *
         * @param wides The number of runs scored from wides.
         * @return This builder
         * @see #withWideDeliveries(int)
         */
        public @Nonnull
        Builder withWides(@Nonnegative int wides) {
            this.wides = wides;
            return this;
        }

        /**
         * @param wideDeliveries The number of deliveries that were bowled wide
         * @return This builder
         * @see #withWides(int)
         */
        public @Nonnull
        Builder withWideDeliveries(@Nonnegative int wideDeliveries) {
            this.wideDeliveries = wideDeliveries;
            return this;
        }

        /**
         * The number of runs no-balls delivered.
         * <p>Note that if runs were scored off a no-ball, then this value would be 1 and the runs scored would
         * be set with {@link #withBatterRuns(int)}.</p>
         *
         * @param noBalls The number of no-balls delivered.
         * @return This builder
         */
        public @Nonnull
        Builder withNoBalls(@Nonnegative int noBalls) {
            this.noBalls = noBalls;
            return this;
        }

        /**
         * @param legByes The number of leg byes run
         * @return This builder
         */
        public @Nonnull
        Builder withLegByes(@Nonnegative int legByes) {
            this.legByes = legByes;
            return this;
        }

        /**
         * @param byes The number of byes run
         * @return This builder
         */
        public @Nonnull
        Builder withByes(@Nonnegative int byes) {
            this.byes = byes;
            return this;
        }

        /**
         * @param penaltyRuns The number of penalty runs awarded, for example 5 if the ball hits the helmet behind the wicket keeper.
         * @return This builder
         */
        public @Nonnull
        Builder withPenaltyRuns(@Nonnegative int penaltyRuns) {
            this.penaltyRuns = penaltyRuns;
            return this;
        }

        /**
         * @param wickets The number of wickets taken
         * @return This builder
         */
        public @Nonnull
        Builder withWickets(@Nonnegative int wickets) {
            this.wickets = wickets;
            return this;
        }

        /**
         * @param dots The number of dot balls (i.e. balls with no runs and no extras)
         * @return This builder
         */
        public @Nonnull
        Builder withDots(@Nonnegative int dots) {
            this.dots = dots;
            return this;
        }

        /**
         * Sets the number of singles run. For a single valid delivery where one run is scored off the bat, this value should be 1; {@link
         * #withBatterRuns(int)} should be 1; and {@link #withValidDeliveries(int)} should be 1.
         *
         * @param singles The number of times a single was scored from the bat
         * @return This builder
         */
        public @Nonnull
        Builder withSingles(@Nonnegative int singles) {
            this.singles = singles;
            return this;
        }

        /**
         * Sets the number of twos. For a single valid delivery where two runs are scored off the bat, this value should be 1; {@link
         * #withBatterRuns(int)} should be 2; and {@link #withValidDeliveries(int)} should be 1.
         *
         * @param twos The number of times a two was scored from the bat
         * @return This builder
         */
        public @Nonnull
        Builder withTwos(@Nonnegative int twos) {
            this.twos = twos;
            return this;
        }

        /**
         * Sets the number of threes. For a single valid delivery where three runs are scored off the bat, this value should be 1; {@link
         * #withBatterRuns(int)} should be 3; and {@link #withValidDeliveries(int)} should be 1.
         *
         * @param threes The number of times a three was scored from the bat
         * @return This builder
         */
        public @Nonnull
        Builder withThrees(@Nonnegative int threes) {
            this.threes = threes;
            return this;
        }

        /**
         * Sets the number of balls that were struck along the ground to the boundary (so this excludes when 4 runs are run by the batters,
         * or when 4 wides, byes, or leg-byes occur). For a single valid delivery the boundary is scored off the bat, this value should be
         * 1; {@link #withBatterRuns(int)} should be 4; and {@link #withValidDeliveries(int)} should be 1.
         *
         * @param fours The number of boundaries (for four) hit off the bat.
         * @return This builder.
         */
        public @Nonnull
        Builder withFours(@Nonnegative int fours) {
            this.fours = fours;
            return this;
        }

        /**
         * Sets the number of balls that were struck over boundary on the full (so this excludes the unlikely case where the batters run 6
         * runs). For a single valid delivery where a six is hit, this value should be 1; {@link #withBatterRuns(int)} should be 6; and
         * {@link #withValidDeliveries(int)} should be 1.
         *
         * @param sixes The number of sixes hit.
         * @return This builder.
         */
        public @Nonnull
        Builder withSixes(@Nonnegative int sixes) {
            this.sixes = sixes;
            return this;
        }

        /**
         * @param count The number of legal deliveries (i.e. number of balls that are not wides or no-balls)
         * @return This builder
         */
        public @Nonnull
        Builder withValidDeliveries(@Nonnegative int count) {
            this.validDeliveries = count;
            return this;
        }

        /**
         * Creates a builder from a score instance
         *
         * @param score The score to base the builder on
         * @return A new builder
         */
        public static @Nonnull
        Builder from(Score score) {
            return new Builder()
                    .withThrees(score.threes())
                    .withTwos(score.twos())
                    .withSingles(score.singles())
                    .withBatterRuns(score.batterRuns())
                    .withValidDeliveries(score.validDeliveries())
                    .withDots(score.dots())
                    .withByes(score.byes())
                    .withFours(score.fours())
                    .withLegByes(score.legByes())
                    .withNoBalls(score.noBalls())
                    .withPenaltyRuns(score.penaltyRuns())
                    .withSixes(score.sixes())
                    .withWickets(score.wickets())
                    .withWides(score.wides())
                    .withWideDeliveries(score.wideDeliveries());
        }

        private static final Score[] COMMON = new Score[] {
                EMPTY, DOT_BALL, SIX, FOUR, THREE, TWO, SINGLE, WIDE, NO_BALL, WICKET, BYE, LEG_BYE
        };

        public @Nonnull
        Score build() {
            Score score = new Score(batterRuns, wides, wideDeliveries, noBalls, legByes, byes, penaltyRuns, wickets,
                    dots, singles, twos, threes, fours, sixes, validDeliveries);
            for (Score cached : COMMON) {
                if (score.equals(cached)) {
                    return cached;
                }
            }
            return score;
        }

    }
}
