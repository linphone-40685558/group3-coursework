package com.napier.gp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class EachPopulationReportUnitTest {

    private EachPopulation_report eachPopulationReport;
    private EachPopulationDAO mockEachPopulationDAO;
    private Connection mockConnection;

    /**
     * Set up for testing
     */
    @BeforeEach
    void setUp() {
        // Mocking the Connection and EachPopulationDAO
        mockConnection = mock(Connection.class);
        mockEachPopulationDAO = mock(EachPopulationDAO.class);

        // Initializing EachPopulation_report with the mocked DAO
        eachPopulationReport = new EachPopulation_report(mockConnection);
        eachPopulationReport.eachPopulationDAO = mockEachPopulationDAO; // Inject the mock DAO into EachPopulation_report
    }

    /**
     * Test printing population per continent
     */
    @Test
    void testPrintPopulationByEachContinent() {
        // Prepare mock data
        List<Population> mockPopulationByEachContinent = new ArrayList<>();
        mockPopulationByEachContinent.add(new Population("Europe", 4000000L, 3900000L, 100000L, (3900000L / 4000000f) * 100, (100000L / 4000000f) * 100));

        // Define behavior for the mock DAO
        when(mockEachPopulationDAO.getPopulationByEachContinent()).thenReturn(mockPopulationByEachContinent);

        // Call the method
        eachPopulationReport.printPopulationByEachContinent();

        // Verify output methods were called
        verify(mockEachPopulationDAO).getPopulationByEachContinent();
    }

    /**
     * Test printing population per continent with null, empty list, and null members in the list.
     */
    @Test
    void testPrintPopulationByEachContinent_NullEmptyAndNullMembers() {
        // Test with null
        when(mockEachPopulationDAO.getPopulationByEachContinent()).thenReturn(null);
        eachPopulationReport.printPopulationByEachContinent();

        // Test with empty list
        when(mockEachPopulationDAO.getPopulationByEachContinent()).thenReturn(new ArrayList<>());
        eachPopulationReport.printPopulationByEachContinent();

        // Test with null member
        List<Population> mockPopulationsWithNullMembers = new ArrayList<>();
        mockPopulationsWithNullMembers.add(new Population("Asia", 4000000L, 3900000L, 100000L, (3900000L / 4000000f) * 100, (100000L / 4000000f) * 100));
        mockPopulationsWithNullMembers.add(null);
        when(mockEachPopulationDAO.getPopulationByEachContinent()).thenReturn(mockPopulationsWithNullMembers);
        eachPopulationReport.printPopulationByEachContinent();
    }

}
