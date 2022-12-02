package hlrecruitmentassignment.uk.co.hl.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import hlrecruitmentassignment.uk.co.hl.databinding.FragmentShowAmountBinding

class ShowAmountFragment : Fragment() {

    private var _binding: FragmentShowAmountBinding? = null
    private val binding get() = _binding!!
    private val args: ShowAmountFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShowAmountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.enteredAmount.text = args.inputValue
    }
}