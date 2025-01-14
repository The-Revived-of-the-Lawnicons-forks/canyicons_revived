package app.lawnchair.canyicons.repository

import app.lawnchair.canyicons.api.GitHubContributorsAPI
import javax.inject.Inject

val coreContributorIds = listOf(
    8080853,
    29139614,
    56888459,
)

class GitHubContributorsRepository @Inject constructor(
    private val api: GitHubContributorsAPI,
) {
    suspend fun getTopContributors() = api.getContributors()
        .filterNot { coreContributorIds.contains(it.id) }
        .sortedByDescending { it.contributions }
}
