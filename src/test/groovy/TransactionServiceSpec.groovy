import groovy.util.logging.Slf4j
import org.nofdev.transaction.*
import org.nofdev.transaction.domain.Customer
import org.nofdev.transaction.domain.Transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

/**
 * Created by Qiang on 3/12/15.
 */
@ActiveProfiles("test")
@ContextConfiguration(loader = SpringApplicationContextLoader, classes = [Application])
@Slf4j
@IntegrationTest
@Transactional
class TransactionServiceSpec extends Specification {
    @Autowired
    private TransactionService transactionService

    def setup(){

    }

    def cleanup() {

    }

    void "使用用户张三创建一条86元5角人民币的交易记录，交易状态为等待付款，交易的金额为86元5角，交易时间为创建时间"() {
        setup:
        def customer = new Customer(firstName: "三", lastName: "张").save(flush: true, failOnError: true)
        def transaction = new TransactionDTO(
                type: TransactionType.PAY,
                amount: 86.50,
                currency: PayCurrency.RMB,
                customer: new CustomerDTO(id: customer.id)
        )
        def result = transactionService.create(transaction)
        expect:
        result.id != ""
        result.status == TransactionStatus.PAYING
        result.amount == new BigDecimal(86.50)
    }

    void "初始化3条交易成功信息，4条交易失败（有两条是张三的）信息。验证全部状态的交易共7条，交易成功的3条，交易失败的4条，其中2条是张三的"() {
        setup:
        def zhangsan = new Customer(firstName: "三", lastName: "张").save(flush: true, failOnError: true)
        def lisi = new Customer(firstName: "四", lastName: "李").save(flush: true, failOnError: true)
        new Transaction(
                status: "SUCCESS",
                type: "PAY",
                amount: 76.50,
                currency: "RMB",
                customer: lisi
        ).save(flush: true, failOnError: true)
        new Transaction(
                status: "SUCCESS",
                type: "PAY",
                amount: 86.50,
                currency: "RMB",
                customer: lisi
        ).save(flush: true, failOnError: true)
        new Transaction(
                status: "SUCCESS",
                type: "PAY",
                amount: 96.50,
                currency: "RMB",
                customer: lisi
        ).save(flush: true, failOnError: true)
        new Transaction(
                status: "FAILURE",
                type: "PAY",
                amount: 86.50,
                currency: "RMB",
                customer: lisi
        ).save(flush: true, failOnError: true)
        new Transaction(
                status: "FAILURE",
                type: "PAY",
                amount: 86.50,
                currency: "RMB",
                customer: lisi
        ).save(flush: true, failOnError: true)
        new Transaction(
                status: "FAILURE",
                type: "PAY",
                amount: 86.50,
                currency: "RMB",
                customer: zhangsan
        ).save(flush: true, failOnError: true)
        new Transaction(
                status: "FAILURE",
                type: "PAY",
                amount: 86.50,
                currency: "RMB",
                customer: zhangsan
        ).save(flush: true, failOnError: true)

        def result = transactionService.list(criteria)

        expect:
        result.size() == num

        where:
        num | criteria
        7   | null
        3   | new TransactionCriteria(statusEq: "SUCCESS")
        4   | new TransactionCriteria(statusEq: "FAILURE")
    }
}
