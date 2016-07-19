package com.example.artur.exp_mobile_android;

import com.example.artur.exp_mobile_android.model.ExpWebServices;
import com.example.artur.exp_mobile_android.model.entities.ExpOpportunity;
import com.example.artur.exp_mobile_android.model.entities.ExpPerson;
import com.example.artur.exp_mobile_android.model.exceptions.InvalidTokenException;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExpRequestsTest {
    @Test
    public void testLogin() {
        ExpWebServices api = new ExpWebServices();
        boolean success = api.login("azaza@gmail.com", "ololo");
        Assert.assertFalse(success);
    }

//    @Test
//    public void testEpRequests() {
//        ExpWebServices api = new ExpWebServices();
//        boolean success = api.login("azaza@mail.com", "trolol");
//        Assert.assertTrue(success);
//        try {
//            List<ExpPerson> eps = api.getEps();
//            Assert.assertNotNull(eps);
//            List<ExpPerson> myEps = api.getMyEps();
//            Assert.assertNotNull(myEps);
//        } catch (InvalidTokenException ex) {
//            Assert.assertTrue("Invalid token", false);
//        }
//    }
//
//    @Test
//    public void testOpportunityRequests() {
//        ExpWebServices api = new ExpWebServices();
//        boolean success = api.login("azaza@mail.com", "trolol");
//        Assert.assertTrue(success);
//        try {
//            List<ExpOpportunity> opportunities = api.getOpportunities();
//            Assert.assertNotNull(opportunities);
//            ExpOpportunity opportunity = api.getOpportunity(opportunities.get(0).getExpId());
//            Assert.assertNotNull(opportunity);
//        } catch (InvalidTokenException ex) {
//            Assert.assertTrue("Invalid token", false);
//        }
//    }
}