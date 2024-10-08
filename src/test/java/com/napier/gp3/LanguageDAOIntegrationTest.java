package com.napier.gp3;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LanguageDAOIntegrationTest {

    static Connection con;
    static LanguageDAO languageDAO;

    @BeforeAll
    void init() {
        // Initialize the database connection
        try {
            App conn = new App();
            conn.connect_function("localhost:33060", 15000);
            con = conn.getCon();
            assertNotNull(con, "Database connection should not be null");
            languageDAO = new LanguageDAO(con);
        } catch (Exception e) {
            fail("Failed to initialize database connection: " + e.getMessage());
        }
    }

    @BeforeEach
    void setup() {
        // Initialize LanguageDAO with the connection
        languageDAO = new LanguageDAO(con);
    }

    @Test
    public void testGetLanguagesByNumberOfPeople() {
        List<Language> languages = languageDAO.getLanguagesByNumberOfPeople();
        assertNotNull(languages, "The list of languages should not be null");
        assertFalse(languages.isEmpty(), "The list of languages should not be empty");

        // Verify that the languages are sorted by the number of people in descending order
        assertTrue(languages.get(0).getNumberOfPeople() >= languages.get(1).getNumberOfPeople(),
                "The list should be sorted by number of people in descending order");

        // Verify that the population percentage is calculated correctly
        double totalPercentage = languages.stream().mapToDouble(Language::getPopulation_percentage).sum();
        assertTrue(totalPercentage <= 100.0, "The total percentage should be less than or equal to 100");
    }

    @AfterAll
    static void tearDownDatabaseConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (Exception e) {
            fail("Failed to close database connection: " + e.getMessage());
        }
    }
}
