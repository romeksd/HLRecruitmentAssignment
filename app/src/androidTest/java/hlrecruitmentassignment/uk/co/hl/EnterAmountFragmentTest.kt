package hlrecruitmentassignment.uk.co.hl

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import hlrecruitmentassignment.uk.co.hl.TextInputLayoutErrorMatcher.hasTextInputLayoutErrorText
import hlrecruitmentassignment.uk.co.hl.ui.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class EnterAmountFragmentTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun testValidDecimal() {
        // Type valid decimal number and then press the 'Validate' button.
        onView(withId(R.id.input_value)).perform(
            typeText(VALID_DECIMAL), closeSoftKeyboard()
        )
        onView(withId(R.id.btn_validate)).perform(click())

        // Check that the entered decimal number is shown in the current fragment
        onView(withId(R.id.message)).check(matches(withText("Entered value: " + VALID_DECIMAL.toDouble())))

        // Check 'Show Next Screen' button is visible and click if it is visible
        onView(withId(R.id.btn_next_screen)).check(matches(isEnabled())).perform(click())

        // Check that the entered decimal number is shown in the next fragment
        onView(withId(R.id.entered_amount)).check(
            matches(
                withText(
                    VALID_DECIMAL.toDouble().toString()
                )
            )
        )
    }

    @Test
    fun testInvalidDecimal() {
        // Type the invalid decimal number and then press the 'Validate' button.
        onView(withId(R.id.input_value)).perform(
            typeText(INVALID_DECIMAL), closeSoftKeyboard()
        )
        onView(withId(R.id.btn_validate)).perform(click())

        val expectedError =
            ApplicationProvider.getApplicationContext<Context>().resources.getString(R.string.error_message)
        // Check that the error message is shown
        onView(withId(R.id.input_value)).check(
            matches(
                hasTextInputLayoutErrorText(expectedError)
            )
        )
    }

    companion object {
        const val VALID_DECIMAL = "21"
        const val INVALID_DECIMAL = "invalid"
    }


}

