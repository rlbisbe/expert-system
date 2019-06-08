package net.rlbisbe.expert;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ExpertSystemTest {

    private ExpertSystem expertSystem;
    private static final Option TRUE = new Option("yes");
    private static final Option FALSE = new Option("no");

    @Before
    public void setUp() {
        expertSystem = new ExpertSystem(new YamlLoader());
    }

    @Test
    public void question() {
        assertThat(expertSystem.getMessage()).isEqualTo("Are you able to see any wifi network?");
    }

@Test
public void firstAnswerYes() {
    assertThat(expertSystem.getMessage()).isEqualTo("Are you able to see any wifi network?");
    expertSystem.answer(TRUE.getValue());
    assertThat(expertSystem.getMessage()).isEqualTo("Is the network ID visible?");
    assertThat(expertSystem.isDone()).isFalse();
}

    @Test
    public void secondAnswerYesYesDone() {
        assertThat(expertSystem.getMessage()).isEqualTo("Are you able to see any wifi network?");
        expertSystem.answer(TRUE.getValue());
        assertThat(expertSystem.getMessage()).isEqualTo("Is the network ID visible?");
        expertSystem.answer(TRUE.getValue());
        assertThat(expertSystem.getMessage()).isEqualTo("Contact your network provider");
        assertThat(expertSystem.isDone()).isTrue();
    }

    @Test
    public void firstAnswerNo() {
        assertThat(expertSystem.getMessage()).isEqualTo("Are you able to see any wifi network?");
        expertSystem.answer(FALSE.getValue());
        assertThat(expertSystem.getMessage()).isEqualTo("Wireless network might be off. Reboot computer");
    }
}