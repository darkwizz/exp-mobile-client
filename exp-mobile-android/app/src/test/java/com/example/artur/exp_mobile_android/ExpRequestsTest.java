package com.example.artur.exp_mobile_android;

import com.example.artur.exp_mobile_android.model.ExpWebServices;

import org.junit.Assert;
import org.junit.Test;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExpRequestsTest {
    @Test
    public void testLogin() {
        ExpWebServices api = new ExpWebServices();
        boolean success = api.login("psyhoge@gmail.com", "ololo");
        Assert.assertFalse(success);
    }
}