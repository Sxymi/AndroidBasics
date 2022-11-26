package org.sxymi.androidbasics;

import org.junit.Test;
import org.sxymi.androidbasics.classes.Functions;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void checkGoToActivityWithNull() {
        Functions.goToActivity(null, null);
    }

    @Test
    public void checKIsEditTextEmptyWithNull() {
        Functions.isEditTextEmpty(null);
    }
}