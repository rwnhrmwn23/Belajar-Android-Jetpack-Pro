package com.onedev.dicoding.architecturecomponent.data.source.remote.response

class ApiResponse<T>(val status: ApiStatusResponse, val body: T, val message: String?) {

    companion object {
        fun <T> success(body: T): ApiResponse<T> = ApiResponse(ApiStatusResponse.SUCCESS, body, null)
    }

}