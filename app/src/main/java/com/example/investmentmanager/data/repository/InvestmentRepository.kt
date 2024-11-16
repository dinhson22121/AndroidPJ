class InvestmentRepository(private val dao: InvestmentDao) {
    fun getInvestmentsByCategory(category: String) = dao.getInvestmentsByCategory(category)
    fun getTotalAmountByCategory(category: String) = dao.getTotalAmountByCategory(category)

    suspend fun insertInvestment(investment: Investment) = dao.insertInvestment(investment)
    suspend fun updateInvestment(investment: Investment) = dao.updateInvestment(investment)
    suspend fun deleteInvestment(investment: Investment) = dao.deleteInvestment(investment)
}
