package enumerationtype

// 느낌이지만 마치 enum 들 중에 하나를 고르면 하나의 객체를 뽑아주는 것 같다.
enum class PaymentStatus(val label: String) : Payable {
    UNPAID(label = "미지급") { override fun isPayable(): Boolean = true },
    PAID(label = "지급완료") { override fun isPayable(): Boolean = false },
    FAILED(label = "지급실패") { override fun isPayable(): Boolean = false },
    REFUNDED(label = "환불") { override fun isPayable(): Boolean = false };
}

interface Payable {
    fun isPayable() : Boolean
}

fun main() {
    println(PaymentStatus.UNPAID.label)

    if (PaymentStatus.UNPAID.isPayable()) {
        println("결제 가능 상태")
    }

    val paymentStatus: PaymentStatus = PaymentStatus.valueOf("unpaid".uppercase())
    println(paymentStatus.label)

    if (paymentStatus == PaymentStatus.UNPAID) {
        println("일치합니다")
    }

    for (status in PaymentStatus.values()) {
        println("[${status.name}](${status.label}) : ${status.ordinal}")
    }
}