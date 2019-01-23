package org.onaio.rxgithub.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.onaio.rxgithub.R
import org.onaio.rxgithub.domain.entities.GithubUser
import org.onaio.rxgithub.presentation.di.Components

class MainFragment : Fragment() {

    private lateinit var usersRecyclerView: RecyclerView
    private lateinit var errorText: TextView
    private lateinit var errorImageView: ImageView
    private lateinit var progressBar: ProgressBar
    private val viewModel: MainViewModel by viewModel()
    private val usersRecyclerAdapter: GithubUsersRecyclerAdapter = get()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        usersRecyclerView = activity!!.findViewById(R.id.usersRecyclerView)
        progressBar = activity!!.findViewById(R.id.progressBar)
        errorImageView = activity!!.findViewById(R.id.dangerImageView)
        errorText = activity!!.findViewById(R.id.errorTextView)
        activity?.title = activity?.getString(R.string.who_to_follow)

        initRecyclerViewAdapter()

        viewModel.state.observe(this, Observer { handleViewState(it) })
        viewModel.errorEvent.observe(this, Observer { handleError(it) })
        viewModel.retrieveUsers()
    }

    private fun initRecyclerViewAdapter() {
        usersRecyclerView.adapter = usersRecyclerAdapter
        usersRecyclerView.layoutManager = LinearLayoutManager(activity)
        usersRecyclerAdapter.setOnItemClickListener(View.OnClickListener {
            val viewHolder = it.tag as RecyclerView.ViewHolder
            val currentUser: GithubUser = usersRecyclerAdapter.getGithubUser(viewHolder.adapterPosition)
            val userDetailsFragment = Components.detailsFragment
            userDetailsFragment.arguments = bundleCurrentUser(currentUser)
            userDetailsFragment.show(activity?.supportFragmentManager, userDetailsFragment.tag)
        })
    }

    private fun bundleCurrentUser(githubUser: GithubUser): Bundle {
        val bundle = Bundle()
        bundle.let {
            it.putString("NAME", githubUser.fullName)
            it.putString("USERNAME", githubUser.username)
            it.putString("BIO", githubUser.bio)
            it.putString("LOCATION", githubUser.location)
            it.putString("COMPANY", githubUser.company)
            it.putString("REPOS", githubUser.publicRepos)
            it.putString("GISTS", githubUser.imageUri)
            it.putString("FOLLOWERS", githubUser.followers)
            it.putString("FOLLOWING", githubUser.following)
            it.putString("PROFILE", githubUser.imageUri)
        }

        return bundle
    }


    private fun handleViewState(viewState: MainActivityViewState) {
        toggleVisibility()
        usersRecyclerAdapter.addUser(viewState.githubUser)
        when {
            viewState.isLoading -> {
                progressBar.visibility = View.GONE
            }
            else -> progressBar.visibility = View.INVISIBLE
        }
    }

    private fun toggleVisibility() {
        errorText.visibility = View.GONE
        progressBar.visibility = View.GONE
        errorImageView.visibility = View.GONE
    }

    private fun handleError(throwable: Throwable) {
        progressBar.visibility = View.GONE
        errorText.visibility = View.VISIBLE
        errorImageView.visibility = View.VISIBLE
        Toast.makeText(context, "An error occurred. Try again later ${throwable.message}", Toast.LENGTH_LONG).show()
    }

    fun refreshList() {
        toggleVisibility()
        usersRecyclerAdapter.clearList()
        viewModel.retrieveUsers()
    }

    override fun onDestroy() {
        usersRecyclerAdapter.clearList()
        super.onDestroy()
    }
}
