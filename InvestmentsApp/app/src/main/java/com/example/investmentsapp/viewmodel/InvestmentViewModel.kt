import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.investmentsapp.domain.model.Investment
import com.example.investmentsapp.repository.InvestmentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch



class InvestmentViewModel (
    private val repository: InvestmentRepository
) : ViewModel() {

    private val _investments = MutableStateFlow<List<Investment>>(emptyList())
    val investments: StateFlow<List<Investment>> = _investments

    fun fetchInvestments(keypass: String) {
        viewModelScope.launch {
            val response = repository.getInvestments(keypass)
            if (response.isSuccessful) {
                _investments.value = response.body()?.entities ?: emptyList()
            }
        }
    }
}

