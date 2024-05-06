package es.leanmind;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainShould {
    @Test
    void fail() {
        assertThat(1).isEqualTo(2);
    }
}
