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

    /**
     * test languages by number of people who speak in languages
     */
    @Test
    public void testGetLanguagesByNumberOfPeople() {
        List<Language> languages = languageDAO.getLanguagesByNumberOfPeople();
        assertNotNull(languages, "languages can't be null");
        assertFalse(languages.isEmpty(), "languages can't be empty");

        // Verify that the languages are sorted by the number of people in descending order
        assertTrue(languages.get(0).getNumberOfPeople() >= languages.get(1).getNumberOfPeople(),
                "The list of language population should be sorted in descending order");

        // Verify that the population percentage is calculated correctly
        double totalPercentage = languages.stream().mapToDouble(Language::getPopulation_percentage).sum();
        assertTrue(totalPercentage <= 100.0, "The total percentage can't be greater than 100");
    }

    @AfterAll
    static void tearDownDatabaseConnection() {
        // close database connection after languageDAO Integration test
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (Exception e) {
            fail("Failed to close database connection: " + e.getMessage());
        }
    }
}
