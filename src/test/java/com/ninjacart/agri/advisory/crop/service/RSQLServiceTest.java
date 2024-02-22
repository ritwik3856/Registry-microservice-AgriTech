package com.ninjacart.agri.advisory.crop.service;

import com.ninjacart.agri.advisory.crop.context.TableContext;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import cz.jirutka.rsql.parser.ast.RSQLVisitor;
import org.jooq.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class RSQLServiceTest {

    @Mock
    private RSQLVisitor<Condition, TableContext> jooqRSQLVisitor;

    @Mock
    private RSQLParser rsqlParser;

    @Mock
    private TableContext tableContext; // Mocked instead of instantiated

    @InjectMocks
    private RSQLService rsqlService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetSqlCondition() {
        // Arrange
        String filter = "field==value";
        Node mockNode = mock(Node.class); // Mock Node returned by the parser
        Condition expectedCondition = mock(Condition.class); // Mock Condition to be returned by the visitor

        when(rsqlParser.parse(filter)).thenReturn(mockNode);
        when(mockNode.accept(jooqRSQLVisitor, tableContext)).thenReturn(expectedCondition);

        // Act
        Condition actualCondition = rsqlService.getSqlCondition(filter, tableContext);

        // Assert
        assertNotNull(actualCondition, "Condition should not be null");
        assertEquals(expectedCondition, actualCondition, "The expected and actual conditions should match");

        // Verify interactions
        verify(rsqlParser).parse(filter);
        verify(mockNode).accept(jooqRSQLVisitor, tableContext);
    }
}
