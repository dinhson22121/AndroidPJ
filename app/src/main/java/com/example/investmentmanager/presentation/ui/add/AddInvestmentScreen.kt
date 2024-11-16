import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddInvestmentScreen(onSaveClick: (Investment) -> Unit) {
    var name by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var expectedProfit by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        TextField(value = category, onValueChange = { category = it }, label = { Text("Category") })
        TextField(value = amount, onValueChange = { amount = it }, label = { Text("Amount") })
        TextField(value = expectedProfit, onValueChange = { expectedProfit = it }, label = { Text("Expected Profit") })
        TextField(value = status, onValueChange = { status = it }, label = { Text("Status") })
        Button(
            onClick = {
                val investment = Investment(
                    name = name,
                    category = category,
                    amount = amount.toDoubleOrNull() ?: 0.0,
                    expectedProfit = expectedProfit.toDoubleOrNull() ?: 0.0,
                    actualProfit = 0.0,
                    status = status
                )
                onSaveClick(investment)
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Save Investment")
        }
    }
}
