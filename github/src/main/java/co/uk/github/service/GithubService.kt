package co.uk.github.service

import co.uk.github.data.Project
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

internal interface GithubService {

    @GET("users/{user}/repos")
    fun getProjectList(@Path("user") user: String): Call<List<Project>>

    @GET("/repos/{user}/{reponame}")
    fun getProjectDetails(@Path("user") user: String, @Path("reponame") projectName: String): Call<Project>
}
