package com.example.artur.exp_mobile_android.model;

import com.example.artur.exp_mobile_android.model.entities.ExpOpportunity;
import com.example.artur.exp_mobile_android.model.entities.ExpPerson;
import com.example.artur.exp_mobile_android.model.exceptions.InvalidTokenException;

import java.util.List;

/**
 * Created by artur on 19.07.16.
 */
public class ExpWebServices {
    /**
     * Logs into EXP system and returns exp auth token.
     * @param email - exp user email;
     * @param password - exp user password;
     * @return authentication token
     */
    public String login(String email, String password) {
        return null;
    }

    /**
     * Logs out from EXP system; makes token invalid.
     * @param token - authentication token;
     * @return <code>true</code> when successive logout;
     *         <code>false</code> when token is already invalid
     */
    // TODO
    public boolean logout(String token) {
        return false;
    }

    /**
     * Gets list of all available opportunities (without filters).
     * @param token - authentication token
     * @return list of opportunities
     */
    // TODO filters
    // TODO pagination (and in server too)
    public List<ExpOpportunity> getOpportunities(String token) throws InvalidTokenException {
        return null;
    }

    /**
     * Gets opportunity with specified identifier.
     * @param token - authentication token;
     * @param id - opportunity id;
     * @return needed opportunity
     */
    public ExpOpportunity getOpportunity(String token, String id) throws InvalidTokenException {
        return null;
    }

    /**
     * Gets list of all registered EPs (without filters).
     * @param token - authenticity token;
     * @return list of EPs
     */
    // TODO filters
    public List<ExpPerson> getEps(String token) throws InvalidTokenException {
        return null;
    }

    /**
     * Gets list of current logged in manager EPs.
     * @param token - authenticity token
     * @return list of EPs
     */
    public List<ExpPerson> getMyEps(String token) throws InvalidTokenException {
        return null;
    }

    /**
     * Gets EP with specified id.
     * @param token - authenticity token;
     * @param id - EP id;
     * @return needed EP
     */
    public ExpPerson getEp(String token, String id) throws InvalidTokenException {
        return null;
    }
}
