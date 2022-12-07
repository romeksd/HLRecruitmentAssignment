package hlrecruitmentassignment.uk.co.hl

import android.view.View
import com.google.android.material.textfield.TextInputEditText
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

/**
 * A custom matcher that checks the error property of a {@link TextInputEditText}. It
 * accepts a {@link String}.
 */
object TextInputLayoutErrorMatcher {

    fun hasTextInputLayoutErrorText(expectedErrorMsg: String): Matcher<View> =
        object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description?) {
            }

            override fun matchesSafely(item: View?): Boolean {
                if (item !is TextInputEditText) return false
                val error = item.error ?: return false

                return expectedErrorMsg == error
            }
        }


}