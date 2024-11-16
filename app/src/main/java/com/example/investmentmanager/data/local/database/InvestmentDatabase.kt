import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Investment::class], version = 1)
abstract class InvestmentDatabase : RoomDatabase() {
    abstract fun investmentDao(): InvestmentDao

    companion object {
        @Volatile
        private var INSTANCE: InvestmentDatabase? = null

        fun getDatabase(context: Context): InvestmentDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InvestmentDatabase::class.java,
                    "investment_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
