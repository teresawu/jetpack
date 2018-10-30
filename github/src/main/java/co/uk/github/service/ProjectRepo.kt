package co.uk.github.service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.uk.github.data.Keys
import co.uk.github.data.Project
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ProjectRepository private constructor() {
    private val gitHubService: GithubService
    private val projectRepository by lazy { ProjectRepository() }

    init {
        //TODO this gitHubService instance will be injected using Dagger in part #2 ...
        val retrofit = Retrofit.Builder()
                .baseUrl(Keys.HTTPS_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        gitHubService = retrofit.create(GithubService::class.java)
    }

    fun getProjectList(userId: String): LiveData<List<Project>> {
        val data = MutableLiveData<List<Project>>()
        gitHubService.getProjectList(userId).enqueue(object : Callback<List<Project>> {
            override fun onFailure(call: Call<List<Project>>?, t: Throwable?) {
                data.setValue(null)
            }

            override fun onResponse(call: Call<List<Project>>?, response: Response<List<Project>>?) {
                data.setValue(response?.body())
            }
        })
        return data
    }

    fun getProjectDetails(userID: String, projectName: String): LiveData<Project> {
        val data = MutableLiveData<Project>()

        gitHubService.getProjectDetails(userID, projectName).enqueue(object : Callback<Project> {
            override fun onFailure(call: Call<Project>?, t: Throwable?) {
                simulateDelay()
                data.setValue(null)
            }

            override fun onResponse(call: Call<Project>?, response: Response<Project>?) {
                data.setValue(response?.body())
            }
        })
        return data
    }

    private fun simulateDelay() {
        try {
            Thread.sleep(10)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }
}
