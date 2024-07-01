package com.flipkart.bean;

/**
 * Represents an administrator user in the system.
 * Extends the User class.
 */
public class FlipfitGymAdmin extends FlipfitGymUser {

    /**
     * Constructs a new Admin user with default values.
     */
    public FlipfitGymAdmin() {
        super("0", "admin", "admin@flipfit.com", "Admin@123", FlipfitRole.ADMIN);
    }
}

