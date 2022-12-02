package hlrecruitmentassignment.uk.co.hl.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import hlrecruitmentassignment.uk.co.hl.R
import hlrecruitmentassignment.uk.co.hl.databinding.FragmentEnterAmountBinding

class EnterAmountFragment : Fragment() {

    private var _binding: FragmentEnterAmountBinding? = null
    private val binding get() = _binding!!
    private val viewModel: EnterAmountViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEnterAmountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnValidate.setOnClickListener {
            viewModel.validateEnteredValue(binding.inputValue.text.toString())
        }

        viewModel.getViewState().observe(viewLifecycleOwner, Observer {
            updateViewState(it)
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.clearState()
        binding.inputValue.text?.clear()
    }

    private fun updateViewState(state: EnterAmountState) {
        binding.btnNextScreen.isEnabled = state.isShowNextScreenButtonEnabled
        binding.message.text = if (state.formattedValue.isNullOrEmpty()) "" else getString(R.string.entered_value, state.formattedValue)

        binding.inputValue.error = if (state.isErrorVisible) {
            getString(R.string.error_message)
        } else {
            null
        }
        binding.btnNextScreen.setOnClickListener {
            val action =
                EnterAmountFragmentDirections.actionEnterAmountFragmentToShowAmountFragment(state.formattedValue!!)
            requireView().findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}