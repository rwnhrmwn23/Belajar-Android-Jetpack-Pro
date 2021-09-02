package com.onedev.dicoding.architecturecomponent.data.source.remote.response

class ApiResponse<T>(val status: ApiStatusResponse, val body: T, val message: String?) {

    companion object {
        fun <T> success(body: T): ApiResponse<T> = ApiResponse(ApiStatusResponse.SUCCESS, body, null)

        fun <T> empty(msg: String, body: T): ApiResponse<T> = ApiResponse(ApiStatusResponse.EMPTY, body, msg)

        fun <T> error(msg: String, body: T): ApiResponse<T> = ApiResponse(ApiStatusResponse.ERROR, body, msg)
    }

}