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

    /**
     * Test printing population per region
     */
    @Test
    void testPrintPopulationByEachRegion() {
        // Prepare mock data
        List<Population> mockPopulationByEachRegion = new ArrayList<>();
        mockPopulationByEachRegion.add(new Population("Eastern Europe", 4000000L, 3900000L, 100000L, (3900000L / 4000000f) * 100, (100000L / 4000000f) * 100));

        // Define behavior for the mock DAO
        when(mockEachPopulationDAO.getPopulationByEachRegion()).thenReturn(mockPopulationByEachRegion);

        // Call the method
        eachPopulationReport.printPopulationByEachRegion();

        // Verify output methods were called
        verify(mockEachPopulationDAO).getPopulationByEachRegion();
    }

    /**
     * Test printing population per region with null, empty list, and null members in the list.
     */
    @Test
    void testPrintPopulationByEachRegion_NullEmptyAndNullMembers() {
        // Test with null
        when(mockEachPopulationDAO.getPopulationByEachRegion()).thenReturn(null);
        eachPopulationReport.printPopulationByEachRegion();

        // Test with empty list
        when(mockEachPopulationDAO.getPopulationByEachRegion()).thenReturn(new ArrayList<>());
        eachPopulationReport.printPopulationByEachRegion();

        // Test with null member
        List<Population> mockPopulationsWithNullMembers = new ArrayList<>();
        mockPopulationsWithNullMembers.add(new Population("Southeast Asia", 4000000L, 3900000L, 100000L, (3900000L / 4000000f) * 100, (100000L / 4000000f) * 100));
        mockPopulationsWithNullMembers.add(null);
        when(mockEachPopulationDAO.getPopulationByEachRegion()).thenReturn(mockPopulationsWithNullMembers);
        eachPopulationReport.printPopulationByEachRegion();
    }

    /**
     * Test printing population per country
     */
    @Test
    void testPrintPopulationByEachCountry() {
        // Prepare mock data
        List<Population> mockPopulationByEachCountry = new ArrayList<>();
        mockPopulationByEachCountry.add(new Population("Germany", 4000000L, 3900000L, 100000L, (3900000L / 4000000f) * 100, (100000L / 4000000f) * 100));

        // Define behavior for the mock DAO
        when(mockEachPopulationDAO.getPopulationByEachCountry()).thenReturn(mockPopulationByEachCountry);

        // Call the method
        eachPopulationReport.printPopulationByEachCountry();

        // Verify output methods were called
        verify(mockEachPopulationDAO).getPopulationByEachCountry();
    }

    /**
     * Test printing population per country with null, empty list, and null members in the list.
     */
    @Test
    void testPrintPopulationByEachCountry_NullEmptyAndNullMembers() {
        // Test with null
        when(mockEachPopulationDAO.getPopulationByEachCountry()).thenReturn(null);
        eachPopulationReport.printPopulationByEachCountry();

        // Test with empty list
        when(mockEachPopulationDAO.getPopulationByEachCountry()).thenReturn(new ArrayList<>());
        eachPopulationReport.printPopulationByEachCountry();

        // Test with null member
        List<Population> mockPopulationsWithNullMembers = new ArrayList<>();
        mockPopulationsWithNullMembers.add(new Population("Myanmar", 4000000L, 3900000L, 100000L, (3900000L / 4000000f) * 100, (100000L / 4000000f) * 100));
        mockPopulationsWithNullMembers.add(null);
        when(mockEachPopulationDAO.getPopulationByEachCountry()).thenReturn(mockPopulationsWithNullMembers);
        eachPopulationReport.printPopulationByEachCountry();
    }
}
