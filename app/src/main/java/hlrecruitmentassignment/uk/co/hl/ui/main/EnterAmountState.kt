package hlrecruitmentassignment.uk.co.hl.ui.main

data class EnterAmountState(
    val isShowNextScreenButtonEnabled: Boolean = false,
    val formattedValue: String? = null,
    val isErrorVisible: Boolean = false,
)