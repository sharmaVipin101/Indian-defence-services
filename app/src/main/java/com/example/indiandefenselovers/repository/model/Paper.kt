package com.example.indiandefenselovers.repository.model

import com.google.gson.annotations.SerializedName

data class Paper(
    @SerializedName("year") val year: String?,
    @SerializedName("phase_one") val phaseOne: PaperModel?,
)

data class PaperModel(
    @SerializedName("question_paper") val qPaper: List<QA?>?,
    @SerializedName("answer_key") val answerKey: List<QA?>?,
)

data class QA(
    @SerializedName("paper_name") val paperName: String?,
    @SerializedName("paper_link") val paperLink: String?
)