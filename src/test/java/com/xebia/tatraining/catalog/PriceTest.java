package com.xebia.tatraining.catalog;

import java.math.BigDecimal;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PriceTest {

    @Test
    public void priceShouldBePrintedInCorrectFormat() {
        assertThat(new Price(BigDecimal.valueOf(1.23)).toString(), is("€ 1.23"));
        assertThat(new Price(BigDecimal.valueOf(1.231)).toString(), is("€ 1.23"));
        assertThat(new Price(BigDecimal.valueOf(1.225)).toString(), is("€ 1.23"));
        assertThat(new Price(BigDecimal.valueOf(1.2349)).toString(), is("€ 1.23"));
    }

    @Test
    public void canComparePrices() {
        assertThat(new Price(BigDecimal.valueOf(1.23)).isMoreThanOrEqual(new Price(BigDecimal.valueOf(1.23))), is(true));
        assertThat(new Price(BigDecimal.valueOf(1.23)).isMoreThanOrEqual(new Price(BigDecimal.valueOf(1.24))), is(false));
        assertThat(new Price(BigDecimal.valueOf(1.23)).isMoreThanOrEqual(new Price(BigDecimal.valueOf(1.22))), is(true));
    }
}
