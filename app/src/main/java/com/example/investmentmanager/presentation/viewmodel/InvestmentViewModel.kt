import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class InvestmentViewModel(private val repository: InvestmentRepository) : ViewModel() {

    fun getInvestmentsByCategory(category: String) = repository.getInvestmentsByCategory(category)

    fun getTotalAmountByCategory(category: String) = repository.getTotalAmountByCategory(category)

    fun addInvestment(investment: Investment) = viewModelScope.launch {
        repository.insertInvestment(investment)
    }

    fun updateInvestment(investment: Investment) = viewModelScope.launch {
        repository.updateInvestment(investment)
    }

    fun deleteInvestment(investment: Investment) = viewModelScope.launch {
        repository.deleteInvestment(investment)
    }
}

class InvestmentViewModelFactory(private val repository: InvestmentRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InvestmentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return InvestmentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
