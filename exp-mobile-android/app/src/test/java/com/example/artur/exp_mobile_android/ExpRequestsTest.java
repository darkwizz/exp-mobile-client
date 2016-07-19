package com.example.artur.exp_mobile_android;

import com.example.artur.exp_mobile_android.model.ExpWebServices;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExpRequestsTest {
    @Test
    public void testLogin() {
        ExpWebServices api = new ExpWebServices();
        String token = api.login("psyhoge@gmail.com", "ololo");
        Assert.assertNotNull(token);
    }
}