package com.napier.gp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class LanguageReportUnitTest {

    private Language_report languageReport;
    private LanguageDAO mockLanguageDAO;
    private Connection mockConnection;

    /**
     * Set up for testing
     */
    @BeforeEach
    void setUp() {
        // Mocking the Connection and LanguageDAO
        mockConnection = mock(Connection.class);
        mockLanguageDAO = mock(LanguageDAO.class);

        // Initializing Language_report with the mocked DAO
        languageReport = new Language_report(mockConnection);
        languageReport.languageDAO = mockLanguageDAO; // Inject the mock DAO into Language_report
    }

    /**
     * Test printing languages by the number of people who speak them
     */
    @Test
    void testPrintLanguagesByNumberOfPeople() {
        // Prepare mock data
        List<Language> mockLanguages = new ArrayList<>();
        mockLanguages.add(new Language("Chinese", 1200000000, 15.00));
        mockLanguages.add(new Language("English", 800000000, 10.00));

        // Define behavior for the mock DAO
        when(mockLanguageDAO.getLanguagesByNumberOfPeople()).thenReturn(mockLanguages);

        // Call the method
        languageReport.printLanguagesByNumberOfPeople();

    }

    /**
     * Test printing languages by the number of people with null, empty list, and null members in the list.
     */
    @Test
    void testPrintLanguagesByNumberOfPeople_NullEmptyAndNullMembers() {
        // Test with null
        when(mockLanguageDAO.getLanguagesByNumberOfPeople()).thenReturn(null);
        languageReport.printLanguagesByNumberOfPeople();

        // Test with empty list
        when(mockLanguageDAO.getLanguagesByNumberOfPeople()).thenReturn(new ArrayList<>());
        languageReport.printLanguagesByNumberOfPeople();

        // Test with null member
        List<Language> mockLanguagesWithNullMembers = new ArrayList<>();
        mockLanguagesWithNullMembers.add(new Language("Chinese", 1200000000, 15.00));
        mockLanguagesWithNullMembers.add(null);
        when(mockLanguageDAO.getLanguagesByNumberOfPeople()).thenReturn(mockLanguagesWithNullMembers);
        languageReport.printLanguagesByNumberOfPeople();
    }
}
