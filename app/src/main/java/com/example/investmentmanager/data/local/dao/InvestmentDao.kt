import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface InvestmentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInvestment(investment: Investment)

    @Update
    suspend fun updateInvestment(investment: Investment)

    @Delete
    suspend fun deleteInvestment(investment: Investment)

    @Query("SELECT * FROM investments WHERE category = :category")
    fun getInvestmentsByCategory(category: String): LiveData<List<Investment>>

    @Query("SELECT SUM(amount) FROM investments WHERE category = :category")
    fun getTotalAmountByCategory(category: String): LiveData<Double>
}
