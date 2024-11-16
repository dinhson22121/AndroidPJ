import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.investmentmanager.presentation.ui.list.InvestmentListScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "investment_list") {
        composable("investment_list") {
            InvestmentListScreen(
                onAddClick = { navController.navigate("add_investment") }
            )
        }
        composable("add_investment") {
            AddInvestmentScreen(
                onSaveClick = { navController.popBackStack() }
            )
        }
    }
}
