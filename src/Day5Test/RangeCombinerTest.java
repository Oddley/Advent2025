package Day5Test;

import Day2.IDRange;
import Day5.RangeCombiner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RangeCombinerTest {
    public static final IDRange ElevenTwelve = new IDRange(11,12);
    public static final IDRange TenFourteen = new IDRange(10,14);
    public static final IDRange SixteenTwenty = new IDRange(16,20);
    public static final IDRange TwelveEighteen = new IDRange(12,18);
    public static final IDRange TenEighteen = new IDRange(10,18);
    public static final IDRange TenTwenty = new IDRange(10,20);

    @Test
    void hasOverlap() {
        assertAll(
                ()->assertTrue(RangeCombiner.HasOverlap(TenFourteen, TwelveEighteen)),
                ()->assertTrue(RangeCombiner.HasOverlap(TwelveEighteen, TenFourteen)),
                ()->assertTrue(RangeCombiner.HasOverlap(TwelveEighteen, SixteenTwenty)),
                ()->assertTrue(RangeCombiner.HasOverlap(TenFourteen, ElevenTwelve))
        );
    }

    @Test
    void hasNoOverlap() {
        assertAll(
                ()->assertFalse(RangeCombiner.HasOverlap(TenFourteen, SixteenTwenty))
        );
    }

    @Test
    void combinePartialOverlap()
    {
        assertAll(
                ()->assertEquals(TenEighteen, RangeCombiner.Combine(TenFourteen, TwelveEighteen)),
                ()->assertEquals(TenEighteen, RangeCombiner.Combine(TwelveEighteen, TenFourteen))
        );
    }
    @Test
    void combineCompleteOverlap()
    {
        assertEquals(TenFourteen, RangeCombiner.Combine(TenFourteen, ElevenTwelve));
    }

    @Test
    void combineAll() {
        assertEquals(List.of(TenTwenty), RangeCombiner.CombineAll(List.of(TenFourteen, SixteenTwenty, TwelveEighteen)));
    }
}