import org.junit.*;

public class SoundSystemTest {
    public SoundSystemTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void setAndGet() {
        SoundSystem soundSystem = new SoundSystem();
        Assert.assertEquals(40, soundSystem.getSpeaker1().getWatts());
        Assert.assertEquals(40, soundSystem.getSpeaker2().getWatts());

        Speaker speaker1 = new Speaker(60);
        soundSystem.setSpeaker1(speaker1);
        Assert.assertEquals(60, soundSystem.getSpeaker1().getWatts());

        Speaker speaker2 = new Speaker(20);
        soundSystem.setSpeaker2(speaker2);
        Assert.assertEquals(20, soundSystem.getSpeaker2().getWatts());

        speaker1 = new Speaker(80);
        speaker2 = new Speaker(30);

        SoundSystem soundSystem2 = new SoundSystem(speaker1, speaker2);
        Assert.assertEquals(80, soundSystem2.getSpeaker1().getWatts());
        Assert.assertEquals(30, soundSystem2.getSpeaker2().getWatts());
    }

    @Test
    public void totalWatts() {
        SoundSystem soundSystem = new SoundSystem();
        Assert.assertEquals(80, soundSystem.getTotalWatts());
        Speaker speaker1 = new Speaker(50);
        Speaker speaker2 = new Speaker(50);
        SoundSystem soundSystem2 = new SoundSystem(speaker1, speaker2);
        Assert.assertEquals(100, soundSystem2.getTotalWatts());
        speaker1 = new Speaker(50);
        speaker2 = new Speaker(100);
        SoundSystem soundSystem3 = new SoundSystem(speaker1, speaker2);
        Assert.assertEquals(150, soundSystem3.getTotalWatts());
    }

    @Test
    public void averageRate() {
        SoundSystem soundSystem = new SoundSystem();
        Assert.assertEquals(2.0, soundSystem.getAverageRating(), 0.01);
        Speaker speaker1 = new Speaker(100);
        Speaker speaker2 = new Speaker(25);
        SoundSystem soundSystem2 = new SoundSystem(speaker1, speaker2);
        Assert.assertEquals(3.0, soundSystem2.getAverageRating(), 0.01);
        speaker1 = new Speaker(70);
        speaker2 = new Speaker(85);
        SoundSystem soundSystem3 = new SoundSystem(speaker1, speaker2);
        Assert.assertEquals(3.5, soundSystem3.getAverageRating(), 0.01);

    }
}
