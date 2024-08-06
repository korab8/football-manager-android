package com.korab.footballmanager

import com.korab.footballmanager.data.Team
import com.korab.footballmanager.util.FixtureGenerator
import junit.framework.TestCase.assertEquals
import org.junit.Test

/**
 * @author korab.muhadri
 */

class FixtureGeneratorTest {
    @Test
    fun `generateFixtures should produce 380 fixtures for 20 teams`() {
        val teams = (1..20).map { Team(id = it, name = "Team $it", coachName = "Coach $it", city = "City $it") }

        val fixtures = FixtureGenerator.generateFixtures(teams)

        assertEquals(380, fixtures.size)
    }
}
