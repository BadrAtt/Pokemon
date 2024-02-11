package com.elattaoui.details.intent

sealed class DetailsIntent {
    data class GetDetails(val name: String) : DetailsIntent()
}