package hlrecruitmentassignment.uk.co.hl.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EnterAmountViewModel : ViewModel() {
    private val viewState = MutableLiveData<EnterAmountState>()
    fun getViewState(): LiveData<EnterAmountState> = viewState

    fun validateEnteredValue(amount: String) {
        val decimalValue = amount.toDoubleOrNull()
        when {
            decimalValue != null -> {
                viewState.value = EnterAmountState(
                    isShowNextScreenButtonEnabled = true,
                    formattedValue = decimalValue.toString(),
                    isErrorVisible = false
                )
            }
            else -> {
                viewState.value = EnterAmountState(
                    isShowNextScreenButtonEnabled = false,
                    formattedValue = null,
                    isErrorVisible = true
                )
            }
        }
    }

    fun clearState() {
        viewState.value = EnterAmountState()
    }
}