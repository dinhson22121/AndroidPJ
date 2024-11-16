import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "investments")
data class Investment(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val category: String,
    val amount: Double,
    val expectedProfit: Double,
    val actualProfit: Double,
    val status: String
)
