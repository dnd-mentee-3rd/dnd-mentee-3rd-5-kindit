package com.dnd.kindit.retrofit.domain.response

data class CommonResponse(var message: String, var result: String) {
    override fun toString(): String {
        return "CommonResponse(message='$message', result='$result')"
    }
}