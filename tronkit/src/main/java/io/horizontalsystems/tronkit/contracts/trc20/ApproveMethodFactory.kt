package io.horizontalsystems.tronkit.contracts.trc20

import io.horizontalsystems.tronkit.models.Address
import io.horizontalsystems.tronkit.contracts.ContractMethodFactory
import io.horizontalsystems.tronkit.contracts.ContractMethodHelper
import io.horizontalsystems.tronkit.toBigInteger
import java.lang.Exception
import java.math.BigInteger

object ApproveMethodFactory : ContractMethodFactory {

    override val methodId = ContractMethodHelper.getMethodId(ApproveMethod.methodSignature)

    override fun createMethod(inputArguments: ByteArray): ApproveMethod {
        try {
            val address = Address.fromRawWithoutPrefix(inputArguments.copyOfRange(12, 32))
            val value = inputArguments.copyOfRange(32, 64).toBigInteger()

            return ApproveMethod(address, value)
        } catch (e: Exception) {
            e.printStackTrace()
            val address = Address.fromRawWithoutPrefix(inputArguments.copyOfRange(12, 32))
            return ApproveMethod(address, BigInteger("0"))
        }
    }

}
